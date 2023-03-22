package es.coloma.products;

import es.coloma.products.type.*;
import es.coloma.views.MenuCardViewList;

import java.util.ArrayList;

public class Catalogue {

    private ArrayList<Product> productList;

    public Catalogue() {
        this.productList = new ArrayList<>();
        setDefaultSandwichList();
        setDefaultDrinkList();
        setDefaultStarterList();
        setDefaultDesertList();
    }

    public void add(Product product) {
        productList.add(product);
    }

    public void listAll(Class type) {
        ArrayList<Product> listado = new ArrayList<>();
        for (Product current: productList) {
            if (current.getClass() == type) {
                listado.add(current);
            }
        }
        MenuCardViewList menuCardView = new MenuCardViewList(listado);
        System.out.println(menuCardView);
    }

    public Product find(String cod) {
        Product productSearched = getProductFromCode(cod);
        if (productList.contains(productSearched)){
            return productList.get(productList.indexOf(productSearched));
        }
        return null;
    }

    public boolean remove(String cod) {
        Product productToRemove = find(cod);
        if (productToRemove != null) {
            productList.remove(productToRemove);
            return true;
        }
        return false;
    }

    private void setDefaultSandwichList() {
        final String productCodePrefix = Catalogue.getCodePrefix(Sandwich.class);
        productList.add(new Sandwich(productCodePrefix + 1, "lechuga, tomate y mayonesa"));
        productList.add(new Sandwich(productCodePrefix + 2, "HUEVO DURO lechuga, tomate y mayonesa"));
        productList.add(new Sandwich(productCodePrefix + 3, "VEGETAL CON QUESO lechuga, tomate y queso"));
        productList.add(new Sandwich(productCodePrefix + 4, "Burger, bacon ahumado, cebolla crujiente y alioli"));
        productList.add(new Sandwich(productCodePrefix + 5, "Pollo, bacon ahumado y salsa brava"));
        productList.add(new Sandwich(productCodePrefix + 6, "Pollo kebab, cebolla, pimiento verde y mayonesa"));
        productList.add(new Sandwich(productCodePrefix + 7, "CUATRO QUESOS: Queso ibérico, queso brie, queso de cabra y crema de queso"));
        productList.add(new Sandwich(productCodePrefix + 8, "CAPRESE: Jamón gran reserva, queso mozzarella, tomate y pesto"));
        productList.add(new Sandwich(productCodePrefix + 9, "Pulled pork y guacamole"));
        productList.add(new Sandwich(productCodePrefix + 10, "PULLED PORK y queso brie"));
        productList.add(new Sandwich(productCodePrefix + 11, "FILETE RUSO, cebolla caramelizada y salsa de queso cheddar"));
        productList.add(new Sandwich(productCodePrefix + 12, "SALMÓN AHUMADO y crema de queso"));
        productList.add(new Sandwich(productCodePrefix + 13, "CARNE MECHADA DESHILACHADA y cebolla crujiente"));
        productList.add(new Sandwich(productCodePrefix + 14, "JAMÓN GRAN RESERVA, tomate y aceite de oliva virgen extra"));
        productList.add(new Sandwich(productCodePrefix + 15, "CARRILLERA AL VINO TINTO y queso ibérico"));
        productList.add(new Sandwich(productCodePrefix + 16, "QUESO IBÉRICO, tortilla de patatas y mayonesa"));
        productList.add(new Sandwich(productCodePrefix + 17, "ALBÓNDIGAS y salsa BBQ"));
        productList.add(new Sandwich(productCodePrefix + 18, "Pollo, cebolla caramelizada y mayonesa trufada"));
        Product product = new Sandwich(productCodePrefix + 19, "CHISTORRA, bacon ahumado y salsa brava");
        product.setDiscount(0.2f);
        productList.add(product);
        productList.add(new Sandwich(productCodePrefix + 20, "Tortilla de patatas"));
    }

    private void setDefaultDrinkList() {
        final String productCodePrefix = Catalogue.getCodePrefix(Drink.class);
        productList.add(new Drink(productCodePrefix + 21, "Coca-Cola"));
        productList.add(new Drink(productCodePrefix + 22, "Agua"));
        productList.add(new Drink(productCodePrefix + 23, "Fanta Limón"));
        productList.add(new Drink(productCodePrefix + 24, "Fanta Naranja"));
        productList.add(new Drink(productCodePrefix + 25, "Cerveza bote 33cl"));
        productList.add(new Drink(productCodePrefix + 26, "Caña Cerveza"));
        productList.add(new Drink(productCodePrefix + 27, "Jarra Cerveza"));
    }

    private void setDefaultDesertList() {
        final String productCodePrefix = Catalogue.getCodePrefix(Desert.class);
        productList.add(new Desert(productCodePrefix + 28, "Pastel de Queso",0,
                Desert.Characteristic.CELIAC_SUITABLE));
        productList.add(new Desert(productCodePrefix + 29, "Pastel Chocolate",0));
        productList.add(new Desert(productCodePrefix + 30, "Helado Chocolate",0,
                Desert.Characteristic.DIABETIC_SUITABLE));
        productList.add(new Desert(productCodePrefix + 31, "Helado Vainilla",0,
                Desert.Characteristic.CELIAC_SUITABLE));
        productList.add(new Desert(productCodePrefix + 32, "Helado Limón",0,
                Desert.Characteristic.CELIAC_SUITABLE, Desert.Characteristic.DIABETIC_SUITABLE));
        productList.add(new Desert(productCodePrefix + 33, "Helado Fresa",0,
                Desert.Characteristic.CELIAC_SUITABLE, Desert.Characteristic.DIABETIC_SUITABLE));
    }

    private void setDefaultStarterList() {
        final String productCodePrefix = Catalogue.getCodePrefix(Starter.class);
        productList.add(new Starter(productCodePrefix + 34, "Patatas 4 Quesos"));
        productList.add(new Starter(productCodePrefix + 35, "Bolas de pollo"));
        productList.add(new Starter(productCodePrefix + 36, "Aceitunas"));
        productList.add(new Starter(productCodePrefix + 37, "Nachos"));
        productList.add(new Starter(productCodePrefix + 38, "Ensalada de la casa"));
        productList.add(new Starter(productCodePrefix + 39, "Bolas de queso"));
        productList.add(new Starter(productCodePrefix + 40, "Alitas de pollo"));
        productList.add(new Starter(productCodePrefix + 41, "Patatas fritas"));
        productList.add(new Starter(productCodePrefix + 42, "Ensalada cesar"));
    }

    public String getNextProductCode(Class classType) {
        return getCodePrefix(classType) + productList.size();
    }

    public static String getCodePrefix(Class classType) {
        if (classType == Desert.class) {
            return "p";
        } else if (classType == Drink.class) {
            return "b";
        } else if (classType == Sandwich.class) {
            return "m";
        } else if (classType == Starter.class) {
            return "e";
        } else {
            assert false;
        }
        return null;
    }

    public static Product getProductFromCode(String cod) {
        if (cod.charAt(0) == 'p') {
            return new Desert(cod);
        } else if (cod.charAt(0) == 'b') {
            return new Drink(cod);
        } else if (cod.charAt(0) == 'm') {
            return new Sandwich(cod);
        } else if (cod.charAt(0) == 'e') {
            return new Starter(cod);
        } else {
            assert false;
        }
        return null;
    }

}
