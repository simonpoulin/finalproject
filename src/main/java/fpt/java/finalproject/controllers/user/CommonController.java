package fpt.java.finalproject.controllers.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fpt.java.finalproject.models.User;
import fpt.java.finalproject.response.UserObjectResponse;
import fpt.java.finalproject.response.UserResponse;
import fpt.java.finalproject.services.ShopItemService;
import fpt.java.finalproject.services.UserService;

@Controller
@RequestMapping("/user")
public class CommonController {

    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ShopItemService shopService;

    // Direct to add page
    @GetMapping("/register")
    public String add(ModelMap m) {

        UserObjectResponse<User> res = new UserObjectResponse<>();
        User u = new User();
        res.setTitle("Đăng ký");

        // Send new response bean
        m.addAttribute("res", res);
        m.addAttribute("object", u);

        return "user/register";
    }

    // Save new
    @PostMapping("/register/save")
    public String save(User u, ModelMap m) {

        UserResponse res = new UserResponse();

        try {
            // Check username is existed
            User check = new User();
            check = userService.findByUsername(u.getUsername());
            if (check != null) {
                throw new Exception("Tên đăng nhập đã tồn tại!");
            }

        } catch (Exception ex) {
            if (!ex.getMessage().equals("User not found")) {
                res.setErrorCode("404");
                res.setTitle("Đăng ký");
                res.setMessage(ex.getMessage());
                m.addAttribute("res", res);
                return "user/signup";
            }
        }

        u.setCreatedAt(new Date(new Date().getTime()));
        u.setPassword(passwordEncoder.encode(u.getPassword()));

        try {
            userService.save(u);
        } catch (Exception ex) {
            res.setErrorCode("404");
            res.setTitle("Đăng ký");
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "user/signup";

        }

        // Set response
        res.setMessage("Đăng ký thành công!");

        // Send response
        m.addAttribute("res", res);

        // Redirect to list page
        return "user/login";
    }

    @GetMapping("/home")
    public String home(ModelMap m) {
        return response(m, "redirect:/user/index");
    }

    @GetMapping("")
    public String blank() {
        return "redirect:/user/home";
    }

    @RequestMapping("/index")
    public String index(ModelMap m) {

        m.put("list", shopService.findAll());
        return response(m, "user/layouts/index");
    }

    @GetMapping("/login")
    public String getLogin() {
        return "user/login";
    }

    @GetMapping("/403")
    public String accessDenied(ModelMap m) {
        UserResponse res = new UserResponse();
        res.setErrorCode("403");
        res.setMessage("You don't have rights to get in!!!");
        m.addAttribute("res", res);
        return "module/error";
    }

    public String response(ModelMap m, String routing) {
        User authUser = userService.getAuthUser();
        UserResponse res = new UserResponse();
        res.setAuthUser(authUser);
        m.addAttribute("res", res);
        return routing;
    }

}
