package es.coloma.restaurante.clasesMenu;

import es.coloma.restaurante.Restaurant;

public class OpcionVisualizarServidos extends Opcion{

    private Restaurant restaurant;

    public OpcionVisualizarServidos(Restaurant restaurant) {
        super("Visualizar pedidos servidos");
        this.restaurant = restaurant;
    }


    @Override
    public void ejecutar() {
        restaurant.viewOrderServidos();
    }
}
