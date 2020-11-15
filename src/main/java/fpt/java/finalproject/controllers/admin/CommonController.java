package fpt.java.finalproject.controllers.admin;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fpt.java.finalproject.models.Employee;
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
    @GetMapping("/register")
    public String add(ModelMap m) {

        AdminObjectResponse<Employee> res = new AdminObjectResponse<>();
        Employee e = new Employee();
        res.setTitle("Thêm nhân viên");
        
        // Send new response bean
        m.addAttribute("res", res);
        m.addAttribute("object", e);

        return "admin/signup";
    }

    // Save new
    @PostMapping("/register/save")
    public String save(Employee e, ModelMap m) {
        //ở đây còn chưa check username đã tồn tại, email số điện thoại có trùng k , ....
        AdminResponse res = new AdminResponse();
        e.setCreatedAt(new Date(new Date().getTime()));
        e.setPassword(passwordEncoder.encode(e.getPassword()));
        e.setEmployeeRole(employeeRoleService.findById(1));

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
        res.setMessage("Đăng ký thành công!");

        // Send response
        m.addAttribute("res", res);

        // Redirect to list page
        return "admin/login";
    }
    
    @GetMapping("/dashboard")
    public String dashboard() {
        return "admin/dashboard";
    }

    @GetMapping("")
    public String blank() {
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/index")
    public String index() {
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "admin/login";
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "module/error";
    }

}
