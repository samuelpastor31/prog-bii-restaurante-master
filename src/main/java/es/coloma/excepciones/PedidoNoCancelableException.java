package es.coloma.excepciones;

public class PedidoNoCancelableException extends RuntimeException{

    public PedidoNoCancelableException(){
        System.out.println("Pedido ya servido o no existente");
    }
}
