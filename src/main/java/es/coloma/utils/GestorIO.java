package es.coloma.utils;

import java.util.Scanner;

public class GestorIO {

    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static int obtenerEntero(String mensaje) {
        do {
            System.out.print(mensaje);
            if (!scanner.hasNextInt()) {
                AnsiColor.errorOutput("Error! Debe introducir un entero");
                scanner.nextLine();
            } else {
                int number = scanner.nextInt();
                scanner.nextLine();
                return number;
            }
        } while (true);
    }

    public static String obtenerCadena(String mensaje) {
        System.out.print(mensaje);
        return scanner.next().trim();
    }

    public static boolean confirmar(String mensaje) {
        System.out.println(mensaje + " [S/N]");
        return scanner.next().toUpperCase().charAt(0) == 'S';
    }
}