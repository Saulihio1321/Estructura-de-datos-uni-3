package colatareas;

import java.util.Scanner;

/**
 * 23550382
 * @author saul Bermudez Arzaga
 * Estructura de datos
 */
public class ColaTareas {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        ColaLineal cola = new ColaLineal();
        
        try {
            while (true) {
                System.out.println("Introduce una tarea para añadir a la cola (o 'salir' para finalizar): ");
                String tarea = input.nextLine();
                
                // Salir si el usuario introduce 'salir'
                if (tarea.equalsIgnoreCase("salir")) {
                    break;
                    
                }
                
                cola.insertar(tarea);
                System.out.println("Tarea \"" + tarea + "\" añadida a la cola.");
                
            }
            
            // Mostrar la primera tarea en la cola
            if (!cola.colaVacia()) {
                System.out.println("Primera tarea en la cola: " + cola.frenteCola());
                
            }
            
            // Quitar las tareas hasta que la cola esté vacía
            while (!cola.colaVacia()) {
                System.out.println("Tarea completada: " + cola.quitar());
                
            }
            
            System.out.println("Todas las tareas han sido completadas. Cola vacía.");
        } catch (Exception er) {
            System.err.println("Exception: " + er);
            
        }
    }
}
