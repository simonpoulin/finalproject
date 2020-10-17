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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shops")
public class Shop implements Serializable{
    private ShopPack shoppack;
    private User user;
    private Set<ShopEmployee> shopemployee;
    private Set<ShopItem> shopitem;
    @Id
    private Integer id;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private Integer phone;
    @Column 
    private Date created_at;
    @Column
    private String email;
    @Column
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public User getUser(){
        return user;
    }
    
    @ManyToOne
    @JoinColumn(name = "shop_pack_id")
    public ShopPack getShopPack() {
        return shoppack;
    }
    @OneToMany(mappedBy = "shopemployees", cascade = CascadeType.ALL)
    public Set<ShopEmployee> getShopEmployee() {
        return shopemployee;
    }
    @OneToMany(mappedBy = "shopitems", cascade = CascadeType.ALL)
    public Set<ShopItem> getShopItem() {
        return shopitem;
    }

    public Shop() {
    }

    public Shop(ShopPack shoppack, User user, Set<ShopEmployee> shopemployee, Set<ShopItem> shopitem, Integer id,
            String name, String address, Integer phone, Date created_at, String email, String status) {
        this.shoppack = shoppack;
        this.user = user;
        this.shopemployee = shopemployee;
        this.shopitem = shopitem;
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.created_at = created_at;
        this.email = email;
        this.status = status;
    }

    public ShopPack getShoppack() {
        return shoppack;
    }

    public void setShoppack(ShopPack shoppack) {
        this.shoppack = shoppack;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<ShopEmployee> getShopemployee() {
        return shopemployee;
    }

    public void setShopemployee(Set<ShopEmployee> shopemployee) {
        this.shopemployee = shopemployee;
    }

    public Set<ShopItem> getShopitem() {
        return shopitem;
    }

    public void setShopitem(Set<ShopItem> shopitem) {
        this.shopitem = shopitem;
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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
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

    
}