package fpt.java.finalproject.dtos;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import fpt.java.finalproject.models.Brand;
import fpt.java.finalproject.models.Category;
import fpt.java.finalproject.models.Employee;
import fpt.java.finalproject.models.Product;

public class ProductDto implements Serializable {

    private Integer id;

    private String name;

    private String des;

    private String status;

    private MultipartFile image;

    private String imageName;

    private Integer categoryId;

    private Integer empolyeeId;

    private Integer brandId;

    public ProductDto() {}

    public ProductDto(Product p) {
        this.id = p.getId();
        this.name = p.getName();
        this.des = p .getDes();
        this.status = p.getStatus();
        this.imageName = p.getImage();
        this.brandId = p.getBrand().getId();
        this.categoryId = p.getCategory().getId();
        this.empolyeeId = p. getEmpolyee().getId();
    }

    public Product convertToProduct() {
        Product p = new Product();
        if (this.id != null && this.id > 0) {
            p.setId(this.id);
        }

        p.setName(this.name);
        p.setDes(this.des);
        p.setStatus(this.status);
        p.setImage(this.imageName);

        if (this.categoryId != null || this.categoryId > 0) {
            Category c = new Category();
            c.setId(this.categoryId);
            p.setCategory(c);
        }

        if (this.empolyeeId != null || this.empolyeeId > 0) {
            Employee e = new Employee();
            e.setId(this.empolyeeId);
            p.setEmpolyee(e);
        }

        if (this.brandId != null || this.brandId > 0) {
            Brand b = new Brand();
            b.setId(this.brandId);
            p.setBrand(b);
        }

        return p;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getEmpolyeeId() {
        return empolyeeId;
    }

    public void setEmpolyeeId(Integer empolyeeId) {
        this.empolyeeId = empolyeeId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

}
