package pt.org.upskill.dto;

import pt.org.upskill.domain.Pandemic;

public class PandemicDTO {
    private Integer ID_Pandemic;
    private String NamePandemic;
    public Integer ID_Pandemic(){ return this.ID_Pandemic;}
    public String NamePandemic(){ return this.NamePandemic;}

    private PandemicDTO(final Builder builder) {
        this.ID_Pandemic = builder.ID_Pandemic;
        this.NamePandemic = builder.NamePandemic;
    }

    public static class Builder {
        private Integer ID_Pandemic;
        private String NamePandemic;
        public Builder withID_Pandemic(final Integer ID_Pandemic){
            this.ID_Pandemic = ID_Pandemic;
            return this;
        }
        public Builder withNamePandemic(final String NamePandemic){
            this.NamePandemic = NamePandemic;
            return this;
        }
        public PandemicDTO build() { return new PandemicDTO(this);}
    }
}
