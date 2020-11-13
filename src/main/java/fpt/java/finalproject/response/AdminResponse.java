package fpt.java.finalproject.response;

import fpt.java.finalproject.models.Employee;

public class AdminResponse extends Response {
    
    Employee authEmployee;

    public AdminResponse() {
    }

    public Employee getAuthEmployee() {
        return authEmployee;
    }

    public void setAuthEmployee(Employee authEmployee) {
        this.authEmployee = authEmployee;
    }

}
