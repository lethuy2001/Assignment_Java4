package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.boot.model.naming.ImplicitNameSource;

import Entities.User;
import Untils.JpaUntil;

public class UserDao {
     private EntityManager em ;
     
     public UserDao( ) {
    	 this.em = JpaUntil.getManager() ;
     }
     
     public User create( User entity ) {
    	 try {
			this.em.getTransaction().begin(); 
			this.em.persist(entity);
			this.em.getTransaction().commit(); 
			return entity ;
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			e.printStackTrace();
			throw e ;	
		}
     }
     
     public User findById( int id) {
    	 return this.em.find( User.class , id) ;
     }    
     
     public User findByEmail( String email ) {
    	 String sqp = "select o from User o where o.email = :email" ;
    	
    	 TypedQuery<User> query = this.em.createQuery(sqp, User.class) ;
    	 query.setParameter("email", email) ;
    	 return query.getSingleResult() ;
     } 
     
     public List<User> findAll(){
		 String jqplString = "Select o from User o" ;
		 TypedQuery< User> query2 = this.em.createQuery(jqplString , User.class) ;
		 
		 return query2.getResultList();
     }
     
     public User edit( User entity ) {
    	 try {
			this.em.getTransaction().begin(); 
			this.em.merge(entity);
			this.em.getTransaction().commit();
			return entity ;
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			e.printStackTrace();
			throw e ;
		}
     }
     
     public User delete( User entity ) {
    	 try {
			this.em.getTransaction().begin(); 
			this.em.remove(entity);
			this.em.getTransaction().commit();
			return entity ;
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			e.printStackTrace();
			throw e ;
		}
     }    
}
