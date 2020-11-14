package fpt.java.finalproject.controllers.admin;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fpt.java.finalproject.models.Employee;
import fpt.java.finalproject.models.EmployeeRole;
import fpt.java.finalproject.response.AdminObjectResponse;
import fpt.java.finalproject.response.AdminResponse;
import fpt.java.finalproject.services.EmployeeRoleService;
import fpt.java.finalproject.services.EmployeeService;

@Controller
@RequestMapping("/admin")
public class CommonController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeRoleService employeeRoleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Direct to add page
    @GetMapping("/add")
    public String add(ModelMap m) {

        AdminObjectResponse<Employee> res = new AdminObjectResponse<>();
        Employee e = new Employee();
        res.setTitle("Thêm nhân viên");
        
        // Send new response bean
        m.addAttribute("res", res);
        m.addAttribute("object", e);

        return "test/test_add_or_edit";
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
    @ModelAttribute(name = "employeeRoles")
    public List<EmployeeRole> getEmployeeRoles(){
        return employeeRoleService.findAll();
    }
    
}
