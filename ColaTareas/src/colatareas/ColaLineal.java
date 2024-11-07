package colatareas;

/**
23550382
 * @author saul Bermudez Arzaga
 * Estructura de datos
 */
public class ColaLineal {

    private static final int MAXTAMQ = 39;
    protected int frente;
    protected int fin;
    protected String[] listaCola;

    public ColaLineal() {
        frente = 0;
        fin = -1;
        listaCola = new String[MAXTAMQ];
        
    }
    
    // Operaciones de modificación de la cola
    public void insertar(String tarea) throws Exception {
        if (!colaLlena()) {
            listaCola[++fin] = tarea;
        } else {
            throw new Exception("Overflow en la cola - no se pueden añadir más tareas.");
            
        }
    }

    public String quitar() throws Exception {
        if (!colaVacia()) {
            return listaCola[frente++];
        } else {
            throw new Exception("Cola vacía - no hay tareas para completar.");
            
        }
    }
    
    // Vacía la cola
    public void borrarCola() {
        frente = 0;
        fin = -1;
        
    }
    
    // Acceso a la cola
    public String frenteCola() throws Exception {
        if (!colaVacia()) {
            return listaCola[frente];
        } else {
            throw new Exception("Cola vacía - no hay tareas en la cola.");
            
        }
    }
    
    // Métodos de verificación del estado de la cola
    public boolean colaVacia() {
        return frente > fin;
        
    }

    public boolean colaLlena() {
        return fin == MAXTAMQ - 1;
        
    }
}
