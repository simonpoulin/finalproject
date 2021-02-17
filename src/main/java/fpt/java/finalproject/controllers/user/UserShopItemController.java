package fpt.java.finalproject.controllers.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fpt.java.finalproject.models.ShopItem;
import fpt.java.finalproject.models.User;
import fpt.java.finalproject.response.UserListResponse;
import fpt.java.finalproject.response.UserObjectResponse;
import fpt.java.finalproject.response.UserResponse;
import fpt.java.finalproject.services.ShopItemService;
import fpt.java.finalproject.services.UserService;
import fpt.java.finalproject.utils.UserQuery;

@Controller
@RequestMapping("/w/items")
public class UserShopItemController {

    @Autowired
    ShopItemService shopItemService;

    @Autowired
    UserService userService;

    // List
    @GetMapping("")
    public String listItem(ModelMap m, @RequestParam(required = false, defaultValue = "") String title,
            @RequestParam(required = false, defaultValue = "true") boolean sort,
            @RequestParam(required = false, defaultValue = "") Integer categoryId,
            @RequestParam(required = false, defaultValue = "") Integer page) {

        List<ShopItem> l;
        UserListResponse<ShopItem> res = new UserListResponse<>();

        // Set paging string
        String pagingStr = "/w/items";
        UserQuery query = new UserQuery("", title, categoryId, 0, 0, 0);
        pagingStr = query.generateResponseQuery(pagingStr);

        try {
            l = shopItemService.customFind(title, categoryId, sort);
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
        res.setTitle("Danh sách mặt hàng");

        // Send response
        m.addAttribute("res", res);
        return response(m, "user/items/list", res);

    }

    // Detail
    @GetMapping("/{id}")
    public String detail(@PathVariable(name ="id") Integer id, ModelMap m){

        UserObjectResponse<ShopItem> res = new UserObjectResponse<>();
        ShopItem sI = new ShopItem();
        List<ShopItem> l = new ArrayList<>();

        // Find by id
        try {
            sI = shopItemService.findById(id);
        } catch (Exception ex) {
           // Return fail
           res.setErrorCode("404");
           res.setMessage(ex.getMessage());
           m.addAttribute("res", res);
           return "module/error";
        }

        // Get sub list with 5 shop items have same category id
        try {
            l = shopItemService.customFindByCategoryId(sI.getProduct().getCategory().getId());
        } catch (Exception e) {

        }

        // Set response
        res.setObject(sI);
        res.setTitle("Thông tin mặt hàng");

        // send response
        m.addAttribute("res", res);
        m.addAttribute("subList", l);

        return response(m, "user/items/detail", res);
    }

    public String response(ModelMap m, String routing, UserListResponse<ShopItem> res) {
        User authUser = userService.getAuthUser();
        res.setAuthUser(authUser);
        m.addAttribute("res", res);
        return routing;
    }

    public String response(ModelMap m, String routing, UserObjectResponse<ShopItem> res) {
        User authUser = userService.getAuthUser();
        res.setAuthUser(authUser);
        m.addAttribute("res", res);
        return routing;
    }
}
