package fpt.java.finalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    // Blank layout
    @RequestMapping("/blank")
    public String blank() {
        return "module/blank_layout";
    }

    // Admin main layout
    @RequestMapping("/amain")
    public String adminMain() {
        return "admin/layouts/main";
    }

    // Admin add product
    @RequestMapping("/aproductadd")
    public String adminAddProduct() {
        return "admin/products/add";
    }

    // Admin add employee
    @RequestMapping("/aemployeeadd")
    public String adminAddEmployee() {
        return "admin/employees/add";
    }

    // Admin add item
    @RequestMapping("/aitemadd")
    public String adminAddItem() {
        return "admin/items/add";
    }

    // Admin add shop
    @RequestMapping("/ashopedit")
    public String adminEditShop() {
        return "admin/shops/edit";
    }

    // Admin add user
    @RequestMapping("/auseredit")
    public String adminEditUser() {
        return "admin/users/edit";
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
