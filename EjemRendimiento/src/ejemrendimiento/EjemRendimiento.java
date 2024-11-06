/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemrendimiento;

/**
* 23550382
 * @author saul Bermudez Arzaga
 * Estructura de datos
 */
public class EjemRendimiento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        long inicioCod = System.nanoTime();
        System.out.println();
        float[][] matriz = {
            {1.0f, 2.0f, 3.0f},
            {4.0f, 5.0f, 6.0f},
            {7.0f, 8.0f, 9.0f}
        };   
        
         // Imprimir la matriz original
        System.out.println("Matriz Original:");
        imprimirMatriz(matriz);

        // Calcular la transpuesta
        traspuesta(matriz, matriz.length);

        // Imprimir la matriz transpuesta
        System.out.println("Matriz Transpuesta:");
        imprimirMatriz(matriz);
}
        
    static void traspuesta(float[][] d, int n){
        int i, j;
            for (i = n - 2; i > 0; i--) {
                for (j = i + 1; j < n; j++) {
                    float t;
                    t = d[i][j];
                    d[i][j] = d[j][i];
                    d[j][i] = t;
                }
            }
        }
    
    static void imprimirMatriz(float[][] matriz) {
        for (float[] fila : matriz) {
            for (float elemento : fila) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    }
    
}
