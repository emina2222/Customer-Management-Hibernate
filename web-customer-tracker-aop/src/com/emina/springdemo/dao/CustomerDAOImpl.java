package com.emina.springdemo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emina.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		Session session=sessionFactory.getCurrentSession();
		Query<Customer> query=session.createQuery("from Customer order by lastName",Customer.class);
		
		List<Customer> customers=query.getResultList();
		return customers;
	}

	@Override
	public void saveCustomer(Customer c) {

		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(c); //ukoliko postoji customer sa nekim ID, moze samo da ga updateuje, u suprotnom ga cuva u bazi
	}

	@Override
	public Customer getCustomer(int id) {
		Session session=sessionFactory.getCurrentSession();
		Customer c=session.get(Customer.class, id);
		return c;
	}

	@Override
	public void deleteCustomer(int id) {
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("delete from Customer where id=:customerId");
		q.setParameter("customerId", id);
		
		q.executeUpdate();
				
	}

}
