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
import modelo.Servicio;
import modelo.ServiciosBD;

public class controlador extends HttpServlet {

    ServiciosBD servBD=new ServiciosBD();
    Servicio s=new Servicio();
    
    List<Servicio> servicio=new ArrayList<>();
    List<Carrito> listaCarrito=new ArrayList<>();
    
    int item;
    double pago_total=0.0;
    int id_serv;
    int tiempo_total=0;
    Carrito carrito;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion=request.getParameter("accion");
        
        servicio=servBD.ListarServicios();
        
        switch(accion)
                {
                    case "inicio":
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                    
                    case "AgregarCarrito":
                       int id_serv=Integer.parseInt(request.getParameter("id_serv"));
                       s=servBD.ListarPorID(id_serv);
                       
                       item=item+1;//Realiza la sumatoria de los servicios agregados al carrito
                       
                       Carrito carrito=new Carrito();
                       carrito.setItem(item);
                       carrito.setId_serv(s.getId_serv());
                       carrito.setNombre_serv(s.getNombre_serv());
                       carrito.setDesc_serv(s.getDesc_serv());
                       carrito.setTiempo(s.getTiempo_serv());
                       carrito.setCosto_serv(s.getCosto_serv());
                       
                       listaCarrito.add(carrito);
                       
                       request.setAttribute("contadorCarrito", listaCarrito.size());
                       request.getRequestDispatcher("controlador?accion=default").forward(request, response);
                    break;
                    
                    case "EliminardelCarrito":
                        id_serv=Integer.parseInt(request.getParameter("id_serv"));
                        
                        for(int i=0 ; i<listaCarrito.size() ; i++)
                        {
                            if((listaCarrito.get(i).getId_serv())==id_serv)
                            {
                                listaCarrito.remove(i);
                            }
                        }
                        
                        request.getRequestDispatcher("controlador?accion=Carrito").forward(request, response);
                    break;
                    
                    case "Carrito":
                        pago_total=0.0;
                        tiempo_total=0;
                        
                        request.setAttribute("carrito", listaCarrito);
                        for(int i=0 ; i<listaCarrito.size() ; i++)
                        {
                            pago_total=pago_total+listaCarrito.get(i).getCosto_serv();
                            tiempo_total=(tiempo_total+listaCarrito.get(i).getTiempo());
                        }
                        
                        
                        request.setAttribute("pago_total", pago_total);
                        request.getRequestDispatcher("Carrito.jsp").forward(request, response);
                    break;
                    
                    case "ReservarCita":
                       id_serv=Integer.parseInt(request.getParameter("id_serv"));
                       s=servBD.ListarPorID(id_serv);
                       
                       item=item+1;//Realiza la sumatoria de los servicios agregados al carrito
                       
                       carrito=new Carrito();
                       carrito.setItem(item);
                       carrito.setId_serv(s.getId_serv());
                       carrito.setNombre_serv(s.getNombre_serv());
                       carrito.setDesc_serv(s.getDesc_serv());
                       carrito.setTiempo(s.getTiempo_serv());
                       carrito.setCosto_serv(s.getCosto_serv());
                       
                       listaCarrito.add(carrito);
                       
                       for(int i=0 ; i<listaCarrito.size() ; i++)
                        {
                            pago_total=pago_total+listaCarrito.get(i).getCosto_serv();
                            tiempo_total=tiempo_total+listaCarrito.get(i).getTiempo();
                        }
                       
                       request.setAttribute("pago_total", pago_total);
                       request.setAttribute("carrito", listaCarrito);
                       request.setAttribute("contadorCarrito", listaCarrito.size());
                       request.getRequestDispatcher("Carrito.jsp").forward(request, response);
                    break;
                    
                    case "ProcederCita":
                                               
                        request.setAttribute("pago_total", pago_total);
                        request.setAttribute("tiempo_total", tiempo_total);
                        request.setAttribute("carrito", listaCarrito);   
                        request.setAttribute("contadorCarrito", listaCarrito.size());
                        request.getRequestDispatcher("Cita.jsp").forward(request, response);
                    break;
                    
                    
                    default:
                        request.setAttribute("servicios", servicio);
                        request.setAttribute("contadorCarrito", listaCarrito.size());
                        request.getRequestDispatcher("Servicios.jsp").forward(request, response);
                    break;
                }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
           //**********
                        
                       
            

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
