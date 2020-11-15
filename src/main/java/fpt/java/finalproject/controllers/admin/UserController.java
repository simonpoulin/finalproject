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

import fpt.java.finalproject.models.User;
import fpt.java.finalproject.response.AdminListResponse;
import fpt.java.finalproject.response.AdminObjectResponse;
import fpt.java.finalproject.response.AdminResponse;
import fpt.java.finalproject.services.UserService;

@RequestMapping("/admin/users")
@Controller
public class UserController {

    @Autowired
    UserService userService;

    // Direct to add page
    @GetMapping("/add")
    public String add(ModelMap m) {

        AdminObjectResponse<User> res = new AdminObjectResponse<>();
        User u = new User();
       

        res.setTitle("Thêm người dùng");

        // Send new response bean
        m.addAttribute("res", res);
        m.addAttribute("object", u);

        return "admin/users/add_or_edit";
    }

    // Save new
    @PostMapping("/save")
    public String save(User u, ModelMap m) {

        AdminObjectResponse<User> res = new AdminObjectResponse<>();

        // Save user
        try {
            userService.save(u);
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
            res.setIsError(true);
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

        return "admin/users/add_or_edit";
    }

    // List
    @GetMapping("")
    public String list(ModelMap m) {

        AdminResponse obj = (AdminResponse) m.getAttribute("res");
        AdminListResponse<User> res = new AdminListResponse<>();
        if (obj == null) {
            res = new AdminListResponse<>();
        } else {
            res.setNewResponse(obj);
        }

        List<User> l;
        try {
            l = userService.findAll();
        } catch (Exception ex) {
            // Return error on fail
            res.setIsError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        // Set response
        try {
            res.generateResponse(l, 0, 0);
        } catch (Exception ex) {
            // Return error on fail
            res.setIsError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }
        res.setTitle("Danh sách người dùng");

        // Send response
        m.addAttribute("res", res);
        return "admin/users/list";
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
            res.setIsError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        // Set response
        res.setObject(u);
        res.setTitle("Thông tin người dùng");

        // Send response
        m.addAttribute("res", res);

        return "admin/users/detail";
    }

    // Delete
    @DeleteMapping("/{id}")
    public String delete(@PathVariable(name = "id") Integer id, ModelMap m) {

        AdminResponse res = new AdminResponse();

        // Find user
        try {
            userService.deleteById(id);
        } catch (Exception ex) {
            // Return error on fail
            res.setIsError(true);
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
