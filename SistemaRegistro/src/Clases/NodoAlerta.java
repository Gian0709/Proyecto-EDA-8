/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author ASUS
 */
public class NodoAlerta <T> {
    private T elemento;
    private NodoAlerta<T> siguiente;

    public NodoAlerta(T elemento) {
        this.elemento = elemento;
        this.siguiente = null;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NodoAlerta<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoAlerta<T> siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
