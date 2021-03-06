//RICARDO CARRASCO S.
// repositorio https://github.com/ricardoCs7/diccionario.git 
package diccionario;

// tree.java
// demonstrates binary tree
// to run this program: C>java TreeApp
import java.io.*;
import java.util.*;               // for Stack class
////////////////////////////////////////////////////////////////

class Node {

    public String pal; //palabra              // data item (key)
    public String sign; //significado
    public String clas; // clasificacion
    public Node leftChild;         // this node's left child
    public Node rightChild;        // this node's right child

    public void displayNode() // display ourself
    {
        System.out.print('{');
        System.out.print(pal);
        System.out.print(": ");
        System.out.print(clas);
        System.out.print(", ");
        System.out.print(sign);
        System.out.print("} ");
    }
}  // end class Node
////////////////////////////////////////////////////////////////

class Tree {

    private Node root;             // first node of tree

// -------------------------------------------------------------
    public Tree() // constructor
    {
        root = null;
    }            // no nodes in tree yet
// -------------------------------------------------------------

    //// REVISAR SI ESTA BIEN
    public Node find(String key) // find node with given key
    {                           // (assumes non-empty tree)
        Node current = root;               // start at root

        try {
            while (current.pal.compareToIgnoreCase(key) != 0) // while no match,   
            {
                if (key.compareToIgnoreCase(current.pal) < 0) { // go left?    

                    current = current.leftChild;
                }
                if (key.compareToIgnoreCase(current.pal) > 0) {
                    current = current.rightChild;
                }
            }
            System.out.println("");
            System.out.println("------------------------------------------------------------------------");
            if (key.compareToIgnoreCase(current.pal) == 0) {  //SI LA PALABRA BUSCADA COINCIDE Y EXISTE EN EL DICCIONARIO, MOSTRAR?? POR CONSOLA LO SGTE: 
                System.out.println("PALABRA: " + current.pal);
                System.out.println("SIGNIFICADO: " + current.sign);
                System.out.println("CLASIFICACON: " + current.clas);
                System.out.println("------------------------------------------------------------------------");
            }
            if (current == null) {
                System.out.println("");
                System.out.println("------------------------------------------------------------------------");
                System.out.println(" no hay coincidencias");// if no child,
                System.out.println("------------------------------------------------------------------------");
                return null;             // didn't find it
            }
        } catch (NullPointerException e) { //EN CASO DE QUE NO EXISTA LA PALABRA BUSCADA, SE ENCAPSULA EL ERROR, Y VUELVE AL CICLO DEL DO-WHY
            System.out.println("");
            System.out.println("------------------------------------------------------------------------");
            System.out.println("ERROR EN LA BUSQUEDA: '" + key + "' " + "no se encuentra en el diccionario");
            System.out.println("------------------------------------------------------------------------");
        }

        return current;                    // found it
    }  // end find()
// -------------------------------------------------------------

    public void insert(String pal, String clas, String sign) {
        Node newNode = new Node();    // make new node
        newNode.pal = pal;           // insert data
        newNode.clas = clas;
        newNode.sign = sign;

        if (root == null) // no node in root
        {
            root = newNode;
        } else // root occupied
        {
            Node current = root;       // start at root
            Node parent;
            while (true) // (exits internally)
            {
                parent = current;
                if (pal.equalsIgnoreCase(parent.pal)) { //SI LA PALABRA YA EXISTE EN EL DICCIONARIO, NO SE GUARDAR??.
                    System.out.println("");
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println("ERROR AL INGREAR: '" + pal + "' " + "ya existe, imposible guardar");
                    System.out.println("------------------------------------------------------------------------");
                    return;
                }
                if (pal.compareToIgnoreCase(current.pal) < 0) // go left? SI LA PALABRA INGRESADA ES "MENOR" ALFABETICAMENTE, VA COMO HIJO IZQUIERDO
                {                                               //LA COMPARACION IGNORA MAYUSCULAS
                    current = current.leftChild;
                    if (current == null) // if end of the line,
                    {                 // insert on left
                        parent.leftChild = newNode;
                        return;
                    }
                } // end if go left
                else // or go right?
                {
                    if (pal.compareToIgnoreCase(current.pal) > 0) {  //SI LA PALABRA INGRESADA ES "MAYOR" ALFABETICAMENTE, VA COMO HIJO DERECHO
                        current = current.rightChild;
                    }

                    if (current == null) // if end of the line
                    {                 // insert on right
                        parent.rightChild = newNode;
                        return;
                    }
                }

                // end else go right
            }  // end while
        }  // end else not root
        System.out.println("");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Se ha ingresado '" + pal + "' exitosamente en el diccionario");
        System.out.println("------------------------------------------------------------------------");
    }  // end insert()
// -------------------------------------------------------------

