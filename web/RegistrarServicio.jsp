<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar servicio</title>
        
        <script>
                function aver()
                {
                    var id;                     
                    var t=document.getElementById("tserv");
                    var tipo=t.options[t.selectedIndex].text;
                    
                    if(tipo=="Maquillaje y peinado")
                    {
                        id=1;
                    }
                    else if(tipo=="Manos y pies")
                    {
                        id=2;
                    }
                    else if(tipo=="Peluquería")
                    {
                        id=3;
                    }
                    
                        document.getElementById("txttserv").value=parseInt(id);
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
                                <h2>Nombre: </h2>
                                <input type="text" name="nombreserv" />

                                <h2>Descripción: </h2>
                                <input type="text" name="descserv"/>
                                
                                <h2>Tiempo de elaboración </h2>
                                <input type="text" name="tiemposerv"/>

                                <h2>Costo:</h2>
                                <input type="text" name="costoserv"/>

                                <h2>Tipo de Servicio</h2>
                                <select name="empdesc" id="tserv" onchange="aver();">
                                        <option value="Select" disabled selected>Seleccione</option>
                                        <option value="Maquillaje y peinado">Maquillaje y peinado</option>
                                        <option value="Manos y pies">Manos y pies</option>
                                        <option value="Peluquería">Peluquería</option>
                                </select>
                                
                                <h2>No. tipo de servicio</h2>
                                <input type="text" name="tiposerv" readonly="" id="txttserv">       
                                <br><br>
                                 
                                <a href="controladoradmin?accion=ListarServicios"> <input type="submit" name="accion" value="RegistrarServicio"></a>
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
