package pt.org.upskill.ui.domain;

import pt.org.upskill.ui.repository.Repositories;
import pt.org.upskill.ui.repository.VaccineTechRepository;

public class VaccineTech {
    private int id;
    private String name;
    private String description;

    public VaccineTech(String name, String description) {
        VaccineTechRepository vaccineTechRepository = Repositories.getInstance().vaccineTechRepository();
        this.id = vaccineTechRepository.nextId();
        this.name = name;
        this.description = description;
    }

    public int id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String description() { return description; }
}