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

import fpt.java.finalproject.models.ShopItem;
import fpt.java.finalproject.response.ShopItemResponse;
import fpt.java.finalproject.services.ShopItemService;

@Controller
@RequestMapping("shopitem")
public class ShopItemController {
    
    private ShopItemResponse shopItemResponse;
    
    @Autowired
    private ShopItemService shopItemService;

    @GetMapping("/add")
    public String add(ModelMap model){
        
        shopItemResponse = new ShopItemResponse();
        shopItemResponse.setTitle("Thêm mặt hàng");

        // Send new response bean
        model.addAttribute("res", shopItemResponse);
        return "admin/shopitems/add";
    }
    //end function add

    // save new
    @PostMapping("/save")
    public String save(ModelMap model, ShopItem shopItem){

        shopItemResponse = new ShopItemResponse();

        // save new shopitem
        try {
            shopItemService.save(shopItem);
        } catch (Exception ex) {
           
            // Return fail
            shopItemResponse.setError(true);
            shopItemResponse.setMessage(ex.getMessage());
            model.addAttribute("res", shopItemResponse);
            return "module/error";
        }
        //end try catch

        // Set response
        shopItemResponse.setMessage("Lưu thành công");

        //send response
        model.addAttribute("res", shopItemResponse);

        // Redirect to list
        return "redirect:/admin/shopitems";
    }
    // end function save

    // edit
    @GetMapping("/edit/{id}")
    public String edit(ModelMap model, @PathVariable(name = "id") Integer id){

        shopItemResponse = new ShopItemResponse();
        ShopItem shopItem = new ShopItem();

        //find by id shopitem
        try {
            shopItem = shopItemService.findById(id);
        } catch (Exception ex) {
           // Return fail
           shopItemResponse.setError(true);
           shopItemResponse.setMessage(ex.getMessage());
           model.addAttribute("res", shopItemResponse);
           return "module/error";
        }
        // end try catch

        // Set response
        shopItemResponse.setShopItem(shopItem);
        shopItemResponse.setEdit(true);
        shopItemResponse.setTitle("cập nhật thành công");

        // Send response
        model.addAttribute("res", shopItemResponse);
        return "admin/shopitems/add";
    }
    // end function edit

    //List
    @GetMapping("")
    public String list(ModelMap model){

        Object obj = model.addAttribute("res");
        List<ShopItem> list;
        if(obj == null){
            shopItemResponse = new ShopItemResponse();
        }else{
            shopItemResponse = (ShopItemResponse) obj;
        }
        // end if else

        try {
            list = shopItemService.findAll();
        } catch (Exception ex) {
            // Return fail
            shopItemResponse.setError(true);
            shopItemResponse.setMessage(ex.getMessage());
            model.addAttribute("res", shopItemResponse);
            return "module/error";
        }
        // end try catch

        // Set response
        shopItemResponse.setShopItemList(list);
        shopItemResponse.setEdit(true);
        shopItemResponse.setTitle("Danh sách mặt hàng");

        // send response
        model.addAttribute("res", shopItemResponse);
        return "admin/shopitems/list";
    }
    // end function list

    // Detail
    @GetMapping("/{id}")
    public String detail(@PathVariable(name ="id") Integer id, ModelMap model){

        shopItemResponse = new ShopItemResponse();
        ShopItem shopItem = new ShopItem();

        // Find by id
        try {
            shopItem = shopItemService.findById(id);
        } catch (Exception ex) {
           // Return fail
           shopItemResponse.setError(true);
           shopItemResponse.setMessage(ex.getMessage());
           model.addAttribute("res", shopItemResponse);
           return "module/error";
        }
        // end function try catch

        // Set response
        shopItemResponse.setShopItem(shopItem);
        shopItemResponse.setTitle("Thông tin mặt hàng");

        // send response
        model.addAttribute("res", shopItemResponse);
        return "admin/shopitems/add";
    }
    // End function detail

    //del
    @DeleteMapping("/{id}")
    public String del(@PathVariable(name = "id") Integer id, ModelMap model){

        shopItemResponse = new ShopItemResponse();

        //dell by id
        try {
            shopItemService.deleteById(id);
        } catch (Exception ex) {
           // Return fail
           shopItemResponse.setError(true);
           shopItemResponse.setMessage(ex.getMessage());
           model.addAttribute("res", shopItemResponse);
           return "module/error";
        }
        // Set response
        shopItemResponse.setTitle("Xóa mặt hàng");

        // send response
        model.addAttribute("res", shopItemResponse);

        return "redirect:/admin/shopitems";
    }
}
