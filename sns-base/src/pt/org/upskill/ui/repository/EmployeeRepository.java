package pt.org.upskill.ui.repository;

import pt.org.upskill.ui.auth.Email;
import pt.org.upskill.ui.domain.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements Persistable {

    private List<Employee> employeeList = new ArrayList<>();

    private boolean validateSave(Object object) {
        // Add validation logic if needed
        return true;
    }

    private boolean validateDelete(Object object) {
        // Add validation logic if needed
        return true;
    }

    public Employee createEmployee(String email, String name) throws Exception {
        return new Employee(new Email(email), name);
    }

    @Override
    public boolean save(Object object) {
        if (validateSave(object)) {
            employeeList.add((Employee) object);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Object object) {
        if (validateDelete(object)) {
            employeeList.remove(object);
            return true;
        }
        return false;
    }

    public List<Employee> employeeList() {
        return employeeList;
    }

    public List<Employee> getEmployeesByRole(String role) {
        List<Employee> employeesByRole = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (role.equals(employee.getPosition())) {
                employeesByRole.add(employee);
            }
        }
        return employeesByRole;
    }
}
