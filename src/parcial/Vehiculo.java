package parcial;

/**
* Código generado por la app UXFtoJava by Charly Cimino
* @see https://github.com/CharlyCimino/uxf-to-java
*/
public abstract class Vehiculo {

    private String patente;
    private String marca;
    private int capacidadPasajeros;
    private int anioFabricacion;

    public Vehiculo(String patente, String marca, int capacidadPasajeros, int anioFabricacion) {
        this.patente = patente;
        this.marca = marca;
        this.capacidadPasajeros = capacidadPasajeros;
        this.anioFabricacion = anioFabricacion;
    }

    public String getPatente() {
        
        return patente;
    }

    public String getMarca() {
        // Método a resolver...
        return marca;
    }

    public int getCapacidadPasajeros() {
        // Método a resolver...
        return capacidadPasajeros;
    }

    public int getAnioFabricacion() {
        // Método a resolver...
        return anioFabricacion;
    }

    public abstract void realizarServicioTuristico();

}