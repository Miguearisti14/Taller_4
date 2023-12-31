import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Taller4 {

    // *Ciclo de llenado con hashmap */
    // Key: casa. Clave: precio

    static HashMap Casas(int size) {
        HashMap<String, Integer> casas = new HashMap<String, Integer>();
        Random random = new Random();
        int rndmPrice = 0;

        String[] prefijos = { "la", "una" };
        String[] mid = { "cueva", "casa", "mansión" };
        String[] suf = {
                "de la montaña",
                "del bosque",
                "del pantano",
                "del desierto",
                "de Drácula",
                "de la bruja",
                "del vampiro",
        };

        for (int i = 0; i < size; i++) {
            int randPref = random.nextInt(prefijos.length);
            int randMid = random.nextInt(mid.length);
            int randSuf = random.nextInt(suf.length);
            String nombre = prefijos[randPref] + " " + mid[randMid] + " " + suf[randSuf];
            rndmPrice = random.nextInt(1000000);

            casas.put(nombre, rndmPrice);

        }
        return casas;
    }

    public static void main(String[] args) {

        // Array de los barrios
        String[] nombreBarrios = {
                "Floresta",
                "Aranjuez",
                "Manrique",
                "Carlos E",
                "Robledo",
        };

        // Inicio de Hashmaps de casa y sus ventas
        HashMap<String, Integer> ventas = new HashMap<String, Integer>();
        HashMap<String, Integer> casas = Casas(10);
        HashMap<String, Integer> numeroVentas = new HashMap<String, Integer>();

        
        for (String barrio : nombreBarrios) {
            ventas.put(barrio, 0);
            numeroVentas.put(barrio, 0);
        }

        int userEntry = 0;
        Random rnd = new Random();
        Scanner scner = new Scanner(System.in);

        System.out.println("¡Hola te doy la bienvenida a Tinder House!");
        System.out.println("El juego consiste en hacer match con cada casa que te guste");
        System.out.println("presiona 0 para descartar, 1 para comprar y 2 para terminar el juego");

        try {

            do {
                // Elegir una clave aleatoria
                Set<String> claves = casas.keySet();
                int cantidadClaves = claves.size();
                int indiceAleatorio = new Random().nextInt(cantidadClaves);
                String claveAleatoria = (String) claves.toArray()[indiceAleatorio];

                // Aqui va el juego
                int randBarrio = rnd.nextInt(nombreBarrios.length);
                int Price = casas.get(claveAleatoria);
                System.out.println("------*-------");
                System.out.println(claveAleatoria);
                System.out.println(nombreBarrios[randBarrio]);
                System.out.println(Price);
                System.out.println("------*-------");

                userEntry = scner.nextInt();

                // Accion a realizar por el usuario
                if (userEntry == 1) {
                    // *Floresta: Peso 3 */
                    if (randBarrio == 0) {
                        int actualVenta = ventas.get(nombreBarrios[randBarrio]);
                        int newVenta = actualVenta + (Price * 3);
                        ventas.replace(nombreBarrios[randBarrio], newVenta);

                        //* Contador para mayor numero de ventas */
                        int numActual = numeroVentas.get(nombreBarrios[randBarrio]);
                        int numNuevo = (numActual + 1);
                        numeroVentas.replace(nombreBarrios[randBarrio], numNuevo);
                    }
                    // *Aranjuez: Peso 2 */
                    else if (randBarrio == 1) {
                        int actualVenta = ventas.get(nombreBarrios[randBarrio]);
                        int newVenta = actualVenta + (Price * 2);
                        ventas.replace(nombreBarrios[randBarrio], newVenta);

                        //* Contador para mayor numero de ventas */
                        int numActual = numeroVentas.get(nombreBarrios[randBarrio]);
                        int numNuevo = (numActual + 1);
                        numeroVentas.replace(nombreBarrios[randBarrio], numNuevo);
                    }
                    // *Manrique: Peso 4 */
                    else if (randBarrio == 2) {
                        int actualVenta = ventas.get(nombreBarrios[randBarrio]);
                        int newVenta = actualVenta + (Price * 4);
                        ventas.replace(nombreBarrios[randBarrio], newVenta);

                        //* Contador para mayor numero de ventas */
                        int numActual = numeroVentas.get(nombreBarrios[randBarrio]);
                        int numNuevo = (numActual + 1);
                        numeroVentas.replace(nombreBarrios[randBarrio], numNuevo);
                    }
                    // *Carlos E: Peso 5 */
                    else if (randBarrio == 3) {
                        int actualVenta = ventas.get(nombreBarrios[randBarrio]);
                        int newVenta = actualVenta + (Price * 5);
                        ventas.replace(nombreBarrios[randBarrio], newVenta);

                        //* Contador para mayor numero de ventas */
                        int numActual = numeroVentas.get(nombreBarrios[randBarrio]);
                        int numNuevo = (numActual + 1);
                        numeroVentas.replace(nombreBarrios[randBarrio], numNuevo);
                    }
                    // *Robledo: Peso 6 */
                    else if (randBarrio == 4) {
                        int actualVenta = ventas.get(nombreBarrios[randBarrio]);
                        int newVenta = actualVenta + (Price * 6);
                        ventas.replace(nombreBarrios[randBarrio], newVenta);

                        //* Contador para mayor numero de ventas */
                        int numActual = numeroVentas.get(nombreBarrios[randBarrio]);
                        int numNuevo = (numActual + 1);
                        numeroVentas.replace(nombreBarrios[randBarrio], numNuevo);
                    }
                }

            } while (userEntry != 2);
        }

        catch (Exception e) {
            System.out.println("------*-------");
            System.out.println("Caracter no valido.\nVuelva a intentarlo");
            System.out.println("------*-------");
            System.out.println();
        }

        System.out.println("Reporte de ventas:");

        for (String barrio : ventas.keySet()) {
            System.out.println(barrio + " vendió " + ventas.get(barrio));

        }
        // *Para hallar el barrio que gano mas dinero */
        String barrioConMayorDinero = null;
        int valorMayor = Integer.MIN_VALUE;

        for (String barrio : ventas.keySet()) {
            int valor = ventas.get(barrio);

            if (valor > valorMayor) {
                valorMayor = valor;
                barrioConMayorDinero = barrio;
            }
        }

        // *Para hallar el barrio que gano menos dinero */
        String barrioConMenorDinero = null;
        int valorMenor = Integer.MAX_VALUE;

        for (String barrio : ventas.keySet()) {
            int valor = ventas.get(barrio);

            if (valor < valorMayor) {
                valorMenor = valor;
                barrioConMenorDinero = barrio;
            }
        }

        // *Para hallar el barrio que tuvo mas ventas */
        String barrioConMasVentas = null;
        int mayoresVentas = Integer.MIN_VALUE;

        for (String barrio : numeroVentas.keySet()) {
            int valor = ventas.get(barrio);

            if (valor > mayoresVentas) {
                mayoresVentas = valor;
                barrioConMasVentas = barrio;
            }
        }

        System.out.println("El barrio que mas dinero gano fue:" + barrioConMayorDinero);
        System.out.println("El barrio que menos dinero gano fue:" + barrioConMenorDinero);
        System.out.println("El barrio que mas ventas tuvo fue:" + barrioConMasVentas);

        scner.close();

    }

}