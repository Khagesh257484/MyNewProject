package com.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.userOprations.HQLOperation;

public class Test {

	private static final Logger logger = LogManager.getLogger(Test.class);
	HQLOperation hql;

	public static void main(String[] args) {
		/*
		 * UserSaveOperation us= new UserSaveOperation(); us.saveUser();
		 */
		HQLOperation.selectAllDataFromUser();
		HQLOperation.moreThanOneColumnData();
		HQLOperation.updateData();
		HQLOperation.updateMultipleData();
		HQLOperation.deleteData();
		HQLOperation.countOfId();
	}
}
