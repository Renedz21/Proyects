package servicio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "ARTICULO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a")
    , @NamedQuery(name = "Articulo.findByCodArt", query = "SELECT a FROM Articulo a WHERE a.codArt = :codArt")
    , @NamedQuery(name = "Articulo.findByNombre", query = "SELECT a FROM Articulo a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Articulo.findByPrecio", query = "SELECT a FROM Articulo a WHERE a.precio = :precio")
    , @NamedQuery(name = "Articulo.findByStock", query = "SELECT a FROM Articulo a WHERE a.stock = :stock")})
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_ART")
    private String codArt;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO")
    private Double precio;
    @Column(name = "STOCK")
    private Integer stock;

    public Articulo() {
    }

    public Articulo(String codArt, String nombre, Double precio, Integer stock) {
        this.codArt = codArt;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    
    

    public Articulo(String codArt) {
        this.codArt = codArt;
    }

    public Articulo(String codArt, String nombre) {
        this.codArt = codArt;
        this.nombre = nombre;
    }

    public String getCodArt() {
        return codArt;
    }

    public void setCodArt(String codArt) {
        this.codArt = codArt;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codArt != null ? codArt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.codArt == null && other.codArt != null) || (this.codArt != null && !this.codArt.equals(other.codArt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "servicio.Articulo[ codArt=" + codArt + " ]";
    }
    
}
