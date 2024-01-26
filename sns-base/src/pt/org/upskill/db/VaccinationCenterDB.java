package pt.org.upskill.db;

import pt.org.upskill.domain.VaccinationCenter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VaccinationCenterDB implements PersistableObject<VaccinationCenter> {

    @Override
    public boolean save(Connection connection, VaccinationCenter object) {
        String sqlCmd;
        sqlCmd = "select * from VaccinationCenter where id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
            ps.setInt(1, object.id());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    sqlCmd = "update VaccinationCenter set name = ?, location = ?, contactinformation = ?, operatinghours = ? where id = ?";
                } else {
                    sqlCmd = "insert into VaccinationCenter(name, location, contactinformation, operatinghours, id) values (?, ?, ?, ?, ?)";
                }
                //
                try (PreparedStatement ps2 = connection.prepareStatement(sqlCmd)) {
                    ps2.setString(1, object.getName());
                    ps2.setString(2, object.getLocation());
                    ps2.setString(3, object.getContactinformation());
                    ps2.setString(4, object.getOperatinghours());
                    ps2.setInt(5, object.id());
                    ps2.executeUpdate();
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(VaccinationCenterDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(Connection connection, VaccinationCenter object) {
        try {
            String sqlCmd;
            sqlCmd = "delete from VaccinationCenter where id = ?";
            try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
                ps.setInt(1, object.id());
                ps.executeUpdate();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VaccinationCenterDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public VaccinationCenter getById(Connection connection, int id) {
        try {
            String sqlCmd;
            sqlCmd = "select * from VaccinationCenter where id = ?";
            try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    VaccinationCenter vaccinationCenter = null;
                    try {
                        vaccinationCenter = new VaccinationCenter.Builder()
                                .withId(rs.getInt("id"))
                                .withName(rs.getString("name"))
                                .withLocation(rs.getString("location"))
                                .withContactinformation(rs.getString("contactinformation"))
                                .withOperatinghours(rs.getString("operatinghours"))
                                .build();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return vaccinationCenter;
                }
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VaccinationCenterDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
