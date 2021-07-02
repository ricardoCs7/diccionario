//RICARDO CARRASCO S.
// repositorio https://github.com/ricardoCs7/diccionario.git 

package diccionario;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Ricardo
 */
public class Diccionario {

    public static void main(String[] args) {

        Tree t = new Tree();
        Scanner leer = new Scanner(System.in); //SCANNER PARA LA OPCION MENU
        int opcion = 0; //SE INICIALIZA EL SCANNER

        Scanner sub = new Scanner(System.in); /// SCANNER SUB YA QUE CON UN SCANNER PARA TODO EL MENU, HACIA CONFLICTO [EL NEXTLINE() NO TOMABA NINGUNA PALABRA]
                                              ///FUE NECESARIO EN ESTE CASO CREAR DOS SCANNERS.
                                    
        do {  //CICLO PARA QUE AL ENCAPSULAR EL ERROR DEL TRY, VUEVLA A EJECTUAR EL MENU

            try { //ENCAPSULA EL ERROR DE INGRESAR UNA OPCION INCORRECTA, ES DECIR, LETRAS EN VEZ DE UN NUMERO DE 1-6

                System.out.println("=========  MENU  ========= ");
                System.out.println("1) Agregar palabra");
                System.out.println("2) Buscar palabra ");
                System.out.println("3) Mostrar Diccionario");
                System.out.println("4) Eliminar Palabra");
                System.out.println("5) Salir");
                System.out.println("6) Mostrar Árbol");
                opcion = leer.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("");
                        System.out.print("Ingrese palabra: ");
                        String n = sub.nextLine(); //NEXTLINE() PARA PODER INGRESAR MAS DE UNA PALABRA EN UNA LINEA 

                        System.out.print("Ingrese Significado: ");
                        String s = sub.nextLine();

                        System.out.print("Ingrese Clasificación (verbo, sustantivo, etc): ");
                        String c = sub.nextLine();

                        t.insert(n, c, s);   /// GUARDA EL NODO "PALABRA" CON SU NOMBRE-CLASIFICACION-SIGNFICADO
                        System.out.println("");
                        break;
                    case 2:
                        System.out.print("Ingrese búsqueda:");
                        String b = sub.nextLine();
                        t.find(b);  //BUSCA EL NODO, CON LA PALABRA INGRESADA POR TECLADO
                        System.out.println("");
                        break;

                    case 3:
                        t.Ordenar();
                        System.out.println("");
                        break;
                    case 4:
                        System.out.print("Palabra a eliminar: ");
                        String e = sub.nextLine();
                        t.delete(e); //SE ELIMINA EL NODO, CON LA PALABRA INGRESADA
                        System.out.println("");
                        break;
                    case 5:
                        System.out.println("");
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Error, eliga un opción entre 1-5");
                        System.out.println("");
                        break;
                    case 6:
                        System.out.println("   ARBOL:");
                        t.displayTree(); //MUESTRA EL ARBOL CON LOS NODOS E HIJOS INGRESADOS EN EL DICCIONARIO
                        System.out.println("");
                }

            } catch (InputMismatchException e) {
                System.out.println("Solo números, intentelo nuevamente"); //ERROR EN CASO DE QUE SE INGRESE UN DATO INCORRECTO EN EL MENU
                leer.next();
                System.out.println("");
            }
        } while (opcion != 5); 

    }
}
