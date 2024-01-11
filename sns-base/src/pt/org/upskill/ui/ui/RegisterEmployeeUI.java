package pt.org.upskill.ui.ui;

import pt.org.upskill.ui.controller.EmployeeController;
import pt.org.upskill.ui.domain.Employee;
import pt.org.upskill.ui.ui.utils.Utils;

import java.util.Scanner;

public class RegisterEmployeeUI extends UI {

    private final EmployeeController employeeController = new EmployeeController();

    public void run() {
        System.out.println("");
        System.out.println("REGISTER NEW EMPLOYEE");
        System.out.println("-----------");

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Email");
            String email = scanner.nextLine();

            System.out.println("Name");
            String name = scanner.nextLine();

            // Create employee with email and name
            employeeController.createEmployee(email, name);

            // Set employee position
            System.out.println("Position");
            String position = scanner.nextLine();
            employeeController.setEmployeePosition(position);

            // Set employee phone
            System.out.println("Phone");
            String phone = scanner.nextLine();
            employeeController.setEmployeePhone(phone);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
