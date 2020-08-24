package modelo;

import configuracion.CONEXION;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioBD
{

        Connection c;
        CONEXION con=new CONEXION();
        PreparedStatement ps;
        ResultSet rs;
        
        int resultado=0;
        
        public int ValidarUsuario(Usuario u)
        {
            
                List<Usuario> usuario=new ArrayList();
        
                String query="SELECT u.id_usuario, c.nombre_cliente,c.apat_cliente,c.amat_cliente,c.direccion,c.email,c.telefono,c.id_usuario"+
                                    "FROM musuario as u INNER JOIN mcliente as c ON(u.id_usuario=c.id_usuario)"+
                                    "WHERE username=? AND pass=?";

                try
                {
                        c=con.getConnection();
                        ps=c.prepareStatement(query);

                        ps.setString(1, u.getUsername());
                        ps.setString(2, u.getPass());
                    
                        rs=ps.executeQuery();

                    while(rs.next())
                    {
                        resultado=resultado+1;

                        Cliente cl=new Cliente();
                        
                        cl.setNombre_cliente(rs.getString("nombre_cliente"));
                        cl.setApepat(rs.getString("apat_cliente"));
                        cl.setApemat(rs.getString("amat_cliente"));
                        cl.setDireccion(rs.getString("direccion"));
                        cl.setEmail(rs.getString("email"));
                        cl.setTelefono(rs.getString("telefono"));
                        cl.setId_usuario(rs.getInt("id_cusuario"));                                                                             
                    }
                    if(resultado==1)
                    {
                        return 1;
                    }
                    else
                    {
                        return 0;
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                    System.out.println(e.getStackTrace());
                    System.out.println("Usuario o contraseña incorrectos");
                    
                    return 0;
                }
        }
        
        
        public List ListarUsuarios()
        {
            
                List<Usuario> usuario=new ArrayList();
        
                String query="SELECT*FROM musuario";

                try
                {
                    c=con.getConnection();
                    ps=c.prepareStatement(query);
                    rs=ps.executeQuery();

                    while(rs.next())
                    {
                        Usuario u=new Usuario();

                        u.setId_usuario(rs.getInt(1));
                        u.setUsername(rs.getString(2));
                        u.setPass(rs.getString(3));
                        u.setId_tipousuario(rs.getInt(4));

                        usuario.add(u);
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                    System.out.println(e.getStackTrace());
                    System.out.println("Error en la conexion! PersonalBD");


                }
            
            return usuario;
        }
        
        public void RegistrarUsuario(Usuario u)
        {
                String query="INSERT INTO musuario(username,pass,id_cusuario)"+
                                    "VALUES(?,?,?)";

                try
                {
                    c=con.getConnection();
                    ps=c.prepareStatement(query);


                        ps.setString(1,u.getUsername());
                        ps.setString(2,u.getPass());
                        ps.setInt(3,u.getId_tipousuario());
                        
                        ps.executeUpdate();
                        
                        System.out.println("Usuario registrado con exito");
                        
                        c.close();
                    
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                    System.out.println(e.getStackTrace());
                    System.out.println("Error en la conexion! UsuarioBD");


                }
        }
        
        public Usuario ListarPorID(int id_usuario)
        {
            String query="SELECT*FROM musuario WHERE id_empleado="+id_usuario;

            Usuario u=new Usuario();

            try
            {
                c=con.getConnection();
                ps=c.prepareStatement(query);
                rs=ps.executeQuery();

                while(rs.next())
                {
                    u.setId_usuario(rs.getInt(1));
                    u.setUsername(rs.getString(2));
                    u.setPass(rs.getString(3));
                    u.setId_tipousuario(rs.getInt(4));
                }

            }
            catch(Exception e)
            {

            }
            return u;
        }
        
        public void EliminarUsuario(int id_usuario)
        {
                 String query="DELETE FROM musuario WHERE id_usuario="+id_usuario;

            Usuario u=new Usuario();

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
        
        public void EditarUsaurio(Usuario u)
        {
                String query="UPDATE musuario SET username=?,pass=?,id_cusuario=? WHERE id_usuario=?";

                try
                {
                        c=con.getConnection();
                        ps=c.prepareStatement(query);

                        ps.setString(1,u.getUsername());
                        ps.setString(2,u.getPass());
                        ps.setInt(3,u.getId_tipousuario());
                        ps.setInt(4,u.getId_usuario());

                        ps.executeUpdate();


                }
                catch(Exception e)
                {
                        System.out.println(e.getMessage());
                        System.out.println(e.getStackTrace());
                }
        }
}
