package es.coloma.restaurante.clasesMenu;

import es.coloma.restaurante.Restaurant;

public class OpcionListarServidos extends Opcion{

    private Restaurant restaurant;

    public OpcionListarServidos(Restaurant restaurant) {
        super("Listar pedidos servidos");
        this.restaurant = restaurant;
    }

    @Override
    public void ejecutar() {
        restaurant.listAllOrdersServed();
    }
}
