package fpt.java.finalproject.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import fpt.java.finalproject.models.Brand;
import fpt.java.finalproject.models.Employee;
import fpt.java.finalproject.models.EmployeeRole;
import fpt.java.finalproject.models.Product;
import fpt.java.finalproject.models.ShopItem;
import fpt.java.finalproject.response.ListResponse;
import fpt.java.finalproject.response.ObjectResponse;
import fpt.java.finalproject.response.ProductResponse;
import fpt.java.finalproject.response.ShopItemResponse;

@Controller
public class AdminController {

    // Blank layout
    @RequestMapping("/blank")
    public String blank() {
        return "module/blank_layout";
    }

    // Admin Empoyee details
    @RequestMapping("/aemployeedetail")
    public String adminEmployeeDetail(ModelMap m) {
        ObjectResponse<Employee> res = new ObjectResponse<>();

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
        res.setObject(e);
        res.setTitle("Employee detail");
        m.addAttribute("res", res);
        System.out.println(res);
        return "admin/employees/detail";
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

    // Test object response
    @RequestMapping("/or")
    public String objectResponse(ModelMap m) {

        // Set new Brand
        Brand b = new Brand();
        b.setId(1);
        b.setBrandName("brandName");

        // Set new ObjectResponse
        ObjectResponse<Brand> res = new ObjectResponse<>();
        res.setObject(b);
        res.setIsEdit(true);
        res.setTitle("Test");
        res.setMessage("Testing new response");

        // Send response
        m.addAttribute("res", res);
        return "test/testObject";
    }

    // Test entity response
    @RequestMapping("/lr")
    public String listResponse(ModelMap m) {

        // Set new Brand
        Brand b1 = new Brand();
        b1.setId(1);
        b1.setBrandName("abc");
        Brand b2 = new Brand();
        b2.setId(2);
        b2.setBrandName("ghi");
        Brand b3 = new Brand();
        b3.setId(3);
        b3.setBrandName("mno");
        Brand b4 = new Brand();
        b4.setId(4);
        b4.setBrandName("xyz");

        // Set new List
        List<Brand> l = new ArrayList<>();
        l.add(b1);
        l.add(b1);
        l.add(b1);
        l.add(b1);
        l.add(b2);
        l.add(b2);
        l.add(b2);
        l.add(b2);
        l.add(b3);
        l.add(b3);
        l.add(b3);
        l.add(b3);
        l.add(b4);
        l.add(b4);
        l.add(b4);
        l.add(b4);

        // Set new EntityResponse
        ListResponse<Brand> res = new ListResponse<>();
        try {
            res.generateResponse(l, 0, 0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        res.setTitle("Test");
        res.setMessage("Testing new response");

        // Send response
        m.addAttribute("res", res);
        return "test/testList";
    }



       //User*******************************************
    @RequestMapping("ublank")
    public String Blank() {
        return "module/blank_layout";
    }
    
    @RequestMapping("/personal")
    public String Personal() {
        return "user/account/personal";
    }
    @RequestMapping("/editpe")
    public String EditPersonal() {
        return "user/account/edit";
    }

    @RequestMapping("/cart")
    public String Cart() {
        return "user/carts/cart";
    }

    @RequestMapping("/umain")
    public String MainUser() {
        return "user/layouts/main";
    }
    @RequestMapping("/addoredit")
    public String AddOrEdit() {
        return "user/layouts/add_or_edit";
    }
    @RequestMapping("/udetail")
    public String Detail() {
        return "user/layouts/detail";
    }
    @RequestMapping("/ulist")
    public String List() {
        return "user/layouts/list";
    }


    @RequestMapping("/order")
    public String Order() {
        return "user/orders/order";
    }   
    
    @RequestMapping("/product")
    public String Pproduct() {
        return "user/products/product";
    }
    @RequestMapping("/productdetail")
    public String PproductDetail() {
        return "user/products/detail";
    }

    @RequestMapping("/employeesadd")
    public String EmployeesAdd() {
        return "user/sales/employees/add_or_edit";
    }
    @RequestMapping("/employeeslist")
    public String EmployeesList() {
        return "user/sales/employees/list";
    }
    @RequestMapping("/orderlist")
    public String OrderList() {
        return "user/sales/orders/list";
    }
    @RequestMapping("/productsadd")
    public String ProductsAdd() {
        return "user/sales/products/add_or_edit";
    }
    @RequestMapping("/productslist")
    public String ProductsList() {
        return "user/sales/products/list";
    }



    
}
