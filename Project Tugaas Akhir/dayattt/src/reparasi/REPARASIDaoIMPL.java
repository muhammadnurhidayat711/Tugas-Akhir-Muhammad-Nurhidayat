/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reparasi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class REPARASIDaoIMPL implements REPARASIDAO {

    private Connection connection;

    public REPARASIDaoIMPL(Connection connection) {
        this.connection = connection;
    }

    public void save(uubah masuk) {
        String SQL = "INSERT INTO masukmemasuk(ID_PELANGGAN,NOSERI,JENIS,KELENGKAPAN,MEREK,KELUHAN,HARGADIAGNOSA,APLIKASI,HARGAAPLIKASI,STATUS,CATATAN,WAKTU,TOTALHARGA,CODE,USER) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1, masuk.getIDPELANGGAN());
            statement.setString(2, masuk.getNOSERI());
            statement.setString(3, masuk.getJENIS());
            statement.setString(4, masuk.getKELENGKAPAN());
            statement.setString(5, masuk.getMEREK());
            statement.setString(6, masuk.getKELUHAN());
            statement.setString(7, masuk.getHARGADIAGNOSA());
            statement.setString(8, masuk.getAPLIKASI());
            statement.setString(9, masuk.getTOTALHARGAAPLIKASI());
            statement.setString(10, new String("PROSES"));
            statement.setString(11, masuk.getCATATAN());
            statement.setDate(12, new Date(masuk.getWAKTU().getTime()));
            statement.setString(13, masuk.getTOTALHARGA());
            statement.setString(14, masuk.getCODE());
            statement.setString(15, masuk.getUSER());
            statement.executeUpdate();
             JOptionPane.showMessageDialog(null, "Tambah Data Berhasil");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

     public void update(uubah masuk) {
        String SQL = "UPDATE masukmemasuk set ID_PELANGGAN=?,NOSERI=?,JENIS=?,KELENGKAPAN=?,MEREK=?,KELUHAN=?,HARGADIAGNOSA=?,APLIKASI=?,HARGAAPLIKASI=?,STATUS=?,CATATAN=?,WAKTU=?,TOTALHARGA=?,CODE=?,USER=? WHERE NO=?";
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
           statement.setString(1, masuk.getIDPELANGGAN());
            statement.setString(2, masuk.getNOSERI());
            statement.setString(3, masuk.getJENIS());
            statement.setString(4, masuk.getKELENGKAPAN());
            statement.setString(5, masuk.getMEREK());
            statement.setString(6, masuk.getKELUHAN());
            statement.setString(7, masuk.getHARGADIAGNOSA());
            statement.setString(8, masuk.getAPLIKASI());
            statement.setString(9, masuk.getTOTALHARGAAPLIKASI());
            statement.setString(10, new String("PROSES"));
            statement.setString(11, masuk.getCATATAN());
            statement.setDate(12, new Date(masuk.getWAKTU().getTime()));
            statement.setString(13, masuk.getTOTALHARGA());
            statement.setString(14, masuk.getCODE());
            statement.setString(15, masuk.getUSER());
            statement.setLong(16, masuk.getNO());
            statement.executeUpdate();
             JOptionPane.showMessageDialog(null, "Update Data Berhasil");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Harap Periksa Kembali Data Anda");
        }

    }

    public void delete(uubah masuk) {
        String SQL = "DELETE FROM masukmemasuk WHERE NO=?";
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setLong(1, masuk.getNO());
            statement.executeUpdate();
             JOptionPane.showMessageDialog(null, "Hapus Data Berhasil");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Harap Periksa Kembali Data Anda");
        }
    }

    public List<uubah> getAll() {
        String SQL = "SELECT masukmemasuk.NO, masukmemasuk.ID_PELANGGAN, pelanggan.NAMA, masukmemasuk.NOSERI, masukmemasuk.JENIS, masukmemasuk.KELENGKAPAN, masukmemasuk.MEREK, masukmemasuk.KELUHAN, masukmemasuk.HARGADIAGNOSA, masukmemasuk.APLIKASI, masukmemasuk.HARGAAPLIKASI, masukmemasuk.STATUS, masukmemasuk.CATATAN,masukmemasuk.WAKTU,masukmemasuk.TOTALHARGA,masukmemasuk.CODE,masukmemasuk.USER FROM masukmemasuk INNER JOIN pelanggan ON masukmemasuk.ID_PELANGGAN=pelanggan.ID_PELANGGAN";
        List<uubah> list = new ArrayList<uubah>();
        uubah masuk = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                masuk = new uubah();
                masuk.setNO(rs.getLong(1));
                masuk.setIDPELANGGAN(rs.getString(2));
                masuk.setNAMA(rs.getString(3));
                masuk.setNOSERI(rs.getString(4));
                masuk.setJENIS(rs.getString(5));
                masuk.setKELANGKAPAN(rs.getString(6));
                masuk.setMEREK(rs.getString(7));
                masuk.setKELUHAN(rs.getString(8));
                masuk.setHARGADIAGNOSA(rs.getString(9));
                masuk.setAPLIKASI(rs.getString(10));
                masuk.setTOTALHARGAAPLIKASI(rs.getString(11));
                masuk.setSTATUS(rs.getString(12));
                masuk.setCATATAN(rs.getString(13));
                masuk.setWAKTU(rs.getDate(14));
                masuk.setTOTALHARGA(rs.getString(15));
                masuk.setCODE(rs.getString(16));
                masuk.setUSER(rs.getString(17));
                list.add(masuk);
                masuk = null;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Harap Periksa Kembali Data Anda");
        }
        return list;
    }

   
}
