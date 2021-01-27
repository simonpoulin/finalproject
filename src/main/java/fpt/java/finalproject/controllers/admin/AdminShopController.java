package fpt.java.finalproject.controllers.admin;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fpt.java.finalproject.models.Employee;
import fpt.java.finalproject.models.Shop;
import fpt.java.finalproject.models.User;
import fpt.java.finalproject.response.AdminListResponse;
import fpt.java.finalproject.response.AdminObjectResponse;
import fpt.java.finalproject.utils.AdminQuery;
import fpt.java.finalproject.response.AdminResponse;
import fpt.java.finalproject.services.EmployeeService;
import fpt.java.finalproject.services.ShopPackService;
import fpt.java.finalproject.services.ShopService;
import fpt.java.finalproject.services.UserService;

@Controller
@RequestMapping("/admin/shops")
public class AdminShopController{

    @Autowired
    private ShopService shopService;

    @Autowired 
    private UserService userService;

    @Autowired 
    private ShopPackService shopPackService;

    @Autowired
    EmployeeService employeeService;

    public String response(ModelMap m, String routing, AdminListResponse<Shop> listResponse) {
        Employee authEmployee = employeeService.getAuthEmployee();
        listResponse.setAuthEmployee(authEmployee);
        m.addAttribute("res", listResponse);
        return routing;
    }

    public String response(ModelMap m, String routing, AdminObjectResponse<Shop> listResponse) {
        Employee authEmployee = employeeService.getAuthEmployee();
        listResponse.setAuthEmployee(authEmployee);
        m.addAttribute("res", listResponse);
        return routing;
    }

    // Direct to add page
    @GetMapping("/add")
    public String add(ModelMap m){
        
        AdminObjectResponse<Shop> res = new AdminObjectResponse<Shop>();
        Shop s = new Shop();

        res.setTitle("Thêm cửa hàng");

        // Send new response bean
        m.addAttribute("object", s);
        m.addAttribute("res", res);

        return response(m, "admin/shops/add_or_edit", res);

    }
    //end function add();

    // save new
    @PostMapping("/save")
    public String save(Shop s, ModelMap m){

        AdminResponse res = new AdminResponse();
        s.setCreatedAt(new Date(new Date().getTime()));

        try {
            s.setShopPack(shopPackService.findById(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // save new shop
        try{
            shopService.save(s);
        }catch(Exception ex){
            
            //return fail
            res.setErrorCode("404");
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            ex.printStackTrace();
            return "module/error";
        }
        // end try catch

        // Set response 
        res.setMessage("Lưu thành công");

        // Send response
        m.addAttribute("res", res);
        m.addAttribute("object", s);

        // Redirect to list
        return "redirect:/admin/shops";
    }

    // Direct to edit page
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") Integer id, ModelMap m){

        AdminObjectResponse<Shop> res = new AdminObjectResponse<>();
        Shop s = new Shop();
        // Find by id Shop
        try{
            s = shopService.findById(id);
        }catch(Exception ex){
            res.setErrorCode("404");
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }
        // end try catch

        // Set response
        res.setIsEdit(true);
        res.setTitle("Cập nhật thông tin");

        // Send response
        m.addAttribute("res", res);
        m.addAttribute("object", s);

        return response(m, "admin/shops/add_or_edit", res);
    }

    // List
    @GetMapping("")
    public String list(ModelMap m,
    @RequestParam(required = false, defaultValue = "0") Integer page,
    @RequestParam(required = false, defaultValue = "") String name
    ){

        AdminResponse obj = (AdminResponse) m.getAttribute("res");
        AdminListResponse<Shop> res = new AdminListResponse<>();
        if(obj == null){
            res = new AdminListResponse<>();
        }else{
            res.setNewResponse(res);
        }
        // end if else
        
        // Set paging string
        String pagingStr = "/admin/shops";
        AdminQuery query = new AdminQuery(name, 0, 0, 0, 0);
        pagingStr = query.generateResponseQuery(pagingStr);

        List<Shop> l;
        try{
            l = shopService.customFind(name);
            res.generateResponse(l, 0, page, pagingStr);
        }catch(Exception ex){
            if (!res.getIsEmpty()) {
                // return fail
                res.setErrorCode("404");
                res.setMessage(ex.getMessage());
                m.addAttribute("res", res);
                return "module/error";
            }
        }
        // end try catch
        res.setTitle("Danh sách cửa hàng");

        // Send AdminResponse
        m.addAttribute("res", res);
        return response(m, "admin/shops/list", res);
    }
    // End function list

    // Detail
    @GetMapping("detail/{id}")
    public String detail(@PathVariable(name ="id") Integer id, ModelMap m){

        Shop s = new Shop();
        AdminObjectResponse<Shop> res= new AdminObjectResponse<>();

        // Find Shop by id
        try{
            s = shopService.findById(id);
        }catch(Exception ex){
            // return error
            res.setErrorCode("404");
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }
        // End try catch

        // Set response
        res.setObject(s);
        res.setTitle("Thông tin cửa hàng");

        // Send AdminResponse
        m.addAttribute("res", res);
        return response(m, "admin/shops/detail", res);
    }
    //end function detail

    //Del
    @RequestMapping("/delete/{id}")
    public String del(@PathVariable(name = "id") Integer id, ModelMap m){
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        AdminResponse res = new AdminResponse();

        // find shop by id
        try{
            shopService.deleteById(id);
        }catch(Exception ex){
            res.setErrorCode("404");
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        // send AdminResponse
        m.addAttribute("res", res);

        return "redirect:/admin/shops";
    }
    
    @ModelAttribute(name = "users")
    public List<User> getUsers(){
        return userService.findAll();
    }
}
