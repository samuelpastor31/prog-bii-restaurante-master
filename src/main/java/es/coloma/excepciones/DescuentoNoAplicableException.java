package es.coloma.excepciones;

public class DescuentoNoAplicableException extends RuntimeException{

    public DescuentoNoAplicableException(){
        System.out.println("No se puede aplicar descuento a los postres");
    }
}
