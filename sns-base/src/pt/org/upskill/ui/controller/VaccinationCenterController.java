package pt.org.upskill.ui.controller;
import pt.org.upskill.ui.domain.*;
import pt.org.upskill.ui.repository.*;

import java.util.List;

public class VaccinationCenterController {
    VaccinationCenterRepository vaccinationCenterRepository = Repositories.getInstance().vaccinationCenterRepository();

    private Vaccine vaccine;

    public void createVaccineCenter(String name, String address, String pandemic) {
        VaccinationCenter newCenter = vaccinationCenterRepository.createVaccinationCenter(name, address, pandemic);
    }
    public List<VaccinationCenter> vaccinationCenterListList() {
        return vaccinationCenterRepository.vaccinationCenterList();
    }

    public boolean confirm() {
        vaccinationCenterRepository.save(vaccine);
        return true;
    }


}

