/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reparasi;



import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Koneksiubah {
    private static Connection connection;
    private static REPARASIDAO UBAHDAO;
    private Koneksiubah(){
        
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

    public static REPARASIDAO getubahDAO() {
        if (UBAHDAO==null){
            UBAHDAO = new REPARASIDaoIMPL(getConnection());
        }
        return UBAHDAO;
    }

}
