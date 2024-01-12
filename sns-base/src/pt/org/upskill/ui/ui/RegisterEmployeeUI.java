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
            employeeController.setEmployeeName(name);

            System.out.println("Position");
            String role = scanner.nextLine();
            employeeController.setEmployeePosition(role);

            System.out.println("Phone");
            int phone = Integer.parseInt(scanner.nextLine());
            employeeController.setEmployeePhone(phone);

            employeeController.createEmployee(email, name, role, phone);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
