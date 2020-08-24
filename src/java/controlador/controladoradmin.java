package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import modelo.Carrito;
import modelo.Personal;
import modelo.PersonalBD;
import modelo.Servicio;
import modelo.ServiciosBD;

public class controladoradmin extends HttpServlet {

    PersonalBD personalbd=new PersonalBD();
    Personal p=new Personal();
    List<Personal> per=new ArrayList<>();
    
    ServiciosBD serviciobd=new ServiciosBD();
    Servicio s=new Servicio();
    List<Servicio> ser=new ArrayList<>();
    
    int id_emp;
    int id_serv;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion=request.getParameter("accion");
        
        per=personalbd.ListarPersonal();
        ser=serviciobd.ListarServicios();
        
        switch(accion)
                {
            
        //PERSONAL
            
            case "Agregar":
                            request.getRequestDispatcher("RegistrarPersonal.jsp").forward(request, response);
                        break;
                        
            case "Listar":
                request.setAttribute("personal", per);
                request.getRequestDispatcher("ListarPersonal.jsp").forward(request, response);
            break;
            
            case "Registrar":
                            String nombre,apat,amat;

                                nombre=request.getParameter("nombreemp");
                                apat=request.getParameter("apatemp");
                                amat=request.getParameter("amatemp");
                                int temp=Integer.parseInt(request.getParameter("tipoemp"));

                                
                                p.setNombre_emp(nombre);
                                p.setApat_emp(apat);
                                p.setAmat_emp(amat);
                                p.setId_tipoemp(temp);
                                
                                personalbd.RegistrarEmpleado(p);
                                
                                per=personalbd.ListarPersonal();
                                
                                request.setAttribute("personal", per);
                                request.getRequestDispatcher("ListarPersonal.jsp").forward(request, response);
                     
                        break;
                        
                        case "EditarEmpleado":                                
                                request.setAttribute("srvid_emp", request.getParameter("id_emp"));
                                
                                request.getRequestDispatcher("EditarEmpleado.jsp").forward(request, response);
                        break;
                        
                        case "Actualizar":
                                id_emp=Integer.parseInt(request.getParameter("txtid"));
                                nombre=request.getParameter("nombreemp");
                                apat=request.getParameter("apatemp");
                                amat=request.getParameter("amatemp");
                                temp=Integer.parseInt(request.getParameter("tipoemp"));

                                p.setId_emp(id_emp);
                                p.setNombre_emp(nombre);
                                p.setApat_emp(apat);
                                p.setAmat_emp(amat);
                                p.setId_tipoemp(temp);
                                
                                personalbd.EditarEmpleado(p);
                                
                                per=personalbd.ListarPersonal();
                                
                                request.setAttribute("personal", per);
                                request.getRequestDispatcher("ListarPersonal.jsp").forward(request, response);
                        break;
                        
                        case "EliminarEmpleado":
                                id_emp=Integer.parseInt(request.getParameter("id_emp"));

                                personalbd.EliminarEmpleado(id_emp);

                                per=personalbd.ListarPersonal();
                                
                                request.setAttribute("personal", per);
                                request.getRequestDispatcher("ListarPersonal.jsp").forward(request, response);
                        break;
                        
                //FIN PERSONAL
                        
                //SERVICIOS
                        case "AgregarServicio":
                            request.getRequestDispatcher("RegistrarServicio.jsp").forward(request, response);
                        break;
                        
                         case "ListarServicios":
                                request.setAttribute("servicio", ser);
                                request.getRequestDispatcher("ListarServicios.jsp").forward(request, response);
                        break;
                        
                        case "RegistrarServicio":
                            String nombres,descs;

                                nombres=request.getParameter("nombreserv");
                                descs=request.getParameter("descserv");
                                int tiempos=Integer.parseInt(request.getParameter("tiemposerv"));
                                double costos=Double.parseDouble(request.getParameter("costoserv"));
                                int tipos=Integer.parseInt(request.getParameter("tiposerv"));

                                
                                s.setNombre_serv(nombres);
                                s.setDesc_serv(descs);
                                s.setTiempo_serv(tiempos);
                                s.setCosto_serv(costos);
                                s.setTipo_serv(tipos);
                                
                                serviciobd.RegistrarServicio(s);
                                
                                ser=serviciobd.ListarServicios();
                                
                                request.setAttribute("servicio", ser);
                                request.getRequestDispatcher("ListarServicios.jsp").forward(request, response);
                     
                        break;
                        
                        case "EditarServicio":                                
                                request.setAttribute("srvid_serv", request.getParameter("id_serv"));
                                
                                request.getRequestDispatcher("EditarServicio.jsp").forward(request, response);
                        break;
                        
                        case "ActualizarServicio":
                                id_serv=Integer.parseInt(request.getParameter("txtidserv"));
                                nombres=request.getParameter("nombreserv");
                                descs=request.getParameter("descserv");
                                tiempos=Integer.parseInt(request.getParameter("tiemposerv"));
                                costos=Double.parseDouble(request.getParameter("costoserv"));
                                tipos=Integer.parseInt(request.getParameter("tiposerv"));

                                s.setId_serv(id_serv);
                                s.setNombre_serv(nombres);
                                s.setDesc_serv(descs);
                                s.setTiempo_serv(tiempos);
                                s.setCosto_serv(costos);
                                s.setTipo_serv(tipos);
                                
                                serviciobd.EditarServicio(s);
                                
                                ser=serviciobd.ListarServicios();
                                
                                request.setAttribute("servicio", ser);
                                request.getRequestDispatcher("ListarServicios.jsp").forward(request, response);
                        break;
                        
                        case "EliminarServicio":
                                id_serv=Integer.parseInt(request.getParameter("id_serv"));

                                serviciobd.EliminarServicio(id_serv);

                                ser=serviciobd.ListarServicios();
                                
                                request.setAttribute("servicio", ser);
                                request.getRequestDispatcher("ListarServicios.jsp").forward(request, response);
                        break;
                //FIN SERVICIOS
                        
                        default:
                            request.setAttribute("personal", per);
                            request.getRequestDispatcher("ListarPersonal.jsp").forward(request, response);
                        break;
                }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
                
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controladoradmin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controladoradmin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
