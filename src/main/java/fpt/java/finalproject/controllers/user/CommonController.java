package fpt.java.finalproject.controllers.user;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fpt.java.finalproject.models.Shop;
import fpt.java.finalproject.models.ShopItem;
import fpt.java.finalproject.models.User;
import fpt.java.finalproject.response.UserHomeResponse;
import fpt.java.finalproject.response.UserObjectResponse;
import fpt.java.finalproject.response.UserResponse;
import fpt.java.finalproject.services.ShopItemService;
import fpt.java.finalproject.services.ShopService;
import fpt.java.finalproject.services.UserService;

@Controller
@RequestMapping("/w")
public class CommonController {

    @Autowired
    UserService userService;

    @Autowired
    ShopItemService shopItemService;

    @Autowired
    ShopService shopService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Direct to add page
    @GetMapping("/register")
    public String add(ModelMap m) {

        UserObjectResponse<User> res = new UserObjectResponse<>();
        User u = new User();
        res.setTitle("Đăng ký");

        // Send new response bean
        m.addAttribute("res", res);
        m.addAttribute("object", u);

        return "user/signup";
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

            // Save user
            userService.save(u);

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

        // Set response
        res.setMessage("Đăng ký thành công!");

        // Send response
        m.addAttribute("res", res);

        // Redirect to list page
        return "user/login";
    }

    @GetMapping("/home")
    public String home(ModelMap m) {
        UserHomeResponse res = new UserHomeResponse();

        try {

            List<ShopItem> mostViewList = shopItemService.getMostViewList(10);
            res.setMostViewList(mostViewList);

            List<ShopItem> mostSellList = shopItemService.getMostSellList(10);
            res.setMostSellList(mostSellList);

            List<Shop> mostViewShop = shopService.getMostViewList(5);
            res.setMostViewShop(mostViewShop);

        } catch (Exception ex) {
            // Return error on fail
            res.setErrorCode("404");
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        return response(m, "user/home", res);
    }

    @GetMapping("")
    public String blank() {
        return "redirect:/w/home";
    }

    @GetMapping("/index")
    public String index() {
        return "redirect:/w/home";
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

    public String response(ModelMap m, String routing, UserHomeResponse res) {
        User authUser = userService.getAuthUser();
        res.setAuthUser(authUser);
        m.addAttribute("res", res);
        return routing;
    }

}
