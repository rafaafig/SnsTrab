package pt.org.upskill.ui.repository;

import pt.org.upskill.ui.domain.Brand;
import pt.org.upskill.ui.domain.VaccinationCenter;
import pt.org.upskill.ui.domain.Vaccine;
import pt.org.upskill.ui.domain.VaccineType;

import java.util.ArrayList;
import java.util.List;

public class VaccinationCenterRepository implements Persistable  {

    public VaccinationCenterRepository() {}

    private List<VaccinationCenter> vaccinationCenterList = new ArrayList<VaccinationCenter>();

        public VaccinationCenter getByName(String name) {
            for (VaccinationCenter vaccineCenter : vaccinationCenterList()) {
                if (vaccineCenter.name() == name) {
                    return vaccineCenter;
                };
            }
            return null;
        }

        private Boolean validateSave(Object object) {
            return true;
        }

        private Boolean validateDelete(Object object) {
            return true;
        }

    public VaccinationCenter createVaccinationCenter(String name, String address, String pandemic) {
        return new VaccinationCenter(name, address, pandemic);
    }

    @Override
    public boolean save(Object object) {

       if (validateSave(object)) {
           vaccinationCenterList.add((VaccinationCenter) object);
           return true;
       }

        return false;
    }

    @Override
    public boolean delete(Object object) {
        if (validateDelete(object)) {
            vaccinationCenterList.remove(object);
            return true;
        }

        return false;

    }

    public List<VaccinationCenter> vaccinationCenterList() {
        return vaccinationCenterList;
    }
/*
    public List<VaccineTech> vaccineTechList() {
        return vaccineTechList;
    }

 */
}

