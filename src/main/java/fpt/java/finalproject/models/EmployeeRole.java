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
@Table(name ="employeeroles")
public class EmployeeRole implements Serializable{
    private Set<Employee> empoloyee;
    @Id
    private Integer id;
    @Column
    private String role_name;

    @OneToMany(mappedBy = "employees", cascade = CascadeType.ALL)
    public Set<Employee> getEmpoloyees() {
        return empoloyee ;
    }

	public EmployeeRole() {
	}

    public EmployeeRole(Set<Employee> empoloyee, Integer id, String role_name) {
        this.empoloyee = empoloyee;
        this.id = id;
        this.role_name = role_name;
    }

    public Set<Employee> getEmpoloyee() {
        return empoloyee;
    }

    public void setEmpoloyee(Set<Employee> empoloyee) {
        this.empoloyee = empoloyee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
    

}
