package pt.org.upskill.ui.domain;

public class VaccinationCenter {
        private String name;
        private String adress;
        private String pandemic;

    public VaccinationCenter(String name, String adress, String pandemic) {
        this.name = name;
        this.adress = adress;
        this.pandemic = pandemic;
    }

    public String name() {
            return name;
        }
    }


