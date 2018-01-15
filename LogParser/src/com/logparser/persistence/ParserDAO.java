package com.logparser.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.logparser.dto.LogDTO;
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
	public List<LogDTO> listar(Date initDate, Date lastDate, Integer minRequests) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();

		StringBuilder sql = new StringBuilder();
		sql.append("select new com.logparser.dto.LogDTO(l.ip, count(l.id) as totLog) from Log l ");
		sql.append(" where l.time >= :initDate ");
		sql.append("and l.time <= :lastDate ");
		sql.append("group by l.ip ");
		sql.append("order by totLog desc ");
	
		Query query = em.createQuery(sql.toString());
		query.setParameter("initDate", initDate);
		query.setParameter("lastDate", lastDate);
		
		return query.getResultList();

	}

	public Integer countNumberAccess(String ip) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();

		StringBuilder sql = new StringBuilder();
		sql.append(" select b.quantity from Blocked b ");
		sql.append(" where b.ip = :ip ");

		Query query = em.createQuery(sql.toString());
		query.setParameter("ip", ip);
		query.setMaxResults(1);

		return (Integer) query.getSingleResult();
	}

}
