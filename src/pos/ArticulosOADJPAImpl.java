/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Uziel
 */
public class ArticulosOADJPAImpl implements ArticulosOAD {
    
    /*
    public static void main(String[] args) {
        ArticulosOADJPAImpl aOAD = new ArticulosOADJPAImpl();
        Articulos arti = new Articulos();
        aOAD.agregarArticulo(arti);
        //aOAD.eliminarArticulo(1);
    }*/
    
    private EntityManagerFactory emf;

    public ArticulosOADJPAImpl() {
        this.emf = Persistence.createEntityManagerFactory("posPU");
    }
    
    @Override
    public void agregarArticulo(Articulos articulo){
    
        EntityManager em = this.emf.createEntityManager();
        
        em.getTransaction().begin();
        boolean palExistente = em.createQuery("SELECT a FROM Articulos a WHERE a.nombre = 'articulo2'")
                //.setParameter("ltrs", palabra.getLetras())
                .getResultList().size() > 0;
        if (true) {
            em.persist(articulo);
            em.getTransaction().commit();
            em.close();
        }
        
    }
    
    @Override
     public Articulos consultarArticulo(int idArticulo){
         EntityManager em = this.emf.createEntityManager();
        return em.find(Articulos.class, idArticulo);
    }
    
   
    @Override
    public void editarArticulo(Articulos articulos){}
    
    
    @Override
    public void eliminarArticulo(int idsArticulos){
         
    }
}
