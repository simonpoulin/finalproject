package fpt.java.finalproject.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="cartdetails")
public class CartDetail implements Serializable {
    private ShopItem shopitem;
    private Cart cart;

    
    @Column
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "shop_item_id")
    public ShopItem getShopItem() {
        return shopitem;
    }
    @ManyToOne
    @JoinColumn(name = "cart_id")
    public Cart getCart() {
        return cart;
    }

    public CartDetail() {
    }

    public CartDetail(ShopItem shopitem, Cart cart, Integer quantity) {
        this.shopitem = shopitem;
        this.cart = cart;
        this.quantity = quantity;
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
    
    
}
