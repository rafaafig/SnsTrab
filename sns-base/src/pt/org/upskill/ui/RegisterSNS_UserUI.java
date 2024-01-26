package pt.org.upskill.ui;

import pt.org.upskill.auth.Email;
import pt.org.upskill.controller.EmployeeController;
import pt.org.upskill.controller.SNS_UserController;
import pt.org.upskill.dto.EmployeeDTO;
import pt.org.upskill.dto.SNS_User_DTO;

import static pt.org.upskill.ui.utils.Utils.readLineFromConsole;

public class RegisterSNS_UserUI extends UI{
    private final SNS_UserController SNS_userController = new SNS_UserController();

    public void run() {
        System.out.println("");
        System.out.println("REGISTER SNS User");
        System.out.println("-----------------");

        try {
            int CC = Integer.parseInt(readLineFromConsole("SNS User CC: "));
            String password = readLineFromConsole("Provisory password: ");
            String e_mail = readLineFromConsole("Email: ");
            int phoneNumber = Integer.parseInt(readLineFromConsole("SNS User phone number: "));

            //DTO
            SNS_User_DTO dto = new SNS_User_DTO.Builder()
                    .withCC(CC)
                    .withPassword(password)
                    .withE_mail(e_mail)
                    .withPhoneNumber(phoneNumber)
                    .build();

            // Registration
            SNS_userController.register(dto);

            // Confirmation
            SNS_userController.save();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
