package parcial;

import java.util.Comparator;


public class ComparadorPorAnio implements Comparator<Vehiculo> {
    @Override
    public int compare(Vehiculo v1, Vehiculo v2){
        return Integer.compare(v2.getAnioFabricacion(), v1.getAnioFabricacion());
        
    }

}
