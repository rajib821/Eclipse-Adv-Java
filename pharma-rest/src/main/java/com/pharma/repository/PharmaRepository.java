package com.pharma.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pharma.entity.MedicineEntity;
import com.pharma.entity.PharmaUserEntity;

@Repository
public class PharmaRepository {
	@Autowired
	SessionFactory sessionFactory;
	
	public void createUserProfile(PharmaUserEntity userEntity) {
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		session.save(userEntity);
		txn.commit();
		session.close();
	}
	
	public PharmaUserEntity getProfileFromEmail(String email) {
		Session session= sessionFactory.openSession();
		String hql = "from PharmaUserEntity where emailId = :email";
		PharmaUserEntity entity = session.createQuery(hql,PharmaUserEntity.class).setParameter("email", email).uniqueResult();
		session.close();
		return entity;
	}
	
	
	public PharmaUserEntity login(String email, String password) {
		Session session = sessionFactory.openSession();
		String hql = "from PharmaUserEntity where emailId = :email and password = :password ";
		Query<PharmaUserEntity> query = session.createQuery(hql,PharmaUserEntity.class).setParameter("email", email).setParameter("password", "password");
		PharmaUserEntity user = query.uniqueResult();
		return user;
	}
	
//	public void addMedicine(MedicineEntity medicineEntity) {
//		Session session = sessionFactory.openSession();
//		Transaction txn = session.beginTransaction();
//		session.save(medicineEntity);
//		txn.commit();
//		session.close();
//	}
}
