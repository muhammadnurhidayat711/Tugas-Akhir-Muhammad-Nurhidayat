/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PENJUALAN.Barang;


import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Koneksi {
    private static Connection connection;
    private static BARANGDao barangDao;
    private Koneksi(){
        
    }

    public static Connection getConnection() {
        if (connection==null){
            try {
                DriverManager.registerDriver(new Driver());
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/datareparasi", "root", "");
            } catch (SQLException ex) {
                Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return connection;
    }

    public static BARANGDao getBarangDao() {
        if (barangDao==null){
            barangDao = new BARANGdaoIMPL(getConnection());
        }
        return barangDao;
    }

}
