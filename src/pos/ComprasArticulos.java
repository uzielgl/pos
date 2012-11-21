/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Uziel
 */
@Entity
@Table(name = "COMPRAS_ARTICULOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComprasArticulos.findAll", query = "SELECT c FROM ComprasArticulos c"),
    @NamedQuery(name = "ComprasArticulos.findByIdCompraArticulo", query = "SELECT c FROM ComprasArticulos c WHERE c.idCompraArticulo = :idCompraArticulo"),
    @NamedQuery(name = "ComprasArticulos.findByCantidad", query = "SELECT c FROM ComprasArticulos c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "ComprasArticulos.findByPrecioCompra", query = "SELECT c FROM ComprasArticulos c WHERE c.precioCompra = :precioCompra")})
public class ComprasArticulos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_COMPRA_ARTICULO")
    private Integer idCompraArticulo;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private int cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "PRECIO_COMPRA")
    private BigDecimal precioCompra;
    @JoinColumn(name = "ID_COMPRA", referencedColumnName = "ID_COMPRA")
    @ManyToOne(optional = false)
    private Compras idCompra;
    @JoinColumn(name = "ID_ARTICULO", referencedColumnName = "ID_ARTICULO")
    @ManyToOne(optional = false)
    private Articulos idArticulo;

    public ComprasArticulos() {
    }

    public ComprasArticulos(Integer idCompraArticulo) {
        this.idCompraArticulo = idCompraArticulo;
    }

    public ComprasArticulos(Integer idCompraArticulo, int cantidad, BigDecimal precioCompra) {
        this.idCompraArticulo = idCompraArticulo;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
    }

    public Integer getIdCompraArticulo() {
        return idCompraArticulo;
    }

    public void setIdCompraArticulo(Integer idCompraArticulo) {
        this.idCompraArticulo = idCompraArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Compras getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Compras idCompra) {
        this.idCompra = idCompra;
    }

    public Articulos getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Articulos idArticulo) {
        this.idArticulo = idArticulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompraArticulo != null ? idCompraArticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComprasArticulos)) {
            return false;
        }
        ComprasArticulos other = (ComprasArticulos) object;
        if ((this.idCompraArticulo == null && other.idCompraArticulo != null) || (this.idCompraArticulo != null && !this.idCompraArticulo.equals(other.idCompraArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pos.ComprasArticulos[ idCompraArticulo=" + idCompraArticulo + " ]";
    }
    
}
