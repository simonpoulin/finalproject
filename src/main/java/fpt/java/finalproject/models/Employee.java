package fpt.java.finalproject.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "nvarchar(50) not null")
    private String name;

    @Column(columnDefinition = "nvarchar(50) not null")
    private String username;

    @Column(columnDefinition = "nvarchar(500) not null")
    private String password;

    @Column(columnDefinition = "date not null")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date createdAt;

    @Column(columnDefinition = "nvarchar(100) not null")
    private String phone;

    @Column(columnDefinition = "nvarchar(500) not null")
    private String address;

    @Column(columnDefinition = "nvarchar(50) not null")
    private String email;

    @Column(columnDefinition = "nvarchar(500)")
    private String avatarUrl;

    @ManyToOne
    @JoinColumn(name = "employee_role_id")
    private EmployeeRole employeeRole;

    @OneToMany(mappedBy = "empolyee")
    private Collection<Product> products;

    public Employee() {
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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

    public EmployeeRole getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employee [address=" + address + ", avatarUrl=" + avatarUrl + ", createdAt=" + createdAt + ", email="
                + email + ", employeeRole=" + employeeRole + ", id=" + id + ", name=" + name + ", password=" + password
                + ", phone=" + phone + ", products=" + products + ", username=" + username + "]";
    }

}
