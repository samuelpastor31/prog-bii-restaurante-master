package es.coloma.views;

import de.vandermeer.asciitable.AT_Row;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciithemes.TA_GridThemes;
import de.vandermeer.asciithemes.a7.A7_Grids;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import es.coloma.restaurante.Order;
import es.coloma.utils.AnsiColor;

import java.util.ArrayList;

public class OrderViewList {

    private ArrayList<Order> orderList;

    public OrderViewList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }

    private String renderView() {

        AsciiTable at = new AsciiTable();
        at.addRule();
        AT_Row row = at.addRow( null, null, null,null, " === Restaurante 20 Montaditos === ");
        row.setTextAlignment(TextAlignment.CENTER);
        at.addRule();
        row = at.addRow("Código", "Cliente", "Fecha", "Tiempo", "Servido");
        row.setTextAlignment(TextAlignment.CENTER);
        at.addRule();
        for (Order order: orderList) {
            AT_Row row2 = at.addRow(order.getCode(), order.getClientName(),order.getCreatedOn() ,order.getTiempo() ,
                    (order.isServed() ? "Si" : "No"));
            row2.setTextAlignment(TextAlignment.CENTER);
            at.addRule();
        }
        row = at.addRow("*", "*", "*", "*", "*");
        row.setTextAlignment(TextAlignment.CENTER);
        at.addRule();
        at.getContext().setGrid(A7_Grids.minusBarPlusEquals());
        at.getContext().setGridTheme(TA_GridThemes.FULL);
        return at.render();

    }

    @Override
    public String toString() {
        return renderView();
    }

}
