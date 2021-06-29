/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diccionario;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Ricardo
 */
public class Diccionario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Tree t = new Tree();
        Scanner leer = new Scanner(System.in);

        int opcion;

        try {

            do {
                System.out.println("===============");
                System.out.println("   Menu");
                System.out.println("===============");
                System.out.println("1) Agregar palabra");
                System.out.println("2) Buscar palabra ");
                System.out.println("3) Mostrar Diccionario");
                System.out.println("4) Eliminar Palabra");
                System.out.println("5) Salir");
                opcion = leer.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese palabra: ");
                        String n = leer.next();

                        System.out.print("Ingrese Significado: ");
                        String s = leer.next();
                        System.out.print("Ingrese Clasificación: ");
                        String c = leer.next();

                        t.insert(n, c, s);
                        break;
                    case 2:
                        System.out.print("Ingrese búsqueda:");
                        String b = leer.next();
                        t.find(b);
                        break;
                        
                    case 3:
                        t.Ordenar();
                        break;
                    case 4:
                        System.out.print("Palabra a eliminar: ");
                        String e = leer.next();
//                    t.delete(e);
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Error, eliga un opción válida");
                        System.out.println("");
                        break;
                }
            } while (opcion != 5);

        } catch (InputMismatchException e) {
            System.out.println("Solo números");
             
        }

    }
}
