<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
<#assign classNameLowerCase = table.classNameLowerCase> 
package ${basepackage}.dao.${classNameLowerCase};

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kalian.tposweb.BaseTest;
import ${basepackage}.dao.${classNameLowerCase}.${className}Dao;
import ${basepackage}.dao.${classNameLowerCase}.${className}DaoImpl;

public class ${className}DaoTest extends BaseTest{
	
	private ${className}Dao ${classNameLower}Dao;
	
	@Before
	public void init(){
		${classNameLower}Dao = (${className}Dao) applicationContext.getBean("${classNameLower}Dao");
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
