<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Servicios</title>
        
        <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@300&display=swap" rel="stylesheet">
        
        <link rel="stylesheet" href="CSS/MS.css"/>
        <link rel="stylesheet" href="CSS/style.css"/>
        <link rel="stylesheet" href="CSS/CAR.css"/>
        
        <script></script>
    </head>
    <body>
        <div class="TODO">
            <div class="RIGHT">
                <div class="LOGO">
                    <a href="controlador?accion=inicio"><img src="Img/LOGO.png" width="100" height="120"></a>
                </div>
            </div>
            <div class="MIDDLE">
                <div class="MENU">
                    <a class="B" href="controlador?accion=inicio">Inicio</a>
                    <a class="B" href="controlador?accion=default">Servicios</a>
                    <a class="B" href="../Html/AGENDAR_CITA.html">Agendar cita</a>
                    <a class="B" href="../Html/SUCURSALES.html">Sucursales</a>
                    <a class="B" href="../Html/PERFIL.html">Mi cuenta</a>
                </div>
                <div class="CONTENEDOR">
            <div class="CARRO">
                <table>
                    <thead>
                        <tr>
                            <td>ITEM</td>
                            <td>NOMBRE</td>
                            <td>DESCRIPCION</td>
                            <td>COSTO</td>
                            <td>TIEMPO</td>
                            <td>ACCION</td>                 
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="car" items="${carrito}">
                            <tr>
                                <td>${car.getItem()}</td>
                                <td>${car.getNombre_serv()}</td>
                                <td>
                                    ${car.getDesc_serv()}<br><br>
                                    <img src="controladorIMG?id_serv=${car.getId_serv()}" width="100" height="100">
                                </td>
                                <td>$ ${car.getCosto_serv()}</td>
                                <td>Aprox.<br> ${car.getTiempo()}</td>
                                <td>
                                    <a href="controlador?accion=EliminardelCarrito&id_serv=${car.getId_serv()}"><img src="Img/TRASH.png" width="30" height="30"></a>
                                </td>               
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="COMPRA">
                <h2>Generar compra</h2>
                <h3>Subtotal:</h3>
                <input type="text" readonly="" value="$ ${pago_total}0">
                
                <h3>Descuento:</h3>
                <input type="text" readonly="" value="$ 0.00">
                
                <h3>Total mínimo a pagar:</h3>
                <input type="text" readonly="" value="$ ${pago_total/2}0">
                <br><br>
                <a class="BTN" href="controlador?accion=ProcederCita">Proceder con la cita</a>
                <a class="BTN" href="controlador?accion=default">Seguir comprando</a>
            </div>
        </div>
            </div>
            <div class="LEFT">
            </div>
        </div>
    </body>
    
    
</html>
