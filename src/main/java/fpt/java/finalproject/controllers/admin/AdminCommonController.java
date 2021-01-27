package fpt.java.finalproject.controllers.admin;

import java.util.Date;

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
public class AdminCommonController {
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

        AdminResponse res = new AdminResponse();
        
        try {

            // Check username is existed
            Employee check = new Employee();
            check = employeeService.findByUsername(e.getUsername());
            if (check != null) {
                throw new Exception("Tên đăng nhập đã tồn tại!");
            }

            // Save employee
            employeeService.save(e);

        } catch (Exception ex) {
            if (!ex.getMessage().equals("Employee not found")) {
                res.setErrorCode("404");
                res.setMessage(ex.getMessage());
                res.setTitle("Đăng ký nhân viên");
                m.addAttribute("res", res);
                return "admin/signup";
            }
        }
        
        e.setCreatedAt(new Date(new Date().getTime()));
        e.setPassword(passwordEncoder.encode(e.getPassword()));
        e.setEmployeeRole(employeeRoleService.findById(1));

        // Set response
        res.setMessage("Đăng ký thành công!");

        // Send response
        m.addAttribute("res", res);

        // Redirect to list page
        return "admin/login";
    }

    @GetMapping("/dashboard")
    public String dashboard(ModelMap m) {
        return response(m, "admin/dashboard");
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
    public String accessDenied(ModelMap m) {
        AdminResponse res = new AdminResponse();
        res.setErrorCode("403");
        res.setMessage("You don't have rights to get in!!!");
        m.addAttribute("res", res);
        return "module/error";
    }

    public String response(ModelMap m, String routing) {
        Employee authEmployee = employeeService.getAuthEmployee();
        AdminResponse res = new AdminResponse();
        res.setAuthEmployee(authEmployee);
        m.addAttribute("res", res);
        return routing;
    }

}
