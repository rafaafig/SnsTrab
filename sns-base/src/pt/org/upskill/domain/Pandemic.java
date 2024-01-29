package pt.org.upskill.domain;


import pt.org.upskill.dto.DTOable;
import pt.org.upskill.dto.PandemicDTO;

public class Pandemic implements DTOable<PandemicDTO> {
    private Integer ID_Pandemic;
    private String Name_Pandemic;
    public Integer ID_Pandemic(){ return this.ID_Pandemic;}
    public String Name_Pandemic(){ return this.Name_Pandemic;}

    private Pandemic(final Builder builder) {
        this.ID_Pandemic = builder.ID_Pandemic;
        this.Name_Pandemic = builder.Name_Pandemic;
    }

    public static class Builder {
        private Integer ID_Pandemic;
        private String Name_Pandemic;
        public Builder withID_Pandemic(final Integer ID_Pandemic){
            this.ID_Pandemic = ID_Pandemic;
            return this;
        }
        public Builder withName_Pandemic(final String Name_Pandemic){
            this.Name_Pandemic = Name_Pandemic;
            return this;
        }
        public Pandemic build() { return new Pandemic(this);}
    }

    @Override
    public PandemicDTO toDTO(){
        PandemicDTO.Builder builder = new PandemicDTO.Builder();
        if(ID_Pandemic() != null){
            builder.withID_Pandemic(ID_Pandemic());
        }
        if (Name_Pandemic() != null) {
            builder.withName_Pandemic(Name_Pandemic());
        }
        return builder.build();
    }
}
