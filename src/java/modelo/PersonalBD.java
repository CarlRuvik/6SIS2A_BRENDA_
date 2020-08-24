package modelo;

import configuracion.CONEXION;
import java.sql.*;
import java.util.*;


public class PersonalBD 
{
        Connection c;
        CONEXION con=new CONEXION();
        PreparedStatement ps;
        ResultSet rs;
        
        public List ListarPersonal()
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
        }
        
        public void RegistrarEmpleado(Personal p)
        {
                String query="INSERT INTO mempleado(id_empleado,nombre_emp,apat_emp,amat_emp,id_cemp)"+
                                    "VALUES(?,?,?,?,?)";

                try
                {
                    c=con.getConnection();
                    ps=c.prepareStatement(query);


                        ps.setInt(1,p.getId_emp());
                        ps.setString(2,p.getNombre_emp());
                        ps.setString(3,p.getApat_emp());
                        ps.setString(4,p.getAmat_emp());
                        ps.setInt(5,p.getId_tipoemp());
                        
                        ps.executeUpdate();
                        
                        System.out.println("Empleado registrado con exito");
                        
                        c.close();
                    
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                    System.out.println(e.getStackTrace());
                    System.out.println("Error en la conexion! PersonalBD");


                }
        }
        
        public Personal ListarPorID(int id_emp)
        {
            String query="SELECT*FROM mempleado WHERE id_empleado="+id_emp;

            Personal p=new Personal();

            try
            {
                c=con.getConnection();
                ps=c.prepareStatement(query);
                rs=ps.executeQuery();

                while(rs.next())
                {
                    p.setId_emp(rs.getInt(1));
                    p.setNombre_emp(rs.getString(2));
                    p.setApat_emp(rs.getString(3));
                    p.setAmat_emp(rs.getString(4));
                    p.setId_tipoemp(rs.getInt(5));
                }

            }
            catch(Exception e)
            {

            }
            return p;
        }
        
        public void EliminarEmpleado(int id_emp)
        {
                 String query="DELETE FROM mempleado WHERE id_empleado="+id_emp;

            Personal p=new Personal();

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
        
        public void EditarEmpleado(Personal p)
        {
                String query="UPDATE mempleado SET nombre_emp=?,apat_emp=?,amat_emp=?,id_cemp=? WHERE id_empleado=?";

                try
                {
                        c=con.getConnection();
                        ps=c.prepareStatement(query);

                        ps.setString(1,p.getNombre_emp());
                        ps.setString(2,p.getApat_emp());
                        ps.setString(3,p.getAmat_emp());
                        ps.setInt(4,p.getId_tipoemp());
                        ps.setInt(5,p.getId_emp());

                        ps.executeUpdate();


                }
                catch(Exception e)
                {
                        System.out.println(e.getMessage());
                        System.out.println(e.getStackTrace());
                }
        }
}
