/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author HP
 */
public class CommonDAO {

    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }

    public int getLastInsertId() {
        try {
            String query = "select last_insert_id()";
            PreparedStatement stmt = DataConnection.getStatement(query);
            int result = 0;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1);
            }
            rs.close();
            stmt.close();
            return result;
        }catch(Exception ex){
            errormessage=ex.toString();
            return 0;
        }
    }
}
