package com.example.assessmentstartercode.warehousesystem;

public abstract class Employee {
    protected String employeeName;
    protected String employeeRole;
    protected String employeeLogin;
    protected String employeePassword;
    private static final Hashpassword hasher = new Hashpassword();

    public Employee(String employeeName, String employeeRole, String employeeLogin, String employeePassword) throws InputValidationException {
        setEmployeeName(employeeName);
        setEmployeeRole(employeeRole);
        setEmployeeLogin(employeeLogin);

        this.employeePassword = hasher.hash(employeePassword);
    }


    public void setEmployeeRole(String employeeRole) throws InputValidationException {
        if (employeeRole != null && (employeeRole.equals("manager") || employeeRole.equals("sales") || employeeRole.equals("warehouse"))) {
            this.employeeRole = employeeRole;
        } else {
            throw new InputValidationException("Invalid role");
        }
    }

    public void setEmployeeName(String employeeName) throws InputValidationException {
        if (employeeName != null && employeeName.matches("(\\p{ASCII}){3,25}")) {
            this.employeeName = employeeName;
        } else {
            throw new InputValidationException("Invalid name");
        }
    }

    public void setEmployeeLogin(String employeeLogin) throws InputValidationException {
        if (employeeLogin != null && employeeLogin.matches("(\\p{ASCII}){3,25}")) {
            this.employeeLogin = employeeLogin;
        } else {
            throw new InputValidationException("Invalid login");
        }
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public String getEmployeeLogin() {
        return employeeLogin;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public boolean login(String employeeLogin, String employeePassword) {

        String hashedInput = hasher.hash(employeePassword);

        return this.employeeLogin.equals(employeeLogin) && this.employeePassword.equals(hashedInput);
    }
}
