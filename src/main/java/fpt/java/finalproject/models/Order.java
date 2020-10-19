package fpt.java.finalproject.models;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "oder_status_id")
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private Recipient recipient;

    

    @OneToMany(mappedBy = "order")
    private Collection<OrderDetail> orderDetails;

    public Order() {
    }

    public Order(Integer id, Date date, User user, OrderStatus orderStatus, Recipient recipient) {
        this.id = id;
        this.date = date;
        this.user = user;
        this.orderStatus = orderStatus;
        this.recipient = recipient;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderStatus getOrderstatus() {
        return orderStatus;
    }

    public void setOrderstatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    
    
}
