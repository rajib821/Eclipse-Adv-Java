package com.ecommerce.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.ProfileEntity;

@Repository
public class ProfileRepository {

	@Autowired
	SessionFactory sessionFactory;
	
	public Integer submitProfile(ProfileEntity entity) {
		System.out.println("ProfileRepository.submitProfile().......start().");
		Session session = sessionFactory.openSession();   // A Hibernate Session object is created
		Transaction txn = session.beginTransaction(); 	// if any problem happens then rollback occur
		Integer id = (Integer) session.save(entity);
		txn.commit();
		
		System.out.println("ProfileRepository.submitProfile().....   end()..id :- "+id);
		return id;
		
	}
	
	
	public ProfileEntity getProfileByEmail(String _email){
		Session session = sessionFactory.openSession();
		
		String hql = "from ProfileEntity e where e.email = :email";
		ProfileEntity entity = session.createQuery(hql, ProfileEntity.class).setParameter("email", _email).uniqueResult();
		session.close();
		return entity;
		
	}
	
	


	
	//show all users
//	public List<ProfileEntity> getAllProfile(){
//		Session session = sessionFactory.openSession();
//		List<ProfileEntity> list = session.createQuery("from ProfileEntity", ProfileEntity.class).getResultList();
//		session.close();
//		return list;
//		
//	}
	
	
	
//	//update or edit profile
//	public ProfileEntity getProfile(Integer id) {
//		Session session = sessionFactory.openSession();
//		ProfileEntity entity = session.get(ProfileEntity.class, id);
//		session.close();
//		return entity;
//	}
//	
//	public void editProfile(ProfileEntity entity) {
//		Session session = sessionFactory.openSession();
//		Transaction txn = session.beginTransaction();
//		session.save(entity);
//		txn.commit();
//		session.close();
//	}
	
//	// Soft delete
//	public void softDelete(Integer id) {
//	    Session session = sessionFactory.openSession();
//	    Transaction txn = session.beginTransaction();
//
//	    ProfileEntity entity = session.get(ProfileEntity.class, id);
//
//	    if (entity != null && !entity.isDeleted()) {
//	        entity.setDeleted(true);
//	        session.update(entity);
//	    }
//
//	    txn.commit();
//	    session.close();
//	}


}
