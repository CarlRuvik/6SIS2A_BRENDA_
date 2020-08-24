<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agendar cita</title>
        
        <script>
                function aver()
                {
                    var horainicial,horafinal,e;
                    var tiempo=parseInt(document.getElementById("tiempo").value);
                                        
                    var h=document.getElementById("hora");
                    var hora=h.options[h.selectedIndex].text;
                    
                     switch(hora)
                        {
                            case "9:00 am":
                                horainicial=9;
                                e="am";
                            break;
                            case "10:00 am":
                                horainicial=10;
                                e="am";
                            break;
                            case "11:00 am":
                                horainicial=11;
                                e="am";
                            break;
                            case "12:00 pm":
                                horainicial=12;
                                e="pm";
                            break;
                            case "13:00 pm":
                                horainicial=13;
                                e="pm";
                            break;
                            case "14:00 pm":
                                horainicial=14;
                                e="pm";
                            break;
                            case "15:00 pm":
                                horainicial=15;
                                e="pm";
                            break;               
                        }
                        horafinal=Math.round(horainicial+(tiempo/60));
                            
                        document.getElementById("time").value=Math.round(tiempo/60)+" horas";
                        document.getElementById("hfinal").value=horafinal+" "+e;
                }
        </script>
        
        <link rel="stylesheet" href="CSS/CAR.css"/>
        <link rel="stylesheet" href="CSS/style.css"/>
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
                <div class="CONTENEDOR" style="display: flex">
                    <div class="CARRO">
                    <table>
                        <thead>
                            <tr>
                                <td>ITEM</td>
                                <td>NOMBRE</td>
                                <td>DESCRIPCION</td>
                                <td>COSTO</td>
                                <td>TIEMPO</td>
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
                                    <td>Aprox. ${car.getTiempo()}</td             
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>  
                    
                    <div class="COMPRA">
                        <h2> Seleccione la sucursal:</h2> 
                        <select name="sucursal">
                                <option value="Zona rosa">Zona rosa</option>
                                <option value="Chapultepec">Chapultepec</option>
                                <option value="Nueva" selected>Nueva</option>
                                <option value="Aquella">Aquella</option>
                        </select>
                        
                        <h2> Seleccione una fecha:</h2> 
                        <input type="date" name="txtfecha" id="txtfecha"/>
                        
                        <h2>Seleccione la hora:</h2>
                        <select name="hora" id="hora" onchange="aver();">
                                <option value="9:00">9:00 am</option>
                                <option value="10:00">10:00 am</option>
                                <option value="11:00" selected>11:00 am</option>
                                <option value="12:00">12:00 pm</option>
                                <option value="13:00">13:00 pm</option>
                                <option value="14:00">14:00 pm</option>
                                <option value="15:00">15:00 pm</option>
                        </select>
                        
                        <h2>Tiempo de elaboracion:</h2>
                        <input id="tiempo" type="hidden" value="${tiempo_total}" />
                        <input id="time" type="text" readonly=""/> 
                        
                        <h2>Hora de finalización</h2>
                        <input type="text" readonly="" id="hfinal"/> 

                        <h2>Estilista que lo atenderá:</h2> 
                        <input type="text" readonly="" value=""/>    
                </div>
            </div>
            </div>
            
            <div class="LEFT">
            </div>
        </div>
        
    </body>
   <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</html>
