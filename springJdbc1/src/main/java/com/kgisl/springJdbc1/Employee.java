package com.kgisl.springJdbc1;

public class Employee {
    
    int empId;
    String empName;
    String empDept;
    String empEmail;
    String empPhone;

    public Employee(){}
    public Employee(int empId,String empName,  String empDept, String empEmail, String empPhone) {
        this.empName = empName;
        this.empId = empId;
        this.empDept = empDept;
        this.empEmail = empEmail;
        this.empPhone = empPhone;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpDept() {
        return empDept;
    }

    public void setEmpDept(String empDept) {
        this.empDept = empDept;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", empName=" + empName + ", empDept=" + empDept + ", empEmail=" + empEmail
                + ", empPhone=" + empPhone + "]";
    }

 

}
