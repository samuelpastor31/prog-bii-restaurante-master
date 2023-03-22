package es.coloma;

import es.coloma.products.Catalogue;
import es.coloma.restaurante.MenuApp;
import es.coloma.restaurante.Restaurant;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException {

        Catalogue catalogue = new Catalogue();

        //Creamos el restaurante con la carta
        Restaurant restaurant = new Restaurant(catalogue);

        //Creamos un menu para que gestiones nuestro restaurante
        MenuApp restaurantMenu = new MenuApp(restaurant);
        restaurantMenu.show();

    }

}
