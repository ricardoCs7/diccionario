/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diccionario;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Ricardo
 */
public class Diccionario {

    public static void main(String[] args) {
        Diccionario d = new Diccionario();
        Tree t = new Tree();
        Scanner leer = new Scanner(System.in);
        int opcion = 0;

        Scanner sub = new Scanner(System.in);
        do {

            try {

                System.out.println("=========  MENU  ========= ");
                System.out.println("1) Agregar palabra");
                System.out.println("2) Buscar palabra ");
                System.out.println("3) Mostrar Diccionario");
                System.out.println("4) Eliminar Palabra");
                System.out.println("5) Salir");
                System.out.println("6) Mostrar Arbol");
                opcion = leer.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("");
                        System.out.print("Ingrese palabra: ");
                        String n = sub.nextLine();

                        System.out.print("Ingrese Significado: ");
                        String s = sub.nextLine();

                        System.out.print("Ingrese Clasificación (verbo, sustantivo, etc): ");
                        String c = sub.nextLine();

                        t.insert(n, c, s);
                        System.out.println("");
                        break;
                    case 2:
                        System.out.print("Ingrese búsqueda:");
                        String b = sub.nextLine();
                        t.find(b);
                        System.out.println("");
                        break;

                    case 3:
                        t.Ordenar();
                        System.out.println("");
                        break;
                    case 4:
                        System.out.print("Palabra a eliminar: ");
                        String e = sub.nextLine();
                        t.delete(e);
                        System.out.println("");
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Error, eliga un opción entre 1-5");
                        System.out.println("");
                        break;
                    case 6:
                        System.out.println("mostrar arbol");
                        t.displayTree();
                }

            } catch (InputMismatchException e) {
                System.out.println("Solo números, intentelo nuevamente");
                leer.next();
                System.out.println("");
            }
        } while (opcion != 5);

    }
}
