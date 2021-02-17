package fpt.java.finalproject.controllers.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fpt.java.finalproject.models.CartDetail;
import fpt.java.finalproject.models.User;
import fpt.java.finalproject.response.UserListResponse;
import fpt.java.finalproject.response.UserResponse;
import fpt.java.finalproject.services.CartDetailSevice;
import fpt.java.finalproject.services.UserService;

@RequestMapping("/w/carts")
@Controller
public class UserCartController {
    
    @Autowired
    CartDetailSevice cartDetailService;

    @Autowired
    UserService userService;

    //Show cart details
    @GetMapping("")
    public String cartDetails(ModelMap m, @RequestParam(required = false, defaultValue = "0") Integer page) {
        
        UserResponse obj = (UserResponse) m.getAttribute("res");
        List<CartDetail> l;
        UserListResponse<CartDetail> res = new UserListResponse<>();
        if (obj == null) {
            res = new UserListResponse<>();
        } else {
            res.setNewResponse(obj);
        }

        // Set paging string
        String pagingStr = "/carts";

        // Set response
        try {
            User authUser = userService.getAuthUser();
            l = cartDetailService.findByUserId(authUser.getId());
            res.generateResponse(l, 0, page, pagingStr);
            res.setAuthUser(authUser);
        } catch (Exception ex) {
            if (!res.getIsEmpty()) {
                // Return error on fail
                res.setErrorCode("404");
                res.setMessage(ex.getMessage());
                m.addAttribute("res", res);
                return "module/error";
            }
        }
        res.setTitle("Chi tiết giỏ hàng");
        
        // Send response

        return "user/cart";
    }

    // Delete
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id, ModelMap m) {

        UserResponse res = new UserResponse();

        // Find brand
        try {
            cartDetailService.deleteById(id);
        } catch (Exception ex) {
            // Return error on fail
            res.setErrorCode("404");
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        // Set response
        res.setTitle("Xóa thành công");

        // Send response
        m.addAttribute("res", res);

        return "redirect:/w/carts";
    }

    // Save new
    @PostMapping("/save")
    public String save(CartDetail c, ModelMap m) {

        UserResponse res = new UserResponse();

        // Save brand
        try {
            cartDetailService.save(c);
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
        return "redirect:/w/carts";
    }
}
