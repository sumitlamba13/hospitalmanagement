package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.RoomTypeTo;

public class RoomTypeDAO {

    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(RoomTypeTo record) {
        try {
            String query = "insert into roomtype (type_id,type_name,charges) values(?,?,?)";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getType_id());
            stmt.setString(2, record.getType_name());
            stmt.setFloat(3, record.getCharges());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean updateRecord(RoomTypeTo record) {
        try {
            String query = "update roomtype set type_name=?, charges=? where type_id=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getType_name());
            stmt.setFloat(2, record.getCharges());
            stmt.setString(3, record.getType_id());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean deleteRecord(String type_id) {
        try {
            String query = "delete from roomtype where type_id=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, type_id);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public RoomTypeTo getRecord(String type_id) {
        try {
            String query = "select type_id,type_name,charges from roomtype where type_id=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, type_id);
            RoomTypeTo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new RoomTypeTo();
                result.setType_id(rs.getString("type_id"));
                result.setType_name(rs.getString("type_name"));
                result.setCharges(rs.getFloat("charges"));
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }

    public List<RoomTypeTo> getAllRecord() {
        try {
            String query = "select type_id,type_name,charges from roomtype";
            PreparedStatement stmt = DataConnection.getStatement(query);
            ArrayList<RoomTypeTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<RoomTypeTo>();
                do {
                    RoomTypeTo record = new RoomTypeTo();
                    record.setType_id(rs.getString("type_id"));
                    record.setType_name(rs.getString("type_name"));
                    record.setCharges(rs.getFloat("charges"));
                    result.add(record);
                } while (rs.next());
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }
}
