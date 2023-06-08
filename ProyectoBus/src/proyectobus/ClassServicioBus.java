package proyectobus;

import java.util.Scanner;

public class ClassServicioBus {

    Scanner entrada = new Scanner(System.in);
    String nombreCliente;
    String nivelAsiento;
    double distanciaViaje;
    double precioTotal;
    double fondosPersona;
    boolean puedePagar;
    // constructor

    public ClassServicioBus(String nombreCliente, String nivelAsiento, double distanciaViaje, double precioTotal, double fondosPersona, boolean puedePagar) {
        this.nombreCliente = nombreCliente;
        this.nivelAsiento = nivelAsiento;
        this.distanciaViaje = distanciaViaje;
        this.precioTotal = precioTotal;
        this.fondosPersona = fondosPersona;
        this.puedePagar = puedePagar;
    }

    public double calcularprecio() {
        double preciototal = distanciaViaje * 3.2; // 3.2 lempiras por kilometro JIJI
        double precioAsiento = 0.0;
        if (nivelAsiento.equalsIgnoreCase("Economico")) {
            precioAsiento = 3.42; // 3 lempiras asiento normal
        } else if (nivelAsiento.equalsIgnoreCase("VIP")) {
            precioAsiento = 40.74; // 40 lempiras asiento 
        }
        return preciototal + precioAsiento;
    }

    public boolean puedepagar() {
        return fondosPersona >= calcularprecio();
    }

    public void comida() {
        if (distanciaViaje > 50) {
            String decisioncomida;

            do {
                System.out.println("Su viaje parece ser bastante largo, desea agregar una comida por el costo adicional de 250.LPS?");
                decisioncomida = entrada.next();
                if (! decisioncomida.equalsIgnoreCase("si") && !decisioncomida.equalsIgnoreCase("no")) {
                    System.out.println("opcion invalida, solo puede ingresar si o no.");
                }
            } while (!decisioncomida.equalsIgnoreCase("si")  && !decisioncomida.equalsIgnoreCase("no"));
            if (decisioncomida.equalsIgnoreCase("si")) {
                precioTotal += 250.0;
                System.out.println("se ha agregado el paquete de comida a su viaje, disfrute y buen provecho!");
            } else {
                System.out.println("decidio no comprar el paquete de comida...");

            }

        }
    }
}

