package pt.org.upskill.ui.domain;

import pt.org.upskill.ui.auth.Email;

public class Employee {
    private final Email email;
    private String name;
    private String role;
    private int phone;

    public Employee(Email email, String name, String role, int phone) {
        this.email = email;
        this.name = name;
        this.role = role;
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public Email getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return email.equals(employee.email);
    }

    public boolean hasEmail(String email) {
        return this.email.address().equals(email);
    }
}