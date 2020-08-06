/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpoly.tn.bll;
import fpoly.tn.dal.dalDanhGia;
import fpoly.tn.dal.dalLoaiSanPham;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author y go
 */
public class ballLoaiSP {
    //Load
    public static void LoadLoaiSP(JTable tbl) {
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0); //Bỏ hết các dòng đang có trong table
       
        ResultSet rs = dalLoaiSanPham.getAllLoaiSP();
        Object obj[] = new Object[3];
        try {
            while (rs.next()) {
                obj[0] = rs.getString("MaLoaiSanPham");
                obj[1] = rs.getString("TenLoaiSanPham");
                obj[2] = rs.getString("MoTa");
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger("Thông báo", "Lỗi kết nối dữ liệu loại sản phẩm !");
        }
    }
}
