/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.patrond.usuario;

import itson.patrond.rutina.PlanEntrenamiento;

/**
 * Clase que representa un usuario
 * @author Fran
 */
public class Usuario {
    String nombre;
    String nomUsuario;
    int edad;
    float peso;
    float estatura;
    PlanEntrenamiento  plan;

    public Usuario(String nombre, String nomUsuario, int edad, float peso, float estatura, PlanEntrenamiento plan) {
        this.nombre = nombre;
        this.nomUsuario = nomUsuario;
        this.edad = edad;
        this.peso = peso;
        this.estatura = estatura;
        this.plan = plan;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public PlanEntrenamiento getPlan() {
        return plan;
    }

    public void setPlan(PlanEntrenamiento plan) {
        this.plan = plan;
    }

    
}
