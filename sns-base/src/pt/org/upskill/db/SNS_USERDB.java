package pt.org.upskill.db;

import pt.org.upskill.auth.Email;
import pt.org.upskill.domain.Employee;
import pt.org.upskill.domain.SNS_User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SNS_USERDB implements PersistableObject<SNS_User> {
    @Override
    public boolean save(Connection connection, SNS_User object) {
        String sqlCmd;
        sqlCmd = "select * from SNS_User where CC = ?";
        try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
            ps.setInt(1, object.CC());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    sqlCmd = "update Employee set name = ?, position = ?, snsnumber = ?, email = ? where id = ?";
                } else {
                    sqlCmd = "insert into Employee(name, position, snsnumber, email, id) values (?, ?, ?, ?, ?)";
                }
                //
                try (PreparedStatement ps2 = connection.prepareStatement(sqlCmd)) {
                    ps2.setInt(1, object.CC());
                    ps2.setString(2, object.password());
                    ps2.setString(3, object.e_mail());
                    ps2.setInt(5, object.phoneNumber());
                    ps2.executeUpdate();
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SNS_USERDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(Connection connection, SNS_User object) {
        try {
            String sqlCmd;
            sqlCmd = "delete from SNS_User where CC = ?";
            try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
                ps.setInt(1, object.CC());
                ps.executeUpdate();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SNS_USERDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public SNS_User getById(Connection connection, int CC) {
        try {
            String sqlCmd;
            sqlCmd = "select * from SNS_User where CC = ?";
            try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
                ps.setInt(1, CC);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    SNS_User user = null;
                    try {
                        user = new SNS_User.Builder()
                                .withCC(rs.getInt("CC"))
                                .withPassword(rs.getString("password"))
                                .withE_mail(rs.getString("e_mail"))
                                .withPhoneNumber(rs.getInt("phoneNumber"))
                                .build();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return user;
                }
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SNS_USERDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
