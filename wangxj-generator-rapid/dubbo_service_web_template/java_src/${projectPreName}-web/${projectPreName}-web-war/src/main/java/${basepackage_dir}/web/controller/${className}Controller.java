<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign classNameLowerCase = table.classNameLowerCase> 
package ${basepackage}.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import  ${basepackage}.Response;
import ${basepackage}.dto.${className}DTO;
import ${basepackage}.web.service.${className}WebService;

@RequestMapping("${classNameLower}")
@Controller
public class ${className}Controller{
	
	@Resource
	private ${className}WebService ${classNameLower}WebService;
	
	
	@RequestMapping("/info")
	public String selectInfo(){
		
		Response<${className}DTO> selectInfo = ${classNameLower}WebService.selectInfo();
		
		ModelAndView module = new ModelAndView();
		
		module.addObject("test", selectInfo);
		return "test";
	}
	
}