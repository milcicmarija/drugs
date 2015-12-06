package opendata.drugs.api.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import opendata.drugs.api.database.HibernateUtil;
import opendata.drugs.api.domain.Drug;

public class DrugsDao {

	@SuppressWarnings("unchecked")
	public List<Drug> getDrugs (int page, int limit, String sort, String q){
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();

		String queryString = "SELECT d.name FROM Drug d ";
		
		if (!q.isEmpty()) {
			queryString += "WHERE d.name LIKE CONCAT('%', :name, '%'))" ;
		}
			queryString += "ORDER BY d.name " + sort;
		
		Query query = session.createQuery(queryString);
		
		if (!q.isEmpty()) {
			query.setString("name", q);
		}
		List<Drug> all = query
				.setFirstResult((page - 1) * limit)
				.setMaxResults(limit)
				.list();

		session.close();

		return all;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Drug> getSupstitute (int page, int limit, String sort, String q){
		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		session.beginTransaction();

		String queryString = "SELECT d.name FROM Drug d ";
		
		if (!q.isEmpty()) {
			queryString += "WHERE d.genericName = (SELECT d.genericName FROM Drug d WHERE d.name LIKE CONCAT('%', :name, '%')))" ;
		}
			queryString += "ORDER BY d.name " + sort;
		
		Query query = session.createQuery(queryString);
		
		if (!q.isEmpty()) {
			query.setString("name", q);
		}
		List<Drug> supstitutes = query
				.setFirstResult((page - 1) * limit)
				.setMaxResults(limit)
				.list();

		session.close();

		return supstitutes;
	}
}
