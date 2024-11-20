$(document).ready(function () {
    // 1. Cargar las mesas
    $.ajax({
        url: "svMesa", // Cambia por la URL real del Servlet
        method: "GET",
        dataType: "json",
        success: function (mesas) {
            mesas.forEach(mesa => {
                $("#mesas-container").append(
                    `<button class="mesa-btn" data-mesa="${mesa.numMesa}">Mesa ${mesa.numMesa}</button>`
                );
            });
        }
    });

    // 2. Crear Tabulator para productos
    const productosTabulator = new Tabulator("#productos-tabulator", {
        ajaxURL: "svCarta", // Cambia la URL según tu contexto
        ajaxConfig: "GET", // Método HTTP
        layout: "fitColumns",
        placeholder: "No hay productos disponibles",
        initialSort: [
        { column: "categoriaProd.Nombre", dir: "asc" } // Ordena por la columna 'categoriaProd.Nombre' de forma ascendente
        ],
        columns: [
            {
                title:"Categoria",
                field:"categoriaProd.Nombre",
                headerFilter:true
            },
            { title: "Nombre", field: "nombreProducto", headerFilter:true },
            { 
                title: "Precio", 
                field: "precioProducto", 
                formatter: "money", 
                formatterParams: { symbol: "$", precision: 2 } 
            },
            {
                title: "Agregar",
                formatter: "buttonCross",
                cellClick: function (e, cell) {
                    agregarProducto(cell.getRow().getData());
                }
            }
        ],
        rowClick: function(e,row){
            const producto = row.getData();
            agregarProducto(producto);
        }
    });

    

    // 4. Configurar Tabulator para el ticket
    let productosEnTicket = []; // Lista para productos en el ticket
    const ticketTabulator = new Tabulator("#ticket-tabulator", {
        layout: "fitColumns",
        data: productosEnTicket,
        columns: [
            { title: "Nombre", field: "nombreProducto" },
            { 
                title: "Precio", 
                field: "precioProducto", 
                formatter: "money", 
                formatterParams: { symbol: "$" } 
            },
            { 
                title: "Cantidad", 
                field: "cantidad", 
                editor: "input", 
                cellEdited: function(cell){
                    actualizarCantidad(cell);
                } // Actualizar total al editar cantidad
            },
            { 
                title: "Subtotal", 
                field: "subtotal", 
                formatter: "money", 
                formatterParams: { symbol: "$" } 
            },
            {
                title: "Eliminar",
                formatter: "buttonCross",
                cellClick: function (e, cell) {
                    eliminarProducto(cell.getRow().getData());
                }
            }
        ]
    });

    
    function agregarProducto(producto) {
    // Verificamos si el producto ya está en el ticket
    const index = productosEnTicket.findIndex(item => item.id === producto.id);

    if (index !== -1) {
        // Si el producto ya existe, incrementamos la cantidad
        productosEnTicket[index].cantidad += 1;
        productosEnTicket[index].subtotal = productosEnTicket[index].cantidad * productosEnTicket[index].precioProducto;
    } else {
        // Si el producto no está en el ticket, lo agregamos con cantidad 1
        const nuevoProducto = {
            id: producto.idProducto,
            nombreProducto: producto.nombreProducto,
            precioProducto: producto.precioProducto,
            cantidad: 1,
            subtotal: producto.precioProducto
        };
        productosEnTicket.push(nuevoProducto);
    }

    // Actualizamos el Tabulator de tickets con los productos en el ticket
    ticketTabulator.setData(productosEnTicket);

    // Actualizamos el total
    actualizarTotal();
}

    

    // 6. Función para eliminar producto del ticket
    function eliminarProducto(producto) {
        productosEnTicket = productosEnTicket.filter(item => item.id !== producto.id);

        // Actualizar el Tabulator de tickets
        ticketTabulator.setData(productosEnTicket);

        // Actualizar el total
        actualizarTotal();
    }

    // 7. Función para actualizar el total del ticket
    function actualizarTotal() {
        const total = productosEnTicket.reduce((sum, item) => sum + item.subtotal, 0);
        document.getElementById("total-ticket").innerText = "Total: $" + total.toFixed(2);
    }

    // 8. Función para actualizar la cantidad de un producto en el ticket
    function actualizarCantidad(cell) {
         const rowData = cell.getRow().getData(); // Obtiene los datos de la fila editada
    const nuevaCantidad = rowData.cantidad; // Cantidad editada

    // Actualiza el subtotal
    rowData.subtotal = nuevaCantidad * rowData.precioProducto;

    // Actualizar el ticket en el array productosEnTicket
    const index = productosEnTicket.findIndex(item => item.id === rowData.id);
    if (index !== -1) {
        productosEnTicket[index].cantidad = nuevaCantidad;
        productosEnTicket[index].subtotal = rowData.subtotal;
    }

    // Actualizar la vista de la tabla de tickets
    ticketTabulator.updateData(productosEnTicket);

    // Actualizar el total
    actualizarTotal();
    }

    // 9. Asignar evento a los botones de mesas
    $(document).on("click", ".mesa-btn", function () {
        const mesa = $(this).data("mesa");
        $("#mesa-seleccionada").text(mesa);
        productosEnTicket = []; // Limpiar ticket para la nueva mesa
        ticketTabulator.setData(productosEnTicket);
        actualizarTotal();
    });
});
