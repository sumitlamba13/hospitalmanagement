package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.PatientRoomTo;

public class PatientRoomDAO {

    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(PatientRoomTo record) {
        try {
            String query = "insert into patientroom (patient_id,room_id,admit_date,discharge_date,amount,ispaid)";
            query += " values(?,?,sysdate(),null,?,null)";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, record.getPatient_id());
            stmt.setString(2, record.getRoom_id());
            stmt.setFloat(3, record.getAmount());
            //stmt.setString(5, record.getIspaid());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean updateRecord(PatientRoomTo record) {
        try {
            String query = "update patientroom set patient_id=?, ";
            query += " room_id=?, admit_date=?, amount=?, ispaid=? where proom_id=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, record.getPatient_id());
            stmt.setString(2, record.getRoom_id());
            stmt.setDate(3, record.getAdmit_date());
            stmt.setFloat(4, record.getAmount());
            stmt.setString(5, record.getIspaid());
            stmt.setInt(6, record.getProom_id());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }
    public boolean update(int pid){
        try {
            String query = "update patientroom set discharge_date=sysdate() where proom_id=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, pid);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }
    public boolean deleteRecord(int proom_id) {
        try {
            String query = "delete from patientroom where proom_id=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, proom_id);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public PatientRoomTo getRecord(int proom_id) {
        try {
            String query = "select proom_id,patient_id,room_id,admit_date,discharge_date,amount,ispaid ";
            query = " from patientroom where proom_id=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, proom_id);
            PatientRoomTo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new PatientRoomTo();
                result.setProom_id(rs.getInt("proom_id"));
                result.setPatient_id(rs.getInt("patient_id"));
                result.setRoom_id(rs.getString("room_id"));
                result.setAdmit_date(rs.getDate("admit_date"));
                result.setDischarge_date(rs.getDate("discharge_date"));
                result.setAmount(rs.getFloat("amount"));
                result.setIspaid(rs.getString("ispaid"));
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }
    public PatientRoomTo getRecords(int patientid) {
        try {
            String query = "select proom_id,patient_id,room_id,admit_date,discharge_date,amount,ispaid from patientroom where patient_id=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, patientid);
            PatientRoomTo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new PatientRoomTo();
                result.setProom_id(rs.getInt("proom_id"));
                result.setPatient_id(patientid);
                result.setRoom_id(rs.getString("room_id"));
                result.setAdmit_date(rs.getDate("admit_date"));
                result.setDischarge_date(rs.getDate("discharge_date"));
                result.setAmount(rs.getFloat("amount"));
                result.setIspaid(rs.getString("ispaid"));
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }

    public List<PatientRoomTo> getAllRecord() {
        try {
            String query = "select proom_id,patient_id,room_id,admit_date,discharge_date,amount,is_paid from patientroom";
            PreparedStatement stmt = DataConnection.getStatement(query);
            ArrayList<PatientRoomTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<PatientRoomTo>();
                PatientRoomTo record = new PatientRoomTo();
                do {
                    record.setProom_id(rs.getInt("proom_id"));
                    record.setPatient_id(rs.getInt("patient_id"));
                    record.setRoom_id(rs.getString("room_id"));
                    record.setAdmit_date(rs.getDate("admit_date"));
                    record.setDischarge_date(rs.getDate("discharge_date"));
                    record.setAmount(rs.getFloat("amount"));
                    record.setIspaid(rs.getString("is_paid"));
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
