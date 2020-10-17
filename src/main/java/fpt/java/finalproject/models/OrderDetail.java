package fpt.java.finalproject.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="orderdetails")
public class OrderDetail implements Serializable {
    private Order order;
    private ShopItem shopitem;

    @ManyToOne
    @JoinColumn(name = "order_id")
    public Order getOrder() {
        return order;
    }
    @ManyToOne
    @JoinColumn(name = "shop_item_id")
    public ShopItem getShopItem() {
        return shopitem;
    }

    public OrderDetail() {
    }

    public OrderDetail(Order order, ShopItem shopitem) {
        this.order = order;
        this.shopitem = shopitem;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ShopItem getShopitem() {
        return shopitem;
    }

    public void setShopitem(ShopItem shopitem) {
        this.shopitem = shopitem;
    }
    
}
