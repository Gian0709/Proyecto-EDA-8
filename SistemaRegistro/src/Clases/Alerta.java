/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author ASUS
 * 
 */
public class Alerta <T>{
    private NodoAlerta<T> cabeza;
    
    public Alerta() {
        this.cabeza = null;
    }
    
    public void agregar(T elemento){
        NodoAlerta <T> nuevo = new NodoAlerta<T>(elemento);
        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.setSiguiente(cabeza);
        } else {
            NodoAlerta <T> temp = cabeza;
            while (temp.getSiguiente() != cabeza){
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevo);
            nuevo.setSiguiente(cabeza);
        }
    }

    public NodoAlerta<T> getCabeza() {
        return cabeza;
    }
    
    public boolean estaVacia() {
        return cabeza == null;
    }
    
    public void agregarPrioridad(T elemento) {
        NodoAlerta<T> nuevo = new NodoAlerta<>(elemento);
        
        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.setSiguiente(cabeza);
        } else {
            NodoAlerta<T> actual = cabeza;
            NodoAlerta<T> anterior = null;
            
            do {
                if (!(elemento instanceof Expediente)){
                    throw new IllegalArgumentException("Solo se pueden agregar objetos de tipo Expediente.");
                }
                
                Expediente expActual = (Expediente) actual.getElemento();
                Expediente expNuevo = (Expediente) elemento;
                
                boolean insertarAntes = false;
                
                if (expNuevo.getPrioridad() < expActual.getPrioridad()) {
                    insertarAntes = true;
                } else if (expNuevo.getPrioridad() == expActual.getPrioridad() && expNuevo.getFechaInicio().isBefore(expActual.getFechaInicio())) {
                    insertarAntes = true;
                }
                
                if (insertarAntes) break;
                
                anterior = actual;
                actual = actual.getSiguiente();
            } while (actual != cabeza);
            
            if (anterior == null) {
                NodoAlerta<T> temp = cabeza;
                while (temp.getSiguiente() != cabeza) {
                    temp = temp.getSiguiente();
                }
                temp.setSiguiente(nuevo);
                nuevo.setSiguiente(cabeza);
                cabeza = nuevo;
            } else {
                anterior.setSiguiente(nuevo);
                nuevo.setSiguiente(actual);
            }
        }
    }
}
