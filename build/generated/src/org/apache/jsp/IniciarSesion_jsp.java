package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class IniciarSesion_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Registrar empleado</title>\n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("                function aver()\n");
      out.write("                {\n");
      out.write("                    var id;                     \n");
      out.write("                    var t=document.getElementById(\"temp\");\n");
      out.write("                    var tipo=t.options[t.selectedIndex].text;\n");
      out.write("                    \n");
      out.write("                    if(tipo==\"Administrador\")\n");
      out.write("                    {\n");
      out.write("                        id=1;\n");
      out.write("                    }\n");
      out.write("                    else if(tipo==\"Estilista\")\n");
      out.write("                    {\n");
      out.write("                        id=2;\n");
      out.write("                    }\n");
      out.write("                    \n");
      out.write("                        document.getElementById(\"txttemp\").value=parseInt(id);\n");
      out.write("                }\n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/CAR.css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/style.css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"TODO\">\n");
      out.write("            <div class=\"RIGHT\">\n");
      out.write("                <div class=\"LOGO\">\n");
      out.write("                    <a href=\"controlador?accion=inicio\"><img src=\"Img/LOGO.png\" width=\"100\" height=\"120\"></a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div class=\"MIDDLE\">\n");
      out.write("                <div class=\"MENU\">\n");
      out.write("                    <a class=\"B\" href=\"controlador?accion=default\">Personal</a>\n");
      out.write("                    <a class=\"B\" href=\"controlador?accion=servicios\">Servicios</a>\n");
      out.write("                    <a class=\"B\" href=\"../Html/AGENDAR_CITA.html\">Citas</a>\n");
      out.write("                    <a class=\"B\" href=\"../Html/SUCURSALES.html\">Sucursales</a>\n");
      out.write("                    <a class=\"B\" href=\"../Html/PERFIL.html\">Mi cuenta</a>\n");
      out.write("                </div>\n");
      out.write("                <form action=\"index.jsp\" >\n");
      out.write("                        <div class=\"CONTENEDOR\">\n");
      out.write("                            <div class=\"COMPRA\">\n");
      out.write("                                <div>\n");
      out.write("                                    <img src=\"Img/USER.png\" alt=\"\" width=\"100\" height=\"100\"/>\n");
      out.write("                                    <br>\n");
      out.write("                                    <label>Iniciar sesión</label>\n");
      out.write("                                </div>\n");
      out.write("                                <div>\n");
      out.write("                                      \n");
      out.write("                                        <h2>Nombre de usuario:</h2>\n");
      out.write("                                        <input type=\"text\" name=\"txtuser\" placeholder=\":3\"/>\n");
      out.write("                                        \n");
      out.write("                                        <h2>Contraseña:</h2>\n");
      out.write("                                        <input type=\"password\" name=\"txtpass\" placeholder=\"Nueva contraseña.\"/>\n");
      out.write("                                        <br><br>\n");
      out.write("                                        <input type=\"submit\" name=\"accion\" value=\"IniciarSesion\"/>                                       \n");
      out.write("                                </div>                               \n");
      out.write("                            </div>  \n");
      out.write("                        </div>\n");
      out.write("                </form>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div class=\"LEFT\">\n");
      out.write("                </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("   <script src=\"https://code.jquery.com/jquery-3.1.1.min.js\"></script>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
