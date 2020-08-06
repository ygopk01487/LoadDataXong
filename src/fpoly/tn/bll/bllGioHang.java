/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpoly.tn.bll;
import fpoly.tn.dal.dalDanhGia;
import fpoly.tn.dal.dalGiohang;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author y go
 */
public class bllGioHang {
    //Load
    public static void LoadGioHang(JTable tbl) {
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
         tbModel.setRowCount(0); //Bỏ hết các dòng đang có trong table
       
        ResultSet rs = dalGiohang.GetAllGiohang();
        Object obj[] = new Object[8];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt("MaGioHang");
                obj[1] = rs.getString("MaSanPham");
                obj[2] = rs.getString("TenSanPham");
                obj[3] = rs.getInt("PhanTramGiamGia");
                obj[4] = rs.getFloat("GiaGoc");
                obj[5] = rs.getFloat("GiaSauKhiGiam");
                obj[6] = rs.getInt("SoLuong");
                obj[7] = rs.getFloat("TongTien");
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger("Thông báo", "Lỗi két nối dữ liệu giỏ hàng !");
        }
    }
}
