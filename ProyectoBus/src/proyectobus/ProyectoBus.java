package proyectobus;

import java.util.Scanner;

public class ProyectoBus {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println(" bienvenido al ingrese su nombre por favor: ");
        String nombreCliente = entrada.nextLine();
        String nivelAsiento;
        do {
            System.out.print("Ingrese el nivel de asiento (Economico/VIP): ");
            nivelAsiento = entrada.nextLine();

            if (!nivelAsiento.equalsIgnoreCase("Economico") && !nivelAsiento.equalsIgnoreCase("VIP")) {
                System.out.println("Opción invalida. Por favor, ingrese 'Economico' o 'VIP'.");
            }
        } while (!nivelAsiento.equalsIgnoreCase("Economico") && !nivelAsiento.equalsIgnoreCase("VIP"));

        System.out.println("ingrese la distancia de su viaje en kilometros: ");
        double distanciaViaje = entrada.nextDouble();
        int distanciaviaje = 0;

        System.out.println("ingrese sus fondos(dinero disponible): ");
        double fondosPersona = entrada.nextDouble();

        ClassServicioBus serviciobus = new ClassServicioBus(nombreCliente, nivelAsiento, distanciaViaje, 0.0, fondosPersona, false);
        
        double precioViaje = serviciobus.calcularprecio();
        serviciobus.precioTotal = precioViaje;
        serviciobus.comida();
        if (serviciobus.puedepagar()) {
            System.out.println("el viaje puede ser pagado.");
            System.out.println("el precio total del viaje es de: " + serviciobus.precioTotal + "lempiras.");

        } else {
            System.out.println(nombreCliente + ", usted no tiene fondos suficientes para pagar el viaje.");
            System.out.println("el precio total del viaje es de: " + serviciobus.precioTotal + "lempiras.");
        }
    }


}
