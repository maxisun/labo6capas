package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.uca.capas.domain.Student;

@Repository
public class StudentDAOImpl implements StudentDAO{
	
	//@PersistenceContext(unitName="capas") //es para un bean
	@PersistenceContext(name="capas")
	private EntityManager entityManager;

	@Override
	public List<Student> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		//sb.append("select * from public.student where b_active='true'");
		sb.append("select * from public.student");
		Query query = entityManager.createNativeQuery(sb.toString(),Student.class);
		List<Student> resulset = query.getResultList();
		return resulset;
	}
	
	@Override
	public Student findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		Student student = entityManager.find(Student.class, code);
		return student;
	}

	@Override
	@Transactional
	public int save(Student s, Integer newRow) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			if(newRow == 1) entityManager.persist(s);
			else entityManager.merge(s);
			entityManager.flush();
			return 1;
		} catch(Throwable e) {
			e.printStackTrace();
			return 1;
		}
	}

	@Override
	@Transactional
	public int delete(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		try{
			StringBuffer sb= new StringBuffer();
			//sb.append("select * from public.student WHERE s_name=:name");
			sb.append("DELETE FROM public.student WHERE s_name=:name");
			Query query = entityManager.createNativeQuery(sb.toString(),Student.class);
			query.setParameter("name", name);
			query.executeUpdate();
			 /*Student student= (Student) query.setMaxResults(1).getSingleResult();
			 entityManager.remove(student);	*/
			 return 1;
		} catch(Throwable e) {
			e.printStackTrace();
			return 0;
		}
	}
}
