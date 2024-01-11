package pt.org.upskill.ui.ui;

import pt.org.upskill.ui.controller.EmployeeController;
import pt.org.upskill.ui.domain.Employee;

import java.util.List;

public class ListEmployeesWithRoleUI extends UI {
    private final EmployeeController employeeController = new EmployeeController();

    public void run() {
        System.out.println("");
        System.out.println("LIST EMPLOYEES BY ROLE");
        System.out.println("-----------");

        try {
            // Assuming you have a method in EmployeeController for getting employees by role
            List<Employee> employeesByRole = employeeController.getEmployeesByRole("desiredRole");

            if (employeesByRole.isEmpty()) {
                System.out.println("No employees found with the specified role.");
            } else {
                for (Employee employee : employeesByRole) {
                    System.out.println("Email: " + employee.getEmail().address() +
                            " - Name: " + employee.getName() +
                            " - Position: " + employee.getPosition() +
                            " - Phone: " + employee.getPhone());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

