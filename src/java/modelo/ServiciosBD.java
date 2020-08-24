package modelo;

import configuracion.CONEXION;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.http.HttpServletResponse;

public class ServiciosBD 
{
    Connection c;
    CONEXION con=new CONEXION();
    PreparedStatement ps;
    ResultSet rs;
    
    public List ListarServicios()
    {
        List<Servicio> servicio=new ArrayList();
        
        String query="SELECT*FROM mservicio";
        
        try
        {
            c=con.getConnection();
            ps=c.prepareStatement(query);
            rs=ps.executeQuery();
            
            while(rs.next())
            {
                Servicio s=new Servicio();
                
                s.setId_serv(rs.getInt(1));
                s.setNombre_serv(rs.getString(2));
                s.setDesc_serv(rs.getString(3));
                s.setTiempo_serv(rs.getInt(4));
                s.setCosto_serv(rs.getDouble(5));
                s.setImg_serv(rs.getBinaryStream(6));
                
                servicio.add(s);
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            System.out.println("Error en la conexion!");

            
        }
        
        return servicio;
    }
    
    public Servicio ListarPorID(int id_serv)
    {
        String query="SELECT*FROM mservicio WHERE id_servicio="+id_serv;
        
        Servicio s=new Servicio();
        
        try
        {
            c=con.getConnection();
            ps=c.prepareStatement(query);
            rs=ps.executeQuery();
            
            while(rs.next())
            {
                s.setId_serv(rs.getInt(1));
                s.setNombre_serv(rs.getString(2));
                s.setDesc_serv(rs.getString(3));
                s.setTiempo_serv(rs.getInt(4));
                s.setCosto_serv(rs.getDouble(5));
                s.setImg_serv(rs.getBinaryStream(6));
            }
            
        }
        catch(Exception e)
        {
            
        }
        return s;
    }
    
    public void RegistrarServicio(Servicio s)
        {
                String query="INSERT INTO mservicio(servicio,desc_serv,tiempo_serv,costo,id_cservicio)"+
                                    "VALUES(?,?,?,?,?)";

                try
                {
                    c=con.getConnection();
                    ps=c.prepareStatement(query);


                        ps.setString(1,s.getNombre_serv());
                        ps.setString(2,s.getDesc_serv());
                        ps.setInt(3,s.getTiempo_serv());
                        ps.setDouble(4,s.getCosto_serv());
                        ps.setInt(5,s.getTipo_serv());
                        
                        ps.executeUpdate();
                        
                        System.out.println("Servicio registrado con exito");
                        
                        c.close();
                    
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                    System.out.println(e.getStackTrace());
                    System.out.println("Error en la conexion! ServicioBD");


                }
        }
    
        public void EliminarServicio(int id_serv)
        {
                 String query="DELETE FROM mservicio WHERE id_servicio="+id_serv;

            Servicio s=new Servicio();

            try
            {
                c=con.getConnection();
                ps=c.prepareStatement(query);
 
                ps.executeUpdate();
                

            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            }
        }
        
        public void EditarServicio(Servicio s)
        {
                String query="UPDATE mservicio SET servicio=?,desc_serv=?,tiempo_serv=?,costo=?, id_cservicio=? WHERE id_servicio=?";

                try
                {
                        c=con.getConnection();
                        ps=c.prepareStatement(query);

                        ps.setString(1,s.getNombre_serv());
                        ps.setString(2,s.getDesc_serv());
                        ps.setInt(3,s.getTiempo_serv());
                        ps.setDouble(4,s.getCosto_serv());
                        ps.setInt(5,s.getTipo_serv());
                        ps.setInt(6,s.getId_serv());

                        ps.executeUpdate();


                }
                catch(Exception e)
                {
                        System.out.println(e.getMessage());
                        System.out.println(e.getStackTrace());
                }
        }
    
    
    public void ListarImg(int id_serv, HttpServletResponse response)
    {
        InputStream inputStream=null;
        OutputStream outputStream=null;
        BufferedInputStream bufferedInputStream=null;
        BufferedOutputStream bufferedOutputStream=null;

        String query="SELECT*FROM mservicio WHERE id_servicio="+id_serv;
        
        try
        {
            outputStream=response.getOutputStream();
            
            c=con.getConnection();
            ps=c.prepareStatement(query);
            rs=ps.executeQuery();
            
            if(rs.next())
            {
                inputStream=rs.getBinaryStream("img_serv");
            }
            bufferedInputStream=new BufferedInputStream(inputStream);
            bufferedOutputStream=new BufferedOutputStream(outputStream);
            int r=0;
            
            while((r=bufferedInputStream.read())!=-1)
            {
                bufferedOutputStream.write(r);
            }
        }
        catch(Exception e)
        {
             System.out.println("Error al cargar la imagen!");
             System.out.println(e.getMessage());
             System.out.println(e.getStackTrace());
        }
    }
}
