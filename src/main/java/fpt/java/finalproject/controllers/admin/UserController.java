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
import fpt.java.finalproject.response.UserResponse;
import fpt.java.finalproject.services.UserService;

@RequestMapping("/admin/users")
@Controller
public class UserController {

    UserResponse res;

    @Autowired
    UserService userService;

    // Direct to add page
    @GetMapping("/add")
    public String add(ModelMap m) {

        res = new UserResponse();
        res.setTitle("Thêm người dùng");

        // Send new response bean
        m.addAttribute("res", res);

        return "admin/users/add_or_edit";
    }

    // Save new
    @PostMapping("/save")
    public String save(User u, ModelMap m) {

        res = new UserResponse();

        // Save user
        try {
            userService.save(u);
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
        return "redirect:/admin/users";
    }

    // Direct to edit page
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") Integer id, ModelMap m) {

        res = new UserResponse();
        User u = new User();

        // Find user
        try {
            u = userService.findById(id);
        } catch (Exception ex) {
            // Return error on fail
            res.setError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        // Set response
        res.setUser(u);
        res.setIsEdit(true);
        res.setTitle("Cập nhật thông tin");

        // Send response
        m.addAttribute("res", res);

        return "admin/users/add_or_edit";
    }

    // List
    @GetMapping("")
    public String list(ModelMap m) {

        Object obj = m.getAttribute("res");
        List<User> l;

        if (obj == null) {
            res = new UserResponse();
        } else {
            res = (UserResponse) obj;
        }

        try {
            l = userService.findAll();
        } catch (Exception ex) {
            // Return error on fail
            res.setError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        // Set response
        res.setUserList(l);
        res.setIsEdit(true);
        res.setTitle("Danh sách người dùng");

        // Send response
        m.addAttribute("res", res);
        return "admin/users/list";
    }

    // Detail
    @GetMapping("/{id}")
    public String detail(@PathVariable(name = "id") Integer id, ModelMap m) {

        res = new UserResponse();
        User u = new User();

        // Find user
        try {
            u = userService.findById(id);
        } catch (Exception ex) {
            // Return error on fail
            res.setError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        // Set response
        res.setUser(u);
        res.setTitle("Thông tin người dùng");

        // Send response
        m.addAttribute("res", res);

        return "admin/users/edit";
    }

    // Delete
    @DeleteMapping("/{id}")
    public String delete(@PathVariable(name = "id") Integer id, ModelMap m) {

        res = new UserResponse();

        // Find user
        try {
            userService.deleteById(id);
        } catch (Exception ex) {
            // Return error on fail
            res.setError(true);
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
