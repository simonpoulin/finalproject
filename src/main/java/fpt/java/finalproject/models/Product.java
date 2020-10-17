package fpt.java.finalproject.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product implements Serializable {
    private Set<ShopItem> shopitem;
    private Set<ProductImage> productimage;
    private Category category;
    private Brand brand;
    private Employee empolyee;
    private ProductStatus productstatus;
    @Id
    private Integer id;
    @Column
    private String name;
    @Column
    private String des;

    @OneToMany(mappedBy = "shop_item", cascade = CascadeType.ALL)
    public Set<ShopItem> getShopItems() {
        return shopitem ;
    }

    @OneToMany(mappedBy = "productimages", cascade = CascadeType.ALL)
    public Set<ProductImage> getProductImage() {
        return productimage ;
    }

    @ManyToOne
    @JoinColumn(name = "categoty_id")
    public Category getCategory() {
        return category;
    }
    @ManyToOne
    @JoinColumn(name = "employee_id")
    public Employee getEmpoloyee() {
        return empolyee;
    }
    @ManyToOne
    @JoinColumn(name = "product_status_id")
    public ProductStatus getStatusProduct() {
        return productstatus;
    }
    @ManyToOne
    @JoinColumn(name = "brand_id")
    public Brand getBrand() {
        return brand;
    }

    public Product() {
    }

    public Product(Set<ShopItem> shopitem, Set<ProductImage> productimage, Category category, Brand brand,
            Employee empolyee, ProductStatus productstatus, Integer id, String name, String des) {
        this.shopitem = shopitem;
        this.productimage = productimage;
        this.category = category;
        this.brand = brand;
        this.empolyee = empolyee;
        this.productstatus = productstatus;
        this.id = id;
        this.name = name;
        this.des = des;
    }

    public Set<ShopItem> getShopitem() {
        return shopitem;
    }

    public void setShopitem(Set<ShopItem> shopitem) {
        this.shopitem = shopitem;
    }

    public Set<ProductImage> getProductimage() {
        return productimage;
    }

    public void setProductimage(Set<ProductImage> productimage) {
        this.productimage = productimage;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
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

    

}
