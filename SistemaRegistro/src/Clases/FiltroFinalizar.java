/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author ASUS
 */
public class FiltroFinalizar<T> {
    private NodoDoble<T> cabeza;
    private NodoDoble<T> cola;
    
    public void agregar(T elemento) {
        NodoDoble<T> nuevo = new NodoDoble<>(elemento);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
            cola = nuevo;
        }
    }
    
    public NodoDoble<T> getCabeza() {
        return cabeza;
    }
}
