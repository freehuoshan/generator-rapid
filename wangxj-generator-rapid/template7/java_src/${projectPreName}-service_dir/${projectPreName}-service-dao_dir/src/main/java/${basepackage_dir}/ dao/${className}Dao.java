<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>   
<#assign classNameLowerCase = table.classNameLowerCase> 

package ${basepackage}.dao;

import ${basepackage}.dao.base.IBaseDao;
import ${basepackage}.po.${className}PO;

/**
 * created by	: ${author}
 * created time	: ${ .now?string("yyyy-MM-dd HH:mm:ss")}
 */

public interface ${className}Dao extends IBaseDao<${className}PO>{
	
}
