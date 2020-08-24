<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Servicios</title>
        <link rel="stylesheet" href="CSS/MS.css"/>
        <link rel="stylesheet" href="CSS/CAR.css"/>
        <link rel="stylesheet" href="CSS/style.css"/>
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
                    <a class="B" href="controladoradmin?accion=ListarServicios">Servicios</a>
                    <a class="B" href="../Html/AGENDAR_CITA.html">Agendar cita</a>
                    <a class="B" href="../Html/SUCURSALES.html">Sucursales</a>
                    <a class="B" href="../Html/PERFIL.html">Mi cuenta</a>
                </div>
                <a href="controladoradmin?accion=AgregarServicio"><label>Registrar nuevo servicio</label></a>
        <div class="CONTENEDOR">
            <c:forEach var="s" items="${servicio}">
                <div class="SERVICIO">
                    <div class="CARD">
                            <div class="NOMBRE">
                                <h1>${s.getNombre_serv()}</h1>
                            </div>
                            <div class="IMAGEN">
                                <img src="controladorIMG?id_serv=${s.getId_serv()}" width="200" height="200" >
                            </div>
                            <div class="DESC">
                                <h3>${s.getDesc_serv()}</h3>
                            </div>
                            <div class="TIEMPO">
                                ${s.getTiempo_serv()}
                            </div>
                            <div class="COL5">
                                <h2>$ ${s.getCosto_serv()}</h2>
                                <br>
                            </div>
                            <div class="ACCIONES">
                                <a class="BTN1" href="controladoradmin?accion=EditarServicio&id_serv=${s.getId_serv()}">Editar</a>
                                <a class="BTN2" href="controladoradmin?accion=EliminarServicio&id_serv=${s.getId_serv()}">Eliminar</a>
                            </div>
                    </div> 
                 </div>
            </c:forEach>
        </div>
            </div>
            
            <div class="LEFT">
                
            </div>
        
        
    </body>
</html>
