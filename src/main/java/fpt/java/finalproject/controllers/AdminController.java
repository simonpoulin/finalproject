package fpt.java.finalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @RequestMapping("/addOrEdit")
    public String layoutChung() {
        return "admin/layouts/add_or_edit_layout";
    }

    // -----------------------------------------------
    @RequestMapping("/addProduct")
    public String addProduct() {
        return "admin/products/add_product";
    }

    @RequestMapping("/productList")
    public String productList() {
        return "admin/products/product_list";
    }

    // -----------------------------------------------
    @RequestMapping("/addEmployee")
    public String addEmployee() {
        return "admin/employees/add_employee";
    }

    @RequestMapping("/employeeList")
    public String EmployeeList() {
        return "admin/employees/employee_list";
    }

    // -----------------------------------------------
    @RequestMapping("/addItem")
    public String addItem() {
        return "admin/items/add_item";
    }

    @RequestMapping("/itemList")
    public String itemList() {
        return "admin/items/item_list";
    }

    // -----------------------------------------------
    @RequestMapping("/editShop")
    public String editShop() {
        return "admin/shops/edit_shop";
    }

    @RequestMapping("/shopList")
    public String shopList() {
        return "admin/shops/shop_list";
    }

    // -----------------------------------------------
    @RequestMapping("/editUser")
    public String editUser() {
        return "admin/users/edit_user";
    }

    @RequestMapping("/userList")
    public String userList() {
        return "admin/users/user_list";
    }
}
