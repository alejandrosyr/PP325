package parcial;

/**
* Código generado por la app UXFtoJava by Charly Cimino
* @see https://github.com/CharlyCimino/uxf-to-java
*/
public class ColectivoTuristico extends Vehiculo {

    private int cantidadPisos;

    public ColectivoTuristico(String patente, String marca, int capacidadPasajeros, int anioFabricacion, int cantidadPisos) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        this.cantidadPisos = cantidadPisos;
    }


    public int getCantidadPisos() {
        return cantidadPisos;
    }

    @Override
    public void realizarServicioTuristico() {
        System.out.println("El Colectivo Turistico de patente " + getPatente() + " esta realizando un passeo.");
    }

}