package org.lizf.db.mysql;

import org.junit.Assert;
import org.junit.Test;
import org.lizf.db.DBHelper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MysqlHelperTest {

	ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");

	@Test
	public void testConnectionTest() {
		DBHelper dh = (DBHelper) ac.getBean("mysql");
		Assert.assertTrue(dh.testConnection());
	}

}
