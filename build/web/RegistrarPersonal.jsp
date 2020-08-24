<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar empleado</title>
        
        <script>
                function aver()
                {
                    var id;                     
                    var t=document.getElementById("temp");
                    var tipo=t.options[t.selectedIndex].text;
                    
                    if(tipo=="Administrador")
                    {
                        id=1;
                    }
                    else if(tipo=="Estilista")
                    {
                        id=2;
                    }
                    
                        document.getElementById("txttemp").value=parseInt(id);
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
                    <a class="B" href="controladoradmin?accion=default">Personal</a>
                    <a class="B" href="controlador?accion=servicios">Servicios</a>
                    <a class="B" href="../Html/AGENDAR_CITA.html">Citas</a>
                    <a class="B" href="../Html/SUCURSALES.html">Sucursales</a>
                    <a class="B" href="../Html/PERFIL.html">Mi cuenta</a>
                </div>
                <form action="controladoradmin" >
                        <div class="CONTENEDOR">
                            <div class="COMPRA">
                                <h2>Nombre(s): </h2>
                                <input type="text" name="nombreemp" />

                                <h2>Apellido paterno: </h2>
                                <input type="text" name="apatemp"/>

                                <h2>Apellido materno:</h2>
                                <input type="text" name="amatemp"/>

                                <h2>Tipo de empleado</h2>
                                <select name="empdesc" id="temp" onchange="aver();">
                                        <option value="Select" disabled selected>Seleccione</option>
                                        <option value="Administrador">Administrador</option>
                                        <option value="Estilista">Estilista</option>
                                </select>
                                
                                <h2>No. tipo de empleado</h2>
                                <input type="text" name="tipoemp" readonly="" id="txttemp">       
                                <br><br>
                                 
                                <a href="controladoradmin?accion=default"> <input type="submit" name="accion" value="Registrar"></a>
                            </div>  
                        </div>
                </form>
                </div>
                
                <div class="LEFT">
                </div>
        </div>
        
    </body>
   <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</html>
