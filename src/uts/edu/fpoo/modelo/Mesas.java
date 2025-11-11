/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.edu.fpoo.modelo;

/**
 *
 * @author sebas
 */
public class Mesas {
    
    private long idmesas;
    private int numero;
    private String estado;

    public Mesas(){
        
    }
    
    public Mesas(long idmesas, int numero, String estado) {
        this.idmesas = idmesas;
        this.numero = numero;
        this.estado = estado;
    }

 

    public long getIdmesas() {
        return idmesas;
    }

    public void setIdmesas(long idmesas) {
        this.idmesas = idmesas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
