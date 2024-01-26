package pt.org.upskill.domain;

import pt.org.upskill.dto.DTOable;
import pt.org.upskill.dto.SNSDTO;

import java.util.List;

public class SNS implements DTOable<SNSDTO> {
    private Integer ID_Registry;
    private Integer ID_VaccinationCenter;
    private String CC_Admin;
    public Integer ID_Registry(){ return this.ID_Registry;}
    public Integer ID_VaccinationCenter(){ return  this.ID_VaccinationCenter;}
    public String CC_Admin(){ return this.CC_Admin;}
    private SNS(final Builder builder){
        this.ID_Registry = builder.ID_Registry;
        this.ID_VaccinationCenter = builder.ID_VaccinationCenter;
        this.CC_Admin = builder.CC_Admin;
    }
    public static class Builder{
        private Integer ID_Registry;
        private Integer ID_VaccinationCenter;
        private String CC_Admin;
        public Builder withID_Registry(final Integer ID_Registry){
            this.ID_Registry = ID_Registry;
            return this;
        }
        public Builder withID_VaccinationCenter(final Integer ID_VaccinationCenter){
            this.ID_VaccinationCenter = ID_VaccinationCenter;
            return this;
        }
        public Builder withCC_Admin(final String CC_Admin){
            this.CC_Admin = CC_Admin;
            return this;
        }
        public SNS build(){ return  new SNS(this);}
    }
    @Override
    public SNSDTO toDTO(){
        SNSDTO.Builder builder = new SNSDTO.Builder();
        if(ID_Registry() != null){
            builder.withID_Registry(ID_Registry());
        }
        if (ID_VaccinationCenter() != null){
            builder.withID_VaccinationCenter(ID_VaccinationCenter());
        }
        if (CC_Admin() != null){
            builder.withCC_Admin(CC_Admin());
        }
        return builder.build();
    }
}
