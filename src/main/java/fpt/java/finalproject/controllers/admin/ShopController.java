package fpt.java.finalproject.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fpt.java.finalproject.models.Shop;
import fpt.java.finalproject.response.ShopResponse;
import fpt.java.finalproject.services.ShopService;

@Controller
@RequestMapping("shop")
public class ShopController{

    private ShopResponse shopResponse;

    @Autowired
    private ShopService shopService;

    // Direct to add page
    @GetMapping("/add")
    public String add(ModelMap model){

        shopResponse = new ShopResponse();
        shopResponse.setTitle("Thêm cửa hàng");

        // Send new response bean
        model.addAttribute("res", shopResponse);
        
        return "admin/shops/add";
    }
    //end function add();

    // save new
    @PostMapping("/save")
    public String save(Shop shop, ModelMap model){

        shopResponse = new ShopResponse();

        // save new shop
        try{
            shopService.save(shop);
        }catch(Exception ex){
            
            //return fail
            shopResponse.setError(true);
            shopResponse.setMessage(ex.getMessage());
            model.addAttribute("res", shopResponse);
            return "module/error";
        }
        // end try catch

        // Set response 
        shopResponse.setMessage("Lưu thành công");

        // Send response
        model.addAttribute("res", shopResponse);

        // Redirect to list
        return "redirect:/admin/shop";
    }

    // Direct to edit page
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") Integer id, ModelMap model){

        shopResponse = new ShopResponse();
        Shop shop = new Shop();
        // Find by id Shop
        try{
            shop = shopService.findById(id);
        }catch(Exception ex){
            shopResponse.setError(true);
            shopResponse.setMessage(ex.getMessage());
            model.addAttribute("res", shopResponse);
            return "module/error";
        }
        // end try catch

        // Set response
        shopResponse.setShop(shop);
        shopResponse.setEdit(true);
        shopResponse.setTitle("Cập nhật thông tin");

        // Send response
        model.addAttribute("res", shopResponse);

        return "admin/shops/add";
    }

    // List
    @GetMapping("")
    public String list(ModelMap model){

        Object obj = model.getAttribute("res");
        List<Shop> list;
        if(obj == null){
            shopResponse = new ShopResponse();
        }else{
            shopResponse = (ShopResponse) obj;
        }
        // end if else

        try{
            list = shopService.findAll();
        }catch(Exception ex){

            // Return erroe on fail
            shopResponse.setError(true);
            shopResponse.setMessage(ex.getMessage());
            model.addAttribute("res", shopResponse);
            return "module/error";
        }
        // end try catch

        // Set response
        shopResponse.setShopList(list);
        shopResponse.setEdit(true);
        shopResponse.setTitle("Danh Sách Người Dùng");

        // Send Response
        model.addAttribute("res", shopResponse);
        return "admin/shops/list";
    }
    // End function list

    // Detail
    @GetMapping("/{id}")
    public String detail(@PathVariable(name ="id") Integer id, ModelMap model){

        shopResponse = new ShopResponse();
        Shop shop = new Shop();

        // Find Shop by id
        try{
            shop = shopService.findById(id);
        }catch(Exception ex){
            // return error
            shopResponse.setError(true);
            shopResponse.setMessage(ex.getMessage());
            model.addAttribute("res", shopResponse);
            return "module/error";
        }
        // End try catch

        // Set response
        shopResponse.setShop(shop);
        shopResponse.setTitle("Thông tin cửa hàng");

        // Send Response
        model.addAttribute("res", shopResponse);
        return "admin/shops/edit";
    }
    //end function detail

    //Del
    @DeleteMapping("/{id}")
    public String del(@PathVariable(name = "id") Integer id, ModelMap model){
        shopResponse = new ShopResponse();

        // find shop by id
        try{
            shopService.deleteById(id);
        }catch(Exception ex){
            shopResponse.setError(true);
            shopResponse.setMessage(ex.getMessage());
            model.addAttribute("res", shopResponse);
            return "module/error";
        }
        // Set Response

        shopResponse.setTitle("Xóa cửa hàng");

        // send Response
        model.addAttribute("res", shopResponse);

        return "redirect:/admin/shops";

    }
}
