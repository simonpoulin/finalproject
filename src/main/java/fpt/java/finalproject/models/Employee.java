package fpt.java.finalproject.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="employees")
public class Employee implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private Date created_at;
    @Column
    private Integer phone;
    @Column
    private String address;
    @Column
    private String email;
    @Column
    private String avatar_url;

    @ManyToOne
    @JoinColumn(name = "employee_role_id")
    private EmployeeRole employeerole;

    public Employee() {
    }

    public Employee(Integer id, String username, String password, Date created_at, Integer phone, String address,
            String email, String avatar_url, EmployeeRole employeerole) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.created_at = created_at;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.avatar_url = avatar_url;
        this.employeerole = employeerole;
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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
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

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public EmployeeRole getEmployeerole() {
        return employeerole;
    }

    public void setEmployeerole(EmployeeRole employeerole) {
        this.employeerole = employeerole;
    }

    
    
}
