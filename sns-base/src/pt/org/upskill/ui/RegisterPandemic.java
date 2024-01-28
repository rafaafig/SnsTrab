package pt.org.upskill.ui;

import pt.org.upskill.auth.Email;
import pt.org.upskill.controller.EmployeeController;
import pt.org.upskill.controller.PandemicController;
import pt.org.upskill.dto.EmployeeDTO;
import pt.org.upskill.dto.PandemicDTO;

import static pt.org.upskill.ui.utils.Utils.readLineFromConsole;

public class RegisterPandemic extends UI {
    private final PandemicController pandemicController = new PandemicController();

    public void run() {
        System.out.println("");
        System.out.println("REGISTER Pandemic");
        System.out.println("-----------------");

        try {
            int idPandemic = Integer.parseInt(readLineFromConsole("ID Pandemic: "));
            String namePandemic = readLineFromConsole("Pandemic Name: ");

            //DTO
            PandemicDTO dto = new PandemicDTO.Builder()
                    .withID_Pandemic(idPandemic)
                    .withNamePandemic(namePandemic)
                    .build();

            // Registration
            pandemicController.register(dto);

            // Confirmation
            pandemicController.save();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
