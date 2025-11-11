/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.edu.fpoo.modelo;

/**
 *
 * @author sebas
 */
public class Platos {
    private long idPlatos;
    private String nombre;
    private int codigo;
    private double precioVenta;
    private String descripcion;

    public Platos(long idPlatos, String nombre, int codigo, double precioVenta, String descripcion) {
        this.idPlatos = idPlatos;
        this.nombre = nombre;
        this.codigo = codigo;
        this.precioVenta = precioVenta;
        this.descripcion = descripcion;
    }
    public Platos(){}

    public long getIdPlatos() {
        return idPlatos;
    }

    public void setIdPlatos(long idPlatos) {
        this.idPlatos = idPlatos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
