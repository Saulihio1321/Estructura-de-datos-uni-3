
package pilaejemplo;

/**
 * 23550328
 * @author angel adrian orozco rodriguez 
 * estructura de datos
 */
public class PilaStack {

    public static void main(String[] args) {

        MiPila  miPila = new MiPila(3);
       System.out.println("¿Está mi pila vacía? " + miPila.isEmpty());

       miPila.push("Bola naranja");
       miPila.push("Bola Violeta");
       miPila.push("Bola Verde");

      miPila.printStack();

       System.out.println("¿Está mi pila vacía? " + miPila.isEmpty());
       while (!miPila.isEmpty()) {
           miPila.pop(miPila.readTop());
           System.out.println("¿Está mi pila vacía? " + miPila.isEmpty());
       }
   }

}

