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
public class Movimiento {
    private String idExpediente;
    private String dniExpediente;
    private String nombre;
    private String observacion;
    private LocalDateTime fechaRegistro;

    public Movimiento(String idExpediente, String dniExpediente, String nombre, String observacion) {
        this.idExpediente = idExpediente;
        this.dniExpediente = dniExpediente;
        this.nombre = nombre;
        this.observacion = observacion;
        this.fechaRegistro = LocalDateTime.now();
    }

    public String getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(String idExpediente) {
        this.idExpediente = idExpediente;
    }

    public String getDniExpediente() {
        return dniExpediente;
    }

    public void setDniExpediente(String dniExpediente) {
        this.dniExpediente = dniExpediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    
    
}


