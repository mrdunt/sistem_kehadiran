/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemkehadiran;

/**
 *
 * @author itsupport
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SistemKehadiran {

    public static Connection getConnection() {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/sistem_kehadiran";
        String user = "root";
        String password = "";
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return conn;
    }
    
    public static void main(String[] args) {
        // TODO code application logic 
        try {
            Connection c = SistemKehadiran.getConnection();
            System.out.println(String.format("Connected to database %s " + "successfully.", c.getCatalog()));
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
}
