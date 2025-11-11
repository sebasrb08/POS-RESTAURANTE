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
import uts.edu.fpoo.modelo.Mesas;
import uts.edu.fpoo.modelo.MesasDAO;
import uts.edu.fpoo.vista.MesasVista;

/**
 *
 * @author sebas
 */
public class MesasControlador  implements ActionListener, ListSelectionListener{
    MesasDAO dao = new MesasDAO();
    Mesas m = new Mesas();
    MesasVista mesasVista = new MesasVista();
    DefaultTableModel modelo =  new DefaultTableModel();

    public MesasControlador(MesasVista v) {
        this.mesasVista = v;
        this.mesasVista.btnListar.addActionListener(this);
        this.mesasVista.btnAgregar.addActionListener(this);
        this.mesasVista.btnActualizar.addActionListener(this);
        this.mesasVista.btnEliminar.addActionListener(this);
        this.mesasVista.tableMesa.getSelectionModel().addListSelectionListener(this);

    }
    
    public void listar(JTable tabla){
        modelo= (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        modelo.setRowCount(0);
        ArrayList<Mesas> mesas = dao.listar();
        Object [] objeto = new Object[3];
        if (mesas == null || mesas.isEmpty()) {
            System.out.println("No hay platos en la base de datos");
            return;
        }
        for (int i = 0; i < mesas.size(); i++) {
            objeto[0] = mesas.get(i).getIdmesas();
            objeto[1] = mesas.get(i).getNumero();
            objeto[2] = mesas.get(i).getEstado();
            modelo.addRow(objeto);
        }
        tabla.setRowHeight(35);
        tabla.setRowMargin(10);
    }
    
    public void agregar(){
        long id = Long.parseLong( mesasVista.getIdField().getText());
        int numero = Integer.parseInt( mesasVista.getNumeroField().getText());
        String estado =  mesasVista.getEstadoField().getText();
        Mesas mesa = new Mesas(id, numero, estado);
        dao.agregar(mesa);
        JOptionPane.showMessageDialog(mesasVista, "Usuario Agregado con exito");
        
    }
    
    public void actualizar(){
        long id = Long.parseLong( mesasVista.getIdField().getText());
        int numero = Integer.parseInt( mesasVista.getNumeroField().getText());
        String estado =  mesasVista.getEstadoField().getText();
        Mesas mesa = new Mesas(id, numero, estado);
        int r = dao.actualizar(mesa);
        if (r == 1) {
           JOptionPane.showMessageDialog(mesasVista, "Usuario Actualizado con exito");
        }else{
            JOptionPane.showMessageDialog(mesasVista, "Usuario No se pudo actualizar");

        }
    }
    
    public void limpiarCampo(){
        mesasVista.getIdField().setText("");
        mesasVista.getNumeroField().setText("");
        mesasVista.getEstadoField().setText("");

    }

    
    public void selectRow(JTable tabla){
        int fila = tabla.getSelectedRow();
        
        mesasVista.getIdField().setText(tabla.getValueAt(fila, 0).toString());
        mesasVista.getNumeroField().setText(tabla.getValueAt(fila, 1).toString());
        mesasVista.getEstadoField().setText(tabla.getValueAt(fila, 2).toString());

    }
    
    public void valueChanged(javax.swing.event.ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int fila = mesasVista.tableMesa.getSelectedRow();
            if (fila != -1) {
            selectRow(mesasVista.tableMesa);
            }
        }
    }
    public void eliminar(){
        long id = Long.parseLong( mesasVista.getIdField().getText());
        int r = dao.eliminar(id);
        if (r == 1) {
            JOptionPane.showMessageDialog(mesasVista, "Usuario Eliminado con exito");

        }else{
            JOptionPane.showMessageDialog(mesasVista, "Usuario no fue Eliminado");

        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mesasVista.btnListar ) {
            System.out.println("✅ Botón Listar presionado"); // Para comprobar
            listar(mesasVista.tableMesa);
        }
        if (e.getSource() == mesasVista.btnAgregar ) {
            agregar();
            System.out.println("✅ Botón Agregar presionado"); // Para comprobar
            listar(mesasVista.tableMesa);
        }
        
        if (e.getSource() == mesasVista.btnActualizar) {
            actualizar();
            System.out.println("✅ Botón Actualizar presionado"); // Para comprobar
            listar(mesasVista.tableMesa);
        }
        
        if (e.getSource() == mesasVista.btnEliminar) {
            eliminar();
            System.out.println("✅ Botón Eliminar presionado"); // Para comprobar
            listar(mesasVista.tableMesa);
        }
        
    }
}
