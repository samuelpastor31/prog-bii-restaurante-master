package es.coloma.restaurante;

import es.coloma.pedidos.ColaPedidosPendientes;
import es.coloma.restaurante.clasesMenu.*;
import es.coloma.utils.AnsiColor;
import es.coloma.utils.GestorIO;

public class MenuApp {

    private final int OPTION_CREATE_ORDER = 1;
    private final int OPTION_LIST = 2;
    private final int OPTION_VIEW_ORDER = 3;
    private final int OPTION_SERVE_ORDER = 4;
    private final int OPTION_EXIT = 5;

    private Restaurant restaurant;
    private ColaPedidosPendientes colaPedidosPendientes;

    public MenuApp(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void show() {
        Menu menu = new Menu( "==============================================\n"+AnsiColor.BLUE+"" +
                "=== Bienvenido al bar de los 20 Montaditos ==="+AnsiColor.ANSI_RESET+"\n==============================================");
        menu.anyadir(new OpcionCrearPedido(restaurant));
        menu.anyadir(new OpcionVisualizarOrden(restaurant));
        menu.anyadir(new OpcionListarPedidos(restaurant));
        menu.anyadir(new OpcionListarServidos(restaurant));
        menu.anyadir(new OpcionPrepararPedido(restaurant));
        menu.anyadir(new OpcionSalir());
        menu.ejecutar();
        /*int option;
        do {
            showWelcomeBanner();
            option = this.getUserOption();
            handleOption(option);
        } while (option != OPTION_EXIT);*/
    }

   /* private void handleOption(int option){
        if (option == this.OPTION_CREATE_ORDER) {
            restaurant.attendClient();
        } else if (option == this.OPTION_LIST) {
            restaurant.listAllOrders();
        }else if (option == this.OPTION_SERVE_ORDER) {
            restaurant.serveOrder();
        }else if (option == this.OPTION_VIEW_ORDER) {
            restaurant.viewOrder();
        } else if (option == this.OPTION_EXIT) {
            showGoodbyeBanner();
        }else {
            AnsiColor.errorOutput("Opción no válida");
        }
    }*/

    private int getUserOption() {
        System.out.println(OPTION_CREATE_ORDER + ". Crear nuevo pedido");
        System.out.println(OPTION_LIST + ". Listar todos los pedidos");
        System.out.println(OPTION_VIEW_ORDER + ". Visualizar orden");
        System.out.println(OPTION_SERVE_ORDER + ". Servir pedido");
        System.out.println(OPTION_EXIT + ". Salir");
        return GestorIO.obtenerEntero("Selecciona una opción: ");
    }

    private void showWelcomeBanner(){
        System.out.println("==============================================");
        AnsiColor.colorizeOutput(AnsiColor.BLUE, "=== Bienvenido al bar de los 20 Montaditos ===");
        System.out.println("==============================================");
    }

    private void showGoodbyeBanner(){
        System.out.println("==============================================");
        AnsiColor.colorizeOutput(AnsiColor.BLUE, "=========== Esperamos verte pronto ===========");
        System.out.println("==============================================");
    }
}
