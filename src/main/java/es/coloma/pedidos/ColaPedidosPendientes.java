package es.coloma.pedidos;

import es.coloma.excepciones.ColaLlenaException;
import es.coloma.excepciones.ColaVaciaException;
import es.coloma.restaurante.Order;
import es.coloma.restaurante.Restaurant;

import java.util.ArrayList;

public class ColaPedidosPendientes {

    private ArrayList<Order> orders;
    private int maximoOrders;

    public ColaPedidosPendientes() {
        this.orders = new ArrayList<>();
        this.maximoOrders = 100;
    }

    public void anyadir(Order order) {
        if (!estaLlena()) {
            orders.add(order);
        } else throw new ColaLlenaException();

    }

    public Order obtenerSiguiente() {
        if (existenPedidos()) {
            Order orderReturn = orders.get(0);
            orders.remove(0);
            return orderReturn;
        } else throw new ColaVaciaException();
    }

    public void retornar(Order order) {
        orders.add(0,order);
    }

    public boolean estaLlena(){
        if (orders.size()<maximoOrders){
            return false;
        }
        return true;
    }

    public boolean existenPedidos(){
        if (orders.size()>0){
            return true;
        }
        return false;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
}
