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
@Table(name ="cartdetails")
public class CartDetail implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column 
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "shop_item_id")
    private ShopItem shopitem;


    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public CartDetail() {
    }

    public CartDetail(ShopItem shopitem, Cart cart, Integer quantity , Integer id) {
        this.shopitem = shopitem;
        this.cart = cart;
        this.quantity = quantity;
        this.id = id;
    }

    public ShopItem getShopitem() {
        return shopitem;
    }

    public void setShopitem(ShopItem shopitem) {
        this.shopitem = shopitem;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }
    
    
}
