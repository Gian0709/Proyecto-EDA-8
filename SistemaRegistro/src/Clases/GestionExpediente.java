/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.List;
/**
 *
 * @author hidea
 */
public class GestionExpediente {
    
    private  Nodo primero;
    private NodoMovimiento iniciMovimiento = null;
    
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
    
    public Expediente buscarPorDNI(String dni) {
        Nodo actual = this.getPrimero();
        while (actual != null) {
            Expediente exp = (Expediente) actual.getElemento();
            if (exp.getDni().equals(dni)) {
                return exp;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }
    
    public FiltroFinalizar<Expediente> obtenerExpedientesFiltrados(boolean finalizados) {
        FiltroFinalizar<Expediente> lista = new FiltroFinalizar<>();
        Nodo actual = this.getPrimero();

        while (actual != null) {
            Expediente exp = (Expediente) actual.getElemento();
            if ((finalizados && exp.getFechaFinal() != null) ||
                (!finalizados && exp.getFechaFinal() == null)) {
                lista.agregar(exp);
            }
            actual = actual.getSiguiente();
        }
        return lista;
    }
    
    public void registrarMovimiento(String id, String dni,String nombre,String observacion){
        Movimiento nuevo = new Movimiento(id, dni, nombre, observacion);
        NodoMovimiento nodo = new NodoMovimiento(nuevo);
        
        if (iniciMovimiento == null) {
            iniciMovimiento = nodo;
        } else {
            NodoMovimiento actual = iniciMovimiento;
            while (actual.getSiguiente()!= null) {                
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nodo);
        }
        
    }
     
    public NodoMovimiento obtenerMovimientoporDNI(String dni){
        NodoMovimiento primero = null;
        NodoMovimiento ultimo = null;
        NodoMovimiento actual  = iniciMovimiento;
        
        while (actual != null){
            Movimiento m = actual.getMovimiento();
            if (m.getDniExpediente().equals(dni)) {
                NodoMovimiento nuevo = new NodoMovimiento(m);
                if (primero == null) {
                    primero = nuevo;
                    ultimo = nuevo;
                } else {
                    ultimo.setSiguiente(nuevo);
                    ultimo = nuevo;
                }
                actual = actual.getSiguiente();
            }
            
        }
        return  primero;
    }
    
    public Alerta<Expediente> generarAlertasPendientes() {
        Alerta<Expediente> alerta = new Alerta<>();
        Nodo actual = this.getPrimero();
        
        while (actual != null) {
            Expediente exp = (Expediente) actual.getElemento();
            if (exp.getFechaFinal() == null) {
                alerta.agregarPrioridad(exp);
            }
            actual = actual.getSiguiente();
        }
        
        
        
        return alerta;
    }
}
