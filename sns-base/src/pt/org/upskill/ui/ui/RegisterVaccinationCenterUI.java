package pt.org.upskill.ui.ui;

import pt.org.upskill.ui.controller.BrandController;
import pt.org.upskill.ui.controller.VaccinationCenterController;
import pt.org.upskill.ui.controller.VaccineController;
import pt.org.upskill.ui.controller.VaccineTypeController;
import pt.org.upskill.ui.domain.Brand;
import pt.org.upskill.ui.domain.VaccinationCenter;
import pt.org.upskill.ui.domain.VaccineType;
import pt.org.upskill.ui.ui.utils.Utils;

import java.util.List;
import java.util.Scanner;

public class RegisterVaccinationCenterUI extends UI {

    private final VaccinationCenterController a = new VaccinationCenterController();


    public void run() {
        System.out.println("");
        System.out.println("CREATE VACCINATION CENTER");
        System.out.println("-----------");

        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Name");
            String name = s.nextLine();

            System.out.println("Address");
            String address = s.nextLine();

            System.out.println("Pandemic");
            String pandemic = s.nextLine();


            //Set data
            a.createVaccineCenter(name, address, pandemic);

            //Confirm
            a.confirm();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


