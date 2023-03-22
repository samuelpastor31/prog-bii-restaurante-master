package es.coloma.products.type;

public class Sandwich extends Product {

    public Sandwich(String cod, String name, float prize, float disccount, float vat) {
        super(cod, name, prize, disccount, vat);
    }

    public Sandwich(String cod, String name) {
        super(cod, name);
    }

    public Sandwich(String cod) {
        super(cod);
    }

}
