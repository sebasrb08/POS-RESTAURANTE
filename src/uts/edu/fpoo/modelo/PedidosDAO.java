/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.edu.fpoo.modelo;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import uts.edu.fpoo.util.Conexion;

/**
 *
 * @author sebas
 */
public class PedidosDAO {
    PreparedStatement ps;
    ResultSet rs;
    Conexion conectar= Conexion.getInstance();
    Connection con = conectar.getConnection();
    
    public ArrayList<Pedidos> listar(){
        ArrayList<Pedidos> pedido =  new ArrayList<>();
        try{
            String url="SELECT p.idPedido, m.numero, p.fecha, p.estado, p.total  FROM pedido as p "
                    + "JOIN mesas as m ON m.idMesas = p.idMesas ";
            ps= con.prepareStatement(url);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pedidos p = new Pedidos();
                p.setId(rs.getLong("idPedido"));
                p.setNumeroMesa(rs.getInt("numero"));
                p.setFecha(rs.getTimestamp("idFecha").toLocalDateTime());
                p.setEstado(rs.getString("estado"));
                p.setTotal(rs.getInt("total"));
                pedido.add(p);
            }
            
    } catch (SQLException e) {
            System.err.println("Error al listar los pedidos: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return pedido;
    }
    
    public void agregar(Pedidos pedidos){
        try{
            String url="INSERT INTO pedido(idMesas,idFecha,estado,total ) values(?,?,?,?)";
            ps= con.prepareStatement(url);
            ps.setLong(1, pedidos.getIdMesa());
            ps.setTimestamp(2, Timestamp.valueOf(pedidos.getFecha()));
            ps.setString(3, pedidos.getEstado());
            ps.setDouble(4, pedidos.getTotal());
            ps.executeUpdate();
            
            
            System.out.println("Pedido agregada correctamente.");
    } catch (SQLException e) {
        System.err.println("Error al agregar pedido: " + e.getMessage());
    }
}
    public int actualizar(Pedidos pedidos){
        int r=0;
        try{
            
            String url="UPDATE pedido SET idMesas = ?, fecha = ?, estado = ?, total = ? WHERE idPedido = ?";
            ps= con.prepareStatement(url);
            ps.setLong(1, pedidos.getIdMesa());
            ps.setTimestamp(2, Timestamp.valueOf(pedidos.getFecha()));
            ps.setString(3, pedidos.getEstado());
            ps.setDouble(4, pedidos.getTotal());
            ps.setDouble(5, pedidos.getId());
            r= ps.executeUpdate();
            
           r = ps.executeUpdate();
        System.out.println(" pedido actualizada correctamente.");

    } catch (SQLException e) {
        System.err.println("Error al actualizar pedido: " + e.getMessage());
    }

    return r;
}
    
     public int eliminar(long id){
        int r = 0;
        try{
            String url="DELETE FROM pedido WHERE idPedido = ?";
            ps= con.prepareStatement(url);
            ps.setLong(1, id);
            r = ps.executeUpdate();
        }catch(SQLException e){      
            System.err.println("Error al eliminar el Pedido:"+ e.getMessage());
        }
        return r;
    }
    
}
