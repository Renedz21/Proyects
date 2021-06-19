package servicio;

import java.util.List;

public interface Servicio {
    
    public String Grabar(String codigo, String nombre, String precio, String stock);
    public String Actualizar(String codigo, String nombre, String precio, String stock);
    public String Eliminar(String codigo);
    public Object[] Buscar(String codigo);
    public List Listar();
    
}
