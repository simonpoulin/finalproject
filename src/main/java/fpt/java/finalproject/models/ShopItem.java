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
@Table(name = "shopitem")
public class ShopItem implements Serializable{

    private Set<ShopItemImage> shopitemimage;
    private Set<OrderDetail> orderdetail;
    private Product product;
    private Set<CartDetail> cartdetail;
    private Shop shop;
    @Id
    private Integer id;
    @Column 
    private String title;
    @Column
    private String  des;
    @Column
    private Float price;
    @Column Integer quantity;


    @OneToMany(mappedBy = "shopitemmages", cascade = CascadeType.ALL)
    public Set<ShopItemImage> getItemImages() {
        return shopitemimage ;
    }
    @ManyToOne
    @JoinColumn(name = "product_id")
    public Product getProduct() {
        return product;
    }
    @ManyToOne
    @JoinColumn(name = "shop_id")
    public Shop getShop() {
        return shop;
    }
    @OneToMany(mappedBy = "orderdetails", cascade = CascadeType.ALL)
    public Set<OrderDetail> getOrderDetail() {
        return orderdetail ;
    }

    @OneToMany(mappedBy = "cartdetails", cascade = CascadeType.ALL)
    public Set<CartDetail> getCartDetail() {
        return cartdetail ;
    }

    public ShopItem() {
    }

    public ShopItem(Set<ShopItemImage> shopitemimage, Set<OrderDetail> orderdetail, Product product,
            Set<CartDetail> cartdetail, Shop shop, Integer id, String title, String des, Float price,
            Integer quantity) {
        this.shopitemimage = shopitemimage;
        this.orderdetail = orderdetail;
        this.product = product;
        this.cartdetail = cartdetail;
        this.shop = shop;
        this.id = id;
        this.title = title;
        this.des = des;
        this.price = price;
        this.quantity = quantity;
    }

    public Set<ShopItemImage> getShopitemimage() {
        return shopitemimage;
    }

    public void setShopitemimage(Set<ShopItemImage> shopitemimage) {
        this.shopitemimage = shopitemimage;
    }

    public Set<OrderDetail> getOrderdetail() {
        return orderdetail;
    }

    public void setOrderdetail(Set<OrderDetail> orderdetail) {
        this.orderdetail = orderdetail;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Set<CartDetail> getCartdetail() {
        return cartdetail;
    }

    public void setCartdetail(Set<CartDetail> cartdetail) {
        this.cartdetail = cartdetail;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    
}
