package com.blinkit.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blinkit.entity.ProfileEntity;

@Repository
public class ProfileRepository {

	@Autowired
	SessionFactory sessionFactory;

	public Integer saveProfile(ProfileEntity profileEntity) {
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		Integer response = (Integer) session.save(profileEntity);
		txn.commit();
		session.close();
		return response;
	}

	//email fetching
	public ProfileEntity getProfileFromMail(String _email) {
		Session session = sessionFactory.openSession();
		
		String hql = "from ProfileEntity where email = :email";
		ProfileEntity entity = session.createQuery(hql,ProfileEntity.class).setParameter("email", _email).uniqueResult();
		session.close();
		return entity;
	}
	
	public List<ProfileEntity> getAllUsers() {
		Session session = sessionFactory.openSession();
		List<ProfileEntity> list = session.createQuery("from ProfileEntity", ProfileEntity.class ).getResultList();
		return list;
	}
}
