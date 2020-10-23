package fpt.java.finalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    // Blank layout
    @RequestMapping("/blank")
    public String blank() {
        return "module/layout_blank";
    }

    // Admin main layout
    @RequestMapping("/amain")
    public String adminMain() {
        return "admin/layouts/layout_main";
    }

    // Admin add product
    @RequestMapping("/aproductadd")
    public String adminAddProduct() {
        return "admin/products/add_product";
    }

    // Admin add employee
    @RequestMapping("/aemployeeadd")
    public String adminAddEmployee() {
        return "admin/employees/add_employee";
    }

    // Admin add item
    @RequestMapping("/aitemadd")
    public String adminAddItem() {
        return "admin/items/add_item";
    }

    // Admin add shop
    @RequestMapping("/ashopedit")
    public String adminEditShop() {
        return "admin/shops/edit_shop";
    }

    // Admin add user
    @RequestMapping("/auseredit")
    public String adminEditUser() {
        return "admin/users/edit_user";
    }

    // User home
    @RequestMapping("/home")
    public String home() {
        return "user/home";
    }

    // User login
    @RequestMapping("/login")
    public String login() {
        return "user/login";
    }

    // User signup
    @RequestMapping("/signup")
    public String signup() {
        return "user/signup";
    }

}
