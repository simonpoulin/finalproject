package fpt.java.finalproject.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="carts")
public class Cart implements Serializable{
    private Set<User> user;
    @Id
    private Integer id;

    @OneToMany(mappedBy = "Users", cascade = CascadeType.ALL)
    public Set<User> getUser() {
        return user ;
    }

    public Cart() {
    }

    public Cart(Set<User> user, Integer id) {
        this.user = user;
        this.id = id;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
}