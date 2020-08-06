/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpoly.tn.bll;
import fpoly.tn.dal.dalDanhGia;
import fpoly.tn.dal.dalThongTInSP;
import fpoly.tn.helper.ChuyenDoi;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author y go
 */
public class bllThongTinSP {
    //Load
    public static void LoadThongTinSP(JTable tbl) {
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0); //Bỏ hết các dòng đang có trong table
       
        ResultSet rs = dalThongTInSP.GetThongTinSP();
        Object obj[] = new Object[5];
        try {
            while (rs.next()) {
                obj[0] = rs.getString("MaThongTin");
                obj[1] = rs.getString("MaSanPham");
                obj[2] = rs.getString("XuatSu");
                obj[3] = ChuyenDoi.LayNgayString(rs.getDate("NgayHetHan"));
                obj[4] = rs.getString("CongDung");
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger("Thông báo", "Lỗi kết nối dữ liệu thông tin sản phẩm !");
        }
    }
}
