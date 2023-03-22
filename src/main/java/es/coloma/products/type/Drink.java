package es.coloma.products.type;

public class Drink extends Product {

    public enum Size {BIG, NORMAL, SMALL}

    private boolean refillable;

    private Size size;

    public Drink(String cod, String name, float prize, float disccount, float vat) {
        super(cod, name, prize, disccount, vat);
        this.refillable = false;
        this.size = Size.NORMAL;
    }

    public Drink(String cod, String name) {
        super(cod, name, 1.0f, 0f, 0.1f);
        this.refillable = false;
        this.size = Size.NORMAL;
    }

    public Drink(String cod) {
        super(cod);
    }

    public boolean isRefillable() {
        return refillable;
    }

    public Size getSize() {
        return size;
    }
}
