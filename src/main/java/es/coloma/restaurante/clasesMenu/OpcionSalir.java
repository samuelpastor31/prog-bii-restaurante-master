package es.coloma.restaurante.clasesMenu;


import es.coloma.utils.AnsiColor;

public class OpcionSalir extends Opcion {

    public OpcionSalir() {
        super("Salir");
    }

    @Override
    public void ejecutar() {
        System.out.println("==============================================");
        AnsiColor.colorizeOutput(AnsiColor.BLUE, "=========== Esperamos verte pronto ===========");
        System.out.println("==============================================");
        setFinalizar(true);
    }
}

