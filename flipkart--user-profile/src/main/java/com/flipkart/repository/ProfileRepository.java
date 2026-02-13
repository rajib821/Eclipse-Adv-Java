package com.flipkart.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flipkart.entity.ProfileEntity;

@Repository
public class ProfileRepository {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public Integer submitProfile(ProfileEntity entity) {
		System.out.println("ProfileRepository.submitProfile().........start::");
		
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		Integer response = (Integer) session.save(entity);
		
		txn.commit();
		System.out.println("ProfileRepository.submitProfile()...........end:::");
		
		return response;
	}
	
	// This method gets all users from the database
	public List<ProfileEntity> getAllProfiles() {
	    Session session = sessionFactory.openSession();
	    List<ProfileEntity> list = session.createQuery("from ProfileEntity", ProfileEntity.class).getResultList();
	    session.close();
	    return list;
	}
	// update or edit profile
	
	public ProfileEntity getProfile(Integer id) {
		Session session = sessionFactory.openSession();
		ProfileEntity entity = session.get(ProfileEntity.class, id);
		session.close();
		return entity;	
	}
	
	public void editProfile(ProfileEntity entity) {
		
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		session.update(entity);
		txn.commit();
		session.close();
	}
	
	//delete
	
	public void deleteProfile(Integer id) {
	    Session session = sessionFactory.openSession();
	    Transaction tx = session.beginTransaction();

	    ProfileEntity entity = session.get(ProfileEntity.class, id);
	    if (entity != null) {
	        session.remove(entity);
	    }

	    tx.commit();
	    session.close();
	}


}
