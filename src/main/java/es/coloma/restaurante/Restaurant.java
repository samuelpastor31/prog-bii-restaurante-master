package es.coloma.restaurante;
import es.coloma.pedidos.ColaPedidosPendientes;
import es.coloma.pedidos.HistoricoPedidos;
import es.coloma.products.Catalogue;
import es.coloma.utils.AnsiColor;
import es.coloma.utils.GestorIO;
import es.coloma.views.OrderView;
import es.coloma.views.OrderViewList;

import java.util.*;

public class Restaurant {

    private ArrayList<Order> orderList;

    private ColaPedidosPendientes colaPedidosPendientes;

    private HistoricoPedidos historicoPedidos;

    private Waiter waiter;

    public Restaurant(Catalogue catalogue) {
        this.orderList = new ArrayList<>();
        this.waiter = new Waiter(catalogue);
        this.colaPedidosPendientes = new ColaPedidosPendientes();
        this.historicoPedidos = new HistoricoPedidos();
    }

    /**
     *  Registra un nuevo pedido en el restaurante
     */
    public void attendClient() {
        Order order =  waiter.attend(getNextOrderCode());
        orderList.add(order);
        colaPedidosPendientes.anyadir(order);
        System.out.println(AnsiColor.colorize(AnsiColor.GREEN, "Pedido registrado con éxito "));
        showOrder(order);
    }

    /**
     * Lista todas los pedidos
     */
    public void listAllOrders() {
        if (orderList.size() == 0) {
            System.out.println(AnsiColor.colorize(AnsiColor.RED, "No existen pedidos por servir en el restaurante"));
        } else {
            OrderViewList orderViewList = new OrderViewList(new ArrayList<>(orderList));
            System.out.println(orderViewList);
        }
    }

    public void listAllOrdersServed() {
        if (historicoPedidos.getOrders().size() == 0) {
            System.out.println(AnsiColor.colorize(AnsiColor.RED, "No existen pedidos ya servidos en el restaurante"));
        } else {
            OrderViewList orderViewList = new OrderViewList(new ArrayList<>(historicoPedidos.getOrders()));
            System.out.println(orderViewList);
        }
    }


    /**
     * Permite acceder a la información de un pedido
     */
    public void viewOrder() {
        listAllOrders();
        String pregunta = AnsiColor.colorize(AnsiColor.HIGH_INTENSITY, "Introduzca el código de la orden que deseas Visualizar");
        String orderCode = GestorIO.obtenerCadena(pregunta);
        Order orderBuscada = new Order(orderCode);
        if (!orderList.contains(orderBuscada)) {
            System.out.println(AnsiColor.colorize(AnsiColor.RED, "El pedido introducido no existe"));
        } else {
            showOrder(orderList.get(orderList.indexOf(orderBuscada)));
        }
    }

    public void viewOrderServidos() {
        if (historicoPedidos.getOrders().size()>0) {
            listAllOrdersServed();
            String pregunta = AnsiColor.colorize(AnsiColor.HIGH_INTENSITY, "Introduzca el código de la orden que deseas Visualizar");
            String orderCode = GestorIO.obtenerCadena(pregunta);
            Order orderBuscada = new Order(orderCode);
            if (!historicoPedidos.getOrders().contains(orderBuscada)) {
                System.out.println(AnsiColor.colorize(AnsiColor.RED, "El pedido introducido no existe"));
            } else {
                showOrder(historicoPedidos.getOrders().get(historicoPedidos.getOrders().indexOf(orderBuscada)));
            }
        }else{
            System.out.println("Crea y sirve algún pedido");
        }
    }

    /**
     *  Permite marcar una orden como servida
     */
    public void serveOrder() {
        if(!showPendingOrderList()){
            return;
        }
        String pregunta = AnsiColor.colorize(AnsiColor.HIGH_INTENSITY, "Introduzca el código de la orden que desea servir");
        String orderCode = GestorIO.obtenerCadena(pregunta);
        Order orderBuscada = new Order(orderCode);
        if (!orderList.contains(orderBuscada)) {
            System.out.println(AnsiColor.colorize(AnsiColor.RED, "El pedido introducido no existe"));
        } else {
            orderList.get(orderList.indexOf(orderBuscada)).setServed();
            System.out.println(AnsiColor.colorize(AnsiColor.GREEN, "El pedido ha sido marcado como servido"));
        }

    }

    /**
     * muestra la lista de ordenes pendientes de servir
     */
    private boolean showPendingOrderList() {
        ArrayList<Order> pendingServedOrderList = new ArrayList<>();
        for (Order orderEntry: orderList) {
            if (!orderEntry.isServed()) {
                pendingServedOrderList.add(orderEntry);
            }
        }
        if (pendingServedOrderList.size() == 0) {
            System.out.println(AnsiColor.colorize(AnsiColor.RED, "No existen pedidos pendientes de servir"));
        } else {
            OrderViewList orderViewList = new OrderViewList(pendingServedOrderList);
            System.out.println(orderViewList);
        }
        return pendingServedOrderList.size() > 0 ;
    }

    private String getNextOrderCode(){
        return "o" + (orderList.size() + 1);
    }

    /**
     * Visualizar una orden en formato tabla
     */
    private void showOrder(Order order) {
        OrderView orderView = new OrderView(order);
        System.out.println(orderView);
    }



    public void prepararPedido() {
        if (colaPedidosPendientes.existenPedidos()) {

            Order siguientePedido = colaPedidosPendientes.obtenerSiguiente();
            showOrder(siguientePedido);
            String mensaje ="¿Quieres marcar este pedido como servido?";
            if (GestorIO.confirmar(mensaje)){
                orderList.get(orderList.size()-1).setServed();
                System.out.println(AnsiColor.colorize(AnsiColor.GREEN, "El pedido ha sido marcado como servido"));
                historicoPedidos.anyadir(orderList.get(orderList.size()-1));
                orderList.remove(orderList.get(orderList.size()-1));
            }else{
                devolverPedidoPreparado();
            }
            // mostrar siguientePedido
            // preguntar al usuario si lo quiere servir o no
            // sí --> lo añades a historico
            // no --> lo retornas a colaPedidosPendientes
        }



    }

    public void devolverPedidoPreparado(){
        colaPedidosPendientes.retornar(orderList.get(orderList.size()-1));
    }
}
