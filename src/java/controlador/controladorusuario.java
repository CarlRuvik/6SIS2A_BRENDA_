package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;
import modelo.UsuarioBD;

public class controladorusuario extends HttpServlet {
    
    UsuarioBD ubd=new UsuarioBD();
    Usuario u=new Usuario();
    
    int resultado;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                String accion=request.getParameter("accion");

                switch(accion)
                {
                    case "IniciarSesion":
                        String user,pass;
                        
                        user=request.getParameter("txtuser");
                        pass=request.getParameter("txtpass");
                        
                        u.setUsername(user);
                        u.setPass(pass);
                        
                        ubd.ValidarUsuario(u);
                        
                        if(ubd!=null)
                        {
                                HttpSession sesion=request.getSession(true);
                                sesion.setAttribute("Usuario", u);
                                
                                HttpSession sesionOK=request.getSession();
                                sesionOK.setAttribute("whoareyou", user);
                                
                                if(u.getId_tipousuario()==1)//1 entonces el usuario es administrador
                                {
                                    response.sendRedirect("ListarServicios.jsp");
                                }
                                else if(u.getId_tipousuario()==2)//2 entonces el usuario es estilista
                                        {
                                            response.sendRedirect("Estilista.jsp");
                                        }
                                else if(u.getId_tipousuario()==3)//3 entonces el usuario es cliente
                                        {
                                            response.sendRedirect("Servicios.jsp");
                                        }
                        }
                        else//Si el usuario no existe o la contraseña es erronea
                        {
                            response.sendRedirect("Error.jsp");
                        }               
                        
                    break;
                    
                }
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controladorusuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controladorusuario at " + request.getContextPath() + "</h1>");
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
