<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
<#assign classNameLowerCase = table.classNameLowerCase> 
package ${basepackage}.service.${classNameLowerCase};

import org.springframework.stereotype.Service;

@Service("${classNameLower}Service")
public class ${className}ServiceImpl implements ${className}Service{

}
