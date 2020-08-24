<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrador</title>
        
        
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
                    <a class="B" href="controladoradmin?accion=default">Personal</a>
                    <a class="B" href="controladoradmin?accion=ListarServicios">Servicios</a>
                    <a class="B" href="../Html/AGENDAR_CITA.html">Citas</a>
                    <a class="B" href="../Html/SUCURSALES.html">Sucursales</a>
                    <a class="B" href="../Html/PERFIL.html">Mi cuenta</a>
                </div>
                <div class="CONTENEDOR">
                    <div class="CARRO">
                        <a href="controladoradmin?accion=Agregar"><label>Registrar nuevo empleado</label></a>
                    <table>
                        <thead>
                            <tr>
                                <td>ID</td>
                                <td>NOMBRE</td>
                                <td>AP. PATERNO</td>
                                <td>AP. MATERNO</td>
                                <td>TIPO EMPLEADO</td>
                                <td>ACCION</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="per" items="${personal}">
                                <tr>
                                    <td>${per.getId_emp()}</td>
                                    <td>${per.getNombre_emp()}</td>
                                    <td>${per.getApat_emp()}</td>
                                    <td>${per.getAmat_emp()}</td>
                                    <td>${per.getId_tipoemp()}</td>
                                    <td> 
                                        <a href="controladoradmin?accion=EliminarEmpleado&id_emp=${per.getId_emp()}"><img src="Img/TRASH.png" width="30" height="30"></a>
                                        <a href="controladoradmin?accion=EditarEmpleado&id_emp=${per.getId_emp()}">Editar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>  
                </div>
                </div>
            
                <div class="LEFT">
                </div>
        </div>
        
    </body>
   <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</html>