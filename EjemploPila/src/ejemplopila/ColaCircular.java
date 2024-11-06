/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplopila;

/**
 *
 * @author saulb
 */
public class ColaCircular {
    private static final int MAXTAMQ = 99; // Tamaño máximo de la cola
    protected int frente; // Índice del frente de la cola
    protected int fin;    // Índice del final de la cola
    protected Object[] listaCola; // Array que contiene los elementos de la cola

    // Constructor: inicializa la cola vacía
    public ColaCircular() {
        frente = 0;
        fin = MAXTAMQ - 1; // Al iniciar, fin está "antes" del frente
        listaCola = new Object[MAXTAMQ];
    }

    // Avanza una posición circularmente
    private int siguiente(int r) {
        return (r + 1) % MAXTAMQ;
    }

    // Inserta un elemento en la cola
    public void insertar(Object elemento) throws Exception {
        if (!colaLlena()) {
            fin = siguiente(fin);
            listaCola[fin] = elemento;
        } else {
            throw new Exception("Overflow: La cola está llena");
        }
    }

    // Elimina y devuelve el elemento al frente de la cola
    public Object quitar() throws Exception {
        if (!colaVacia()) {
            Object elemento = listaCola[frente];
            frente = siguiente(frente);
            return elemento;
        } else {
            throw new Exception("Underflow: La cola está vacía");
        }
    }

    // Reinicia la cola a su estado vacío
    public void borrarCola() {
        frente = 0;
        fin = MAXTAMQ - 1;
    }

    // Devuelve el elemento en el frente sin eliminarlo
    public Object frenteCola() throws Exception {
        if (!colaVacia()) {
            return listaCola[frente];
        } else {
            throw new Exception("Underflow: La cola está vacía");
        }
    }

    // Verifica si la cola está vacía
    public boolean colaVacia() {
        return frente == siguiente(fin);
    }

    // Verifica si la cola está llena
    public boolean colaLlena() {
        return frente == siguiente(siguiente(fin));
    }

    // Método auxiliar para mostrar los elementos de la cola (para depuración)
    public void mostrarCola() {
        if (colaVacia()) {
            System.out.println("La cola está vacía");
        } else {
            System.out.print("Elementos en la cola: ");
            int i = frente;
            while (i != siguiente(fin)) {
                System.out.print(listaCola[i] + " ");
                i = siguiente(i);
            }
            System.out.println();
        }
    }

    // Método principal para pruebas
    public static void main(String[] args) {
        try {
            ColaCircular cola = new ColaCircular();
            cola.insertar("Elemento 1");
            cola.insertar("Elemento 2");
            cola.insertar("Elemento 3");

            cola.mostrarCola();

            System.out.println("Frente de la cola: " + cola.frenteCola());

            cola.quitar(); // Quita el 1
            cola.mostrarCola(); // Debería mostrar 2, 3

            cola.insertar(4);
            cola.mostrarCola(); // Debería mostrar 2, 3, 4

            cola.borrarCola(); // Reinicia la cola
            cola.mostrarCola(); // Debería indicar que está vacía

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
