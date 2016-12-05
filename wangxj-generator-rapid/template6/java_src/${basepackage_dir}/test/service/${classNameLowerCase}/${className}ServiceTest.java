<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
<#assign classNameLowerCase = table.classNameLowerCase> 
package ${basepackage}.service.share.${classNameLowerCase};

import org.junit.Before;
import org.junit.Test;

import com.kalian.account.provide.service.BaseTest;
import ${basepackage}.service.${classNameLowerCase}.${className}Service;

public class ${className}ServiceTest extends BaseTest{
	
	private ${className}Service ${classNameLower}Service;
	
	@Before
	public void init(){
		${classNameLower}Service = (${className}Service) applicationContext.getBean("${classNameLower}Service");
	}
	
	@Test
	public void testInsert(){
		//to-do
	}
	
}
