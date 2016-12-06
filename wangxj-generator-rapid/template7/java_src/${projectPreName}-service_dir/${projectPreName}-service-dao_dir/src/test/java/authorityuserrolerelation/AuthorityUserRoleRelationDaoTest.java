package net.wangxj.ssm.dao.authorityuserrolerelation;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kalian.account.provide.dao.BaseTest;
import net.wangxj.ssm.dao.authorityuserrolerelation.AuthorityUserRoleRelationDao;
import net.wangxj.ssm.dao.authorityuserrolerelation.AuthorityUserRoleRelationDaoImpl;

/**
 * created by	: wangxj
 * created time	: 2016-09-22 17:12:11
 */

public class AuthorityUserRoleRelationDaoTest extends BaseTest{
	
	private AuthorityUserRoleRelationDao authorityUserRoleRelationDao;
	
	@Before
	public void init(){
		authorityUserRoleRelationDao = (AuthorityUserRoleRelationDao) applicationContext.getBean("authorityUserRoleRelationDao");
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
