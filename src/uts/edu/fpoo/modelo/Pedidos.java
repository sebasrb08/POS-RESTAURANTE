/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.edu.fpoo.modelo;

import java.time.LocalDateTime;

/**
 *
 * @author sebas
 */
public class Pedidos {
    private long idPedido;
    private long idMesa;
    private LocalDateTime fecha;
    private String estado;
    private double total;
    private int numeroMesa;
    

    public Pedidos(long idMesa, LocalDateTime fecha, String estado, double total) {
        this.idMesa = idMesa;
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
    }

    public Pedidos() {
    }
    
    
    
    public long getId() {
        return idPedido;
    }

    public void setId(long idPedido) {
        this.idPedido = idPedido;
    }

    public long getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(long idMesa) {
        this.idMesa = idMesa;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }
    
}
