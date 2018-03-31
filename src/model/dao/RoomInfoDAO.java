package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.RoomInfoTo;

public class RoomInfoDAO {

    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(RoomInfoTo record) {
        try {
            String query = "insert into roominfo (room_no,floor_id,room_type,no_of_bed) values(?,?,?,?)";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getRoom_no());
            stmt.setString(2, record.getFloor_id());
            stmt.setString(3, record.getRoom_type());
            stmt.setInt(4, record.getNo_of_bed());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean updateRecord(RoomInfoTo record) {
        try {
            String query = "update roominfo set floor_id=?, room_type=?, no_of_bed=? where room_no=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getFloor_id());
            stmt.setString(2, record.getRoom_type());
            stmt.setInt(3, record.getNo_of_bed());
            stmt.setString(4, record.getRoom_no());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean deleteRecord(String room_no) {
        try {
            String query = "delete from roominfo where room_no=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, room_no);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public RoomInfoTo getRecord(String room_no) {
        try {
            String query = "select room_no,floor_id,room_type,no_of_bed from roominfo where room_no=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, room_no);
            RoomInfoTo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new RoomInfoTo();
                result.setRoom_no(rs.getString("room_no"));
                result.setFloor_id(rs.getString("floor_id"));
                result.setRoom_type(rs.getString("room_type"));
                result.setNo_of_bed(rs.getInt("no_of_bed"));
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }

    public List<RoomInfoTo> getAllRecord() {
        try {
            String query = "select room_no,r.floor_id,floor_type,r.room_type,type_name,no_of_bed from roominfo r ";
            query +=" join floorinfo f on r.floor_id=f.floor_id ";
            query +=" join roomtype rt on rt.type_id=r.room_type";
            PreparedStatement stmt = DataConnection.getStatement(query);
            ArrayList<RoomInfoTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<RoomInfoTo>();
                do {
                    RoomInfoTo record = new RoomInfoTo();
                    record.setRoom_no(rs.getString("room_no"));
                    record.setFloor_id(rs.getString("floor_id"));
                    record.setRoom_type(rs.getString("room_type"));
                    record.setNo_of_bed(rs.getInt("no_of_bed"));
                    record.setFloor_name(rs.getString("floor_type"));
                    record.setType_name(rs.getString("type_name"));
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

    public List<RoomInfoTo> getAllRecord(String typeid) {
        try {
            String query = "select room_no,floor_id,room_type,no_of_bed from roominfo ";
            query += " where room_type=? ";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, typeid);
            ArrayList<RoomInfoTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<RoomInfoTo>();
                do {
                    RoomInfoTo record = new RoomInfoTo();
                    record.setRoom_no(rs.getString("room_no"));
                    record.setFloor_id(rs.getString("floor_id"));
                    record.setRoom_type(rs.getString("room_type"));
                    record.setNo_of_bed(rs.getInt("no_of_bed"));
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
