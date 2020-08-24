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
                    <a class="B" href="controlador?accion=default">Personal</a>
                    <a class="B" href="controlador?accion=servicios">Servicios</a>
                    <a class="B" href="../Html/AGENDAR_CITA.html">Citas</a>
                    <a class="B" href="../Html/SUCURSALES.html">Sucursales</a>
                    <a class="B" href="../Html/PERFIL.html">Mi cuenta</a>
                </div>
                <form action="index" >
                        <div class="CONTENEDOR">
                            <div class="COMPRA">
                                <div>
                                    <img src="Img/USER.png" alt="" width="100" height="100"/>
                                    <h1>Registrarse</h1>
                                </div>
                                <div>
                                        <h2>Nombre(s): </h2>
                                        <input type="text" name="nombrecli" placeholder="Juan"/>
                                        
                                        <h2>Apellido paterno: </h2>
                                        <input type="text" name="apatcli" placeholder="Perez"/>
                                        
                                        <h2>Apellido materno:</h2>
                                        <input type="text" name="amatcli" placeholder="Mendez"/>
                                        
                                        <h2>Nombre de usuario:</h2>
                                        <input type="text" name="user" placeholder="Nuevo nombre de usuario."/>
                                        
                                        <h2>Contraseña:</h2>
                                        <input type="password" name="pass" placeholder="Nueva contraseña."/>
                                        
                                        <h2>Dirección:</h2>
                                        <input type="text" name="direc" />
                                        
                                        <h2>Correo electrónico:</h2>
                                        <input type="text" name="email" placeholder="Juan@ejemplo.com"/>
                                        
                                        <h2>Teléfono:</h2>
                                        <input type="text" name="tel" placeholder="XXXXXXXXXX"/>
                                        <br>
                                        <input type="submit" name="accion" value="RegistrarUsuario"/>                                       
                                </div>                               
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
