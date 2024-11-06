/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplopila;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author saulb
 */
public class NumeroCapicua {
    public static void main(String[] args) {
        boolean capicua;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        String numero;
        PilaVector2 pila = new PilaVector2(); // Suponiendo que es una clase personalizada
        ColaCircular q = new ColaCircular(); // Suponiendo que es una clase personalizada

        try {
            capicua = false;

            while (!capicua) {
                // Validar si el número es correcto (solo dígitos)
                do {
                    System.out.print("\nTeclea el número: ");
                    numero = entrada.readLine();
                } while (!valido(numero));

                // Insertar cada dígito en la cola y en la pila
                for (int i = 0; i < numero.length(); i++) {
                    char c = numero.charAt(i);
                    q.insertar(c);  // Suponiendo que insertar trabaja con char
                    pila.insertar(c);  // Suponiendo que insertar trabaja con char
                }

                // Comparar elementos sacados de la cola y la pila
                capicua = true;
                while (!q.colaVacia() && capicua) {
                    char dCola = (char) q.quitar();
                    char dPila = (char) pila.quitar();
                    capicua = (dCola == dPila);
                }

                // Resultados
                if (capicua) {
                    System.out.println(numero + " es capicúa.");
                } else {
                    System.out.print(numero + " no es capicúa, ");
                    System.out.println("intente otro.");
                    // Limpiar la cola y la pila
                    q.borrarCola();  // Suponiendo que este método vacía la cola
                    pila.limpiarPila();  // Suponiendo que este método vacía la pila
                }
            }
        } catch (Exception er) {
            System.err.println("Error (excepción) en el proceso: " + er);
        }
    }

    // Método para validar que el string solo contiene dígitos
    private static boolean valido(String numero) {
        for (int i = 0; i < numero.length(); i++) {
            if (!Character.isDigit(numero.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
