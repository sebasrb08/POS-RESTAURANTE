/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.edu.fpoo.controlador;

<<<<<<< HEAD
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import uts.edu.fpoo.modelo.Pedidos;
import uts.edu.fpoo.modelo.PedidosDAO;
import uts.edu.fpoo.modelo.Platos;
import uts.edu.fpoo.modelo.PlatosDAO;
import uts.edu.fpoo.vista.PedidosVista;
import uts.edu.fpoo.vista.PlatosVista;

=======
>>>>>>> 91b9e10fa8c1f76cb6b0de7f346c66a745d286b2
/**
 *
 * @author sebas
 */
<<<<<<< HEAD
public class PedidosControlador implements  ActionListener, ListSelectionListener{
    PedidosDAO dao = new PedidosDAO();
    PedidosVista pedidosVista = new PedidosVista();
    Pedidos p = new Pedidos();
    DefaultTableModel modelo =  new DefaultTableModel();
    
    public PedidosControlador(PedidosVista v) {
        System.out.println("holaaaaaaaaasdasd");
        this.pedidosVista = v;
        this.pedidosVista.btnBuscarProducto.addActionListener(this);
        //this.pedidosVista.btnAgregar.addActionListener(this);
        //this.pedidosVista.btnActualizar.addActionListener(this);
        //this.pedidosVista.btnEliminar.addActionListener(this);
        this.pedidosVista.tableProductos.getSelectionModel().addListSelectionListener(this);

    }
    
    public void buscar(JTable tabla){
        modelo= (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        modelo.setRowCount(0);
        Object [] objeto = new Object[5];
        PlatosDAO platos =  new PlatosDAO();
        ArrayList<Platos> lista =platos.listar();
        for ( Platos p: lista ){
            if(pedidosVista.getTxtCodigoProducto().getText().equals(p.getCodigo())){
                objeto[0] = p.getNombre();
                objeto[1] = p.getPrecioVenta();
                objeto[2] = 1;
                objeto[3] =  p.getPrecioVenta()*1;
                modelo.addRow(objeto);
            
            }
        }
        tabla.setRowHeight(35);
        tabla.setRowMargin(10);
    }

    
    public void actionPerformed(ActionEvent e) {
        System.out.println("✅ algo presiono"); // Para comprobar
        if (e.getSource() == pedidosVista.btnBuscarProducto ) {
            System.out.println("✅ Botón Listar presionado"); // Para comprobar
            buscar(pedidosVista.tableProductos);
        }
        
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
=======
public class PedidosControlador {
>>>>>>> 91b9e10fa8c1f76cb6b0de7f346c66a745d286b2
    
}
