package fpt.java.finalproject.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Product_status")
public class ProductStatus implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String product_status_name;

    public ProductStatus() {
    }

    public ProductStatus(Integer id, String product_status_name) {
        this.id = id;
        this.product_status_name = product_status_name;
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
