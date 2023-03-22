package es.coloma.products.type;

import es.coloma.excepciones.DescuentoNoAplicableException;

import java.util.HashSet;
import java.util.List;

public class Desert extends Product {

    public enum Characteristic {
        DIABETIC_SUITABLE, CELIAC_SUITABLE
    }

    private HashSet<Characteristic> characteristic;

    public Desert(String cod) {
        super(cod);
    }

    public Desert(String cod, String name ,float discount,Characteristic... characteristic) {
        super(cod, name);
        if (discount == 0) {
            this.characteristic = new HashSet<>(List.of(characteristic));
        } else throw new DescuentoNoAplicableException();
    }

    public HashSet<Characteristic> getCharacteristic() {
        return characteristic;
    }


}
