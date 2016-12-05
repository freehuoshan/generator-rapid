<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
<#assign classNameLowerCase = table.classNameLowerCase> 
package com.kalian.tposweb.controller.manage.${classNameLowerCase};

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.log4j.Logger;
import com.kalian.tposweb.controller.BaseController;

/**
 * 
 *
 */
@Controller
@RequestMapping("/manage/${classNameLower}")
@Scope("prototype")
public class ${className}Controller extends BaseController{

	private static Logger log = Logger.getLogger(${className}Controller.class);
	
}
