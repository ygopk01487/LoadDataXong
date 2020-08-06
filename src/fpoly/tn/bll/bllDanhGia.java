/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpoly.tn.bll;
import fpoly.tn.dal.dalDanhGia;
import fpoly.tn.dal.dal_SanPham;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author y go
 */
public class bllDanhGia {
    //Load
    public static void LoadDG(JTable tbl) {
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0); //Bỏ hết các dòng đang có trong table
       
        ResultSet rs = dalDanhGia.GetAllDG();
        Object obj[] = new Object[4];
        try {
            while (rs.next()) {
                obj[0] = rs.getString("MaDanhGia");
                obj[1] = rs.getString("MaLoaiSanPham");
                obj[2] = rs.getInt("Sao");
                obj[3] = rs.getString("NoiDung");
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger("Thông báo", "Lỗi kết nối dữ liệu đánh giá !");
        }
    }
}
