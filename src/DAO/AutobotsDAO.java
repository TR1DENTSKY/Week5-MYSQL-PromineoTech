package DAO;

import Entity.Autobots;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutobotsDAO {

    private Connection connection;
    private final String GET_AUTOBOTS_BY_TRANSFORMERS_ID_QUERY = "SELECT * FROM autobots WHERE transformers_id = ?";
    private final String DELETE_TRANSFORMERS_BY_TRANSFORMERS_ID_QUERY = "DELETE FROM autobots_id = ?";
    private final String CREATE_NEW_AUTOBOTS_QUERY = "INSERT INTO autobots(firstName, lastName, transformers_id) VALUES (?,?,?)";
    private final String DELETE_AUTOBOTS_BY_ID_QUERY = "DELETE FROM autobots WHERE id = ?";

    public List<Autobots> AutobotsDAO() {
        connection = DBConnection.getConnection();

        public List<Autobots> getAutobotsByTransformersId(int transformers_Id) throws SQLException {
            PreparedStatement ps = connection.prepareStatement(GET_AUTOBOTS_BY_TRANSFORMERS_ID_QUERY);
            ps.setInt(1, transformers_Id);
            ResultSet rs = ps.executeQuery();
            List<Autobots> autobots = new ArrayList<Autobots>();

            while (rs.next()) {
                autobots.add(new Autobots(rs.getInt(1), rs.getString(2), rs.getString(3)));

                return autobots;
            }

            public void createNewAutobots(String firstName, String lastName, int transformersId) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(CREATE_NEW_AUTOBOTS_QUERY);
                ps.setString(1, firstName);
                ps.setString(1, lastName);
                ps.setInt(3, transformers_Id);
                ps.executeUpdate();
            }
        }
        public void deletetransformerssBytransformersId (int transformers_Id) throws SQLException {
            PreparedStatement ps = connection.prepareStatement(DELETE_TRANSFORMERS_BY_TRANSFORMERS_ID_QUERY);
            ps.setInt(1, transformers_Id);
            ps.executeUpdate();
        }

        public void deleteAutobotsById (int transformers_Id) throws SQLException {
            PreparedStatement ps = connection.prepareStatement(DELETE_AUTOBOTS_BY_ID_QUERY);
            ps.setInt(1, transformers_Id);
            ps.executeUpdate();
        }
    }
}
