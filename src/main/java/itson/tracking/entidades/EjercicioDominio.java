package itson.tracking.entidades;

/**
 *  Clase que representa un ejercicio de un plan de entrenamiento
 *  @author David Acosta Fajardo - Raul Alejandro Sauceda Rayos - Francisco de Jesús López Ruiz / ITSON
 */
public class EjercicioDominio {
    private String nombre;
    private String tipo;
    private int duracion;  

    /**
     * Constructor de la clase EjercicioDominio con todos los atributos
     * @param nombre
     * @param tipo
     * @param duracion
     */
    public EjercicioDominio(String nombre, String tipo, int duracion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.duracion = duracion;
    }



    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getTipo() {
        return tipo;
    }



    public void setTipo(String tipo) {
        this.tipo = tipo;
    }



    public int getDuracion() {
        return duracion;
    }



    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

}
