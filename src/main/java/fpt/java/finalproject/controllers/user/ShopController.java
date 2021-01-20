package fpt.java.finalproject.controllers.user;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fpt.java.finalproject.models.Shop;
import fpt.java.finalproject.models.ShopEmployee;
import fpt.java.finalproject.models.ShopItem;
import fpt.java.finalproject.models.User;
import fpt.java.finalproject.response.UserListResponse;
import fpt.java.finalproject.response.UserObjectResponse;
import fpt.java.finalproject.response.UserResponse;
import fpt.java.finalproject.services.ShopEmployeeService;
import fpt.java.finalproject.services.ShopItemService;
import fpt.java.finalproject.services.ShopService;
import fpt.java.finalproject.services.UserService;
import fpt.java.finalproject.utils.UserQuery;

@Controller
@RequestMapping("/w/shops")
public class ShopController {

    @Autowired
    ShopService shopService;

    @Autowired
    ShopItemService shopItemService;

    @Autowired
    ShopEmployeeService shopEmployeeService;

    @Autowired
    UserService userService;

    public String response(ModelMap m, String routing, UserObjectResponse res) {
        User authUser = userService.getAuthUser();
        res.setAuthUser(authUser);
        m.addAttribute("res", res);
        return routing;
    }

    // Drirect to shop register page
    @GetMapping("/register")
    public String register(ModelMap m) {

        UserObjectResponse<Shop> res = new UserObjectResponse<>();
        User authUser = userService.getAuthUser();
        res.setAuthUser(authUser);

        try {
            List<ShopEmployee> l = shopEmployeeService.findByUserId(authUser.getId());
            if (l.size() > 0) {
                // Return error on fail
                res.setErrorCode("400");
                res.setMessage(
                        "Bạn đang làm việc tại cửa hàng khác, vui lòng rời cửa hàng hiện tại nếu bạn muốn tạo cửa hàng mới!");
                m.addAttribute("res", res);
                return "module/error";
            }
        } catch (Exception e) {
            // Return error on fail
            res.setErrorCode("404");
            res.setMessage(e.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        Shop s = new Shop();
        res.setTitle("Đăng ký cửa hàng");

        // Send new response bean
        m.addAttribute("res", res);
        m.addAttribute("object", s);

        return "user/shops/register";
    }

    // Save new
    @PostMapping("/register/save")
    public String save(Shop s, ModelMap m) {

        UserResponse res = new UserResponse();
        User authUser = userService.getAuthUser();
        res.setAuthUser(authUser);

        try {

            // Save shop
            shopService.save(s);

        } catch (Exception ex) {
            res.setErrorCode("404");
            res.setTitle("Đăng ký");
            res.setMessage("Đăng ký thất bại");
            m.addAttribute("object", s);
            m.addAttribute("res", res);
            return "user/shops/register";
        }

        s.setCreatedAt(new Date(new Date().getTime()));

        ShopEmployee se = new ShopEmployee();
        se.setUser(authUser);

        // Set response
        res.setMessage("Đăng ký thành công!");

        // Send response
        m.addAttribute("res", res);

        // Redirect to list page
        return "redirect:/w/shops";
    }

    // Shop details
    @GetMapping("/details")
    public String shopDetails(ModelMap m) {

        UserObjectResponse<Shop> res = new UserObjectResponse<>();
        User authUser = userService.getAuthUser();
        res.setAuthUser(authUser);

        Shop s;

        try {
            List<ShopEmployee> el = shopEmployeeService.findByUserId(authUser.getId());
            if (el.size() == 0) {
                // Return error on fail
                res.setTitle("Đăng ký cửa hàng");
                res.setMessage("Bạn chưa làm việc trong cửa hàng nào, vui lòng đăng kí!");
                m.addAttribute("object", new Shop());
                m.addAttribute("res", res);
                return "/user/shops/register";
            }
            s = el.get(0).getShop();
        } catch (Exception e) {
            // Return error on fail
            res.setErrorCode("404");
            res.setMessage(e.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        res.setObject(s);
        res.setTitle("Thông tin cửa hàng");

        return "user/shops/detail";
    }

    @GetMapping("/details/edit")
    public String shopSaveEdited(Shop s, ModelMap m) {
        
        UserObjectResponse<Shop> res = new UserObjectResponse<>();
        User authUser = userService.getAuthUser();
        res.setAuthUser(authUser);

        try {
            List<ShopEmployee> el = shopEmployeeService.findByUserId(authUser.getId());
            if (el.size() == 0) {
                // Return error on fail
                res.setTitle("Đăng ký cửa hàng");
                res.setMessage("Bạn chưa làm việc trong cửa hàng nào, vui lòng đăng kí!");
                m.addAttribute("object", new Shop());
                m.addAttribute("res", res);
                return "/user/shops/register";
            }
            shopService.save(s);
        } catch (Exception e) {
            // Return error on fail
            res.setErrorCode("404");
            res.setMessage(e.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        res.setObject(s);
        res.setTitle("Thông tin cửa hàng");

        return "user/shops/edit";
    }

    @GetMapping("/items")
    public String shopItems(Shop s, ModelMap m, @RequestParam(required = false, defaultValue = "0") Integer productId,
            @RequestParam(required = false, defaultValue = "0") Integer page) {

        UserListResponse<ShopItem> res = new UserListResponse<>();
        User authUser = userService.getAuthUser();

        try {
            List<ShopEmployee> el = shopEmployeeService.findByUserId(authUser.getId());
            if (el.size() == 0) {
                res.setTitle("Đăng ký cửa hàng");
                res.setMessage("Bạn chưa làm việc trong cửa hàng nào, vui lòng đăng kí!");
                m.addAttribute("object", new Shop());
                m.addAttribute("res", res);
                return "/user/shops/register";
            }
            Integer shopId = el.get(0).getShop().getId();

            // Set paging string
            String pagingStr = "/w/shops/items";
            UserQuery query = new UserQuery("", 0, 0, shopId, productId);
            pagingStr = query.generateResponseQuery(pagingStr);

            List<ShopItem> l = shopItemService.customFind(0, 0, shopId, productId);
            res.generateResponse(l, 0, page, pagingStr);

        } catch (Exception e) {
            if (!res.getIsEmpty()) {
                // return fail
                res.setErrorCode("404");
                res.setMessage(e.getMessage());
                m.addAttribute("res", res);
                return "module/error";
            }
        }

        res.setAuthUser(authUser);

        return "user/shops/items/list";
    }

}
