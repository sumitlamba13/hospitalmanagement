package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.PatientInfoTo;

public class PatientInfoDAO {

    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(PatientInfoTo record) {
        try {
            String query = "insert into patientinfo (patient_name,contact_no,attendent,date_of_birth,address) ";
            query += " values(?,?,?,?,?)";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getPatient_name());
            stmt.setString(2, record.getContact_no());
            stmt.setString(3, record.getAttendent());
            stmt.setDate(4, record.getDate_of_birth());
            stmt.setString(5, record.getAddress());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean updateRecord(PatientInfoTo record) {
        try {
            String query = "update patientinfo set patient_name=?, ";
            query += " contact_no=?, attendent=?, date_of_birth=?, address=? where patient_id=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getPatient_name());
            stmt.setString(2, record.getContact_no());
            stmt.setString(3, record.getAttendent());
            stmt.setDate(4, record.getDate_of_birth());
            stmt.setString(5, record.getAddress());
            stmt.setInt(6, record.getPatient_id());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean deleteRecord(int patient_id) {
        try {
            String query = "delete from patientinfo where patient_id=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, patient_id);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public PatientInfoTo getRecord(int patient_id) {
        try {
            String query = "select patient_id,patient_name,contact_name,attendent,date_of_birth,address ";
            query = " from patientinfo where patient_id=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, patient_id);
            PatientInfoTo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new PatientInfoTo();
                result.setPatient_id(rs.getInt("patient_id"));
                result.setPatient_name(rs.getString("patient_name"));
                result.setContact_no(rs.getString("contact_no"));
                result.setAttendent(rs.getString("attendent"));
                result.setDate_of_birth(rs.getDate("date_of_birth"));
                result.setAddress(rs.getString("address"));
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }

    public List<PatientInfoTo> getAllRecord() {
        try {
            String query = "select patient_id,patient_name,contact_no,attendent,date_of_birth,address from patientinfo";
            PreparedStatement stmt = DataConnection.getStatement(query);
            ArrayList<PatientInfoTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<PatientInfoTo>();
                do {
                    PatientInfoTo record = new PatientInfoTo();
                    record.setPatient_id(rs.getInt("patient_id"));
                    record.setPatient_name(rs.getString("patient_name"));
                    record.setContact_no(rs.getString("contact_no"));
                    record.setAttendent(rs.getString("attendent"));
                    record.setDate_of_birth(rs.getDate("date_of_birth"));
                    record.setAddress(rs.getString("address"));
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

    public List<PatientInfoTo> getAllRecord(String disease_id) {
        try {
            String query = "select patient_id,patient_name,contact_no,attendent,date_of_birth,address ";
            query += " from patientinfo where patient_id not in ";
            query += " ( select patient_id from patientdisease where disease_id=? )";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, disease_id);
            ArrayList<PatientInfoTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<PatientInfoTo>();
                PatientInfoTo record = new PatientInfoTo();
                do {
                    record.setPatient_id(rs.getInt("patient_id"));
                    record.setPatient_name(rs.getString("patient_name"));
                    record.setContact_no(rs.getString("contact_no"));
                    record.setAttendent(rs.getString("attendent"));
                    record.setDate_of_birth(rs.getDate("date_of_birth"));
                    record.setAddress(rs.getString("address"));
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
