<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
<#assign classNameLowerCase = table.classNameLowerCase> 
package ${basepackage}.dao.elife.${classNameLowerCase};

import org.junit.Before;
import org.junit.Test;

import ${basepackage}.dao.elife.BaseTest;

public class ${className}DaoTest extends BaseTest{
	
	private ${className}Dao ${classNameLower}Dao;
	
	@Before
	public void init(){
		${classNameLower}Dao = (${className}Dao) applicationContext.getBean("${classNameLower}Dao");
	}
	
	@Test
	public void testInser(){
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
