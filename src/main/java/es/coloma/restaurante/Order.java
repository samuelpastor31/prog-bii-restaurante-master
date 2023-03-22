package es.coloma.restaurante;

import es.coloma.products.type.Product;

import java.util.ArrayList;
import java.util.Objects;

public class Order {

    private String code;

    private String clientName;

    private String createdOn;

    private boolean served;

    private ArrayList<Product> products;

    private String tiempo;

    public Order(String code) {
        this.code = code;
    }

    public Order(String code, String clientName, String createdOn, String tiempo) {
        this.clientName = clientName;
        this.createdOn = createdOn;
        this.tiempo = tiempo;
        this.code = code;
        served = false;
        this.products = new ArrayList<>();
    }

    public String getTiempo() {
        return tiempo;
    }

    public void addNewProduct(Product product) {
        products.add(product);
    }

    public String getClientName() {
        return clientName;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public boolean isServed() {
        return served;
    }

    public String getCode() {
        return code;
    }

    public void setServed() {
         served = true;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public boolean hasProducts() {
        return products.size() > 0;
    }

    public double getOrderPrize() {
        double totalPrize = 0;
        for (Product product : products) {
            totalPrize += product.getPrize();
        }
        return totalPrize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Order)) {
            return false;
        }
        Order order = (Order) o;
        return code.equals(order.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
