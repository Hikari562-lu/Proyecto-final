public class AVLTree {
    Node raiz;

    public void insertar(int valor) {
        raiz = insertar(raiz, valor);
    }

    private Node insertar(Node nodo, int valor) {
        if (nodo == null) return new Node(valor);

        if (valor < nodo.valor)
            nodo.izquierda = insertar(nodo.izquierda, valor);
        else if (valor > nodo.valor)
            nodo.derecha = insertar(nodo.derecha, valor);
        else
            return nodo; // No se permiten duplicados

        // Actualizar altura
        nodo.altura = 1 + Math.max(getAltura(nodo.izquierda), getAltura(nodo.derecha));

        // Calcular factor de balance
        int balance = getFactorBalance(nodo);

        // Rotaciones AVL
        // Caso Izquierda-Izquierda
        if (balance > 1 && valor < nodo.izquierda.valor)
            return rotarDerecha(nodo);

        // Caso Derecha-Derecha
        if (balance < -1 && valor > nodo.derecha.valor)
            return rotarIzquierda(nodo);

        // Caso Izquierda-Derecha
        if (balance > 1 && valor > nodo.izquierda.valor) {
            nodo.izquierda = rotarIzquierda(nodo.izquierda);
            return rotarDerecha(nodo);
        }

        // Caso Derecha-Izquierda
        if (balance < -1 && valor < nodo.derecha.valor) {
            nodo.derecha = rotarDerecha(nodo.derecha);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    public int getAltura(Node nodo) {
        if (nodo == null) return 0;
        return nodo.altura;
    }

    public int getFactorBalance(Node nodo) {
        if (nodo == null) return 0;
        return getAltura(nodo.izquierda) - getAltura(nodo.derecha);
    }

    public Node rotarDerecha(Node y) {
        Node x = y.izquierda;
        Node T2 = x.derecha;

        // Rotación
        x.derecha = y;
        y.izquierda = T2;

        // Actualizar alturas
        y.altura = 1 + Math.max(getAltura(y.izquierda), getAltura(y.derecha));
        x.altura = 1 + Math.max(getAltura(x.izquierda), getAltura(x.derecha));

        return x;
    }

    public Node rotarIzquierda(Node x) {
        Node y = x.derecha;
        Node T2 = y.izquierda;

        // Rotación
        y.izquierda = x;
        x.derecha = T2;

        // Actualizar alturas
        x.altura = 1 + Math.max(getAltura(x.izquierda), getAltura(x.derecha));
        y.altura = 1 + Math.max(getAltura(y.izquierda), getAltura(y.derecha));

        return y;
    }

    //  printTree(Node raiz) solicitado
    public void printTree(Node nodo) {
        printTreeRec(nodo, 0);
    }

    private void printTreeRec(Node nodo, int nivel) {
        if (nodo == null) return;

        printTreeRec(nodo.derecha, nivel + 1);

        for (int i = 0; i < nivel; i++)
            System.out.print("    "); // 4 espacios por nivel

        System.out.println(nodo.valor);

        printTreeRec(nodo.izquierda, nivel + 1);
    }
}
