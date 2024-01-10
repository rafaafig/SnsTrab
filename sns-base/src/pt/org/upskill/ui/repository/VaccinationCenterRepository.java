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
    /*
        public int nextId() {
            int maxId = 0;
            for (VaccineTech vaccineTech : vaccineTechList) {
                if (vaccineTech.id() > maxId) {
                    maxId = vaccineTech.id();
                };
            }
            return maxId+1;
        }



        public VaccineTech getById(int id) {
            for (VaccineTech vaccineTech : vaccineTechList) {
                if (vaccineTech.id() == id) {
                    return vaccineTech;
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
    */
    public VaccinationCenter createVaccinationCenter(String name, String address, String pandemic) {
        return new VaccinationCenter(name, address, pandemic);
    }

    @Override
    public boolean save(Object object) {

//        if (validateSave(object)) {
//            vaccineTechList.add((VaccineTech) object);
//            return true;
//        }
//
        return false;
    }

    @Override
    public boolean delete(Object object) {
        /*
        if (validateDelete(object)) {
            vaccineTechList.remove(object);
            return true;
        }
        */
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

