package pt.org.upskill.domain;

import pt.org.upskill.auth.Email;
import pt.org.upskill.dto.DTOable;
import pt.org.upskill.dto.EmployeeDTO;
import pt.org.upskill.dto.VaccinationCenterDTO;

import java.util.Objects;

public class VaccinationCenter implements DTOable<VaccinationCenterDTO> {
    private int id;
    private String name;
    private String location;
    private String contactinformation;
    private String operatinghours;


    public VaccinationCenter(final Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.location = builder.location;
        this.contactinformation = builder.contactinformation;
        this.operatinghours = builder.operatinghours;
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactinformation() {
        return contactinformation;
    }

    public void setContactinformation(String contactinformation) {
        this.contactinformation = contactinformation;
    }

    public String getOperatinghours() {
        return operatinghours;
    }

    public void setOperatinghours(String operatinghours) {
        this.operatinghours = operatinghours;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        VaccinationCenter other = (VaccinationCenter) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }


    @Override
    public VaccinationCenterDTO toDTO() {
        VaccinationCenterDTO dto = new VaccinationCenterDTO.Builder()
                .withId(getId())
                .withName(getName())
                .withLocation(getLocation())
                .withContactinformation(getContactinformation())
                .withOperatinghours(getOperatinghours())
                .build();
        return dto;
    }


    public static class Builder {
        private Integer id;
        private String name;
        private String location;
        private String contactinformation;
        private String operatinghours;
        public VaccinationCenter.Builder withId(int id) {
            this.id = id;
            return this;
        }

        public VaccinationCenter.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public VaccinationCenter.Builder withLocation(String location) {
            this.location = location;
            return this;
        }

        public VaccinationCenter.Builder withContactinformation(String contactinformation) {
            this.contactinformation = contactinformation;
            return this;
        }

        public VaccinationCenter.Builder withOperatinghours(String operatinghours) {
            this.operatinghours = operatinghours;
            return this;
        }



        public VaccinationCenter build() {
            return new VaccinationCenter(this);
        }
    }
}



