package fpt.java.finalproject.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shops")
public class Shop implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private Integer phone;
    @Column
    private Date createdAt;
    @Column
    private String email;
    @Column
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @MapsId
    private User user;

    @ManyToOne
    @JoinColumn(name = "shop_pack_id")
    private ShopPack shopPack;

    @OneToMany(mappedBy = "shop")
    private Collection<ShopItem> shopItems;

    @OneToMany(mappedBy = "shop")
    private Collection<ShopEmployee> shopEmployees;

    public Shop() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ShopPack getShopPack() {
        return shopPack;
    }

    public void setShopPack(ShopPack shopPack) {
        this.shopPack = shopPack;
    }

    public Collection<ShopItem> getShopItems() {
        return shopItems;
    }

    public void setShopItems(Collection<ShopItem> shopItems) {
        this.shopItems = shopItems;
    }

    public Collection<ShopEmployee> getShopEmployees() {
        return shopEmployees;
    }

    public void setShopEmployees(Collection<ShopEmployee> shopEmployees) {
        this.shopEmployees = shopEmployees;
    }

}