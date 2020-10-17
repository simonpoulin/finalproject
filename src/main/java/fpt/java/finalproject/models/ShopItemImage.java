package fpt.java.finalproject.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shopitemimage")
public class ShopItemImage implements Serializable {
    private ShopItem shopitem;
    
    @Id
    private Integer id;
    @Column String imgae_url;

    @ManyToOne
    @JoinColumn(name = "shop_item_id")
    public ShopItem getCourse() {
        return shopitem;
    }

    public ShopItemImage() {
    }

    public ShopItemImage(ShopItem shopitem, Integer id, String imgae_url) {
        this.shopitem = shopitem;
        this.id = id;
        this.imgae_url = imgae_url;
    }

    public ShopItem getShopitem() {
        return shopitem;
    }

    public void setShopitem(ShopItem shopitem) {
        this.shopitem = shopitem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgae_url() {
        return imgae_url;
    }

    public void setImgae_url(String imgae_url) {
        this.imgae_url = imgae_url;
    }
    

    
}
