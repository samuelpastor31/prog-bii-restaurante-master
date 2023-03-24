package es.coloma.restaurante.clasesMenu;

import es.coloma.restaurante.Restaurant;

public class OpcionCancelarPedido extends Opcion{

    private Restaurant restaurant;

    public OpcionCancelarPedido(Restaurant restaurant) {
        super("Cancelar pedido");
        this.restaurant = restaurant;
    }

    @Override
    public void ejecutar() {
        restaurant.listAllOrdersServedToCancelIt();
    }
}
