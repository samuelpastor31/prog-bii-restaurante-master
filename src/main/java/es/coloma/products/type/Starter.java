package es.coloma.products.type;

public class Starter extends Product {

    private int ration;

    private final static int PRIZE_PER_RATION = 1;

    public Starter(String cod, String name, float prize, float disccount, float vat) {
        super(cod, name, prize, disccount, vat);
    }

    public Starter(String cod, String name) {
        super(cod, name);
    }

    public Starter(String cod) {
        super(cod);
    }

    public int getRation() {
        return ration;
    }

    @Override
    public float getPrize() {
        return super.getPrize() + ration * PRIZE_PER_RATION;
    }
}
