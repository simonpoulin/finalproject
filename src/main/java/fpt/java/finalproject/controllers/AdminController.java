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

    // Admin edit product
    @RequestMapping("/aproductedit")
    public String adminEditProduct() {
        return "admin/products/edit";
    }

    // Admin add employee
    @RequestMapping("/aemployeeadd")
    public String adminAddEmployee() {
        return "admin/employees/add";
    }

    // Admin edit employee
    @RequestMapping("/aemployeeedit")
    public String adminEditEmployee() {
        return "admin/employees/edit";
    }

    // Admin add item
    @RequestMapping("/aitemadd")
    public String adminAddItem() {
        return "admin/items/add";
    }

    // Admin edit item
    @RequestMapping("/aitemedit")
    public String adminEditItem() {
        return "admin/items/edit";
    }

    // Admin add shop
    @RequestMapping("/ashopadd")
    public String adminAddShop() {
        return "admin/shops/add";
    }

    // Admin edit shop
    @RequestMapping("/ashopedit")
    public String adminEditShop() {
        return "admin/shops/edit";
    }

    // Admin add user
    @RequestMapping("/auseradd")
    public String adminAddUser() {
        return "admin/users/add";
    }

    // Admin edit user
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

    // User forget password
    @RequestMapping("/forgetpassword")
    public String forgetPassword() {
        return "user/forget_password";
    }

    // Admin home
    @RequestMapping("/ahome")
    public String adminHome() {
        return "admin/admin_page";
    }

    // Admin login
    @RequestMapping("/alogin")
    public String adminLogin() {
        return "admin/login";
    }

    // Admin signup
    @RequestMapping("/asignup")
    public String adminSignup() {
        return "admin/signup";
    }

    // Admin forget password
    @RequestMapping("/aforgetpassword")
    public String adminForgetPassword() {
        return "admin/forget_password";
    }

    //User*******************************************

    @RequestMapping("/ublank")
    public String BlankUser() {
        return "user/layouts/blank_user_layouts";
    }
    @RequestMapping("/umain")
    public String MainUser() {
        return "user/layouts/main_user";
    }
     @RequestMapping("/adduser")
    public String AddUser() {
        return "user/layouts/add_user";
    }
    @RequestMapping("/cart")
    public String Cart() {
        return "user/cart";
    }
    @RequestMapping("/carth")
    public String CartHistory() {
        return "user/cart_history";
    }
    
    @RequestMapping("/personal")
    public String Personal() {
        return "user/personal";
    }
    @RequestMapping("/product")
    public String Pproduct() {
        return "user/product";
    }
    @RequestMapping("/productde")
    public String ProductlDetails() {
        return "user/product_details";
    }
    @RequestMapping("/statistical")
    public String Statisticals() {
        return "user/shop/statistical";
    }
    @RequestMapping("/store")
    public String Store() {
        return "user/store";
    }
    @RequestMapping("/chart")
    public String Chart() {
        return "user/shop/chart";
    }

}  