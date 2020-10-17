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
@Table(name ="brands")
public class Brand implements Serializable {
    private Set<Product> product;
    @Id
    private Integer id;
    @Column
    private String brand_name;

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
    public Set<Product> getProduct() {
        return product ;
    }

    public Brand() {
    }

    public Brand(Set<Product> product, Integer id, String brand_name) {
        this.product = product;
        this.id = id;
        this.brand_name = brand_name;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }
    
    
}
