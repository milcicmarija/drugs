package opendata.drugs.api.test;

import org.hibernate.Session;

import opendata.drugs.api.database.HibernateUtil;
import opendata.drugs.api.domain.Drug;

public class Test {

	public static void main(String[] args) {

		Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
		
		session.beginTransaction();
		
		Drug d = (Drug)session.createCriteria(Drug.class).setMaxResults(1).uniqueResult();
		System.out.println(d.toString());
		
		session.close();
		HibernateUtil.getInstance().shutdown();
		
	}

}
