/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.edu.fpoo.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import uts.edu.fpoo.modelo.Platos;
import uts.edu.fpoo.modelo.PlatosDAO;
import uts.edu.fpoo.vista.PlatosVista;

/**
 *
 * @author sebas
 */
public class PlatosControlador implements ActionListener, ListSelectionListener {
    
    PlatosDAO dao = new PlatosDAO();
    Platos p = new Platos();
    PlatosVista platosVista = new PlatosVista();
    DefaultTableModel modelo =  new DefaultTableModel();

    public PlatosControlador(PlatosVista v) {
        this.platosVista = v;
        this.platosVista.btnListar.addActionListener(this);
        this.platosVista.btnAgregar.addActionListener(this);
        this.platosVista.btnActualizar.addActionListener(this);
        this.platosVista.btnEliminar.addActionListener(this);
        this.platosVista.TablePlatos.getSelectionModel().addListSelectionListener(this);

    }
    
    public void listar(JTable tabla){
        modelo= (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        modelo.setRowCount(0);
        ArrayList<Platos> platos = dao.listar();
        Object [] objeto = new Object[5];
        if (platos == null || platos.isEmpty()) {
            System.out.println("No hay platos en la base de datos");
            return;
        }
        for (int i = 0; i < platos.size(); i++) {
            objeto[0] = platos.get(i).getIdPlatos();
            objeto[1] = platos.get(i).getCodigo();
            objeto[2] = platos.get(i).getNombre();
            objeto[3] =  platos.get(i).getPrecioVenta();
            objeto[4] =  platos.get(i).getDescripcion();
            modelo.addRow(objeto);
        }
        tabla.setRowHeight(35);
        tabla.setRowMargin(10);
    }
    
    public void agregar(){
        long id = Long.parseLong( platosVista.getIdField().getText());
        int codigo = Integer.parseInt( platosVista.getCodigoField().getText());
        String nombre =  platosVista.getNombreField().getText();
        double precio =  Double.parseDouble( platosVista.getPrecioField().getText());
        String descripcion =  platosVista.getDescripcionField().getText();
        Platos plato = new Platos(id, nombre, codigo, precio, descripcion);
        dao.agregar(plato);
        JOptionPane.showMessageDialog(platosVista, "Usuario Agregado con exito");
        
    }
    
    public void actualizar(){
        long id = Long.parseLong( platosVista.getIdField().getText());
        int codigo = Integer.parseInt( platosVista.getCodigoField().getText());
        String nombre =  platosVista.getNombreField().getText();
        double precio =  Double.parseDouble( platosVista.getPrecioField().getText());
        String descripcion =  platosVista.getDescripcionField().getText();
        Platos plato = new Platos(id, nombre, codigo, precio, descripcion);
        int r = dao.actualizar(plato);
        if (r == 1) {
           JOptionPane.showMessageDialog(platosVista, "Usuario Actualizado con exito");
        }else{
            JOptionPane.showMessageDialog(platosVista, "Usuario No se pudo actualizar");

        }
    }
    
    public void limpiarCampo(){
        platosVista.getIdField().setText("");
        platosVista.getCodigoField().setText("");
        platosVista.getNombreField().setText("");
        platosVista.getPrecioField().setText("");
        platosVista.getDescripcionField().setText("");
    }

    
    public void selectRow(JTable tabla){
        int fila = tabla.getSelectedRow();
        
        platosVista.getIdField().setText(tabla.getValueAt(fila, 0).toString());
        platosVista.getCodigoField().setText(tabla.getValueAt(fila, 1).toString());
        platosVista.getNombreField().setText(tabla.getValueAt(fila, 2).toString());
        platosVista.getPrecioField().setText(tabla.getValueAt(fila, 3).toString());
        platosVista.getDescripcionField().setText(tabla.getValueAt(fila, 4).toString());
    }
    
    public void valueChanged(javax.swing.event.ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int fila = platosVista.TablePlatos.getSelectedRow();
            if (fila != -1) {
            selectRow(platosVista.TablePlatos);
            }
        }
    }
    public void eliminar(){
        long id = Long.parseLong( platosVista.getIdField().getText());
        int r = dao.eliminar(id);
        if (r == 1) {
            JOptionPane.showMessageDialog(platosVista, "Usuario Eliminado con exito");

        }else{
            JOptionPane.showMessageDialog(platosVista, "Usuario no fue Eliminado");

        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == platosVista.btnListar ) {
            System.out.println("✅ Botón Listar presionado"); // Para comprobar
            listar(platosVista.TablePlatos);
        }
        if (e.getSource() == platosVista.btnAgregar ) {
            agregar();
            System.out.println("✅ Botón Agregar presionado"); // Para comprobar
            listar(platosVista.TablePlatos);
        }
        
        if (e.getSource() == platosVista.btnActualizar) {
            actualizar();
            System.out.println("✅ Botón Actualizar presionado"); // Para comprobar
            listar(platosVista.TablePlatos);
        }
        
        if (e.getSource() == platosVista.btnEliminar) {
            eliminar();
            System.out.println("✅ Botón Eliminar presionado"); // Para comprobar
            listar(platosVista.TablePlatos);
        }
        
    }
    
}