    public boolean delete(String key) // delete node with given key
    {                           // (assumes non-empty list)
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        try {

            while (!current.pal.equalsIgnoreCase(key)) // search for node 
            {
                parent = current;
                if (key.compareToIgnoreCase(current.pal) < 0) // go left? ---- SE COMPARA LA PALABRA A ELIMINAR PARA VER SI VA COMO HIJO IZQUIERDO
                {                                                               //SI LA PALABRA INGRESADA ES MENOR ALFABETICAMENTE A LA EXISTENTE
                    isLeftChild = true;
                    current = current.leftChild;
                }
                if (key.compareToIgnoreCase(current.pal) > 0) { // or go right? --- SE COMPARA LA PALABRA A ELIMINAR PARA VER SI VA COMO HIJO IZQUIERDO
                    isLeftChild = false;                                            //SI LA PALABRA INGRESADA ES MENOR ALFABETICAMENTE A LA EXISTENTE
                    current = current.rightChild;

                }
                if (current == null) // end of the line,
                {
                    System.out.println("");
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println("ERROR AL ELIMINAR: No existe la palabra '" + key + "' en el diccionario");
                    System.out.println("------------------------------------------------------------------------");
                    return false;                // didn't find it
                }
            }  // end while
            // found node to delete

            // if no children, simply delete it
            if (current.leftChild == null
                    && current.rightChild == null) {
                if (current == root) // if root,
                {
                    root = null;                 // tree is empty
                } else if (isLeftChild) {
                    parent.leftChild = null;     // disconnect
                } else // from parent
                {
                    parent.rightChild = null;
                }
            } // if no right child, replace with left subtree
            else if (current.rightChild == null) {
                if (current == root) {
                    root = current.leftChild;
                } else if (isLeftChild) {
                    parent.leftChild = current.leftChild;
                } else {
                    parent.rightChild = current.leftChild;
                }
            } // if no left child, replace with right subtree
            else if (current.leftChild == null) {
                if (current == root) {
                    root = current.rightChild;
                } else if (isLeftChild) {
                    parent.leftChild = current.rightChild;
                } else {
                    parent.rightChild = current.rightChild;
                }
            } else // two children, so replace with inorder successor
            {
                // get successor of node to delete (current)
                Node successor = getSuccessor(current);

                // connect parent of current to successor instead
                if (current == root) {
                    root = successor;
                } else if (isLeftChild) {
                    parent.leftChild = successor;
                } else {
                    parent.rightChild = successor;
                }

                // connect successor to current's left child
                successor.leftChild = current.leftChild;
            }  // end else two children
            // (successor cannot have a left child)
            System.out.println("");
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Se ha eliminado la palabra '" + key + "' exitosamente");
            System.out.println("------------------------------------------------------------------------");
        } catch (java.lang.NullPointerException e) {  //ENCAPSULA EL ERRO EN CASO DE QUE NO EXISTA LA PALABRA A ELIMINAR
            System.out.println("");
            System.out.println("------------------------------------------------------------------------");
            System.out.println("ERROR AL ELIMINAR: No existe la palabra '" + key + "' en el diccionario");
            System.out.println("------------------------------------------------------------------------");

        }

        // success
        return true;
    }  // end delete()

    // end delete()
    // returns node with next-highest value after delNode
    // goes to right child, then right child's left descendents
    ////-------------------------------------------------------------------------   
    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;   // go to right child
        while (current != null) // until no more
        {                                 // left children,
            successorParent = successor;
            successor = current;
            current = current.leftChild;      // go to left child
        }
        // if successor not
        if (successor != delNode.rightChild) // right child,
        {                                 // make connections
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }
// -------------------------------------------------------------

    public void Ordenar() {

        if (root == null) {
            System.out.println("");
            System.out.println("------------------------------------------");
            System.out.println("No hay palabras en el diccionario");            //SI SE DESESA ORDENAR EL DICCIONARIO, SIN HABER PALABRAS, MUESTRA ESTE MENSAJE
            System.out.println("------------------------------------------");
        } else {
            System.out.println("");
            System.out.println("");
            System.out.println("======   DICCIONARIO   =====");

            inOrder(root); //SI HAY PALABRAS INGRESADAS, SE MOSTRAR??N IN ORDER, ORDENADAS ALFABETICAMENTE DE A-Z 
        }
    }
// -------------------------------------------------------------

    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.pal + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }
// -------------------------------------------------------------

    private void inOrder(Node localRoot) {
        if (localRoot != null) {

            inOrder(localRoot.leftChild);
            System.out.println(localRoot.pal + " ");
            System.out.println("-------------------------");
            inOrder(localRoot.rightChild);

        }

    }
// -------------------------------------------------------------

    private void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.pal + " ");

        }
    }
// -------------------------------------------------------------

    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println(
                "......................................................");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < nBlanks; j++) {
                System.out.print(' ');
            }

            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    temp.displayNode();                     ////// FUE MODIFICADO, PARA QUE AL MOSTRAR EL ARBOL, MUESTRE EN FORMATO {PALABRA, SIGNIFICADO, CLASIFICACION}
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if (temp.leftChild != null
                            || temp.rightChild != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(' ');
                }
            }  // end while globalStack not empty
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false) {
                globalStack.push(localStack.pop());
            }
        }  // end while isRowEmpty is false
        System.out.println(
                "......................................................");
    }  // end displayTree()
// -------------------------------------------------------------
}  // end class Tree
////////////////////////////////////////////////////////////////
