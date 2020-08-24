package modelo;

import configuracion.CONEXION;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteBD 
{
    Connection c;
        CONEXION con=new CONEXION();
        PreparedStatement ps;
        ResultSet rs;
        
 /*       public List ListarPersonal()
        {
            
                List<Personal> personal=new ArrayList();
        
                String query="SELECT*FROM mempleado";

                try
                {
                    c=con.getConnection();
                    ps=c.prepareStatement(query);
                    rs=ps.executeQuery();

                    while(rs.next())
                    {
                        Personal p=new Personal();

                        p.setId_emp(rs.getInt(1));
                        p.setNombre_emp(rs.getString(2));
                        p.setApat_emp(rs.getString(3));
                        p.setAmat_emp(rs.getString(4));
                        p.setId_tipoemp(rs.getInt(5));

                        personal.add(p);
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                    System.out.println(e.getStackTrace());
                    System.out.println("Error en la conexion! PersonalBD");


                }
            
            return personal;
        }*/
        
        public void RegistrarUsuario(Cliente cl)
        {
                String query="INSERT INTO mcliente(nombre_cliente,apat_cliente,amat_cliente,direccion,email,telefono,id_usuario)"+
                                    "VALUES(?,?,?,?,?,?)";

                try
                {
                    c=con.getConnection();
                    ps=c.prepareStatement(query);


                        ps.setString(1,cl.getNombre_cliente());
                        ps.setString(2,cl.getApepat());
                        ps.setString(3,cl.getApemat());
                        ps.setString(4,cl.getDireccion());
                        ps.setString(5,cl.getEmail());
                        ps.setString(6,cl.getTelefono());
                        ps.setInt(7,cl.getId_usuario());
                        
                        ps.executeUpdate();
                        
                        System.out.println("Cliente registrado con exito");
                        
                        c.close();
                    
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                    System.out.println(e.getStackTrace());
                    System.out.println("Error en la conexion! ClienteBD");


                }
        }
        
       public Cliente ListarPorID(int id_cliente)
        {
            String query="SELECT*FROM mcliente WHERE id_cliente="+id_cliente;

            Cliente cl=new Cliente();

            try
            {
                c=con.getConnection();
                ps=c.prepareStatement(query);
                rs=ps.executeQuery();

                while(rs.next())
                {
                    cl.setId_cliente(rs.getInt(1));
                    cl.setNombre_cliente(rs.getString(2));
                    cl.setApepat(rs.getString(3));
                    cl.setApemat(rs.getString(4));
                    cl.setDireccion(rs.getString(5));
                    cl.setEmail(rs.getString(6));
                    cl.setTelefono(rs.getString(7));
                    cl.setId_usuario(rs.getInt(8));
                }

            }
            catch(Exception e)
            {

            }
            return cl;
        }
        
        public void EliminarCliente(int id_cliente)
        {
                 String query="DELETE FROM mcliente WHERE id_cliente="+id_cliente;

            Cliente cl=new Cliente();

            try
            {
                c=con.getConnection();
                ps=c.prepareStatement(query);
                
               
                
                ps.executeUpdate();
                

            }
            catch(Exception e)
            {

            }
        }
        
        public void EditarCliente(Cliente cl)
        {
                String query="UPDATE mempleado SET nombre_cliente=?,apat_cliente=?,amat_cliente=?,direccion=?,email=?,telefono=?,id_usuario=? WHERE id_cliente=?";

                try
                {
                        c=con.getConnection();
                        ps=c.prepareStatement(query);

                        ps.setString(1,cl.getNombre_cliente());
                        ps.setString(2,cl.getApepat());
                        ps.setString(3,cl.getApemat());
                        ps.setString(4,cl.getDireccion());
                        ps.setString(5,cl.getEmail());
                        ps.setString(6,cl.getTelefono());
                        ps.setInt(7,cl.getId_usuario());
                        ps.setInt(8,cl.getId_cliente());


                        ps.executeUpdate();


                }
                catch(Exception e)
                {
                        System.out.println(e.getMessage());
                        System.out.println(e.getStackTrace());
                }
        }
}
