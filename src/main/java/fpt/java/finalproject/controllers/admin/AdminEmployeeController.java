package fpt.java.finalproject.controllers.admin;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import fpt.java.finalproject.utils.AdminQuery;
import fpt.java.finalproject.response.AdminResponse;
import fpt.java.finalproject.services.EmployeeRoleService;
import fpt.java.finalproject.services.EmployeeService;

@RequestMapping("/admin/employees")
@Controller
public class AdminEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRoleService employeeRoleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @ModelAttribute(name = "employeeRoles")
    public List<EmployeeRole> getEmployeeRoles() {
        return employeeRoleService.findAll();
    }

    public String response(ModelMap m, String routing, AdminListResponse<Employee> res) {
        Employee authEmployee = employeeService.getAuthEmployee();
        res.setAuthEmployee(authEmployee);
        m.addAttribute("res", res);
        return routing;
    }

    public String response(ModelMap m, String routing, AdminObjectResponse<Employee> res) {
        Employee authEmployee = employeeService.getAuthEmployee();
        res.setAuthEmployee(authEmployee);
        m.addAttribute("res", res);
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
        e.setPassword(passwordEncoder.encode(e.getPassword()));
        // Save employee
        try {
            employeeService.save(e);
        } catch (Exception ex) {
            // Return error on fail
            res.setErrorCode("404");
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
            res.setErrorCode("404");
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
    public String list(ModelMap m, 
    @RequestParam(required = false, defaultValue = "0") Integer page,
    @RequestParam(required = false, defaultValue = "") String name
    ) {

        AdminResponse obj = (AdminResponse) m.getAttribute("res");
        List<Employee> l;
        AdminListResponse<Employee> res = new AdminListResponse<>();
        if (obj == null) {
            res = new AdminListResponse<>();
        } else {
            res.setNewResponse(obj);
        }

        // Set paging string
        String pagingStr = "/admin/employees";
        AdminQuery query = new AdminQuery(name, 0, 0, 0, 0);
        pagingStr = query.generateResponseQuery(pagingStr);

        // Set list
        
        try {
            l = employeeService.customFind(name);
            System.out.println(l);
            res.generateResponse(l, 0, page, pagingStr);
        } catch (Exception ex) {
            if (!res.getIsEmpty()) {
                // Return error on fail
                res.setErrorCode("404");
                res.setMessage(ex.getMessage());
                m.addAttribute("res", res);
                return "module/error";
            }
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
            res.setErrorCode("404");
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
            res.setErrorCode("404");
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
