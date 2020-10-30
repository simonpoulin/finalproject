package fpt.java.finalproject.models;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column
    private String name;
    
    @Column(columnDefinition = "varchar not null")
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
    private String avatarUrl;

    @OneToOne(mappedBy = "user")
    private Shop shop;

    @OneToOne(mappedBy = "user")
    private Cart cart;

    @OneToMany(mappedBy = "user")
    private Collection<Order> orders;

    @OneToMany(mappedBy = "user")
    private Collection<ShopEmployee> shopEmployees;

    @OneToMany(mappedBy = "user")
    private Collection<Recipient> recipients;

    public User() {
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

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Collection<Order> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }

    public Collection<ShopEmployee> getShopEmployees() {
        return shopEmployees;
    }

    public void setShopEmployees(Collection<ShopEmployee> shopEmployees) {
        this.shopEmployees = shopEmployees;
    }

    public Collection<Recipient> getRecipients() {
        return recipients;
    }

    public void setRecipients(Collection<Recipient> recipients) {
        this.recipients = recipients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
