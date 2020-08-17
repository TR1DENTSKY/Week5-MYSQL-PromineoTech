package DAO;

import Entity.Transformers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransformersDAO {

    private Connection connection;
    private TransformersDAO transformersDAO;
    private DecepticonsDAO decepticonsDAO;
    private AutobotsDAO autobotsDAO;
    private final String GET_TRANSFORMERS_QUERY = "SELECT * FROM transformers";
    private final String GET_TRANSFORMERS_BY_ID_QUERY = "SELECT * FROM transformers WHERE id = ?";
    private final String CREATE_NEW_TRANSFORMERS_QUERY = "INSERT INTO transformers(name) VALUES(?)";
    private final String DELETE_TRANSFORMERS_BY_ID_QUERY = "DELETE FROM transformers WHERE id = ?";

    public TransformersDAO() {
        connection = DBConnection.getConnection();
        transformersDAO = new TransformersDAO();
    }
    public List<Transformers> getTransformers() throws SQLException {
        ResultSet rs = connection.prepareStatement(GET_TRANSFORMERS_QUERY).executeQuery();
        List<Transformers> Transformers = new ArrayList<Transformers>();
        while (rs.next()) {
            Transformers.add(populateTransformers(rs.getInt(1), rs.getString(2)));
        }
        return Transformers;
    }
    public Transformers getTransformersId(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(GET_TRANSFORMERS_BY_ID_QUERY);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return populateTransformers(rs.getInt(1), rs.getString(2));
    }
    public void createNewTransformers(String TransformersName) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(CREATE_NEW_TRANSFORMERS_QUERY);
        ps.setString(1, TransformersName);
        ps.executeUpdate();
    }
    public void deleteTransformersByTransformersId(int id) throws SQLException {
        decepticonsDAO.deleteTransformersByTransformersId(id);
        PreparedStatement ps = connection.prepareStatement(DELETE_TRANSFORMERS_BY_ID_QUERY);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
    private Transformers populateTransformers(int id, String name) throws SQLException {
        return new Transformers(id, name, decepticonsDAO.getDecepticonsTransformersId(id));
    }
    private Transformers populateTransformers(int id, String name) throws SQLException {
        return new Transformers(id, name, autobotsDAO.getAutobotsTransformersId(id));
    }
}
