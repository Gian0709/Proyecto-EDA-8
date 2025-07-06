/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author hidea
 */
public class NodoMovimiento {
    private Movimiento movimiento;
    private NodoMovimiento siguiente;
    
    public NodoMovimiento(Movimiento movimiento){
        this.movimiento = movimiento;
        this.siguiente = null;
    }

    public Movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    public NodoMovimiento getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoMovimiento siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
