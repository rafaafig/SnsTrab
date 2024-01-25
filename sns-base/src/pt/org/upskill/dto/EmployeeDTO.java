package pt.org.upskill.dto;

import pt.org.upskill.auth.Email;

public class EmployeeDTO implements DTO {
    private String name;
    private String position;
    private String snsNumber;
    private Email email;
    private Integer id;

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getSnsNumber() {
        return snsNumber;
    }

    public Email getEmail() {
        return email;
    }

    public Integer getId() {
        return id;
    }

    private EmployeeDTO(Builder builder) {
        this.name = builder.name;
        this.position = builder.position;
        this.snsNumber = builder.snsNumber;
        this.email = builder.email;
        this.id = builder.id;
    }

    public static class Builder {
        private String name;
        private String position;
        private String snsNumber;
        private Email email;
        private Integer id;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withPosition(String position) {
            this.position = position;
            return this;
        }

        public Builder withSnsNumber(String snsNumber) {
            this.snsNumber = snsNumber;
            return this;
        }

        public Builder withEmail(Email email) {
            this.email = email;
            return this;
        }

        public Builder withId (int id) {
            this.id = id;
            return this;
        }

        public EmployeeDTO build() {
            return new EmployeeDTO(this);
        }
    }
}