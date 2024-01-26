package pt.org.upskill.dto;

public class VaccinationCenterDTO implements DTO{
    private Integer id;
    private String name;
    private String location;
    private String contactinformation;
    private String operatinghours;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public static class Builder {
        private Integer id;
        private String name;
        private String location;
        private String contactinformation;
        private String operatinghours;

        public VaccinationCenterDTO.Builder withId(int id) {
            this.id = id;
            return this;
        }

        public VaccinationCenterDTO.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public VaccinationCenterDTO.Builder withLocation(String location) {
            this.location = location;
            return this;
        }

        public VaccinationCenterDTO.Builder withContactinformation(String contactinformation) {
            this.contactinformation = contactinformation;
            return this;
        }

        public VaccinationCenterDTO.Builder withOperatinghours(String operatinghours) {
            this.operatinghours = operatinghours;
            return this;
        }

        // Make the constructor package-private or public
        public VaccinationCenterDTO build() {
            return new VaccinationCenterDTO(this);
        }
    }

    // Make the constructor package-private or public
    public VaccinationCenterDTO(VaccinationCenterDTO.Builder builder) {
        // Copy fields from builder to DTO
        this.id = builder.id;
        this.name = builder.name;
        this.location = builder.location;
        this.contactinformation = builder.contactinformation;
        this.operatinghours = builder.operatinghours;
    }
}
