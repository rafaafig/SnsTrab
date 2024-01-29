package pt.org.upskill.dto;

public class PandemicDTO implements DTO{
    private Integer ID_Pandemic;
    private String NamePandemic;
    public Integer ID_Pandemic(){ return this.ID_Pandemic;}
    public String NamePandemic(){ return this.NamePandemic;}

    private PandemicDTO(final Builder builder) {
        this.ID_Pandemic = builder.ID_Pandemic;
        this.NamePandemic = builder.Name_Pandemic;
    }

    public static class Builder {
        private Integer ID_Pandemic;
        private String Name_Pandemic;
        public Builder withID_Pandemic(final Integer ID_Pandemic){
            this.ID_Pandemic = ID_Pandemic;
            return this;
        }
        public Builder withName_Pandemic(final String NamePandemic){
            this.Name_Pandemic = NamePandemic;
            return this;
        }
        public PandemicDTO build() { return new PandemicDTO(this);}
    }
}
