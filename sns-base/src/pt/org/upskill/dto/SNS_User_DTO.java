package pt.org.upskill.dto;

import pt.org.upskill.auth.Email;

public class SNS_User_DTO implements DTO{
    private int CC;
    private String password;
    private String e_mail;
    private int phoneNumber;

    private SNS_User_DTO(Builder builder) {
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

    public static class Builder {
        private int CC;
        private String password;
        private String e_mail;
        private int phoneNumber;


        public SNS_User_DTO.Builder withCC(int CC) {
            this.CC = CC;
            return this;
        }

        public SNS_User_DTO.Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public SNS_User_DTO.Builder withE_mail(String e_mail) {
            this.e_mail = e_mail;
            return this;
        }

        public SNS_User_DTO.Builder withPhoneNumber(int phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public SNS_User_DTO build() {
            return new SNS_User_DTO(this);
        }
    }
}
