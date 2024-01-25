package pt.org.upskill.domain;


import pt.org.upskill.dto.PandemicDTO;

public class Pandemic {
    private Integer ID_Pandemic;
    private String NamePandemic;
    public Integer ID_Pandemic(){ return this.ID_Pandemic;}
    public String NamePandemic(){ return this.NamePandemic;}

    private Pandemic(final Builder builder) {
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
        public Pandemic build() { return new Pandemic(this);}
    }

    @Override
    public PandemicDTO toDTO(){
        PandemicDTO.Builder builder = new PandemicDTO.Builder();
        if(ID_Pandemic() != null){
            builder.withID_Pandemic(ID_Pandemic());
        }
        if (NamePandemic() != null) {
            builder.withNamePandemic(NamePandemic());
        }
        return builder.build();
    }
}
