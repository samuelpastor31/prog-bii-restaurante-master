package es.coloma.products.type;

import java.util.Objects;

public abstract class Product {

    private String cod;

    private String name;

    private float prize;

    private float discount;

    private float vat;

    public Product(String cod, String name, float prize, float discount, float vat) {
        this.cod = cod;
        this.name = name;
        this.prize = prize;
        this.discount = discount;
        this.vat = vat;
    }

    public Product(String cod, String name) {
        this.cod = cod;
        this.name = name;
        this.discount = 0f;
        this.prize = 1.25f;
        this.vat = 0.1f;
    }

    public Product(String cod) {
        this.cod = cod;
    }

    public String getCod() {
        return this.cod;
    }

    public float getPrize() {
        return prize * (1 + vat) - (prize * discount);
    }

    public float getPrizeWithoutDiscount() {
        return prize * (1 + vat);
    }


    public String getName() {
        return name;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getPercentageDiscount() {
        return discount * 100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return cod.equals(product.cod);
    }

}
