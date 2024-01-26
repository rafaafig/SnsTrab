package pt.org.upskill.repository;

import pt.org.upskill.db.ConnectionFactory;
import pt.org.upskill.db.DatabaseConnection;
import pt.org.upskill.db.VaccinationCenterDB;
import pt.org.upskill.domain.VaccinationCenter;
import pt.org.upskill.dto.DTO;
import pt.org.upskill.dto.KeyValueDTO;
import pt.org.upskill.dto.VaccinationCenterDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VaccinationCenterRepository implements PersistableRepo {

    private List<VaccinationCenter> vaccinationCenterList = new ArrayList<>();

    public int nextId() {
        int maxId = 0;
        for (VaccinationCenter center : vaccinationCenterList) {
            if (center.id() > maxId) {
                maxId = center.id();
            }
        }
        return maxId + 1;
    }

    public VaccinationCenter getById(int id) {
        for (VaccinationCenter center : vaccinationCenterList) {
            if (center.id() == id) {
                return center;
            }
        }
        return null;
    }

    private Boolean validateSave(VaccinationCenter center) {
        // Add validation logic if needed
        return true;
    }

    private Boolean validateDelete(VaccinationCenter center) {
        // Add validation logic if needed
        return true;
    }

    public VaccinationCenter createVaccinationCenter(DTO dto) throws Exception {
        // Assuming VaccinationCenterDTO is the DTO class for VaccinationCenter
        VaccinationCenterDTO vaccinationCenterDTO = (VaccinationCenterDTO) dto;
        return new VaccinationCenter.Builder()
                .withId(vaccinationCenterDTO.getId())
                .withName(vaccinationCenterDTO.getName())
                .withLocation(vaccinationCenterDTO.getLocation())
                .withContactinformation(vaccinationCenterDTO.getContactinformation())
                .withOperatinghours(vaccinationCenterDTO.getOperatinghours())
                .build();
    }



    @Override
    public boolean save(Object object) {
        ConnectionFactory cf = new ConnectionFactory(); // You may use your actual connection factory
        DatabaseConnection dbc = cf.getDatabaseConnection();
        Connection conn = dbc.getConnection();

        try {
            conn.setAutoCommit(false);

            VaccinationCenterDB vaccinationCenterDB = new VaccinationCenterDB();
            vaccinationCenterDB.save(conn, (VaccinationCenter) object);

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
        ConnectionFactory cf = new ConnectionFactory(); // You may use your actual connection factory
        DatabaseConnection dbc = cf.getDatabaseConnection();
        Connection conn = dbc.getConnection();

        try {
            conn.setAutoCommit(false);

            VaccinationCenterDB vaccinationCenterDB = new VaccinationCenterDB();
            vaccinationCenterDB.delete(conn, (VaccinationCenter) object);

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

    public List<VaccinationCenter> vaccinationCenterList() {
        return vaccinationCenterList;
    }

    public List<KeyValueDTO> keyValueDTOList() {
        List<KeyValueDTO> dtoList = new ArrayList<>();
        for (VaccinationCenter center : vaccinationCenterList()) {
            VaccinationCenterDTO dto = center.toDTO();
            dtoList.add(new KeyValueDTO(Integer.toString(dto.getId()), dto.getName()));
        }
        return dtoList;
    }
}
