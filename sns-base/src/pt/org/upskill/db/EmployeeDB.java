package pt.org.upskill.db;

import pt.org.upskill.auth.Email;
import pt.org.upskill.domain.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDB implements PersistableObject<Employee> {

    @Override
    public boolean save(Connection connection, Employee object) {
        String sqlCmd;
        sqlCmd = "select * from Employee where id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
            ps.setInt(1, object.id());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    sqlCmd = "update Employee set name = ?, position = ?, snsnumber = ?, email = ? where id = ?";
                } else {
                    sqlCmd = "insert into Employee(name, position, snsnumber, email, id) values (?, ?, ?, ?, ?)";
                }
                //
                try (PreparedStatement ps2 = connection.prepareStatement(sqlCmd)) {
                    ps2.setString(1, object.getName());
                    ps2.setString(2, object.getPosition());
                    ps2.setString(3, object.getSnsNumber());
                    ps2.setString(4, object.getEmail().address());
                    ps2.setInt(5, object.id());
                    ps2.executeUpdate();
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(Connection connection, Employee object) {
        try {
            String sqlCmd;
            sqlCmd = "delete from Employee where id = ?";
            try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
                ps.setInt(1, object.id());
                ps.executeUpdate();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Employee getById(Connection connection, int id) {
        try {
            String sqlCmd;
            sqlCmd = "select * from Employee where id = ?";
            try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    Employee employee = null;
                    try {
                        employee = new Employee.Builder()
                                .withId(rs.getInt("id"))
                                .withName(rs.getString("name"))
                                .withPosition(rs.getString("position"))
                                .withSnsNumber(rs.getString("snsnumber"))
                                .withEmail(new Email(rs.getString("email")))
                                .build();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return employee;
                }
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
