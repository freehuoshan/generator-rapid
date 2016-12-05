<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign classNameLowerCase = table.classNameLowerCase> 
package ${basepackage}.dao.elife.${classNameLowerCase};

import ${basepackage}.dao.IBaseDao;
import ${basepackage}.model.elife.${classNameLowerCase}.${className};

public interface ${className}Dao extends IBaseDao<${className}>{
	
}
