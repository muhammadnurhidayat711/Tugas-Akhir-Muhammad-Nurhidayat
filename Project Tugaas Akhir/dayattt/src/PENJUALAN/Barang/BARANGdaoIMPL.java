/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PENJUALAN.Barang;


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
 * @author arya
 */
public class BARANGdaoIMPL implements BARANGDao{
private Connection connection;

    public BARANGdaoIMPL(Connection connection){
        this.connection = connection;
    }
    public void save(BARANG brg) {
        String SQL = "INSERT INTO barangdb(namabarang,jumlah,harga,garansi,waktu,keterangan) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1, brg.getNama());
            statement.setString(2, brg.getJumlah());
            statement.setString(3, brg.getHarga());
            statement.setString(4, brg.getGaransi());
            statement.setDate(5, new Date( brg.getWaktu().getTime()));
            statement.setString(6, brg.getKeterangan());
            statement.executeUpdate();
             JOptionPane.showMessageDialog(null, "Tambah Data Berhasil");
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null,"Harap Periksa Kembali Data Anda");
        }
    }

    public void update(BARANG brg) {
        String SQL = "UPDATE barangdb set namabarang=?,jumlah=?,harga=?,garansi=?,waktu=?,keterangan=? WHERE ID_BARANG=?";
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
             statement.setString(1, brg.getNama());
            statement.setString(2, brg.getJumlah());
            statement.setString(3, brg.getHarga());
            statement.setString(4, brg.getGaransi());
            statement.setDate(5, new Date( brg.getWaktu().getTime()));
            statement.setString(6, brg.getKeterangan());
            statement.setLong(7, brg.getId());
            statement.executeUpdate();
             JOptionPane.showMessageDialog(null, "Ubah Data Berhasil");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Harap Periksa Kembali Data Anda");
        }

    }

    public void delete(BARANG brg) {
        String SQL="DELETE FROM barangdb WHERE ID_BARANG=?";
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setLong(1, brg.getId());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tambah Data Berhasil");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Harap Periksa Kembali Data Anda");
        }
    }

    public List<BARANG> getAll() {
        String SQL = "SELECT ID_BARANG,namabarang,jumlah,harga,garansi,waktu,keterangan FROM barangdb";
        List<BARANG> list = new ArrayList<BARANG>();
        BARANG brg = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                brg = new BARANG();
                brg.setId(rs.getLong(1));
                brg.setNama(rs.getString(2));
                brg.setJumlah(rs.getString(3));
                brg.setHarga(rs.getString(4));
                brg.setGaransi(rs.getString(5));
                brg.setWaktu(rs.getDate(6));
                brg.setKeterangan(rs.getString(7));
                list.add(brg);
                brg=null;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Harap Periksa Kembali Data Anda");
        }
        return list;
    }

}
