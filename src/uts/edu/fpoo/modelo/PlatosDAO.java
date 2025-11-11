/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.edu.fpoo.modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import uts.edu.fpoo.util.Conexion;
/**
 *
 * @author sebas
 */
public class PlatosDAO {
    PreparedStatement ps;
    ResultSet rs;
    Conexion conectar= Conexion.getInstance();
    Connection con = conectar.getConnection();
   

    public ArrayList<Platos> listar(){
        ArrayList<Platos> platos =  new ArrayList<>();
        try{
            String url="SELECT * FROM platos";
            ps= con.prepareStatement(url);
            rs = ps.executeQuery();
            while (rs.next()) {
                Platos p = new Platos();
                p.setIdPlatos(rs.getLong(1));
                p.setNombre(rs.getString(2));
                p.setCodigo(rs.getInt(3));
                p.setPrecioVenta(rs.getDouble(4));
                p.setDescripcion(rs.getString(5));
                platos.add(p);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return platos;
    }
    
    public void agregar(Platos plato){
        try{
            String url="INSERT INTO platos values(?,?,?,?,?)";
            ps= con.prepareStatement(url);
            ps.setLong(1, plato.getIdPlatos());
            ps.setString(2, plato.getNombre());
            ps.setInt(3, plato.getCodigo());
            ps.setDouble(4, plato.getPrecioVenta());
            ps.setString(5, plato.getDescripcion());
            ps.executeUpdate();
            
            
        }catch(Exception e){
            
        }
    }
    
    public int actualizar(Platos plato){
        int r=0;
        try{
            
            String url="UPDATE platos SET codigo = ?, nombre = ?, precioVenta = ?, descripcion = ? where idPlatos = ?";
            ps= con.prepareStatement(url);
            ps.setInt(1, plato.getCodigo());
            ps.setString(2, plato.getNombre());
            ps.setDouble(3, plato.getPrecioVenta());
            ps.setString(4, plato.getDescripcion());
            ps.setLong(5, plato.getIdPlatos());
            r= ps.executeUpdate();
            
            
        }catch(Exception e){
            
        }
        return r;

    }
    
    public int eliminar(long id){
        int r =0;
        try{
            String url="DELETE FROM platos WHERE idPlatos = ?";
            ps= con.prepareStatement(url);
            ps.setLong(1, id);
            r = ps.executeUpdate();
            
        }catch(Exception e){            
        }
        return r;
    }
          
}
