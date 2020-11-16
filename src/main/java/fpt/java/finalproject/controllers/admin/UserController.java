package fpt.java.finalproject.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fpt.java.finalproject.models.Employee;
import fpt.java.finalproject.models.User;
import fpt.java.finalproject.response.AdminListResponse;
import fpt.java.finalproject.response.AdminObjectResponse;
import fpt.java.finalproject.response.AdminResponse;
import fpt.java.finalproject.services.EmployeeService;
import fpt.java.finalproject.services.UserService;

@RequestMapping("/admin/users")
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    EmployeeService employeeService;

    public String response(ModelMap m, String routing, AdminListResponse<User> listResponse) {
        Employee authEmployee = employeeService.getAuthEmployee();
        listResponse.setAuthEmployee(authEmployee);
        m.addAttribute("res", listResponse);
        return routing;
    }

    public String response(ModelMap m, String routing, AdminObjectResponse<User> listResponse) {
        Employee authEmployee = employeeService.getAuthEmployee();
        listResponse.setAuthEmployee(authEmployee);
        m.addAttribute("res", listResponse);
        return routing;
    }

    // Direct to add page
    @GetMapping("/add")
    public String add(ModelMap m) {

        AdminObjectResponse<User> res = new AdminObjectResponse<>();
        User u = new User();
    
        res.setTitle("Thêm người dùng");

        // Send new response bean
        m.addAttribute("res", res);
        m.addAttribute("object", u);

        return response(m, "admin/users/add_or_edit", res);
    }

    // Save new
    @PostMapping("/save")
    public String save(User u, ModelMap m) {

        AdminResponse res = new AdminResponse();

        // Save user
        try {
            userService.save(u);
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
        return "redirect:/admin/users";
    }

    // Direct to edit page
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") Integer id, ModelMap m) {

        AdminObjectResponse<User> res = new AdminObjectResponse<>();
        User u = new User();

        // Find user
        try {
            u = userService.findById(id);
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
        m.addAttribute("res", res);
        m.addAttribute("object", u);

        return response(m, "admin/users/add_or_edit", res);
    }

    // List
    @GetMapping("")
    public String list(ModelMap m, @RequestParam(required = false, defaultValue = "0") Integer page,
    @RequestParam(required = false, defaultValue = "") String name,
    @RequestParam(required = false, defaultValue = "0") Integer role) {

        AdminResponse obj = (AdminResponse) m.getAttribute("res");
        AdminListResponse<User> res = new AdminListResponse<>();
        if (obj == null) {
            res = new AdminListResponse<>();
        } else {
            res.setNewResponse(obj);
        }

         // Set paging string
         boolean isFirst = true;
         String pagingStr = "/admin/user";
 
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

        List<User> l;
        try {
            l = userService.findAll();
            res.generateResponse(l, 0, page, pagingStr);
        } catch (Exception ex) {
            if (!res.getIsEmpty()) {
                // return fail
                res.setErrorCode("404");
                res.setMessage(ex.getMessage());
                m.addAttribute("res", res);
                return "module/error";
            }
        }
        res.setTitle("Danh sách người dùng");

        // Send response
        m.addAttribute("res", res);
        return response(m, "admin/users/list", res);
    }

    // Detail
    @GetMapping("/{id}")
    public String detail(@PathVariable(name = "id") Integer id, ModelMap m) {

        AdminObjectResponse<User> res = new AdminObjectResponse<>();
        User u = new User();

        // Find user
        try {
            u = userService.findById(id);
        } catch (Exception ex) {
            // Return error on fail
            res.setErrorCode("404");
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        // Set response
        res.setObject(u);
        res.setTitle("Thông tin người dùng");

        // Send response
        m.addAttribute("res", res);

        return response(m, "admin/users/list", res);
    }

    // Delete
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id, ModelMap m) {

        AdminResponse res = new AdminResponse();

        // Find user
        try {
            userService.deleteById(id);
        } catch (Exception ex) {
            // Return error on fail
            res.setErrorCode("404");
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        // Set response
        res.setTitle("Xóa người dùng thành công");

        // Send response
        m.addAttribute("res", res);

        return "redirect:/admin/users";
    }
}
