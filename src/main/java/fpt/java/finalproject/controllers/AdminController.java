package fpt.java.finalproject.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import fpt.java.finalproject.models.Brand;
import fpt.java.finalproject.models.Category;
import fpt.java.finalproject.models.Employee;
import fpt.java.finalproject.models.EmployeeRole;
import fpt.java.finalproject.models.Product;
import fpt.java.finalproject.models.ShopItem;
import fpt.java.finalproject.models.User;
import fpt.java.finalproject.response.BrandResponse;
import fpt.java.finalproject.response.CategoryResponse;
import fpt.java.finalproject.response.EmployeeResponse;
import fpt.java.finalproject.response.ProductResponse;
import fpt.java.finalproject.response.ShopItemResponse;
import fpt.java.finalproject.response.UserResponse;

@Controller
public class AdminController {

    // Blank layout
    @RequestMapping("/blank")
    public String blank() {
        return "module/blank_layout";
    }

    // Admin Brand detail
    @RequestMapping("/abranddetail")
    public String adminBrandDetail(ModelMap m) {
        // the nay cung duowc ok
        BrandResponse res = new BrandResponse();
        Brand b = new Brand();
        b.setId(1);
        b.setBrandName("abc");
        res.setBrand(b);
        m.addAttribute("res", res);
        System.out.println(res);
        return "admin/brands/detail";
    }

    // Admin Empoyee details
    @RequestMapping("/aemployeedetail")
    public String adminEmployeeDetail(ModelMap m) {
        EmployeeResponse res = new EmployeeResponse();
        
        // Set EmployeeRole
        EmployeeRole r = new EmployeeRole();
        r.setId(12);
        r.setRoleName("Super");

        // Set Employee
        Employee e = new Employee();
        e.setId(1);
        e.setName("Pham Ngoc Tung");
        e.setUsername("username");
        e.setPassword("password");
        e.setCreatedAt(new Date(new Date().getTime()));
        e.setPhone("0775352970");
        e.setAddress("address");
        e.setEmail("email");
        e.setAvatarUrl("avatarUrl");
        e.setEmployeeRole(r);

        // Set response
        res.setEmployee(e);
        res.setTitle("Employee detail");
        m.addAttribute("res", res);
        System.out.println(res);
        return "admin/employees/detail";
    }

    // Admin categories details
    @RequestMapping("acategorydetail")
    public String adminCategoryDetail(ModelMap m) {
        CategoryResponse res = new CategoryResponse();
        Category c = new Category();
        c.setId(1);
        c.setCategoryName("smartphone");
        res.setCategory(c);
        m.addAttribute("res", res);
        System.out.println(res);
        return "admin/categories/detail";
    }

    // Admin item detail
    @RequestMapping("aitemdetail")
    public String adminItemDetail(ModelMap m) {
        ShopItemResponse res = new ShopItemResponse();
        ShopItem s = new ShopItem();
        s.setId(1);
        s.setTitle("APPLE IPHONE 8 99%");
        s.setDes("LOCK NHẬT");
        // s.setPrice();
        s.setQuantity(12);
        res.setShopItem(s);
        m.addAttribute("res", res);
        System.out.println(res);
        return "admin/items/detail";
    }

    // Admin user detail
    @RequestMapping("auserdetail")
    public String adminUserDetail(ModelMap m) {
        UserResponse res = new UserResponse();
        User u = new User();
        u.setId(1);
        u.setName("Pham Ngoc Tung");
        u.setUsername("tunggzsu128");
        u.setPassword("123");
        u.setPhone("941687974");
        u.setAddress("Da Nang City");
        u.setEmail("tungpham2127@gmail.com");
        u.setAvatarUrl("avatarUrl");
        res.setUser(u);
        m.addAttribute("res", res);
        System.out.println(res);
        return "admin/users/detail";
    }

    // Admin product detail
    @RequestMapping("aproductdetail")
    public String adminproductDetail(ModelMap m) {
        ProductResponse res = new ProductResponse();
        Product p = new Product();
        p.setId(1);
        p.setName("Iphone 8");
        // p.setShopItems("shopItems");
        // p.setCategory(category);
        // p.setBrand(brand);
        p.setStatus("Hoạt động");
        p.setDes("Lock nhật");
        res.setProduct(p);
        m.addAttribute("res", res);
        System.out.println(res);
        return "admin/products/detail";
    }

    // Admin shop detail
    @RequestMapping("/ashopdetail")
    public String adminShopDetail(ModelMap m) {
        // ShopResponse res = new ShopResponse();
        return "admin/shops/detail";
    }

}
