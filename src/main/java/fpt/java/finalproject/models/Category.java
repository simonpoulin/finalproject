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
@Table(name ="categories")
public class Category implements Serializable{
    private Set<Product> products; 
    @Id
    private Integer id;
    @Column
    private String category_name;

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
    public Set<Product> getProduct() {
        return products ;
    }

    public Category() {
    }

    public Category(Set<Product> products, Integer id, String category_name) {
        this.products = products;
        this.id = id;
        this.category_name = category_name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    
}
