package pt.org.upskill.domain;

import pt.org.upskill.auth.Email;
import pt.org.upskill.dto.DTOable;
import pt.org.upskill.dto.EmployeeDTO;
import pt.org.upskill.dto.SNS_User_DTO;

public class SNS_User implements DTOable<SNS_User_DTO> {

    private int CC;
    private String password;
    private String e_mail;
    private int phoneNumber;

    public SNS_User(final Builder builder) {
        this.CC = builder.CC;
        this.password = builder.password;
        this.e_mail = builder.e_mail;
        this.phoneNumber = builder.phoneNumber;
    }

    public int CC(){
        return this.CC;
    }

    public String password(){ return this.password;}

    public String e_mail() {
        return this.e_mail;
    }

    public int phoneNumber() { return this.phoneNumber;}


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SNS_User)) {
            return false;
        }
        SNS_User sns_user = (SNS_User) o;
        return CC == sns_user.CC;
    }

    @Override
    public SNS_User_DTO toDTO() {
        SNS_User_DTO sns_user_dto = new SNS_User_DTO().Builder()
                .withCC(CC())
                .withPassword(password())
                .withE_mail(e_mail())
                .withPhoneNumber(phoneNumber())
                .build();
        return sns_user_dto;
    }

    public static class Builder {
        private int CC;
        private String password;
        private String e_mail;
        private int phoneNumber;

        public SNS_User.Builder withCC(int CC) {
            this.CC = CC;
            return this;
        }

        public SNS_User.Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public SNS_User.Builder withE_mail(String e_mail) {
            this.e_mail = e_mail;
            return this;
        }

        public SNS_User.Builder withPhoneNumber(int phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public SNS_User build() {
            return new SNS_User(this);
        }
    }
}
