package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.PatientDiseaseTo;

public class PatientDiseaseDAO {

    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(PatientDiseaseTo record) {
        try {
            String query = "insert into patientdisease (disease_id,patient_id,history) values(?,?,?)";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getDisease_id());
            stmt.setInt(2, record.getPatient_id());
            stmt.setString(3, record.getHistory());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean updatRecord(PatientDiseaseTo record) {
        try {
            String query = "update patientdisease set disease_id=?, patient_id=?, history=? where sr_no=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setString(1, record.getDisease_id());
            stmt.setInt(2, record.getPatient_id());
            stmt.setString(3, record.getHistory());
            stmt.setInt(4, record.getSr_no());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean deleteRecord(int sr_no) {
        try {
            String query = "delete from patientdisease where sr_no=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, sr_no);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public PatientDiseaseTo getRecord(int sr_no) {
        try {
            String query = "select sr_no,disease_id,patient_id,history from patientdisease where sr_no=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, sr_no);
            PatientDiseaseTo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new PatientDiseaseTo();
                result.setSr_no(rs.getInt("sr_no"));
                result.setDisease_id(rs.getString("disease_id"));
                result.setPatient_id(rs.getInt("patient_id"));
                result.setHistory(rs.getString("history"));
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }

    public List<PatientDiseaseTo> getAllRecord(int pid) {
        try {
            String query = "select sr_no,disease_id,patient_id,history from patientdisease where patient_id=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, pid);
            ResultSet rs = stmt.executeQuery();
            ArrayList<PatientDiseaseTo> result = null;
            if (rs.next()) {
                result = new ArrayList<PatientDiseaseTo>();
                do {
                    PatientDiseaseTo record = new PatientDiseaseTo();
                    record.setSr_no(rs.getInt("sr_no"));
                    record.setDisease_id(rs.getString("disease_id"));
                    record.setPatient_id(rs.getInt("patient_id"));
                    record.setHistory(rs.getString("history"));
                    //record.setDisease_name(rs.getString("disease_name"));
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

    public List<PatientDiseaseTo> getRecords(int patientid) {
        try {
            String query = "select pd.disease_id,d.disease_name from patientdisease pd join diseaseinfo d on d.disease_id=pd.disease_id  where patient_id=?";
            PreparedStatement stmt = DataConnection.getStatement(query);
            stmt.setInt(1, patientid);
            ResultSet rs = stmt.executeQuery();
            ArrayList<PatientDiseaseTo> result = null;
            if (rs.next()) {
                result = new ArrayList<PatientDiseaseTo>();
                do {
                    PatientDiseaseTo record = new PatientDiseaseTo();
                    record.setDisease_id(rs.getString("disease_id"));
                    record.setDisease_name(rs.getString("disease_name"));
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
