# 1. Restaurante 20 Montaditos
## 1.1 Descripción
Esta actividad tiene como objetivo hacer un pequeña aplicación simplificada de gestión de productos y pedidos de un Restaurante de comida rápida. Las especificaciones son las siguientes:

- De cada producto queremos guardar un código (puede ser automático a partir de 1), **un nombre**, **una descripción**, **el precio base**, **el descuento** y **el IVA**. Se deberá implementar algún método para **calcular el PVP** (precio de venta al público), según el precio base, el IVA y el descuento que se le aplica.
- De cada pedido guardaremos un identificador (también puede ser automático a partir del 1), **la lista de productos**, **la fecha del pedido**, **el nombre del cliente** que lo ha realizado y **si ya ha sido servido** en mesa o no.

En esta práctica se manejarán 2 listas:

- **1 lista para gestionar los Productos** y que representarán la carta disponible en el restaurante.
- **1 lista para gestionar los Pedidos** la cual contendrá los diferentes pedidos que se han realizado, tanto servidos como pendientes de servir.

Deberemos poder llevar a cabo las siguientes acciones:

**1. Registrar nuevo pedido:**  cuando se crea un nuevo pedido, deberemos:

   - **1.1.** Pedir el nombre del cliente y la fecha del pedido en formato **dd/mm/yyyy**. 
   - **1.2.** Pedir que el usuario seleccione los productos que desea incluir en el pedido; para hacerlo, se podrá proceder de alguna de las dos formas siguientes:
        - **(opción A)** Se listarán todos los productos disponibles y se pedirá uno por uno el códgo del producto que se quiere añadir al pedido, preguntando después de insertar cada producto si se quiere insertar alguno más.
        - **(opción B)** Se listarán todos los productos y se podrán introducir más de un cada vez. En este caso, se introducirán, separados por comas, los códigos de los productos.

**2. Buscar y visualizar un pedido:** se debe poder buscar y mostrar la información de un pedido. Se procederá de la siguiente forma:

   - **2.1.** Se mostrará en una tabla el código, nombre, fecha y estado de todos los pedidos.
   - **2.2.** El usuario introducirá el código del pedido que se quiere visualizar y seguidamente aparecerá la información detallada del pedido: nombre del cliente, fecha del pedido, lista de productos con la información de cada uno de ellos (uno bajo del otro) y el importe total del pedido.
    
**3. Registrar entrega de pedido:** Se debe poder marcar los pedidos como entregados. Para ello se procederá de la siguiente forma:

   - **3.1.** Se mostrará en un tabla el código, nombre y fecha de todos los pedidos pendientes de entrega.
   - **3.2.** El usuario introducirá el código del pedido que quiere marcar como entregado, de forma que se modificará la propiedad correspondiente del objeto que representa al pedido seleccionado y se volverá a mostrar el menú principal.
       Por último, para no tener que insertar todos los productos cada vez que iniciemos la aplicación, y dado que los productos que existen en el restaurante son fijos, crea una clase llamada **BaseDeDatosEnMemoria** que disponga de un ArrayList de Productos creados  por nosotros mismos (hardCode). Deberá disponer del método obtenerTodos() que nos devuelva el conjunto de productos que se cargaran al ejecutar la aplicación.

# 2. Codigo de Estilo
El estilo de codificación que se ha seguido a lo largo del proyecto es el [siguiente](https://google.github.io/styleguide/javaguide.html)