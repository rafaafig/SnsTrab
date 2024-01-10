package pt.org.upskill.ui.controller;
/**
 * @author Nuno Castro anc@isep.ipp.pt
 */

import pt.org.upskill.ui.domain.VaccineTech;
import pt.org.upskill.ui.repository.Repositories;
import pt.org.upskill.ui.repository.VaccineTechRepository;

import java.util.List;

public class VaccineTechController {
    VaccineTechRepository vaccineTechRepository = Repositories.getInstance().vaccineTechRepository();

    private VaccineTech vaccineTech;

    public void createVaccineTech(String name, String description) {
        vaccineTech = vaccineTechRepository.createVaccineTech(name, description);
    }

    public List<VaccineTech> vaccineTechList() {
        return vaccineTechRepository.vaccineTechList();
    }

    public String getVaccineTechName(int id) {
        return vaccineTechRepository.getById(id).name();
    }

    public boolean confirm() {
        vaccineTechRepository.save(vaccineTech);
        return true;
    }
}
