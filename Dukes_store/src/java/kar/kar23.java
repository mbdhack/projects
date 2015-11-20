/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kar;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author karthik
 */
@Stateful
public class kar23 {
    @PersistenceContext(type=PersistenceContextType.EXTENDED)
    private EntityManager em;
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

  public kar23()
  {
      em.createQuery("SELECT c FROM Category c");
  }
}
