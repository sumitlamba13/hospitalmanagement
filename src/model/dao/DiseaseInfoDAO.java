package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.DiseaseInfoTo;

public class DiseaseInfoDAO {

    private static String errormessage;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(DiseaseInfoTo record) {
        try {
            String query="insert into diseaseinfo (disease_id,disease_name,description) ";
            query+=" values(?,?,?)";
            PreparedStatement stmt=DataConnection.getStatement(query);
            stmt.setString(1, record.getDisease_id());
            stmt.setString(2, record.getDisease_name());
            stmt.setString(3, record.getDescription());
            boolean result=stmt.executeUpdate()>0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean updateRecord(DiseaseInfoTo record) {
        try {
            String query="update diseaseinfo set disease_name=?, description=? where disease_id=?";
            PreparedStatement stmt=DataConnection.getStatement(query);
            stmt.setString(1, record.getDisease_name());
            stmt.setString(2, record.getDescription());
            stmt.setString(3, record.getDisease_id());
            boolean result=stmt.executeUpdate()>0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean deleteRecord(String disease_id) {
        try {
            String query="delete from diseaseinfo where disease_id=?";
            PreparedStatement stmt=DataConnection.getStatement(query);
            stmt.setString(1, disease_id);
            boolean result=stmt.executeUpdate()>0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public DiseaseInfoTo getRecord(String disease_id) {
        try {
            String query="select disease_id,disease_name,description from diseaseinfo where disease_id=?";
            PreparedStatement stmt=DataConnection.getStatement(query);
            stmt.setString(1, disease_id);
            ResultSet rs=stmt.executeQuery();
            DiseaseInfoTo result=null;
            if(rs.next()){
                result=new DiseaseInfoTo();
                result.setDisease_id(rs.getString("disease_id"));
                result.setDisease_name(rs.getString("disease_name"));
                result.setDescription(rs.getString("description"));
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }

    public List<DiseaseInfoTo> getAllRecord() {
        try {
            String query="select disease_id,disease_name,description from diseaseinfo";
            PreparedStatement stmt=DataConnection.getStatement(query);
            ArrayList<DiseaseInfoTo> result=null;
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                result=new ArrayList<DiseaseInfoTo>();
                
                do{
                    DiseaseInfoTo record= new DiseaseInfoTo();
                    record.setDisease_id(rs.getString("disease_id"));
                    record.setDisease_name(rs.getString("disease_name"));
                    record.setDescription(rs.getString("description"));
                    result.add(record);
                }while(rs.next());
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }

}
