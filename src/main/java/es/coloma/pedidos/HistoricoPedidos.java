package es.coloma.pedidos;

import es.coloma.restaurante.Order;

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
}
