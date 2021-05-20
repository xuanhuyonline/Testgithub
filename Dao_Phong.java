/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlynhahang;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Le Xuan Huy
 */
public class Dao_Phong {
    private SQL con;
    
    public Dao_Phong() 
    {
        con=new SQL("DESKTOP-95N5PBV", "QL_NHAHANG", "sa", "1");
    }
    
    public void LayDSPhong(Vector vdata){
        
        vdata.removeAllElements();
        try {
            con.OpenConnection();
            String sql = "SELECT * FROM PHONG";
            PreparedStatement preStatement=con.GetConnect().prepareStatement(sql);
            ResultSet rs=preStatement.executeQuery();
            while(rs.next())
            {
                String ID_Phong=rs.getString("ID_Phong");
                String Ten_Phong=rs.getString("Ten_Phong");
                Vector<String> v=new Vector<String>();
                v.add(ID_Phong);
                v.add(Ten_Phong);
                vdata.add(v);
            }
            con.CloseConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_Phong.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
}
