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
        System.out.println("\n--- AGREGAR VEHÍCULO ---");
        System.out.println("1. Colectivo Turístico");
        System.out.println("2. Van Ejecutiva");
        System.out.println("3. Lancha Turística");
        
        System.out.println("Seleccione el numero del tipo de vehículo que desea agregar: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Patente: ");
        String patente = scanner.nextLine();
        
        boolean patenteValida = false;
        
        while(!patenteValida){
            if (patente.isEmpty()){
                System.out.println("La patente no puede estar vacía.");
            }
            else {
                boolean patenteRepetida = false;
                
                for (Vehiculo v : vehiculos){
                    if (v.getPatente().equals(patente)){
                        patenteRepetida = true;
                    }
                }
                if (patenteRepetida){
                System.out.println("La patente ya está registrada.");
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
            System.out.println("La marca no puede estar vacía.");
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
        
        System.out.println("Año de fabricación: ");
        int anioFabricacion = scanner.nextInt();
        
        while(anioFabricacion < 1990 || anioFabricacion > anioActual){
            System.out.println("El año debe estar entre 1990 y " + anioActual + ".");
            System.out.println("Año de fabricación: ");
            anioFabricacion = scanner.nextInt();
        }
        switch (tipo){
            case 1:
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
                break;
            
            case 2:
                System.out.println("Tiene aire acondicionado?(Si/No): ");
                String respuesta = scanner.nextLine().toLowerCase();
                
                while(!respuesta.equals("si") && !respuesta.equals("no")){
                    System.out.println("El dato que ingresaste es inválido.\nDebe ingresar Si o No.");
                    
                    System.out.println("Tiene aire acondicionado? (Si/No): ");
                    respuesta = scanner.nextLine().toLowerCase();
                }
                
                boolean aireAcondicionado = respuesta.equals("si");
                
                
                VanEjecutiva van = new VanEjecutiva(
                        patente, marca, capacidadPasajeros, anioFabricacion, aireAcondicionado);
                vehiculos.add(van);
                
                System.out.println("Van agregada correctamente");
                break;

            
            case 3:
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
                break;
                
            default:
                System.out.println("El numero ingresado es invalido.");
                    
        }
        
    }
    public void mostrarTodosLosVehiculos(){
       
    }
    public void iniciar(){
        int opcion = 0;
        
        while (opcion != 8){
            System.out.println("\n--- SISTEMA DE TURISMO ---");
            System.out.println("1. Agregar Vehículo");
            System.out.println("2. Mostrar todos lso vehículos");
            System.out.println("3. Realizar servicios turísticos");
            System.out.println("4. Buscar vehículo por patente");
            System.out.println("5. Mostrar vehículo por patente");
            System.out.println("6. Mostrar vehículos ordenados por año");
            System.out.println("7. Mostrar vehículos ordenados por capacidad");
            System.out.println("8. Salir");
            
            System.out.println("Seleccione una opción: ");
            opcion = scanner.nextInt();
            
            switch (opcion){
                case 1 -> { 
                    System.out.println("Agregando vehículo");
                    agregarVehiculo();
                }
                    
                case 2 -> System.out.println("Mostrar vehículos");
                case 3 -> System.out.println("Realizar servicio turistico");
                case 4 -> System.out.println("Buscar vehículo por patente");
                case 5 -> System.out.println("Mostrar vehículo por patente");
                case 6 -> System.out.println("Mostrar vehículos ordenados por año");
                case 7 -> System.out.println("Mostrar vehículos ordenados por capacidad");
                case 8 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida");
            }

            
        }
    }
}