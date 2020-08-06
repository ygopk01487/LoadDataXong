/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpoly.tn.bll;
import java.sql.*;
import fpoly.tn.dal.dal_SanPham;
import fpoly.tn.helper.ChuyenDoi;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author y go
 */
public class bllSanPham {
    //Hàm load
    public static void LoadSanPham(JTable tbl) {
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0); //Bỏ hết các dòng đang có trong table
       
        ResultSet rs = dal_SanPham.Load();
        Object obj[] = new Object[9];
        try {
            while (rs.next()) {
                obj[0] = rs.getString("MaSanPham");
                obj[1] = rs.getString("TenSanPham");
                obj[2] = rs.getInt("PhanTramGiamGia");
                obj[3] = rs.getFloat("GiaGoc");
                obj[4] = rs.getFloat("GiaSauKhiGiam");
                obj[5] = rs.getString("MaDanhGia");
                obj[6] = rs.getInt("PhanTramTraGop");
                obj[7] = ChuyenDoi.LayNgayString(rs.getDate("NgayNhap"));
                obj[8] = rs.getString("MaSanPham");
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger("Thông báo", "Lỗi kết nối dữ liệu sản phẩm !");
        }
    }
}
