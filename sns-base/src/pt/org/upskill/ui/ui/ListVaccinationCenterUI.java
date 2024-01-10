package pt.org.upskill.ui.ui;

import pt.org.upskill.ui.controller.VaccinationCenterController;
import pt.org.upskill.ui.controller.VaccineTechController;
import pt.org.upskill.ui.domain.VaccinationCenter;
import pt.org.upskill.ui.domain.VaccineTech;

import java.util.List;

public class ListVaccinationCenterUI extends UI {
    private final VaccinationCenterController vCC = new VaccinationCenterController();

    public void run() {
        System.out.println("");
        System.out.println("LIST VACCINATION CENTERS");
        System.out.println("-----------");

        try {
            List<VaccinationCenter> vaccinatioC = vCC.vaccinationCenterListList();
            for (VaccinationCenter vaccinationCenter : vaccinatioC) {
                System.out.println(vaccinationCenter.name());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

