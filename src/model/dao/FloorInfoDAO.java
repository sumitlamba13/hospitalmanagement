package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.FloorInfoTo;

public class FloorInfoDAO {

    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(FloorInfoTo record) {
        try {
            String query = "insert into floorinfo (floor_id,floor_type) values(?,?)";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getFloor_id());
            stmt.setString(2, record.getFloor_type());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean updateRecord(FloorInfoTo record) {
        try {
            String query = "update floorinfo set floor_type=? where floor_id=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getFloor_type());
            stmt.setString(2, record.getFloor_id());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean deleteRecord(String Floor_id) {
        try {
            String query = "delete from floorinfo where floor_id=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, Floor_id);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public FloorInfoTo getRecord(String floor_id) {
        try {
            String query = "select floor_id,floor_type from floorinfo where floor_id=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, floor_id);
            FloorInfoTo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new FloorInfoTo();
                result.setFloor_id(rs.getString("floor_id"));
                result.setFloor_type(rs.getString("floor_type"));
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }

    public List<FloorInfoTo> getAllRecord() {
        try {
            String query = "select floor_id,floor_type from floorinfo";
            PreparedStatement stmt = DataConnection.getStatement(query);
            ArrayList<FloorInfoTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                
                result = new ArrayList<FloorInfoTo>();
                do {
                    FloorInfoTo record = new FloorInfoTo();
                    record.setFloor_id(rs.getString("floor_id"));
                    record.setFloor_type(rs.getString("floor_type"));
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
