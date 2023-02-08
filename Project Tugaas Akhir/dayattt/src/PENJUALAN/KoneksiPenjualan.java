/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PENJUALAN;



import reparasi.*;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class KoneksiPenjualan {
    private static Connection connection;
    private static PenjualanDAO PenjualanDAO;
    private KoneksiPenjualan(){
        
    }

    private static Connection getConnection() {
        if (connection==null){
            try {
                DriverManager.registerDriver(new Driver());
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/datareparasi", "root", "");
            } catch (SQLException ex) {
                Logger.getLogger(Koneksiubah.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return connection;
    }

    public static PenjualanDAO getPenjualanDAO() {
        if (PenjualanDAO==null){
           PenjualanDAO = new PenjualanDaoIMPL(getConnection());
        }
        return PenjualanDAO;
    }

}
