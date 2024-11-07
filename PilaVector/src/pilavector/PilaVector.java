package pilavector;

import java.io.*;

/**
 * 23550328
 *
 * @author angel adrian orozco rodriguez estructura de datos
 */
public class PilaVector {

    public static void main(String[] args) {

        PilaVector2 pila = new PilaVector2();
        int x;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Teclea el número de elementoss a insertar en la pila: ");
        try {
            x = Integer.parseInt(entrada.readLine());
            System.out.println("Teclea números positivos y negativos: ");
            for (int j = 1; j <= x; j++) {
                Double d;
                d = Double.valueOf(entrada.readLine());
                pila.insertar(d);
                
            }
            // Vaciado de la pila
            System.out.println("Elementos de la Pila: ");
            while (!pila.pilaVacia()) {
                Double d;
                d = (Double) pila.quitar();
                if (d.doubleValue() > 0.0) {
                    System.out.print(d + " ");
                    
                }
            }
        } catch (Exception er) {
            System.err.println("Excepcion: " + er);
            
        }
    }

}
