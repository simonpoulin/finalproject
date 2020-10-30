package fpt.java.finalproject.response;

import java.util.List;

import fpt.java.finalproject.models.Employee;

public class EmployeeResponse extends Response {
    
    private Employee employee;
    private List<Employee> employeeList;
    private boolean isEdit;

    public EmployeeResponse() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public boolean getIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

	@Override
	public String toString() {
		return "EmployeeResponse [eList=" + employeeList + ", employee=" + employee + ", isEdit=" + isEdit + "]";
	}

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

}
