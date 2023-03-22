package es.coloma.restaurante.clasesMenu;

import es.coloma.pedidos.ColaPedidosPendientes;
import es.coloma.restaurante.Restaurant;

public class OpcionPrepararPedido extends Opcion{

    private Restaurant restaurant;

    public OpcionPrepararPedido(Restaurant restaurant) {
        super("Preparar pedido");
        this.restaurant = restaurant;
    }

    @Override
    public void ejecutar() {
        restaurant.prepararPedido();
    }
}
