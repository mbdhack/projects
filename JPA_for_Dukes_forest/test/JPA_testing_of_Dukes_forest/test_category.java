/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA_testing_of_Dukes_forest;

import Entities.Category;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author karthik
 */
public class test_category {
    
    public test_category() {
    }
    @Test
    public void category_test()
    {
        Category c=new Category();
        EntityManagerFactory entityManagerFactory =
  Persistence.createEntityManagerFactory("JPA_for_Dukes_forestPU");
  EntityManager em = entityManagerFactory.createEntityManager();
  Query q=em.createNamedQuery("Category.findAll");
  List<Category> r=q.getResultList();
  Iterator<Category> i=r.iterator();
  while(i.hasNext())
  {
      Category c1=i.next();
      System.out.println(c1.getId()+" "+c1.getName());
  }
  
  
  
        
    }
    
}
