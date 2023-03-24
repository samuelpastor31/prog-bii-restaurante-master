package es.coloma.excepciones;

public class FechaNoValidadaException extends RuntimeException{


    public FechaNoValidadaException(){
        System.out.println("El formato introducido no es válido. Recuerde (dd/mm/yyyy)");
    }
}
