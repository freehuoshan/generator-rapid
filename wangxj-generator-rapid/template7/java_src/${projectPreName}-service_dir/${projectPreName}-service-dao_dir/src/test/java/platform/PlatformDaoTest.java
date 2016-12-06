package net.wangxj.ssm.dao.platform;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kalian.account.provide.dao.BaseTest;
import net.wangxj.ssm.dao.platform.PlatformDao;
import net.wangxj.ssm.dao.platform.PlatformDaoImpl;

/**
 * created by	: wangxj
 * created time	: 2016-09-22 17:12:12
 */

public class PlatformDaoTest extends BaseTest{
	
	private PlatformDao platformDao;
	
	@Before
	public void init(){
		platformDao = (PlatformDao) applicationContext.getBean("platformDao");
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
