package es.coloma.views;

import com.github.freva.asciitable.AsciiTable;
import com.github.freva.asciitable.Column;
import com.github.freva.asciitable.ColumnData;
import es.coloma.products.type.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuCardViewList {

    private List<Product> products;

    public MenuCardViewList(ArrayList<Product> menuCard) {
        this.products = menuCard;
    }

    private String renderView() {
        return AsciiTable.getTable(products, Arrays.asList(
                new Column().with(Product::getCod),
                new Column().header("Nombre").with(Product::getName),
                new Column().header("Precio").with((Product product) ->
                        String.format("%.02f€", product.getPrizeWithoutDiscount())
                ),
                new Column().header("Descuento (%)").with((Product product)
                        -> String.format("%.02f", product.getPercentageDiscount())
                ),
                new Column().header("Extras").with(this::getExtras)
                )
        );
    }

    private String getExtras(Product product) {
        if (product instanceof Starter) {
            Starter starter = (Starter) product;
            return String.format("Raciones: %s", starter.getRation());
        } else if(product instanceof Drink) {
            Drink drink = (Drink) product;
            return String.format("Rellenable: %b, Tamaño: %s", (drink.isRefillable())? "Sí": "No", drink.getSize());
        } else if(product instanceof Desert) {
            Desert desert = (Desert) product;
            if (desert.getCharacteristic() != null) {
                return String.format("%s", desert.getCharacteristic());
            }
        }
        return "";
    }

    @Override
    public String toString() {
        return renderView();
    }

}
