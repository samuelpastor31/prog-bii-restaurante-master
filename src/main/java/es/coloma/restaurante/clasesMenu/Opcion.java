package es.coloma.restaurante.clasesMenu;

public abstract class Opcion {

    private String titulo;

    private boolean finalizar;

    public Opcion(String titulo) {
        this.titulo = titulo;
        this.finalizar = false;
    }

    public void mostrar(int numOpcion) {
        System.out.print("\n" + numOpcion + ") " + titulo);
    }

    public abstract void ejecutar();

    public boolean finalizar() {
        return finalizar;
    }

    protected void setFinalizar(boolean finalizar) {
        this.finalizar = finalizar;
    }

}

