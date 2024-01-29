package pt.org.upskill.ui;

import pt.org.upskill.controller.PandemicController;
import pt.org.upskill.dto.PandemicDTO;

import static pt.org.upskill.ui.utils.Utils.readLineFromConsole;

public class RegisterPandemic extends UI {
    private final PandemicController pandemicController = new PandemicController();

    public void run() {
        System.out.println("");
        System.out.println("REGISTER Pandemic");
        System.out.println("-----------------");

        try {
            int ID_Pandemic = Integer.parseInt(readLineFromConsole("ID_Pandemic: "));
            String Name_Pandemic = readLineFromConsole("Name_Pandemic: ");

            //DTO
            PandemicDTO dto = new PandemicDTO.Builder()
                    .withID_Pandemic(ID_Pandemic)
                    .withName_Pandemic(Name_Pandemic)
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
