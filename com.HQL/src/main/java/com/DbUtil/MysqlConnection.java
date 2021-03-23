package com.DbUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MysqlConnection {

	public static  Session openSession() {
		Configuration cfg = new Configuration().configure("com/resource/mysql.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		return session;
	}
}
