
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
public class ComprasOADJPAImpl implements ComprasOAD {
    
   
    
    private EntityManagerFactory emf;

    public ComprasOADJPAImpl() {
        this.emf = Persistence.createEntityManagerFactory("posPU");
    }
    
    @Override
    public void agregarCompra(Compras compra){
        EntityManager em = this.emf.createEntityManager();
        
            em.getTransaction().begin();
            em.persist(compra);
            em.getTransaction().commit();
            em.close();
    }
    
}