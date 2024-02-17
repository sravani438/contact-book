package com.jspiders.contactbook;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

@Component
public class MyContactsDao {
	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("prasad") ;
	 EntityManager em = emf.createEntityManager() ;
	 EntityTransaction et = em.getTransaction() ;
	 
	 
     public void saveContact(MyContacts mc) {	 
    	 et.begin();
    	 em.persist(mc);
    	 et.commit();
     }
     
     public List<MyContacts> getAllContacts() {
    	
    	 
    	       Query q = em.createQuery("select c from MyContacts c", MyContacts.class ) ;
    	    List<MyContacts> contacts =  q.getResultList() ; 
    	    return contacts ;
     }
     
     public MyContacts getContactById(int id) {
    	 
    	 MyContacts mc = em.find(MyContacts.class, id) ;
    	 return mc ;
    	 
     }
    
     public void updateContact(MyContacts mc) {
    	
    	 et.begin();
    	 em.merge(mc) ;
    	 et.commit();
     }
     
     public void deleteContact(int id) {
    	 MyContacts mc = em.find(MyContacts.class, id) ;
    	 et.begin();
    	 em.remove(mc);
    	 et.commit();
     }  
}
