package Vista;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servicio.*;


@WebServlet(name = "Control", urlPatterns = {"/Control"})
public class Control extends HttpServlet {
    private Presentador pre;
    private Servicio ser;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("acc");
        if (accion.equals("Gestion de articulos")) {
            pre = new Presentador();
            ser = new Servicio_Imp();
            request.getSession().setAttribute("pre", pre);
        }
        
        if (accion.equals("Grabar")) {
            String codigo = request.getParameter("cod");
            String nombre = request.getParameter("nom");
            String prec = request.getParameter("pre");
            String stock = request.getParameter("stock");
            pre.setMensaje(ser.Grabar(codigo, nombre, prec, stock));
        
        }
        if (accion.equals("Actualizar")) {
            String codigo = request.getParameter("cod");
            String nombre = request.getParameter("nom");
            String prec = request.getParameter("pre");
            String stock = request.getParameter("stock");
            pre.setMensaje(ser.Actualizar(codigo, nombre, prec, stock));
        }
        if (accion.equals("Eliminar")) {
            String codigo = request.getParameter("cod");
            pre.setMensaje(ser.Eliminar(codigo));
        }
        if (accion.equals("Buscar")) {
            String codigo = request.getParameter("cod");
            Object[]fila = ser.Buscar(codigo);
            if (fila != null) {
                pre.setFil(fila);
            }else{
                pre.setMensaje("Articulo no existe");
            }
        }
        if (accion.equals("Listar")) {
            pre.setLista(ser.Listar());
        }
        if (accion.equals("Limpiar")) {
            pre.setMensaje("");
            Object[]fila = {"","","",""};
            pre.setFil(fila);
            List lis = new ArrayList();
            lis.add(fila);
            pre.setLista(lis);
        }
               
        response.sendRedirect("Vista.jsp");
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
