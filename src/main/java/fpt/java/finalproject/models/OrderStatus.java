package fpt.java.finalproject.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="orderstatuses")
public class OrderStatus implements Serializable {
    private Set<Order> order;

    @Id
    private Integer id;
    @Column
    private String status_name;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    public Set<Order> getOrder() {
        return order ;
    }

    public OrderStatus() {
    }

    public OrderStatus(Set<Order> order, Integer id, String status_name) {
        this.order = order;
        this.id = id;
        this.status_name = status_name;
    }

    public void setOrder(Set<Order> order) {
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }

    
}
