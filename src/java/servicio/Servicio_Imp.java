package servicio;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Servicio_Imp implements Servicio{
    private Articulo_DAO artdao;

    public Servicio_Imp() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Proyecto_ArticuloPU");
        artdao = new Articulo_DAO(emf);
    }
    

    @Override
    public String Grabar(String codigo, String nombre, String precio, String stock) {
        String msg;
        Articulo art = new Articulo(codigo,nombre, Double.parseDouble(precio), Integer.parseInt(stock));
        try{
            artdao.create(art);
            msg = "Articulo Grabado";
        
        }catch(Exception e){
        msg = e.getMessage();
        }
        
        
        return msg;
    }

    @Override
    public String Actualizar(String codigo, String nombre, String precio, String stock) {
        String msg;
        Articulo art = new Articulo(codigo,nombre, Double.parseDouble(precio), Integer.parseInt(stock));
        try{
            artdao.edit(art);
            msg = "Articulo Actualizado";
        
        }catch(Exception e){
        msg = e.getMessage();
        }
        
        
        return msg;
    }

    @Override
    public String Eliminar(String codigo) {
        
        String msg;
        try{
            artdao.destroy(codigo);
            msg = "Articulo Eliminado";
        
        }catch(Exception e){
        msg = e.getMessage();
        }
        
        
        return msg;
        
        
    }

    @Override
    public Object[] Buscar(String codigo) {
        
       Articulo art  = artdao.findArticulo(codigo);
        if (art != null) {
            Object[] fila = new Object[4];
            fila[0] = art.getCodArt();
            fila[1] = art.getNombre();
            fila[2] = art.getPrecio();
            fila[3] = art.getStock();
            return fila;
            
        }
       return null;
        
    }

    @Override
    public List Listar() {
        List lista = new ArrayList();
        List lis = artdao.findArticuloEntities();
        for (int i = 0; i < lis.size(); i++) {
            Articulo art = (Articulo)lis.get(i);
             Object[] fila = new Object[4];
            fila[0] = art.getCodArt();
            fila[1] = art.getNombre();
            fila[2] = art.getPrecio();
            fila[3] = art.getStock();
            lista.add(fila);
        }
        
        return lista;
    }
    
}
