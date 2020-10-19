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
@Table(name = "shopitems")
public class ShopItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String title;
    @Column
    private String des;
    @Column
    private Float price;
    @Column
    Integer quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @OneToMany(mappedBy = "shopItem")
    private Collection<ShopItemImage> shopItemImages;

    @OneToMany(mappedBy = "shopItem")
    private Collection<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "shopItem")
    private Collection<CartDetail> cartDetails;

    public ShopItem() {
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Collection<ShopItemImage> getShopItemImages() {
        return shopItemImages;
    }

    public void setShopItemImages(Collection<ShopItemImage> shopItemImages) {
        this.shopItemImages = shopItemImages;
    }

    public Collection<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Collection<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Collection<CartDetail> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(Collection<CartDetail> cartDetails) {
        this.cartDetails = cartDetails;
    }

}
