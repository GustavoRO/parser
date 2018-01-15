package com.logparser.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.logparser.entity.Blocked;
import com.logparser.entity.Log;

public class ParserDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	public Log saveLog(Log obj) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();

		em.persist(obj);
		em.flush();

		em.getTransaction().commit();
		em.close();
		return obj;
	}

	public Blocked saveBlocked(Blocked obj) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();

		em.persist(obj);
		em.flush();

		em.getTransaction().commit();
		em.close();
		return obj;
	}

	@SuppressWarnings("unchecked")
	public List<Log> listar(Date initDate, Date lastDate, Integer minRequests) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();

		StringBuilder sql = new StringBuilder();
		sql.append(" from Log l ");

	
		Query query = em.createQuery(sql.toString());
		
		return query.getResultList();

	}

	public Long countNumberAccess(String ip) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();

		StringBuilder sql = new StringBuilder();
		sql.append(" select count(l) from Log l ");
		sql.append(" where l.ip = :ip ");

		Query query = em.createQuery(sql.toString());
		query.setParameter("ip", ip);

		return (Long) query.getSingleResult();
	}

}
