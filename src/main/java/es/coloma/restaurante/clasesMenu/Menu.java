package es.coloma.restaurante.clasesMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private ArrayList<Opcion> opciones;

    private String tituloMenu;

    public Menu(String tituloMenu) {
        this.tituloMenu = tituloMenu;
        this.opciones = new ArrayList<>();
    }

    public void ejecutar(){
        Opcion opcion;
        do {
            mostrar();
            opcion = getOpcion();
            opcion.ejecutar();
        } while (!opcion.finalizar());
    }

    public void anyadir(Opcion opcion) {
        this.opciones.add(opcion);
    }

    private void mostrar() {
        System.out.print("\n" + tituloMenu + "\n===================");
        for (int i = 0; i < opciones.size() ; i++) {
            opciones.get(i).mostrar(i + 1);
        }
    }

    private Opcion getOpcion() {
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("\nSeleccione una opcion [1-" + opciones.size()+ "]");
            if (teclado.hasNextInt()) {
                int opcion = teclado.nextInt();
                if (opcion >= 1 && opcion <= opciones.size()) {
                    return this.opciones.get(opcion - 1);
                }
            }
            System.out.println("Error! La opcion seleccionada no existe");
            teclado.nextLine();
        } while (true);
    }
}

