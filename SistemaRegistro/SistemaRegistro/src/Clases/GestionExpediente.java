/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author hidea
 */
public class GestionExpediente {
    
    private  Nodo primero;
    
    public GestionExpediente(){
        primero = null;
    }

    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }
    
    public void AgregarPrimero(Nodo pNuevo) {
        if (primero == null) //esta vacía
        {
            primero = pNuevo;
        } else {
            pNuevo.setSiguiente(primero);
            primero = pNuevo;
        }
    }

    public void MostrarLista() {
        Nodo actual = primero;
        while (actual != null) {
            System.out.print(actual.getElemento() + " -> ");
            actual = actual.getSiguiente();
        }
        System.out.println("");
    }

    

    public void AgregarUltimo(Nodo pNuevo) {
        if (primero == null) //esta vacía
        {
            primero = pNuevo;
        } else {
            Nodo actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(pNuevo);
        }
    }
    
    public int NumeroElementos() {
        int cont = 0;
        Nodo actual = primero;
        while (actual != null) {
            cont++;
            actual = actual.getSiguiente();
        }
        return cont;
    }
    
    public void EliminarPrimero(){
        if (primero == null || primero.getSiguiente()==null) {
            primero = null;
        }
        else
        {
            primero = primero.getSiguiente();
        }
    }
    
    public void EliminarUltimo(){
        if (primero == null || primero.getSiguiente()==null) {
            primero = null;
        }
        else
        {
            Nodo actual = primero;
            while (actual.getSiguiente().getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(null);
        }
    }    
    
}
