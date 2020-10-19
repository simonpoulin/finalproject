package fpt.java.finalproject.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String des; 

    @ManyToOne
    @JoinColumn(name = "categoty_id")
    private Category category;


    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee empolyee;

    @ManyToOne
    @JoinColumn(name = "product_status_id")
    private ProductStatus productstatus;


    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    public Product() {
    }

    public Product(Integer id, String name, String des, Category category, Employee empolyee,
            ProductStatus productstatus, Brand brand) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.category = category;
        this.empolyee = empolyee;
        this.productstatus = productstatus;
        this.brand = brand;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Employee getEmpolyee() {
        return empolyee;
    }

    public void setEmpolyee(Employee empolyee) {
        this.empolyee = empolyee;
    }

    public ProductStatus getProductstatus() {
        return productstatus;
    }

    public void setProductstatus(ProductStatus productstatus) {
        this.productstatus = productstatus;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    

    

}
