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
@Table(name = "shoproles")
public class ShopRole implements Serializable{
    private Set<ShopEmployee> shopemployee;
    @Id
    private Integer id;
    @Column
    private String role_name;

    @OneToMany(mappedBy = "shopemployee", cascade = CascadeType.ALL)
    public Set<ShopEmployee> getShopEmployee() {
        return shopemployee;
    }

    public ShopRole() {
    }

    public ShopRole(Set<ShopEmployee> shopemployee, Integer id, String role_name) {
        this.shopemployee = shopemployee;
        this.id = id;
        this.role_name = role_name;
    }

    public Set<ShopEmployee> getShopemployee() {
        return shopemployee;
    }

    public void setShopemployee(Set<ShopEmployee> shopemployee) {
        this.shopemployee = shopemployee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
    
    
}
