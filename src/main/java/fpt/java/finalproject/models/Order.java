package fpt.java.finalproject.models;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "orders")
public class Order implements Serializable {
    private User user;
    private OrderStatus orderstatus;
    private Set<OrderDetail> orderdetail;
    @Id
    private Integer id;

    @Column
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }
    @ManyToOne
    @JoinColumn(name = "oder_status_id")
    public OrderStatus getOderStatus() {
        return orderstatus;
    }

    @OneToMany(mappedBy = "orderdetails", cascade = CascadeType.ALL)
    public Set<OrderDetail> getOrderDetail() {
        return orderdetail ;
    }

    public Order() {
    }

    public Order(User user, OrderStatus orderstatus, Set<OrderDetail> orderdetail, Integer id, Date date) {
        this.user = user;
        this.orderstatus = orderstatus;
        this.orderdetail = orderdetail;
        this.id = id;
        this.date = date;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderStatus getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(OrderStatus orderstatus) {
        this.orderstatus = orderstatus;
    }

    public Set<OrderDetail> getOrderdetail() {
        return orderdetail;
    }

    public void setOrderdetail(Set<OrderDetail> orderdetail) {
        this.orderdetail = orderdetail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
