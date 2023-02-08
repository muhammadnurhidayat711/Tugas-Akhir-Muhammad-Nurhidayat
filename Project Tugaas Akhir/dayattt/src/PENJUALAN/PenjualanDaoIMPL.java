/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PENJUALAN;

import reparasi.*;
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
public class PenjualanDaoIMPL implements PenjualanDAO {

    private Connection connection;

    public PenjualanDaoIMPL(Connection connection) {
        this.connection = connection;
    }

    public void save(ppenjualan masuk) {
        String SQL = "INSERT INTO pembelian(ID_PELANGGAN,ID_BARANG,JUMLAH,WAKTU,TOTALHARGA,TOTAL,BAYAR,KEMBALIAN,GARANSI,CODE,USER) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1, masuk.getIDPELANGGAN());
            statement.setString(2, masuk.getIDBARANG());
            statement.setString(3, masuk.getJUMLAH());
            statement.setDate(4, new Date(masuk.getWAKTU().getTime()));
            statement.setString(5, masuk.getHARGA());
            statement.setString(6, masuk.getTOTAL());
            statement.setString(7, masuk.getBAYAR());
            statement.setString(8, masuk.getKEMBALIAN());
            statement.setString(9, masuk.getGARANSI());
            statement.setString(10, masuk.getCODE());
            statement.setString(11, masuk.getUSER());
            statement.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Harap Isi Data Dengan Benar");
        }
    }

     public void update(ppenjualan masuk) {
        String SQL = "UPDATE pembelian set ID_PELANGGAN=?,ID_BARANG=?,JUMLAH=?,WAKTU=?,TOTALHARGA=?,TOTAL=?,BAYAR=?,KEMBALIAN=?,GARANSI=?,CODE=?,USER=? WHERE NO=?";
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1, masuk.getIDPELANGGAN());
            statement.setString(2, masuk.getIDBARANG());
            statement.setString(3, masuk.getJUMLAH());
            statement.setDate(4, new Date(masuk.getWAKTU().getTime()));
            statement.setString(5, masuk.getHARGA());
            statement.setString(6, masuk.getTOTAL());
            statement.setString(7, masuk.getBAYAR());
            statement.setString(8, masuk.getKEMBALIAN());
            statement.setString(9, masuk.getGARANSI());
            statement.setString(10, masuk.getCODE());
            statement.setString(11, masuk.getUSER());
            statement.setLong(12,masuk.getNO());
            statement.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Harap Isi Data Dengan Benar");
        }

    }

    public void delete(ppenjualan masuk) {
        String SQL = "DELETE FROM pembelian WHERE NO=?";
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setLong(1, masuk.getNO());
            statement.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Harap Isi Data Dengan Benar");
        }
    }

    public List<ppenjualan> getAll() {
        String SQL = "SELECT pembelian.NO, pembelian.ID_PELANGGAN, pelanggan.NAMA, pembelian.ID_BARANG,barangdb.namabarang, pembelian.JUMLAH, pembelian.WAKTU, pembelian.TOTALHARGA, pembelian.TOTAL, pembelian.BAYAR, pembelian.KEMBALIAN, pembelian.GARANSI, pembelian.CODE, pembelian.USER FROM ((pembelian INNER JOIN pelanggan ON pembelian.ID_PELANGGAN=pelanggan.ID_PELANGGAN) INNER JOIN barangdb ON pembelian.ID_BARANG = barangdb.ID_BARANG)";
        List<ppenjualan> list = new ArrayList<ppenjualan>();
        ppenjualan masuk = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                masuk = new ppenjualan();
                masuk.setNO(rs.getLong(1));
                masuk.setIDPELANGGAN(rs.getString(2));
                masuk.setNAMAPELANGGAN(rs.getString(3));
                masuk.setIDBARANG(rs.getString(4));
                masuk.setNAMABARANG(rs.getString(5));
                masuk.setJUMLAH(rs.getString(6));
                masuk.setWAKTU(rs.getDate(7));
                masuk.setHARGA(rs.getString(8));
                masuk.setTOTAL(rs.getString(9));
                masuk.setBAYAR(rs.getString(10));
                masuk.setKEMBALIAN(rs.getString(11));
                masuk.setGARANSI(rs.getString(12));
                masuk.setCODE(rs.getString(13));
                masuk.setUSER(rs.getString(14));
                list.add(masuk);
                masuk = null;
            }
        } catch (Exception ex) {
           
        }
        return list;
    }

   
}
