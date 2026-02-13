package com.blinkit.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blinkit.entity.UserEntity;

@Repository
public class UserRepository {
	@Autowired
	SessionFactory sessionFactory;
	
	public void saveProfile(UserEntity userEntity) {
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		session.save(userEntity);
		txn.commit();
		session.close();
		
	}
	
	public UserEntity getProfileFromEmail(String _email) {
		Session session = sessionFactory.openSession();
		String hql = "from UserEntity where email = :email";
		UserEntity entity = session.createQuery(hql, UserEntity.class).setParameter("email", _email).uniqueResult();
		
		session.close();
		return entity;
		
	}
	// view all profile
	public List<UserEntity> getAllProfile(){
		Session session = sessionFactory.openSession();
		String hql = "from UserEntity";
		List<UserEntity> entity = session.createQuery(hql, UserEntity.class).list();
		
		session.close();
		return entity;
		
	}
	
	
	// Fetch profile
	public UserEntity getProfile(Integer id) {
	    Session session = sessionFactory.openSession();
	    UserEntity entity = session.get(UserEntity.class, id);
	    session.close();   
	    return entity;
	}
	
	// Update profile
	public void editProfile(UserEntity entity) {
	    Session session = sessionFactory.openSession();
	    Transaction txn = session.beginTransaction();

	    session.update(entity);  

	    txn.commit();
	    session.close();
	}


//	public UserEntity getProfile(Integer id) {
//	    Session session = sessionFactory.openSession();
//	    try {
//	        return session.get(UserEntity.class, id);
//	    } finally {
//	        session.close();
//	    }
//	}
	
//	public void editProfile(UserEntity entity) {
//	    Session session = sessionFactory.openSession();
//	    Transaction txn = session.beginTransaction();
//
//	    session.merge(entity);   // safer than update()
//
//	    txn.commit();
//	    session.close();
//	}

	
	
	// delete 
	public void softDeleteUser(Integer id) {
	    Session session = sessionFactory.getCurrentSession();

	    UserEntity user = session.get(UserEntity.class, id);
	    if (user == null) {
	        throw new RuntimeException("User not found with id: " + id);
	    }

	    user.setDeleted(true);
	    session.merge(user);
	}

}
