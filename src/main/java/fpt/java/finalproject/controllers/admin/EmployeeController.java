package fpt.java.finalproject.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fpt.java.finalproject.models.Employee;
import fpt.java.finalproject.response.EmployeeResponse;
import fpt.java.finalproject.services.EmployeeService;

@RequestMapping("/admin/employees")
@Controller
public class EmployeeController {

    EmployeeResponse res;

    @Autowired
    EmployeeService employeeService;

    // Direct to add page
    @GetMapping("/add")
    public String add(ModelMap m) {

        res = new EmployeeResponse();
        res.setTitle("Thêm nhân viên");
        res.setIsEdit(false);

        // Send new response bean
        m.addAttribute("res", res);

        return "admin/employees/add_or_edit";
    }

    // Save new
    @PostMapping("/save")
    public String save(Employee e, ModelMap m) {

        res = new EmployeeResponse();

        // Save employee
        try {
            employeeService.save(e);
        } catch (Exception ex) {
            // Return error on fail
            res.setError(true);
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

        res = new EmployeeResponse();
        Employee e = new Employee();

        // Find employee
        try {
            e = employeeService.findById(id);
        } catch (Exception ex) {
            // Return error on fail
            res.setError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        // Set response
        res.setEmployee(e);
        res.setIsEdit(true);
        res.setTitle("Cập nhật thông tin");

        // Send response
        m.addAttribute("res", res);

        return "admin/employees/add_or_edit";
    }

    // List
    @GetMapping("")
    public String list(ModelMap m) {

        Object obj = m.getAttribute("res");
        List<Employee> l;

        if (obj == null) {
            res = new EmployeeResponse();
        } else {
            res = (EmployeeResponse) obj;
        }

        try {
            l = employeeService.findAll();
        } catch (Exception ex) {
            // Return error on fail
            res.setError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        // Set response
        res.setEmployeeList(l);
        res.setIsEdit(true);
        res.setTitle("Danh sách nhân viên");

        // Send response
        m.addAttribute("res", res);
        return "admin/employees/list";
    }

    // Detail
    @GetMapping("/{id}")
    public String detail(@PathVariable(name = "id") Integer id, ModelMap m) {

        res = new EmployeeResponse();
        Employee e = new Employee();

        // Find employee
        try {
            e = employeeService.findById(id);
        } catch (Exception ex) {
            // Return error on fail
            res.setError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        // Set response
        res.setEmployee(e);
        res.setTitle("Thông tin nhân viên");

        // Send response
        m.addAttribute("res", res);

        return "admin/employees/edit";
    }

    // Delete
    @DeleteMapping("/{id}")
    public String delete(@PathVariable(name = "id") Integer id, ModelMap m) {

        res = new EmployeeResponse();

        // Find employee
        try {
            employeeService.deleteById(id);
        } catch (Exception ex) {
            // Return error on fail
            res.setError(true);
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
