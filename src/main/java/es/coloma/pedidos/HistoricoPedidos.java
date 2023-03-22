package es.coloma.pedidos;

import es.coloma.restaurante.Order;

import java.time.LocalDate;
import java.util.ArrayList;

public class HistoricoPedidos {

    private ArrayList<Order> ordersServidos;

    public HistoricoPedidos() {
        this.ordersServidos = new ArrayList<>();
    }

    public void anyadir(Order order){
        ordersServidos.add(order);
    }

    public ArrayList<Order> getOrders() {
        return ordersServidos;
    }

    public ArrayList<Order> filtrarPedidosFechas(String date){
        ArrayList<Order> pedidos = new ArrayList<>();

        for (int i = 0; i <ordersServidos.size() ; i++) {
            if (ordersServidos.get(i).getCreatedOn().equals(date)){
                pedidos.add(ordersServidos.get(i));
            }
        }
        return pedidos;
    }
}
