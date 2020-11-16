package fpt.java.finalproject.response;

import fpt.java.finalproject.models.Employee;

public class AdminResponse extends Response {
    
    private Employee authEmployee;

    public AdminResponse() {
    }

    public void setNewResponse(AdminResponse res) {
        this.setMessage(res.getMessage());
        this.setTitle(res.getTitle());
    }

    public Employee getAuthEmployee() {
        return authEmployee;
    }

    public void setAuthEmployee(Employee authEmployee) {
        this.authEmployee = authEmployee;
    }

}
