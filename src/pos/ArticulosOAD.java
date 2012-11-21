/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;
import java.util.List;

/**
 *
 * @author Uziel
 */
public interface ArticulosOAD {
    
    void agregarArticulo(Articulos articulo);

    Articulos consultarArticulo(int idArticulo);
    
    void editarArticulo(Articulos articulo);
    
    void eliminarArticulo(int idArticulos);
}

