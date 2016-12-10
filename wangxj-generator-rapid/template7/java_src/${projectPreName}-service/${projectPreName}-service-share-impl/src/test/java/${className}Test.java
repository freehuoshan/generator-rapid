<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign classNameLowerCase = table.classNameLowerCase> 
import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ${basepackage}.service.share.${className}ShareService;
import ${basepackage}.Response;
import ${basepackage}.dto.${className}DTO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:/dubbo_use_test.xml"})
public class ${className}Test{
	
	@Resource
	private ${className}ShareService ${classNameLower}ShareService;
	
	@Test
	public void testSelectInfo(){
		
		${className}DTO ${classNameLower}Dto =  new ${className}DTO();
		
		Response<${className}DTO> response = ${classNameLower}ShareService.queryListByCondition(${classNameLower}Dto);
		
		System.out.println(response);
		System.out.println(response.getData());
	}
}