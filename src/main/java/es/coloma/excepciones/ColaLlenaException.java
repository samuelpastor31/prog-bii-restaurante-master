package es.coloma.excepciones;

public class ColaLlenaException extends RuntimeException{

    public ColaLlenaException(){
        System.out.println("Se ha llegado al tamaño máximo de pedidos pendientes" +
                " por servir.");
    }
}
