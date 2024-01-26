package pt.org.upskill.repository;

import pt.org.upskill.db.ConnectionFactory;
import pt.org.upskill.db.DatabaseConnection;
import pt.org.upskill.db.EmployeeDB;
import pt.org.upskill.db.SNS_USERDB;
import pt.org.upskill.domain.Employee;
import pt.org.upskill.domain.SNS_User;
import pt.org.upskill.dto.DTO;
import pt.org.upskill.dto.EmployeeDTO;
import pt.org.upskill.dto.KeyValueDTO;
import pt.org.upskill.dto.SNS_User_DTO;
import pt.org.upskill.session.Context;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SNS_User_Repository implements PersistableRepo{
    public SNS_User_Repository() {
    }

    private List<SNS_User> SNS_User_List = new ArrayList<>();


    public SNS_User getByCC(int CC) {
        for (SNS_User user : SNS_User_List) {
            if (user.CC() == CC) {
                return user;
            }
        }
        return null;
    }

    private Boolean validateSave(SNS_User user) {
        // Add validation logic if needed
        return true;
    }

    private Boolean validateDelete(SNS_User user) {
        // Add validation logic if needed
        return true;
    }

    public SNS_User createSNS_User(DTO dto) throws Exception {
        SNS_User_DTO userDto = (SNS_User_DTO) dto;
        return new SNS_User.Builder()
                .withCC(SNS_User_DTO.CC())
                .withPassword(SNS_User_DTO.password())
                .withE_mail(SNS_User_DTO.e_mail())
                .withPhoneNumber(SNS_User_DTO.phoneNumber())
                .build();
    }

    @Override
    public boolean save(Object object) {
        ConnectionFactory cf = Context.getConnectionFactory();
        DatabaseConnection dbc = cf.getDatabaseConnection();
        Connection conn = dbc.getConnection();

        try {
            conn.setAutoCommit(false);

            SNS_USERDB snsUserdb = new SNS_USERDB();
            snsUserdb.save(conn, (SNS_User) object);

            conn.commit();
            return true;
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public boolean delete(Object object) {
        ConnectionFactory cf = Context.getConnectionFactory();
        DatabaseConnection dbc = cf.getDatabaseConnection();
        Connection conn = dbc.getConnection();

        try {
            conn.setAutoCommit(false);

            SNS_USERDB snsUserdb = new SNS_USERDB();
            snsUserdb.save(conn, (SNS_User) object);

            conn.commit();
            return true;
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        }
    }

    public List<SNS_User> SNS_User_list() {
        return SNS_User_List;
    }

    public List<KeyValueDTO> keyValueDTOList() {
        List<KeyValueDTO> dtoList = new ArrayList<>();
        for (SNS_User item : SNS_User_list()) {
            SNS_User_DTO dto = item.toDTO();
            dtoList.add(new KeyValueDTO(Integer.toString(dto.CC()), dto.e_mail()));
        }
        return dtoList;
    }
}
