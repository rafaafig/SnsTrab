package pt.org.upskill.ui.controller;
import pt.org.upskill.ui.domain.*;
import pt.org.upskill.ui.repository.*;

import java.util.List;

public class VaccinationCenterController {
    VaccinationCenterRepository vaccinationCenterRepository = Repositories.getInstance().vaccinationCenterRepository();

    private VaccinationCenter vaccinationCenter;

    public void createVaccineCenter(String name, String address, String pandemic) {
        VaccinationCenterRepository vaccinationCenterRepository = Repositories.getInstance().vaccinationCenterRepository();
    }
    public List<VaccinationCenter> vaccinationCenterListList() {
        return vaccinationCenterRepository.vaccinationCenterList();
    }

    public boolean confirm() {
        vaccinationCenterRepository.save(vaccinationCenter);
        return true;
    }
}

