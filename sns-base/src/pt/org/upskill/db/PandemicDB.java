package pt.org.upskill.db;

import pt.org.upskill.domain.Pandemic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PandemicDB implements PersistableObject<Pandemic> {
    @Override
    public boolean save(Connection connection, Pandemic object) {
        String sqlCmd;
        sqlCmd = "select * from Pandemic where ID_Pandemic = ?";
        try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
            ps.setInt(1, object.ID_Pandemic());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    sqlCmd = "update Pandemic set Name_Pandemic = ? where ID_Pandemic";
                } else {
                    sqlCmd = "insert into Pandemic(ID_Pandemic, Name_Pandemic) values (?,?)";
                }
                //
                try (PreparedStatement ps2 = connection.prepareStatement(sqlCmd)) {
                    ps2.setInt(1, object.ID_Pandemic());
                    ps2.setString(2, object.Name_Pandemic());
                    ps2.executeUpdate();
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PandemicDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(Connection connection, Pandemic object) {
        try {
            String sqlCmd;
            sqlCmd = "delete from Pandemic where ID_Pandemic = ?";
            try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
                ps.setInt(1, object.ID_Pandemic());
                ps.executeUpdate();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PandemicDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Pandemic getById(Connection connection, int ID_Pandemic) {
        try {
            String sqlCmd;
            sqlCmd = "select * from Pandemic where ID_Pandemic = ?";
            try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
                ps.setInt(1, ID_Pandemic);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    Pandemic user = null;
                    try {
                        user = new Pandemic.Builder()
                                .withID_Pandemic(rs.getInt("ID_Pandemic"))
                                .withName_Pandemic(rs.getString("Name_Pandemic"))
                                .build();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return user;
                }
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PandemicDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
