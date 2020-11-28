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

import fpt.java.finalproject.models.Brand;
import fpt.java.finalproject.models.Employee;
import fpt.java.finalproject.response.AdminListResponse;
import fpt.java.finalproject.response.AdminObjectResponse;
import fpt.java.finalproject.models.AdminQuery;
import fpt.java.finalproject.response.AdminResponse;
import fpt.java.finalproject.services.BrandService;
import fpt.java.finalproject.services.EmployeeService;

@RequestMapping("/admin/brands")
@Controller
public class BrandController {

    @Autowired
    BrandService brandService;

    @Autowired
    private EmployeeService employeeService;

    public String response(ModelMap m, String routing, AdminListResponse<Brand> res) {
        Employee authEmployee = employeeService.getAuthEmployee();
        res.setAuthEmployee(authEmployee);
        m.addAttribute("res", res);
        return routing;
    }

    public String response(ModelMap m, String routing, AdminObjectResponse<Brand> res) {
        Employee authEmployee = employeeService.getAuthEmployee();
        res.setAuthEmployee(authEmployee);
        m.addAttribute("res", res);
        return routing;
    }

    // Direct to add page
    @GetMapping("/add")
    public String add(ModelMap m) {

        AdminObjectResponse<Brand> res = new AdminObjectResponse<>();
        Brand b = new Brand();

        res.setTitle("Thêm nhãn hàng");

        // Send new response bean
        m.addAttribute("object", b);

        return response(m, "admin/brands/add_or_edit", res);
    }

    // Save new
    @PostMapping("/save")
    public String save(Brand b, ModelMap m) {

        AdminResponse res = new AdminResponse();

        // Save brand
        try {
            brandService.save(b);
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
        return "redirect:/admin/brands";
    }

    // Direct to edit page
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") Integer id, ModelMap m) {

        AdminObjectResponse<Brand> res = new AdminObjectResponse<>();
        Brand b = new Brand();

        // Find brand
        try {
            b = brandService.findById(id);
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
        m.addAttribute("object", b);
        return response(m, "admin/brands/add_or_edit", res);
    }

    // List
    @GetMapping("")
    public String list(ModelMap m, 
    @RequestParam(required = false, defaultValue = "0") Integer page,
    @RequestParam(required = false, defaultValue = "") String name
    ) {

        AdminResponse obj = (AdminResponse) m.getAttribute("res");
        List<Brand> l;
        AdminListResponse<Brand> res = new AdminListResponse<>();
        if (obj == null) {
            res = new AdminListResponse<>();
        } else {
            res.setNewResponse(obj);
        }

        // Set paging string
        String pagingStr = "/admin/brands";
        AdminQuery query = new AdminQuery(name, 0, 0, 0, 0);
        pagingStr = query.generateResponseQuery(pagingStr);
        String sqlClause = query.generateSQLQuery();

        // Set response
        
        try {
            l = brandService.customFind(sqlClause);
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
        res.setTitle("Danh sách nhãn hàng");

        // Send response
        return response(m, "admin/brands/list", res);
    }

    // Delete
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id, ModelMap m) {

        AdminResponse res = new AdminResponse();

        // Find brand
        try {
            brandService.deleteById(id);
        } catch (Exception ex) {
            // Return error on fail
            res.setErrorCode("404");
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        // Set response
        res.setTitle("Xóa nhãn hàng thành công");

        // Send response
        m.addAttribute("res", res);

        return "redirect:/admin/brands";
    }
}
