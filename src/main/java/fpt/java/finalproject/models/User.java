package fpt.java.finalproject.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable{

    private Shop shop;
    private Cart cart;
    private Set<Order> order;
    private Set<ShopEmployee> shopempolyee;

    @Id
    private Integer id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private Integer phone;
    @Column
    private String address;
    @Column
    private String email;
    @Column
    private String avatar_url;


    @OneToOne(mappedBy = "Shop")
    public Shop getShop() {
        return shop;
    }

    @ManyToOne
    @JoinColumn(name = "cart_id")
    public Cart getCart() {
        return cart;
    }
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    public Set<Order> getOrder() {
        return order ;
    }
    @OneToMany(mappedBy = "shopemployees", cascade = CascadeType.ALL)
    public Set<ShopEmployee> getShopEmployee() {
        return shopempolyee ;
    }

    public User() {
    }

    public User(Shop shop, Cart cart, Set<Order> order, Set<ShopEmployee> shopempolyee, Integer id, String username,
            String password, Integer phone, String address, String email, String avatar_url) {
        this.shop = shop;
        this.cart = cart;
        this.order = order;
        this.shopempolyee = shopempolyee;
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.avatar_url = avatar_url;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setOrder(Set<Order> order) {
        this.order = order;
    }

    public Set<ShopEmployee> getShopempolyee() {
        return shopempolyee;
    }

    public void setShopempolyee(Set<ShopEmployee> shopempolyee) {
        this.shopempolyee = shopempolyee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
    

}
