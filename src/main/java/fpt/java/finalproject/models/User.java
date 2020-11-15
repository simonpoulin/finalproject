package fpt.java.finalproject.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "nvarchar(50) not null")
    private String name;

    @Column(columnDefinition = "nvarchar(50) not null")
    private String username;

    @Column(columnDefinition = "nvarchar(50) not null")
    private String password;

    @Column(columnDefinition = "nvarchar(10) not null")
    private String phone;

    @Column(columnDefinition = "nvarchar(500) not null")
    private String address;

    @Column(columnDefinition = "nvarchar(50) not null")
    private String email;

    @Column(columnDefinition = "nvarchar(500)")
    private String avatarUrl;

    @Column
    private Date createdAt;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Shop shop;

    @OneToMany(mappedBy = "user")
    private Collection<CartDetail> cartDetails;

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Collection<CartDetail> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(Collection<CartDetail> cartDetails) {
        this.cartDetails = cartDetails;
    }

}
