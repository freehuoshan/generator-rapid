<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign classNameLowerCase = table.classNameLowerCase>
package ${basepackage}.web.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ${basepackage}.Response;
import ${basepackage}.dto.${className}DTO;
import ${basepackage}.service.share.${className}ShareService;

@Service(value="${className}WebService")
public class ${className}WebService {
	
	@Resource
	private ${className}ShareService ${classNameLower}ShareService;
	
	public Response<${className}DTO> selectInfo(){
		${className}DTO ${classNameLower}Dto = new ${className}DTO();
		
		Response<${className}DTO> ${classNameLower}Response = ${classNameLower}ShareService.queryListByCondition(${classNameLower}Dto);
		
		return ${classNameLower}Response;
	}
	
}
