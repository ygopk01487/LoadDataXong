/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpoly.tn.dal;
import fpoly.tn.helper.sql_helper;
import java.sql.*;
/**
 *
 * @author y go
 */
public class dalGiohang {
    //Lấy
    public static ResultSet GetAllGiohang() {
        String sql  = "Select * from GioHang";
        return sql_helper.executeQuery(sql);
    }
}
