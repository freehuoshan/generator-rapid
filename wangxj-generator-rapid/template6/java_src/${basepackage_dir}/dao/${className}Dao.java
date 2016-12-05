<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign classNameLowerCase = table.classNameLowerCase> 
package ${basepackage}.dao;

import ${basepackage}.dao.base.IBaseDao;
import ${basepackage}.po.${className}PO;

public interface ${className}Dao extends IBaseDao<${className}PO>{
	
}
