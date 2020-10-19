package fpt.java.finalproject.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="orderdetails")
public class OrderDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 
   
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "shop_item_id")
    private ShopItem shopItem;

    public OrderDetail() {
    }

    public OrderDetail(Order order, ShopItem shopItem) {
        this.order = order;
        this.shopItem = shopItem;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ShopItem getShopitem() {
        return shopItem;
    }

    public void setShopitem(ShopItem shopItem) {
        this.shopItem = shopItem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }
    
}
