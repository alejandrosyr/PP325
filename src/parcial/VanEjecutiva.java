package parcial;

/**
* Código generado por la app UXFtoJava by Charly Cimino
* @see https://github.com/CharlyCimino/uxf-to-java
*/
public class VanEjecutiva extends Vehiculo {

    private boolean aireAcondicionado;

    public VanEjecutiva(String patente, String marca, int capacidadPasajeros, int anioFabricacion, boolean aireAcondicionado) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        this.aireAcondicionado = aireAcondicionado;
    }

    public boolean getAireAcondicionado() {
        return aireAcondicionado;
    }
    @Override
    public void realizarServicioTuristico() {
        System.out.println("La Van Ejecutiva de patente " + getPatente() + " está realizando un passeo.");
    }

}