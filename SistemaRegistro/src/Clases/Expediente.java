/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.time.LocalDateTime;
/**
 *
 * @author hidea
 */
public class Expediente {
    private String identificador;
    private int prioridad;
    private String dni;
    private String nombre;
    private String telefono;
    private String correo;
    private String asunto;
    private String documento;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinal;
    private String documentoResultado;

    public Expediente(String identificador, int prioridad, String dni, String nombre, String telefono, String correo, String asunto, String documento) {
        this.identificador = identificador;
        this.prioridad = prioridad;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.asunto = asunto;
        this.documento = documento;
        this.fechaInicio = LocalDateTime.now();
        this.fechaFinal = null;
        this.documentoResultado = null;
    }





    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDateTime fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getDocumentoResultado() {
        return documentoResultado;
    }

    public void setDocumentoResultado(String documentoResultado) {
        this.documentoResultado = documentoResultado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
}
