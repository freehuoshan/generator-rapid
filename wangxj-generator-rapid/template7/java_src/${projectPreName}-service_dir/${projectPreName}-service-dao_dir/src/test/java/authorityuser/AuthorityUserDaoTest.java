package net.wangxj.ssm.dao.authorityuser;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kalian.account.provide.dao.BaseTest;
import net.wangxj.ssm.dao.authorityuser.AuthorityUserDao;
import net.wangxj.ssm.dao.authorityuser.AuthorityUserDaoImpl;

/**
 * created by	: wangxj
 * created time	: 2016-09-22 17:12:11
 */

public class AuthorityUserDaoTest extends BaseTest{
	
	private AuthorityUserDao authorityUserDao;
	
	@Before
	public void init(){
		authorityUserDao = (AuthorityUserDao) applicationContext.getBean("authorityUserDao");
	}
	
	@Test
	public void testInsert(){
		//to-do
	}
	
	@Test
	public void testInsertBatch(){
		//to-do
	}
	
	@Test
	public void testUpdate(){
		//to-do
	}
	
	@Test
	public void testUpdateBatch(){
		//to-do
	}
	
	@Test
	public void testSelectList(){
		//to-do
	}
	
	@Test
	public void testSelectPageList(){
		//to-do
	}
	
	@Test
	public void testQueryInfo(){
		//to-do
	}
	
	@Test
	public void testSelectMap(){
		//to-do
	}
	
}
