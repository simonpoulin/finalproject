package fpt.java.finalproject.models;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(500) not null")
    private String name;

    @Column(columnDefinition = "varchar(500) not null")
    private String des;

    @Column(columnDefinition = "varchar(50) not null")
    private String status;

    @ManyToOne
    @JoinColumn(name = "categoty_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee empolyee;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "product")
    private Collection<ProductImage> productImages;

    @OneToMany(mappedBy = "product")
    private Collection<ShopItem> shopItems;

    public Product() {
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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Collection<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(Collection<ProductImage> productImages) {
        this.productImages = productImages;
    }

    public Collection<ShopItem> getShopItems() {
        return shopItems;
    }

    public void setShopItems(Collection<ShopItem> shopItems) {
        this.shopItems = shopItems;
    }

}
