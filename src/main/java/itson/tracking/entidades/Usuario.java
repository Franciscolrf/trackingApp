package itson.tracking.entidades;

/**
 * Clase que representa a un usuario de la aplicación
 *  @author David Acosta Fajardo - Raul Alejandro Sauceda Rayos - Francisco de Jesús López Ruiz / ITSON
 */
public class Usuario {
    private String nombre;
    private String nomUsuario;
    private int edad;
    private float peso;
    private float estatura;
    private PlanEntrenamiento planEntrenamiento;

    /**
     * Constructor de la clase Usuario con todos los atributos
     * @param nombre
     * @param nomUsuario
     * @param edad
     * @param peso
     * @param estatura
     * @param planEntrenamiento
     */
    public Usuario(String nombre, String nomUsuario, int edad, float peso, float estatura, PlanEntrenamiento planEntrenamiento) {
        this.nombre = nombre;
        this.nomUsuario = nomUsuario;
        this.edad = edad;
        this.peso = peso;
        this.estatura = estatura;
        this.planEntrenamiento = planEntrenamiento;
    }

    // Getters - Setters

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



    public PlanEntrenamiento getPlanEntrenamiento() {
        return planEntrenamiento;
    }



    public void setPlanEntrenamiento(PlanEntrenamiento planEntrenamiento) {
        this.planEntrenamiento = planEntrenamiento;
    }

}
