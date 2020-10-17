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
@Table(name ="shoppack")
public class ShopPack implements Serializable{

    private Set<Shop> shop;
    @Id
    private Integer id;
    @Column
    private String name;
    @Column
    private Float price;
    @Column
    private String Rank;
    
    @OneToMany(mappedBy = "shops", cascade = CascadeType.ALL)
    public Set<Shop> getShop() {
        return shop;
    }

    public ShopPack() {
    }

    public ShopPack(Set<Shop> shop, Integer id, String name, Float price, String rank) {
        this.shop = shop;
        this.id = id;
        this.name = name;
        this.price = price;
        Rank = rank;
    }

    public void setShop(Set<Shop> shop) {
        this.shop = shop;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getRank() {
        return Rank;
    }

    public void setRank(String rank) {
        Rank = rank;
    }

    
}
