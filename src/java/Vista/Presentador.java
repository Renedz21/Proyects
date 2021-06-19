package Vista;

import java.util.ArrayList;
import java.util.List;

public class Presentador {
    private String mensaje = "";
    private Object[]fil={"","","",""};
    private List lista = new ArrayList();

    public Presentador() {
        lista.add(fil);
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object[] getFil() {
        return fil;
    }

    public void setFil(Object[] fil) {
        this.fil = fil;
    }

    public List getLista() {
        return lista;
    }

    public void setLista(List lista) {
        this.lista = lista;
    }
    
    
    
}
