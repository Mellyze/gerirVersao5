/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbClasses;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author gustavo
 */
public abstract class ExecutaQuery {
    
    
    
    public static ResultSet executaSql(String sql, Connection con){
       Statement stm=null;
       ResultSet rs=null;
        try{
            stm=con.createStatement();
           rs = stm.executeQuery(sql);
        }
       catch(SQLException e){
           System.out.println(e.getMessage());
       }
       return rs;
    }
    
    
}
