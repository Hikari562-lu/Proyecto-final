import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AVLTree arbol = new AVLTree();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Ingrese un número (-1 para salir): ");
            String input = scanner.nextLine();

            if (input.equals("exit") || input.equals("-1")) {
                System.out.println("Saliendo...");
                break;
            }

            try {
                int numero = Integer.parseInt(input);
                arbol.insertar(numero);
                System.out.println("\nÁrbol actualizado:");
                arbol.printTree(arbol.raiz);
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número válido.");
            }
        }

        scanner.close();
    }
}
