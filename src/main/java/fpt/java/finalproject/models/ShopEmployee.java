package fpt.java.finalproject.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shopemployee")
public class ShopEmployee implements Serializable {
    private User user;
    private Shop shop;

    @Id
    private Integer shop_role_id;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    @ManyToOne
    @JoinColumn(name = "shop_id")
    public Shop getShop() {
        return shop;
    }

    public ShopEmployee() {
    }

    public ShopEmployee(User user, Shop shop, Integer shop_role_id) {
        this.user = user;
        this.shop = shop;
        this.shop_role_id = shop_role_id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Integer getShop_role_id() {
        return shop_role_id;
    }

    public void setShop_role_id(Integer shop_role_id) {
        this.shop_role_id = shop_role_id;
    }
    
    
    

}