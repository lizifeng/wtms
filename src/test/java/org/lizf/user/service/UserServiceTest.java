package org.lizf.user.service;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.lizf.user.dao.UserDao;
import org.lizf.user.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {
	
	private static UserDao userDao;
	private static ApplicationContext ac;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		userDao = (UserDao) ac.getBean("userDao");
	}

	@Test
	public void loginTest() {
		String username = "admin";
		String password = "123";
		User user = userDao.login(username, password); 
		System.out.println(user);
		Assert.assertNotNull(user);
	}

}
