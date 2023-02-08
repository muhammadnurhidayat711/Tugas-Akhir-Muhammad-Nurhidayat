
package KASIR;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jajang Nurjaman
 */
public class koneksitransaksi {

    Connection conn = null;
    public static Connection koneksi() {
        String driver = "com.mysql.jdbc.Driver";
        String _host = "jdbc:mysql://localhost/datareparasi";
        String _user = "root";
        String _pass = "";       
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(_host , _user ,_pass);
            return conn;
        }
        catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,e);
        } 
        return null;
    }
} 
