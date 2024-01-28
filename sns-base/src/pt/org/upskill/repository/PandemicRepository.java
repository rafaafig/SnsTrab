package pt.org.upskill.repository;


import pt.org.upskill.db.ConnectionFactory;
import pt.org.upskill.db.DatabaseConnection;
import pt.org.upskill.db.PandemicDB;
import pt.org.upskill.db.SNS_USERDB;
import pt.org.upskill.domain.Pandemic;
import pt.org.upskill.domain.SNS_User;
import pt.org.upskill.dto.DTO;
import pt.org.upskill.dto.KeyValueDTO;
import pt.org.upskill.dto.PandemicDTO;
import pt.org.upskill.dto.SNS_User_DTO;
import pt.org.upskill.session.Context;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PandemicRepository implements PersistableRepo {
    public PandemicRepository() {
    }

    private List<Pandemic> Pandemic_List = new ArrayList<>();


    public Pandemic getByID(int ID_Pandemic) {
        for (Pandemic pandemic : Pandemic_List) {
            if (pandemic.ID_Pandemic() == ID_Pandemic) {
                return pandemic;
            }
        }
        return null;
    }

    private Boolean validateSave(Pandemic pandemic) {
        // Add validation logic if needed
        return true;
    }

    private Boolean validateDelete(Pandemic pandemic) {
        // Add validation logic if needed
        return true;
    }

    public Pandemic create_Pandemic(DTO dto) throws Exception {
        PandemicDTO pandemicDTO = (PandemicDTO) dto;
        return new Pandemic.Builder()
                .withID_Pandemic(pandemicDTO.ID_Pandemic())
                .withNamePandemic(pandemicDTO.NamePandemic())
                .build();
    }

    @Override
    public boolean save(Object object) {
        ConnectionFactory cf = Context.getConnectionFactory();
        DatabaseConnection dbc = cf.getDatabaseConnection();
        Connection conn = dbc.getConnection();

        try {
            conn.setAutoCommit(false);

            PandemicDB pandemicDB = new PandemicDB();
            pandemicDB.save(conn, (Pandemic) object);

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

            PandemicDB pandemicDB = new PandemicDB();
            pandemicDB.save(conn, (Pandemic) object);

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

    public List<Pandemic> Pande_List() {
        return Pande_List();
    }

    public List<KeyValueDTO> keyValueDTOList() {
        List<KeyValueDTO> dtoList = new ArrayList<>();
        for (Pandemic item : Pande_List()) {
            PandemicDTO dto = item.toDTO();
            dtoList.add(new KeyValueDTO(Integer.toString(dto.ID_Pandemic()), dto.NamePandemic()));
        }
        return dtoList;
    }
}
