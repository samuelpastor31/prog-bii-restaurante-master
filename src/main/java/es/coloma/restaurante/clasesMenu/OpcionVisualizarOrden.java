package es.coloma.restaurante.clasesMenu;

import es.coloma.restaurante.Restaurant;

public class OpcionVisualizarOrden extends Opcion{

    private Restaurant restaurant;

    public OpcionVisualizarOrden(Restaurant restaurant) {
        super("Visualizar pedido");
        this.restaurant = restaurant;
    }


    @Override
    public void ejecutar() {
        restaurant.viewOrder();
    }
}
