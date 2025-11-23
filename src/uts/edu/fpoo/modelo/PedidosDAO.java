/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.edu.fpoo.modelo;

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
    
    public ArrayList<Pedidos> listar(long idPedido){
        ArrayList<Pedidos> pedido =  new ArrayList<>();
        try{
            String url="SELECT p.idPedido, p.fecha, p.estado, p.total  FROM pedido as p "
                    + "JOIN pedido as p ON p.idPedido = dp.idPedido ";
            ps= con.prepareStatement(url);
            ps.setLong(1,idPedido);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pedidos p = new Pedidos();
                p.setId(rs.getLong("idPedido"));
                //Timestamp ts = rs.getTimestamp("idFecha");
                //p.setFecha(ts.toLocalDateTime());
                //p.setIdProducto(rs.getLong("idProducto"));
                //p.setCantidad(rs.getInt("cantidad"));
                //p.setSubtotal(rs.getInt("subtotal"));
                pedido.add(p);
            }
            
    } catch (SQLException e) {
            System.err.println("Error al listar lso detalles de pedido: " + e.getMessage());
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
    
    public void agregar(DetallePedido detallePedido){
        try{
            String url="INSERT INTO detallePedido(idPedido, idProducto, cantidad,subtotal) values(?,?,?,?)";
            ps= con.prepareStatement(url);
            ps.setLong(1, detallePedido.getIdPedido());
            ps.setLong(2, detallePedido.getIdProducto());
            ps.setInt(3, detallePedido.getCantidad());
            ps.setDouble(4, detallePedido.getSubtotal());
            ps.executeUpdate();
            
            
            System.out.println("Mesa agregada correctamente.");
    } catch (SQLException e) {
        System.err.println("Error al agregar mesa: " + e.getMessage());
    }
}
    public int actualizar(DetallePedido detallePedido){
        int r=0;
        try{
            
            String url="UPDATE detallePedido SET idPedido = ?, idProducto = ?, cantidad = ?, subtotal = ? WHERE idDetallePedido = ?";
            ps= con.prepareStatement(url);
            ps.setLong(1, detallePedido.getIdPedido());
            ps.setLong(2, detallePedido.getIdProducto());
            ps.setInt(3, detallePedido.getCantidad());
            ps.setDouble(4, detallePedido.getSubtotal());
            ps.setDouble(5, detallePedido.getId());
            r= ps.executeUpdate();
            
           r = ps.executeUpdate();
        System.out.println("Detalle del pedido actualizada correctamente.");

    } catch (SQLException e) {
        System.err.println("Error al actualizar detalle pedido: " + e.getMessage());
    }

    return r;
}
    
     public int eliminar(long id){
        int r = 0;
        try{
            String url="DELETE FROM detallePedido WHERE idDetallePedido = ?";
            ps= con.prepareStatement(url);
            ps.setLong(1, id);
            r = ps.executeUpdate();
        }catch(SQLException e){      
            System.err.println("Error al eliminar el detalle Pedido:"+ e.getMessage());
        }
        return r;
    }
    
}
