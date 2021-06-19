<%-- 
    Document   : Vista
    Created on : 01/06/2021, 08:02:48 PM
    Author     : Microsoft
--%>

<%@page import="Vista.Presentador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="Estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div>
            <form action="Control" method="post">
                <% Presentador pre = (Presentador) session.getAttribute("pre"); %>
                <table>
                    <tr><th>Mantenimiento de Articulos</th></tr>
                </table>
                <% Object[] f = pre.getFil();%>
                <table>
                    <tr>
                        <td>Codigo</td><td><input type="text" name="cod" size="15" value="<%= f[0]%>"></td>
                    </tr>
                    <tr><td>Nombre</td><td><input type="text" name="nom" size="15" value="<%= f[1]%>"></td></tr>
                    <tr><td>Precio</td><td><input type="text" name="pre" size="15" value="<%= f[2]%>"></td></tr>
                    <tr><td>Stock</td><td><input type="text" name="stock" size="15" value="<%= f[3]%>"></td></tr>

                </table>
                <table>
                    <tr>
                        <td>
                            <input type="submit" name="acc" value="Grabar">
                            <input type="submit" name="acc" value="Actualizar">
                            <input type="submit" name="acc" value="Eliminar">
                            <input type="submit" name="acc" value="Buscar">
                            <input type="submit" name="acc" value="Listar">
                            <input type="submit" name="acc" value="Limpiar">
                        </td>
                    </tr>

                </table>

                <table>
                    <tr><th>Lista de Articulos</th></tr>
                </table>
                <table>
                    <tr>
                        <td>CODIGO:</td>
                        <td>NOMBRE:</td>
                        <td>PRECIO:</td>
                        <td>STOCK:</td>
                    </tr>

                    <% for (int i = 0; i < pre.getLista().size(); i++) { %>
                    <% Object[] fi1 = (Object[]) pre.getLista().get(i);%>

                    <tr>
                        <td><input type="text" size="5" value="<%= fi1[0]%>" name=""></td>
                        <td><input type="text" size="5" value="<%= fi1[1]%>" name=""></td>
                        <td><input type="text" size="5" value="<%= fi1[2]%>" name=""></td>
                        <td><input type="text" size="5" value="<%= fi1[3]%>" name=""></td>
                    </tr>

                    <% }%> 

                </table>
                    <%= pre.getMensaje() %>

            </form>
        </div>
    </body>
</html>
