
import Entities.Category;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author karthik
 */

public class test1 {
    
    public static void main(String[] args){
     EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPA_for_Dukes_forestPU" );
     EntityManager entitymanager = emfactory.createEntityManager();
    Query query = entitymanager.createNamedQuery("Category.findAll");
    List l=query.getResultList();
    Iterator i=l.iterator();
    while(i.hasNext())
    {
        Category u=(Category) i.next();
        System.out.println(u.getName());
    }
    
    }
    
}
