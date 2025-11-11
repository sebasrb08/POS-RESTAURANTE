/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.edu.fpoo.util;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author sebas
 */
public class Conexion {
    
    String ruta = "C:\\Users\\sebas\\Downloads\\sqlite-tools-win-x64-3500400\\restaurante.db";
    // Definir el url
    
    String url = "jdbc:sqlite:"+ruta;
    Connection con;
    private static Conexion instance;
    
    
    private Conexion() {
        try {
            con = DriverManager.getConnection(url);
            System.out.println("Conexión establecida correctamente (Singleton)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔁 Devuelve la única instancia de la clase
    public static synchronized Conexion getInstance() {
        if (instance == null) {
            instance = new Conexion();
        }
        return instance;
    }

    // 🧩 Devuelve la conexión ya existente (sin crear nueva)
    public Connection getConnection() {
        return con;
    }
            
}
