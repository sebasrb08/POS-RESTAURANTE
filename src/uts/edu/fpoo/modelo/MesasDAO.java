package uts.edu.fpoo.modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import uts.edu.fpoo.util.Conexion;
/**
 *
 * @author sebas
 */
public class MesasDAO {
    PreparedStatement ps;
    ResultSet rs;
    Conexion conectar= Conexion.getInstance();
    Connection con = conectar.getConnection();
    
    public ArrayList<Mesas> listar(){
        ArrayList<Mesas> mesas =  new ArrayList<>();
        try{
            String url="SELECT * FROM mesas";
            ps= con.prepareStatement(url);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mesas m = new Mesas();
                m.setIdmesas(rs.getLong("idMesas"));
                m.setNumero(rs.getInt("numero"));
                m.setEstado(rs.getString("estado"));
                mesas.add(m);
            }
            
    } catch (SQLException e) {
            System.err.println("Error al listar mesas: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return mesas;
    }
     public void agregar(Mesas mesa){
        try{
            String url="INSERT INTO mesas(idMesas, numero, estado) values(?,?,?)";
            ps= con.prepareStatement(url);
            ps.setLong(1, mesa.getIdmesas());
            ps.setInt(2, mesa.getNumero());
            ps.setString(3, mesa.getEstado());
            ps.executeUpdate();
            
            
            System.out.println("Mesa agregada correctamente.");
    } catch (SQLException e) {
        System.err.println("Error al agregar mesa: " + e.getMessage());
    }
}
    public int actualizar(Mesas mesa){
        int r=0;
        try{
            
            String url="UPDATE mesas SET numero = ?, estado = ? WHERE idMesas = ?";
            ps= con.prepareStatement(url);
            ps.setInt(1, mesa.getNumero());
            ps.setString(2, mesa.getEstado());
            ps.setLong(3, mesa.getIdmesas());
            r= ps.executeUpdate();
            
           r = ps.executeUpdate();
        System.out.println("Mesa actualizada correctamente.");

    } catch (SQLException e) {
        System.err.println("Error al actualizar mesa: " + e.getMessage());
    }

    return r;
}
    
     public int eliminar(long id){
        int r = 0;
        try{
            String url="DELETE FROM mesas WHERE idMesas = ?";
            ps= con.prepareStatement(url);
            ps.setLong(1, id);
            r = ps.executeUpdate();
        }catch(SQLException e){      
            System.err.println("Error al eliminar mesa:"+ e.getMessage());
        }
        return r;
    }
          
}