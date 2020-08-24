<%@page import="modelo.Servicio"%>
<%@page import="modelo.ServiciosBD"%>
<%@page import="modelo.Personal"%>
<%@page import="modelo.PersonalBD"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar datos del empleado</title>
        
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
                    <a class="B" href="controladoradmin?accion=ListarServicios">Servicios</a>
                    <a class="B" href="../Html/AGENDAR_CITA.html">Citas</a>
                    <a class="B" href="../Html/SUCURSALES.html">Sucursales</a>
                    <a class="B" href="../Html/PERFIL.html">Mi cuenta</a>
                </div>
                
                <%
                    ServiciosBD sbd=new ServiciosBD();
                    int id_serv=Integer.parseInt((String)request.getAttribute("srvid_serv"));
                    
                        Servicio ser=(Servicio)sbd.ListarPorID(id_serv);
                %>
                
                <form action="controladoradmin" >
                        <div class="CONTENEDOR">
                            <div class="COMPRA">
                                
                                <input type="text" name="txtidserv" value="<%=ser.getId_serv()%>"/>
                                
                                <h2>Nombre: </h2>
                                <input type="text" name="nombreserv" value="<%=ser.getNombre_serv()%>"/>

                                <h2>Descripción: </h2>
                                <input type="text" name="descserv" value="<%=ser.getDesc_serv()%>"/>
                                
                                <h2>Tiempo de elaboración: </h2>
                                <input type="text" name="tiemposerv" value="<%=ser.getTiempo_serv()%>"/>

                                <h2>Costo:</h2>
                                <input type="text" name="costoserv" value="<%=ser.getCosto_serv()%>"/>
                                
                                <h2>No. tipo de servicio</h2>
                                <input type="text" name="tiposerv" readonly="" id="txttserv" value="<%=ser.getTiempo_serv()%>">       
                                <br><br>
                                 
                                <a href="controladoradmin?accion=ListarServicios"> <input type="submit" name="accion" value="ActualizarServicio"></a>
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
