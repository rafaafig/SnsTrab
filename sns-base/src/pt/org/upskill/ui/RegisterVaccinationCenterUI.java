package pt.org.upskill.ui;

import pt.org.upskill.auth.Email;
import pt.org.upskill.controller.VaccinationCenterController;
import pt.org.upskill.dto.VaccinationCenterDTO;

import static pt.org.upskill.ui.utils.Utils.readLineFromConsole;

public class RegisterVaccinationCenterUI extends UI {

    private final VaccinationCenterController vaccinationCenterController = new VaccinationCenterController();

    public void run() {
        System.out.println("");
        System.out.println("REGISTER VACCINATION CENTER");
        System.out.println("---------------------------");

        try {
            String name = readLineFromConsole("Vaccination Center Name: ");
            String location = readLineFromConsole("Vaccination Center Location: ");
            String contactInformation = readLineFromConsole("Contact Information: ");
            String operatingHours = readLineFromConsole("Operating Hours: ");
            int id = Integer.parseInt(readLineFromConsole("Vaccination Center ID: "));

            // DTO
            VaccinationCenterDTO dto = new VaccinationCenterDTO.Builder()
                    .withName(name)
                    .withLocation(location)
                    .withContactinformation(contactInformation)
                    .withOperatinghours(operatingHours)
                    .withId(id)
                    .build();

            // Registration
            vaccinationCenterController.register(dto);

            // Confirmation
            vaccinationCenterController.save();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
