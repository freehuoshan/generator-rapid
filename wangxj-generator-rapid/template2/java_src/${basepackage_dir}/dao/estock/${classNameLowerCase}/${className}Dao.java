<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign classNameLowerCase = table.classNameLowerCase> 
package ${basepackage}.dao.estock.${classNameLowerCase};

import ${basepackage}.dao.IBaseDao;
import ${basepackage}.model.estock.${classNameLowerCase}.${className};

public interface ${className}Dao extends IBaseDao<${className}>{
	
}
