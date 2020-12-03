 package fpt.java.finalproject.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fpt.java.finalproject.dtos.ShopItemDto;
import fpt.java.finalproject.models.Employee;
import fpt.java.finalproject.models.Product;
import fpt.java.finalproject.models.Shop;
import fpt.java.finalproject.models.ShopItem;
import fpt.java.finalproject.response.AdminListResponse;
import fpt.java.finalproject.response.AdminObjectResponse;
import fpt.java.finalproject.utils.AdminQuery;
import fpt.java.finalproject.response.AdminResponse;
import fpt.java.finalproject.services.EmployeeService;
import fpt.java.finalproject.services.ProductService;
import fpt.java.finalproject.services.ShopItemService;
import fpt.java.finalproject.services.ShopService;

@Controller
@RequestMapping("/admin/items")
public class ShopItemController {
    
    @Autowired
    private ShopItemService shopItemService;

    @Autowired
    private ShopService shopService;

    @Autowired
    private ProductService productService;

    @Autowired
    EmployeeService employeeService;

    @ModelAttribute(name = "shops")
    public List<Shop> getShops() {
        return shopService.findAll();
    }

    @ModelAttribute(name = "products")
    public List<Product> getProducts() {
        return productService.findAll();
    }

    public String response(ModelMap m, String routing, AdminListResponse<ShopItem> listResponse) {
        Employee authEmployee = employeeService.getAuthEmployee();
        listResponse.setAuthEmployee(authEmployee);
        m.addAttribute("res", listResponse);
        return routing;
    }

    public String response(ModelMap m, String routing, AdminObjectResponse<ShopItem> listResponse) {
        Employee authEmployee = employeeService.getAuthEmployee();
        listResponse.setAuthEmployee(authEmployee);
        m.addAttribute("res", listResponse);
        return routing;
    }

    @GetMapping("/add")
    public String add(ModelMap m){
        
        AdminObjectResponse<ShopItem> res = new AdminObjectResponse<ShopItem>();
        ShopItemDto sI = new ShopItemDto();

        res.setTitle("Thêm mặt hàng");

        // Send new response bean
        m.addAttribute("object", sI);

        return response(m, "admin/items/add_or_edit", res);
    }
    //end function add

    // save new
    @PostMapping("/save")
    public String save(ModelMap m, @Validated ShopItemDto s, BindingResult r){

        AdminResponse res = new AdminResponse();
        // save new shopitem
        if (r.hasErrors()) {
            AdminObjectResponse<ShopItem> oRes = new AdminObjectResponse<ShopItem>();
            if (s.getId() != null || s.getId() > 0) {
                oRes.setTitle("Cập nhật thông tin");
                oRes.setIsEdit(true);
            } else {
                oRes.setTitle("Thêm mặt hàng");
                oRes.setIsEdit(false);
            }
            oRes.setTitle("Please input all forms");
            m.addAttribute("object", s);
            return response(m, "admin/items/add_or_edit", oRes);
        }

        try {
            shopItemService.save(s);
        } catch (Exception ex) {
           
            // Return fail
            res.setErrorCode("404");
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }
        //end try catch

        // Set response
        res.setMessage("Lưu thành công");

        //send response
        m.addAttribute("res", res);

        // Redirect to list
        return "redirect:/admin/items";
    }
    // end function save

    // edit
    @GetMapping("/edit/{id}")
    public String edit(ModelMap m, @PathVariable(name = "id") Integer id){

        AdminObjectResponse<ShopItem> res = new AdminObjectResponse<>();
        ShopItem sI = new ShopItem();

        //find by id shopitem
        try {
            sI = shopItemService.findById(id);
        } catch (Exception ex) {
           // Return fail
           res.setErrorCode("404");
           res.setMessage(ex.getMessage());
           m.addAttribute("res", res);
           return "module/error";
        }
        // end try catch
        // Send response
        ShopItemDto s = new ShopItemDto(sI);
        res.setIsEdit(true);
        res.setTitle("Cập nhật thông tin");
        m.addAttribute("object", s);

        return response(m, "admin/items/add_or_edit", res);
    }
    // end function edit

    //List
    @GetMapping("")
    public String list(ModelMap m, 
    @RequestParam(required = false, defaultValue = "0") Integer page,
    @RequestParam(required = false, defaultValue = "0") Integer productId,
    @RequestParam(required = false, defaultValue = "0") Integer shopId
    ){

        AdminResponse obj = (AdminResponse) m.getAttribute("res");
        List<ShopItem> l;
        AdminListResponse<ShopItem> res = new AdminListResponse<>();

        if (obj == null) {
            res = new AdminListResponse<>();
        } else {
            res.setNewResponse(obj);
        }

        // Set paging string
        String pagingStr = "/admin/items";
        AdminQuery query = new AdminQuery("", 0, 0, shopId, productId);
        pagingStr = query.generateResponseQuery(pagingStr);

        // end if else

        try {
            l = shopItemService.customFind(shopId, productId);
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
        // end try catch
        res.setTitle("Danh sách mặt hàng");

        // send response
        m.addAttribute("res", res);
        return response(m, "admin/items/list", res);
    }
    // end function list

    // Detail
    @GetMapping("/{id}")
    public String detail(@PathVariable(name ="id") Integer id, ModelMap m){

        AdminObjectResponse<ShopItem> res = new AdminObjectResponse<>();
        ShopItem sI = new ShopItem();

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
        // end function try catch

        // Set response
        res.setObject(sI);
        res.setTitle("Thông tin mặt hàng");

        // send response
        m.addAttribute("res", res);
        return response(m, "admin/items/detail", res);
    }
    // End function detail

    //del
    @RequestMapping("/delete/{id}")
    public String del(@PathVariable(name = "id") Integer id, ModelMap m){

        AdminResponse res = new AdminResponse();

        //dell by id
        try {
            shopItemService.deleteById(id);
        } catch (Exception ex) {
           // Return fail
           res.setErrorCode("404");
           res.setMessage(ex.getMessage());
           m.addAttribute("res", res);
           return "module/error";
        }
        // Set response
        res.setTitle("Xóa mặt hàng");

        // send response
        m.addAttribute("res", res);

        return "redirect:/admin/items";
    }
}
