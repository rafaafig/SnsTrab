package pt.org.upskill.domain;

import pt.org.upskill.auth.Email;
import pt.org.upskill.dto.DTOable;
import pt.org.upskill.dto.EmployeeDTO;

public class Employee implements DTOable<EmployeeDTO> {
    private final Email email;
    private String name;
    private String position;
    private String snsNumber;
    private int id;

    public Employee(final Builder builder) {
        this.name = builder.name;
        this.position = builder.position;
        this.snsNumber = builder.snsNumber;
        this.email = builder.email;
        this.id = builder.id;
    }

    public int id(){
        return this.id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Email getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSnsNumber() {
        return snsNumber;
    }

    public void setSnsNumber(String snsNumber) {
        this.snsNumber = snsNumber;
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

    @Override
    public EmployeeDTO toDTO() {
        EmployeeDTO dto = new EmployeeDTO.Builder()
                .withName(getName())
                .withPosition(getPosition())
                .withSnsNumber(getSnsNumber())
                .withEmail(getEmail())
                .withId(getId())
                .build();
        return dto;
    }

    public static class Builder {
        private String name;
        private String position;
        private String snsNumber;
        private Email email;
        private Integer id;

        public Employee.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Employee.Builder withPosition(String position) {
            this.position = position;
            return this;
        }

        public Employee.Builder withSnsNumber(String snsNumber) {
            this.snsNumber = snsNumber;
            return this;
        }

        public Employee.Builder withEmail(Email email) {
            this.email = email;
            return this;
        }

        public Employee.Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}



