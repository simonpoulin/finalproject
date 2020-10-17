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
@Table(name ="Product_status")
public class ProductStatus implements Serializable {
    private Set<Product> product;
    @Id
    private Integer id;
    @Column
    private String product_status_name;

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
    public Set<Product> getProduct() {
        return product ;
    }

    public ProductStatus() {
    }

    public ProductStatus(Set<Product> product, Integer id, String product_status_name) {
        this.product = product;
        this.id = id;
        this.product_status_name = product_status_name;
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

    public String getProduct_status_name() {
        return product_status_name;
    }

    public void setProduct_status_name(String product_status_name) {
        this.product_status_name = product_status_name;
    }

    
}
