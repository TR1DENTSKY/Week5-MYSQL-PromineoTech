package DAO;

import Entity.Decepticons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DecepticonsDAO {

    private Connection connection;
    private final String GET_DECEPTICONS_BY_CHARACTER_ID_QUERY = "SELECT * FROM decepticons WHERE character_id = ?";
    private final String DELETE_CHARACTERS_BY_CHARACTER_ID_QUERY = "DELETE FROM decepticons_id = ?";
    private final String CREATE_NEW_DECEPTICONS_QUERY = "INSERT INTO decepticons(first_name, last_name, character_id) VALUES (?,?,?)";
    private final String DELETE_DECEPTICONS_BY_ID_QUERY = "DELETE FROM decepticons WHERE id = ?";

    public DecepticonsDAO() {
        connection = DBConnection.getConnection();

        public List<Decepticons> getDecepticonsByCharacterId(int transformersId) throws SQLException {
            PreparedStatement ps = connection.prepareStatement(GET_DECEPTICONS_BY_CHARACTER_ID_QUERY);
            ps.setInt(1, transformersId);
            ResultSet rs = ps.executeQuery();
            List<Decepticons> decepticons = new ArrayList<Decepticons>();

            while (rs.next()) {
                decepticons.add(new Decepticons(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        }
        return decepticons;
    }

    public void createNewDecepticons(String first_Name, String last_Name, int character_Id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(CREATE_NEW_DECEPTICONS_QUERY);
        ps.setString(1, first_Name);
        ps.setString(1, last_Name);
        ps.setInt(3, character_Id);
        ps.executeUpdate();
    }

    public void deleteCharactersByCharacterId (int character_Id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(DELETE_CHARACTERS_BY_CHARACTER_ID_QUERY);
        ps.setInt(1, character_Id);
        ps.executeUpdate();
    }

    public void deleteDecepticonsById (int character_Id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(DELETE_DECEPTICONS_BY_ID_QUERY);
        ps.setInt(1, character_Id);
        ps.executeUpdate();
    }
}
