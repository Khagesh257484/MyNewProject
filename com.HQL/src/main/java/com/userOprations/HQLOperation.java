package com.userOprations;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.DbUtil.MysqlConnection;
import com.Entities.User;

public class HQLOperation {

	private static final Logger logger = LogManager.getLogger(HQLOperation.class);

	// GetAllData from user
	public static User selectAllDataFromUser() {
		/*
		 * Not accessing static object in static way..
		 * 
		 * MysqlConnection dbCon=new MysqlConnection(); Session
		 * session=dbCon.openSession();
		 */

		Session session = MysqlConnection.openSession();
		System.out.println("SessionOpen , sessionID : " + session);
		// Transaction tx=session.beginTransaction(); // Need of transaction when want
		// to save data.....
		String hql = "from User";

		Query q = session.createQuery(hql);

		List<User> userList = q.getResultList();
		for (User user : userList) {
			System.out.println(user.getId() + "\t" + user.getName() + "\t" + user.getMobile());
		}
		logger.info(userList, null);
		session.close();
		return new User();

	}

	// Get more than one column data
	public static void moreThanOneColumnData() {

		Session session = MysqlConnection.openSession();
		System.out.println("Session Id is : " + session);
		String hql = "from com.Entities.User where id=:id order by name desc";

		// createQuery("SELECT p FROM Person p WHERE p.id IN :ids").setParameter("ids",
		// ids).getResultList();
		Query q = session.createQuery(hql);
		q.setParameter("id", Arrays.asList(1));
		List<User> list = q.getResultList();
		System.out.println("\n Fetching Id  Name  User from user table");
		for (User user : list) {
			System.out.println(user.getId() + "\t" + user.getName() + "\t" + user.getMobile());
		}
		session.close();
		// return new User();
	}

	// update Data in Table
	public static void updateData() {
		Session session = MysqlConnection.openSession();
		System.out.println("Session Id is : " + session);
		String hql = "update User set mobile=:mobile where id=:id";
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery(hql);
		q.setParameter("mobile", 9516107620l);
		q.setParameter("id", 1);
		int result = q.executeUpdate();
		tx.commit();
		System.out.println("Affected rows: " + result);
		session.close();
	}

	// update multiple id data
	public static void updateMultipleData() {
		System.out.println("Please implement...");
	}

	//Delete Data from table 	
	public static void deleteData() {
		Session session = MysqlConnection.openSession();
		System.out.println("Session Id is : " + session);
		Transaction tx = session.beginTransaction();
		String hql = "delete from User where id=:id";
		Query q=session.createQuery(hql);
		q.setParameter("id", 4);
		int result=q.executeUpdate();
		tx.commit();
		System.out.println("Affected row : "+result);
	}
	
	// Aggregate function	
	public static void countOfId() {
		Session session = MysqlConnection.openSession();
		System.out.println("Session Id is : " + session);
		String hql="select count(id) from User";
		Query q=session.createQuery(hql);
		List<Integer> list=q.getResultList();
		System.out.println(list.get(0));  // return column list 
	}
}
