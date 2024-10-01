/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.tracking.entidades;
import java.util.Date;
import java.util.List;

/**
 *  Clase que representa un plan de entrenamiento
 *  @author David Acosta Fajardo - Raul Alejandro Sauceda Rayos - Francisco de Jesús López Ruiz / ITSON
 */
public class PlanEntrenamiento {
    private List<Dia> dias;
    private Date fechaInicial;
    private Date fechaFinal;

    /**
     * Constructor de la clase PlanEntrenamiento con todos los atributos
     * @param dias
     * @param fechaInicial
     * @param fechaFinal
     */
    public PlanEntrenamiento(List<Dia> dias, Date fechaInicial, Date fechaFinal) {
        this.dias = dias;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
    }


    public List<Dia> getDias() {
        return dias;
    }


    public void setDias(List<Dia> dias) {
        this.dias = dias;
    }


    public Date getFechaInicial() {
        return fechaInicial;
    }


    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }


    public Date getFechaFinal() {
        return fechaFinal;
    }


    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }


}