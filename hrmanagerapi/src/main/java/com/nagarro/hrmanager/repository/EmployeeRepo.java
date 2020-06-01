package com.nagarro.hrmanager.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nagarro.hrmanager.model.Employee;
import com.nagarro.hrmanager.util.HibernateUtil;


public class EmployeeRepo {

	
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployees() {
		Transaction transaction = null;
		List<Employee> emplist = null;
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			//start a transaction
			transaction = session.beginTransaction();
			
			//getting Employees 
			emplist = session.createQuery("from Employee").getResultList();
			
			
			//commit transaction
			transaction.commit();
			
		} catch (Exception e) {
			
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		return emplist;
	}


	public void addEmployee(Employee emp) {
		Transaction transaction = null;
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			//start a transaction
			transaction = session.beginTransaction();
			
			//save Employee 
			session.save(emp);
			
			
			//commit transaction
			transaction.commit();
			
		} catch (Exception e) {
			
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		
		
	}


	public Employee getEmployee(int ecode) {
		Transaction transaction = null;
		Employee emp = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			//start a transaction
			transaction = session.beginTransaction();
			
			//save Employee 
			emp = session.get(Employee.class, ecode);
			
			
			//commit transaction
			transaction.commit();
			
		} catch (Exception e) {
			
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		return emp;
	}


	public void updateEmpoyee(Employee emp) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			//Session session = HibernateUtil.getSessionFactory().openSession();
			//start a transaction
			transaction = session.beginTransaction();
			
			//update Employee 
			session.update(emp);
			
			
			//commit transaction
			transaction.commit();
			
		} catch (Exception e) {
			
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }		
	}
	
	public void deleteEmpoyee(int ecode) {
		Transaction transaction = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			//Session session = HibernateUtil.getSessionFactory().openSession();
			//start a transaction
			transaction = session.beginTransaction();
			
			Employee emp = getEmployee(ecode);
			
			if (emp != null) {
				session.delete(emp);
				System.out.println("Employee Deleted");
			}
			
			
			//commit transaction
			transaction.commit();
			
		} catch (Exception e) {
			
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }		
	}
}

