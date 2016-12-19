<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign classNameLowerCase = table.classNameLowerCase> 
package ${basepackage}.web.controller;

@RequestMapping("${classNameLower}")
public class ${className}Controller{
	
	@Resource
	private ${className}WebService ${classNameLower}WebService;
	
	
	public Module
	
}