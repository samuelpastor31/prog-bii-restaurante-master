package es.coloma.restaurante.clasesMenu;

import es.coloma.restaurante.Restaurant;

public class OpcionListarPedidos extends Opcion{

    private Restaurant restaurant;

    public OpcionListarPedidos(Restaurant restaurant) {
        super("Listar pedidos pendientes");
        this.restaurant = restaurant;
    }

    @Override
    public void ejecutar() {
        restaurant.listAllOrders();
    }
}
