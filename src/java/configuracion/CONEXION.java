package configuracion;

import com.mysql.jdbc.*;
import java.sql.DriverManager;

public class CONEXION 
{
    Connection c;
    String url="jdbc:mysql://localhost:3306/estetica";
    String username="root";
    String password="Enderman7";
    
    public Connection getConnection()
    {
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            c=(Connection) DriverManager.getConnection(url,username,password);
            System.out.println("Conexión exitosa! AQUI");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            System.out.println("Error en la conexion!");
        }
        
        return c;
    }
}
