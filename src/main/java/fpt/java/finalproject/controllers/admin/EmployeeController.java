package fpt.java.finalproject.controllers.admin;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fpt.java.finalproject.models.Employee;
import fpt.java.finalproject.models.EmployeeRole;
import fpt.java.finalproject.response.AdminListResponse;
import fpt.java.finalproject.response.AdminObjectResponse;
import fpt.java.finalproject.response.AdminResponse;
import fpt.java.finalproject.services.EmployeeRoleService;
import fpt.java.finalproject.services.EmployeeService;

@RequestMapping("/admin/employees")
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeRoleService employeeRoleService;

    @ModelAttribute(name = "employeeRoles")
    public List<EmployeeRole> getEmployeeRoles() {
        return employeeRoleService.findAll();
    }

    public String response(ModelMap m, String routing, AdminListResponse<Employee> listResponse) {
        Employee authEmployee = employeeService.getAuthEmployee();
        listResponse.setAuthEmployee(authEmployee);
        m.addAttribute("res", listResponse);
        return routing;
    }

    public String response(ModelMap m, String routing, AdminObjectResponse<Employee> listResponse) {
        Employee authEmployee = employeeService.getAuthEmployee();
        listResponse.setAuthEmployee(authEmployee);
        m.addAttribute("res", listResponse);
        return routing;
    }

    // Direct to add page
    @GetMapping("/add")
    public String add(ModelMap m) {

        AdminObjectResponse<Employee> res = new AdminObjectResponse<>();
        Employee e = new Employee();
        res.setTitle("Thêm nhân viên");

        // Send new response bean
        m.addAttribute("object", e);

        return response(m, "admin/employees/add_or_edit", res);
    }

    // Save new
    @PostMapping("/save")
    public String save(Employee e, ModelMap m) {

        AdminResponse res = new AdminResponse();
        e.setCreatedAt(new Date(new Date().getTime()));
        e.setPassword(new BCryptPasswordEncoder().encode(e.getPassword()));
        // Save employee
        try {
            employeeService.save(e);
        } catch (Exception ex) {
            // Return error on fail
            res.setIsError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        // Set response
        res.setMessage("Lưu thành công!");

        // Send response
        m.addAttribute("res", res);

        // Redirect to list page
        return "redirect:/admin/employees";
    }

    // Direct to edit page
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") Integer id, ModelMap m) {

        AdminObjectResponse<Employee> res = new AdminObjectResponse<>();
        Employee e = new Employee();

        // Find employee
        try {
            e = employeeService.findById(id);
        } catch (Exception ex) {
            // Return error on fail
            res.setIsError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        // Set response
        res.setIsEdit(true);
        res.setTitle("Cập nhật thông tin");

        // Send response
        m.addAttribute("object", e);

          return response(m, "admin/employees/add_or_edit", res);
    }

    // List
    @GetMapping("")
    public String list(ModelMap m, @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "0") Integer role) {

        AdminResponse obj = (AdminResponse) m.getAttribute("res");
        AdminListResponse<Employee> res = new AdminListResponse<>();
        if (obj == null) {
            res = new AdminListResponse<>();
        } else {
            res.setNewResponse(obj);
        }

        List<Employee> l;
        try {
            l = employeeService.findAll();
        } catch (Exception ex) {
            // Return error on fail
            res.setIsError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        // Set paging string
        boolean isFirst = true;
        String pagingStr = "/admin/employees";

        if (!name.equals("")) {
            pagingStr += "?name=" + name;
            isFirst = false;
        }

        if (role != 0) {
            if (isFirst) {
                pagingStr += "?";
            } else {
                pagingStr += "&";
            }
            pagingStr += "role=" + role;
        }

        // Set response
        try {
            res.generateResponse(l, 0, page, pagingStr);
        } catch (Exception ex) {
            // Return error on fail
            res.setIsError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }
        res.setTitle("Danh sách nhân viên");

        // Send response
        return response(m, "admin/employees/list", res);
        
    }

    // Detail
    @GetMapping("/{id}")
    public String detail(@PathVariable(name = "id") Integer id, ModelMap m) {

        AdminObjectResponse<Employee> res = new AdminObjectResponse<>();
        Employee e = new Employee();

        // Find employee
        try {
            e = employeeService.findById(id);
        } catch (Exception ex) {
            // Return error on fail
            res.setIsError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        // Set response
        res.setObject(e);
        res.setTitle("Thông tin nhân viên");

        // Send response

        return response(m, "admin/employees/detail", res);
    }

    // Delete
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id, ModelMap m) {

        AdminResponse res = new AdminResponse();

        // Find employee
        try {
            employeeService.deleteById(id);
        } catch (Exception ex) {
            // Return error on fail
            res.setIsError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        // Set response
        res.setTitle("Xóa nhân viên thành công");

        // Send response
        m.addAttribute("res", res);

        return "redirect:/admin/employees";
    }

}
