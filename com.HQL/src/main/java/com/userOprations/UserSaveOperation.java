package com.userOprations;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.DbUtil.MysqlConnection;
import com.Entities.User;
import com.userRepositories.UserServiceV1;

public class UserSaveOperation implements UserServiceV1 {

	public User saveUser() {
		User user = new User();
		user.setName("Khagesh");
		user.setAddress("Sabalgarh");
		user.setMobile(9643272334l);
		try {
			Session session = MysqlConnection.openSession();
			System.out.println("Session id: " + session);
			Transaction tx = session.beginTransaction();
			int id = (Integer) session.save(user);
			System.out.println("Id is : " + id);
			tx.commit();
			System.out.println("Data has been saved ..");
			session.clear();
			session.close();
			System.out.println("Session Id : " + session);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
