public class Node {
    int valor;
    int altura;
    Node izquierda, derecha;

    public Node(int valor) {
        this.valor = valor;
        this.altura = 1; // Al crear un nodo hoja, altura = 1
        izquierda = derecha = null;
    }
}
