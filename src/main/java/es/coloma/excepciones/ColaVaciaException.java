package es.coloma.excepciones;

public class ColaVaciaException extends RuntimeException{

    public ColaVaciaException(){
        System.out.println("No hay ningún pedido");
    }
}
