package fpt.java.finalproject.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fpt.java.finalproject.models.ShopPack;
import fpt.java.finalproject.models.Employee;
import fpt.java.finalproject.response.AdminListResponse;
import fpt.java.finalproject.response.AdminObjectResponse;
import fpt.java.finalproject.models.AdminQuery;
import fpt.java.finalproject.response.AdminResponse;
import fpt.java.finalproject.services.ShopPackService;
import fpt.java.finalproject.services.EmployeeService;

@RequestMapping("/admin/shoppacks")
@Controller
public class ShopPackController {

    @Autowired
    ShopPackService shopPackService;

    @Autowired
    private EmployeeService employeeService;

    public String response(ModelMap m, String routing, AdminListResponse<ShopPack> res) {
        Employee authEmployee = employeeService.getAuthEmployee();
        res.setAuthEmployee(authEmployee);
        m.addAttribute("res", res);
        return routing;
    }

    public String response(ModelMap m, String routing, AdminObjectResponse<ShopPack> res) {
        Employee authEmployee = employeeService.getAuthEmployee();
        res.setAuthEmployee(authEmployee);
        m.addAttribute("res", res);
        return routing;
    }

    // Direct to add page
    @GetMapping("/add")
    public String add(ModelMap m) {

        AdminObjectResponse<ShopPack> res = new AdminObjectResponse<>();
        ShopPack c = new ShopPack();
        res.setTitle("Thêm gói cửa hàng");

        // Send new response bean
        m.addAttribute("object", c);

        return response(m, "admin/shoppacks/add_or_edit", res);
    }

    // Save new
    @PostMapping("/save")
    public String save(ShopPack c, ModelMap m) {

        AdminResponse res = new AdminResponse();

        // Save shopPack
        try {
            shopPackService.save(c);
        } catch (Exception ex) {
            // Return error on fail
            res.setErrorCode("404");
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        // Set response
        res.setMessage("Lưu thành công!");

        // Send response
        m.addAttribute("res", res);

        // Redirect to list page
        return "redirect:/admin/shoppacks";
    }

    // Direct to edit page
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") Integer id, ModelMap m) {

        AdminObjectResponse<ShopPack> res = new AdminObjectResponse<>();
        ShopPack c = new ShopPack();

        // Find shopPack
        try {
            c = shopPackService.findById(id);
        } catch (Exception ex) {
            // Return error on fail
            res.setErrorCode("404");
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        // Set response
        res.setIsEdit(true);
        res.setTitle("Cập nhật thông tin");

        // Send response
        m.addAttribute("object", c);

        return response(m, "admin/shoppacks/add_or_edit", res);
    }

    // List
    @GetMapping("")
    public String list(ModelMap m, 
    @RequestParam(required = false, defaultValue = "0") Integer page,
    @RequestParam(required = false, defaultValue = "") String name
    ) {

        AdminResponse obj = (AdminResponse) m.getAttribute("res");
        AdminListResponse<ShopPack> res = new AdminListResponse<>();
        if (obj == null) {
            res = new AdminListResponse<>();
        } else {
            res.setNewResponse(obj);
        }

        // Set paging string
        String pagingStr = "/admin/shoppacks";
        AdminQuery query = new AdminQuery(name, 0, 0, 0, 0);
        pagingStr = query.generateResponseQuery(pagingStr);

        // Set list
        List<ShopPack> l;
        try {
            l = shopPackService.customFind(name);
            res.generateResponse(l, 0, page, pagingStr);
        } catch (Exception ex) {
            if (!res.getIsEmpty()) {
                // Return error on fail
                res.setErrorCode("404");
                res.setMessage(ex.getMessage());
                m.addAttribute("res", res);
                return "module/error";
            }
        }
        res.setTitle("Danh sách gói cửa hàng");

        // Send response
        return response(m, "admin/shoppacks/list", res);
    }

    // Delete
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id, ModelMap m) {

        AdminResponse res = new AdminResponse();

        // Find shopPack
        try {
            shopPackService.deleteById(id);
        } catch (Exception ex) {
            // Return error on fail
            res.setErrorCode("404");
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        // Set response
        res.setTitle("Xóa gói cửa hàng thành công");

        // Send response
        m.addAttribute("res", res);

        return "redirect:/admin/shoppacks";
    }
}
