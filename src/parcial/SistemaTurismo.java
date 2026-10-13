package parcial;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

/**
* Código generado por la app UXFtoJava by Charly Cimino
* @see https://github.com/CharlyCimino/uxf-to-java
*/
public class SistemaTurismo {

    private ArrayList<Vehiculo> vehiculos;
    private Scanner scanner;
    
    public SistemaTurismo(){
        vehiculos = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    public void agregarVehiculo(){
        System.out.println("\n--- AGREGAR VEHiCULO ---");
        System.out.println("1. Colectivo Turistico");
        System.out.println("2. Van Ejecutiva");
        System.out.println("3. Lancha Turistica");
        
        System.out.println("Seleccione el numero del tipo de vehiculo que desea agregar: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Patente: ");
        String patente = scanner.nextLine();
        
        boolean patenteValida = false;
        
        while(!patenteValida){
            if (patente.isEmpty()){
                System.out.println("La patente no puede estar vacia.");
                System.out.println("Ingrese nuevamente la patente: ");
                patente = scanner.nextLine();
            }
            else {
                boolean patenteRepetida = false;
                
                for (Vehiculo v : vehiculos){
                    if (v.getPatente().equals(patente)){
                        patenteRepetida = true;
                    }
                }
                if (patenteRepetida){
                    System.out.println("La patente ya esta registrada.");
                    System.out.println("Ingrese nuevamente la patente: ");
                    patente = scanner.nextLine();
                }
                else{
                    patenteValida = true;
                }
            }
        }
        
        //La consigna no pide validación de marca pero me pareció raro no tenerlo.
        System.out.println("Marca: ");
        String marca = scanner.nextLine();
        while(marca.isEmpty()){
            System.out.println("La marca no puede estar vacia.");
            System.out.println("\n Marca: ");
            marca = scanner.nextLine();
        }
        
        //Me pareció coherente que tambien tenga un máximo. 
        System.out.println("Capacidad de pasajeros: ");
        int capacidadPasajeros = scanner.nextInt();
        
        while (capacidadPasajeros <= 0 || capacidadPasajeros > 60){
            System.out.println("La capacidad de pasajeros debe ser mayor que 0 y menor que 60");
            System.out.println("Capacidad de pasajeros: ");
            capacidadPasajeros = scanner.nextInt();
        }
        
        int anioActual = LocalDate.now().getYear();
        
        System.out.println("Anio de fabricacion: ");
        int anioFabricacion = scanner.nextInt();
        
        while(anioFabricacion < 1990 || anioFabricacion > anioActual){
            System.out.println("El anio debe estar entre 1990 y " + anioActual + ".");
            System.out.println("Anio de fabricacion: ");
            anioFabricacion = scanner.nextInt();
        }
        switch (tipo){
            case 1 -> {
                System.out.println("Cantidad de pisos(1 o 2): ");
                int cantidadPisos = scanner.nextInt();
                while (cantidadPisos != 1 && cantidadPisos !=2){
                    System.out.println("La cantidad de pisos debe ser 1 o 2");
                    System.out.println("Cantidad de pisos(1 o 2): ");
                    cantidadPisos = scanner.nextInt();
                }
                
                ColectivoTuristico colectivo = new ColectivoTuristico(
                        patente, marca, capacidadPasajeros, anioFabricacion, cantidadPisos);
                vehiculos.add(colectivo);
                
                System.out.println("Colectivo agregado correctamente.");
            }
            
            case 2 -> {
                scanner.nextLine();
                System.out.println("Tiene aire acondicionado?(Si/No): ");
                String respuesta = scanner.nextLine().toLowerCase();
                
                while(!respuesta.equals("si") && !respuesta.equals("no")){
                    System.out.println("El dato que ingresaste es invalido.\nDebe ingresar Si o No.");
                    
                    System.out.println("Tiene aire acondicionado? (Si/No): ");
                    respuesta = scanner.nextLine().toLowerCase();
                }
                
                boolean aireAcondicionado = respuesta.equals("si");
                
                
                VanEjecutiva van = new VanEjecutiva(
                        patente, marca, capacidadPasajeros, anioFabricacion, aireAcondicionado);
                vehiculos.add(van);
                
                System.out.println("Van agregada correctamente");
            }

            
            case 3 -> {
                scanner.nextLine();
                System.out.println("Tipo de motor(NAFTA/DIESEL/ELECTRICO): ");
                String tipoMotor = scanner.nextLine().toUpperCase();
                
                while (!tipoMotor.equals("NAFTA") 
                        && !tipoMotor.equals("DIESEL")
                        && !tipoMotor.equals("ELECTRICO")){
                    System.out.println("Tipo de motor Invalido");
                    System.out.println("Ingrese NAFTA, DIESEL o ELECTRICO");
                    tipoMotor = scanner.nextLine().toUpperCase();
                }
                
                LanchaTuristica lancha = new LanchaTuristica(
                        patente, marca, capacidadPasajeros, anioFabricacion, tipoMotor);
                
                vehiculos.add(lancha);
                
                System.out.println("Lancha agregada correctamente.");
            }
                
            default -> System.out.println("El numero ingresado es invalido.");
                    
        }
        
    }
    public void mostrarTodosLosVehiculos(){
        
        if (vehiculos.isEmpty()){
            System.out.println("No hay vehículos registrados.");
            return;
        }
       
       for (Vehiculo v : vehiculos){
           System.out.println("===================");
           System.out.println("Patente: " + v.getPatente());
           System.out.println("Marca: " + v.getMarca());
           System.out.println("Capacidad: " + v.getCapacidadPasajeros());
           System.out.println("Año de fabricación: " + v.getAnioFabricacion());
           
           if (v instanceof ColectivoTuristico colectivo){
               System.out.println("Cantidad de pisos: " + colectivo.getCantidadPisos());
           }
           //Acordar de cambiar de bool a String para que sea mejor para usuário. 
           else if (v instanceof VanEjecutiva van){
               System.out.println("Aire Acondicionado: " + van.getAireAcondicionado());
           }
           else if (v instanceof LanchaTuristica lancha){
               System.out.println("Tipo de Motor: " + lancha.getTipoMotor());
           }
       }
    }
    public void realizarServiciosTuristicos(){
        if (vehiculos.isEmpty()){
            System.out.println("No hay vehiculos registrados");
            return;
        }
        for (Vehiculo v : vehiculos){
            System.out.println("========================");
            System.out.println("Patente: " + v.getPatente());
            v.realizarServicioTuristico();
        }
    }
    public void buscarVehiculoPorPatente(){
        if (vehiculos.isEmpty()){
            System.out.println("No hay vehiculos registrados.");
        }
        System.out.println("Ingrese la patente a buscar: ");
        String patenteBuscada = scanner.nextLine();
        
        boolean encontrado = false;
        
        for (Vehiculo v: vehiculos){
            if (v.getPatente().equals(patenteBuscada)){
                System.out.println("Vehiculo Encontrado!");
                System.out.println("Patente: " + v.getPatente());
                System.out.println("Marca: " + v.getMarca());
                System.out.println("Capacidad: " + v.getCapacidadPasajeros());
                System.out.println("Anio: " + v.getAnioFabricacion());
                
                encontrado = true;
            }
        }
        if (!encontrado){
            System.out.println("No se encontro un vehiculo con esa patente");
        }
        
    }
    public void iniciar(){
        int opcion = 0;
        
        while (opcion != 8){
            System.out.println("\n--- SISTEMA DE TURISMO ---");
            System.out.println("1. Agregar Vehiculo");
            System.out.println("2. Mostrar todos los vehiculos");
            System.out.println("3. Realizar servicios turisticos");
            System.out.println("4. Buscar vehiculo por patente");
            System.out.println("5. Mostrar vehiculo por patente");
            System.out.println("6. Mostrar vehiculos ordenados por anio");
            System.out.println("7. Mostrar vehiculos ordenados por capacidad");
            System.out.println("8. Salir");
            
            System.out.println("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            
            switch (opcion){
                case 1 -> { 
                    System.out.println("Agregando vehiculo");
                    agregarVehiculo();
                }
                    
                case 2 -> {
                    System.out.println("Mostrando vehiculos");
                    mostrarTodosLosVehiculos();
                }
                case 3 -> {
                    System.out.println("Realizar servicio turistico");
                    realizarServiciosTuristicos();
                }
                case 4 -> {
                    System.out.println("Buscando vehiculo por patente");
                    buscarVehiculoPorPatente();
                }
                case 5 -> System.out.println("Mostrar vehiculos con capacidad mayor a un valor ingresado");
                case 6 -> System.out.println("Mostrar vehiculos ordenados por anio de fabricacion descendente");
                case 7 -> System.out.println("Mostrar vehiculos ordenados por capacidad descendente");
                case 8 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opcion invalida");
            }

            
        }
    }
}