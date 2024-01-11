package pt.org.upskill.ui.controller;

import pt.org.upskill.ui.auth.Email;
import pt.org.upskill.ui.domain.Employee;
import pt.org.upskill.ui.repository.EmployeeRepository;
import pt.org.upskill.ui.repository.Repositories;

import java.util.List;

public class EmployeeController {
    private final EmployeeRepository employeeRepository = Repositories.getInstance().employeeRepository();
    private Employee employee;


    public void createEmployee(String email, String name) throws Exception {
        employee = new Employee(new Email(email), name);
    }

    public void setEmployeePosition(String position) {
        employee.setPosition(position);
    }


    public void setEmployeePhone(String phone) {
        employee.setPhone(phone);
    }

    public boolean confirm() {
        employeeRepository.save(employee);
        return true;
    }

    public List<Employee> getEmployeesByRole(String role) {
        return employeeRepository.getEmployeesByRole(role);
    }
}
