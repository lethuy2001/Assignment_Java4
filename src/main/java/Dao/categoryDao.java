package Dao;

import javax.persistence.EntityManager;

import Entities.Category;
import Entities.User;
import Untils.JpaUntil;

public class categoryDao {
	private EntityManager em ;
	
	public categoryDao() {
		this.em = JpaUntil.getManager() ;
	}
	
	public Category create( Category entity) {
		try {
			this.em.getTransaction().begin();
			this.em.persist(entity);
			this.em.getTransaction().commit();
			return entity ;
		} catch (Exception e) {
			e.printStackTrace();
			this.em.getTransaction().rollback();
			throw e ;
		}
	}
}
