package es.coloma.restaurante.clasesMenu;

import es.coloma.restaurante.Order;
import es.coloma.restaurante.Restaurant;
import es.coloma.utils.AnsiColor;

public class OpcionCrearPedido extends Opcion{

    private Restaurant restaurant;

    public OpcionCrearPedido(Restaurant restaurant) {
        super("Crear nuevo pedido");
        this.restaurant = restaurant;
    }

    @Override
    public void ejecutar() {
       restaurant.attendClient();
    }
}
