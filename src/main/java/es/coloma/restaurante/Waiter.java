package es.coloma.restaurante;

import es.coloma.products.Catalogue;
import es.coloma.products.type.*;
import es.coloma.utils.AnsiColor;
import es.coloma.utils.GestorIO;
import es.coloma.utils.Validator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class Waiter {

    public static final String FINISH_INTRODUCTION = "0";
    private Catalogue catalogue;

    private Order order;

    public Waiter(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    /**
     * Crea un nuevo Pedido con el identificador @code
     *
     * @param code
     * @return Order
     */
    public Order attend(String code) {
        String clientName = getClientName();
        String currentDate =  getCurrentDate();
        String date = cojerPrimera(currentDate);
        String tiempo = getCurrentTiempo(currentDate);
        order = new Order(code, clientName, date, tiempo);
        askForProducts();
        return (order.hasProducts()) ? order : null;
    }

    private String cojerPrimera(String date){
        String[] palabras = date.split(" ");
        String segundaPalabra = palabras[0];
        return segundaPalabra;
    }

    /**
     * Preguntar al usuario por los productos que desea tomar
     */
    private void askForProducts() {
        System.out.println("Buenos dias, que deseas Tomar?");
        System.out.println("¿Qué desea beber?");
        selectProductsOfType(Drink.class);
        System.out.println("¿Desea tomar algo de entrante?");
        selectProductsOfType(Starter.class);
        System.out.println("¿Desea tomar bocadillos?");
        selectProductsOfType(Sandwich.class);
        System.out.println("¿Quieres algo de postre?");
        selectProductsOfType(Desert.class);
    }

    /**
     *  Selecciona productos del tipo @productClass y los añade al pedido
     *
     * @param productClass
     */
    private void selectProductsOfType(Class productClass){
        catalogue.listAll(productClass);
        do {
            Product product = askForNewProduct();
            if (product == null) {
                break;
            }
            if (product.getClass() != productClass) {
                if (!confirmSelection()) {
                    continue;
                }
            }
            addNewProductToOrder(product);
        } while (true);

    }

    /**
     * Preguntamos al usuario que producto nuevo quiere añadir
     * @return Producto a añadir
     */
    private Product askForNewProduct() {
        do {
            String code = getProductCode();
            if (code == null) {
                return null;
            }
            Product product = catalogue.find(code);
            if (product == null) {
                AnsiColor.errorOutput("El código del producto introducido no existe");
            } else {
                return product;
            }
        } while (true);
    }

    /**
     * Obtenemos el código del producto a introducir / null si no quiere mas
     * @return codigo del producto a añadir
     */
    private String getProductCode() {
        do {
            String question = String.format("Introduzca el código del producto que desea añadir %s \n",
                    AnsiColor.colorize(AnsiColor.CYAN, "(0 - Finalizar)"));

            String productCode = GestorIO.obtenerCadena(question);
            if (productCode.equalsIgnoreCase(FINISH_INTRODUCTION)){
                return null;
            }else if (isValidProductCode(productCode)){
                return productCode;
            }
            System.out.println("El código de producto introducido no es válido");
        } while (true);
    }

    /**
     * Añade el producto seleccionado a la orden
     *
     * @param product
     */
    private void addNewProductToOrder(Product product) {
        order.addNewProduct(product);
        System.out.printf("%s - %s %s \n",
                AnsiColor.colorize(AnsiColor.GREEN, product.getCod()),
                product.getName(),
                AnsiColor.colorize(AnsiColor.GREEN,  "[Añadido]")
        );
    }

    /**
     * Obtiene el nombre del cliente que quiere realizar el pedido
     *
     * @return nombreCliente
     */
    private String getClientName() {
        return GestorIO.obtenerCadena("Introduzca su nombre: ");
    }

    /**
     * Devuelve la fecha del pedido en formato dd/mm/yyyy
     *
     * @return
     */
    private String getCurrentDate() {

        System.out.println("La fecha actual del sistema es : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        String mensaje = "¿Quieres añadir tu propia fecha de forma manual?";

        if (GestorIO.confirmar(mensaje)) {
            do {
                String question = String.format("Introduzca la fecha actual en formato %s \n", AnsiColor.colorize(AnsiColor.HIGH_INTENSITY, "dd/mm/yyyy"));
                String date = GestorIO.obtenerCadena(question);
                try {
                    String dateAsString = date;
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    return LocalDate.parse(dateAsString, formatter).toString()+ " 8:00:00";
                } catch (DateTimeParseException e) {
                    System.out.println("\"El formato introducido no es válido. Recuerde (dd/mm/yyyy)\"");
                }
            } while (true);
        } else {
            return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        }
    }

    /**
     * Permite validar el formato de la fecha introducido por el usuario
     *
     * @param date
     */
    private boolean isvalidDateFormat(String date) {
        return Validator.isValidateDate(date);
    }

    private String getCurrentTiempo (String date){
        String[] palabras = date.split(" ");
        String segundaPalabra = palabras[1];
        return segundaPalabra;
    }

    /**
     * Permite validar el formato del código de producto introducido por el usuario
     *
     * @param productCode
     */
    private boolean isValidProductCode(String productCode) {
        return Validator.isValidProductCode(productCode);
    }

    private boolean confirmSelection() {
        String message = "El producto seleccionado no pertenece a la categoría, desea agregarlo";
        return GestorIO.confirmar(AnsiColor.colorize(AnsiColor.GREEN, message));
    }

}
