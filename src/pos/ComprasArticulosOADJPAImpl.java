/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;
import java.math.BigDecimal;
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
public class ComprasArticulosOADJPAImpl implements ComprasArticulosOAD{
    private EntityManagerFactory emf;

    public ComprasArticulosOADJPAImpl() {
        this.emf = Persistence.createEntityManagerFactory("posPU");
    }
    
    @Override
    
    public void agregarComprasArticulos(ComprasArticulos detalleCompra){
        
        EntityManager em = this.emf.createEntityManager();
        
            em.getTransaction().begin();
            em.persist(detalleCompra);
            em.getTransaction().commit();
            em.close();
    }
}
