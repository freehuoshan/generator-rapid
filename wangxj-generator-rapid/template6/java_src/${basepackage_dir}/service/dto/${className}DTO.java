<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign classNameLowerCase = table.classNameLowerCase> 
package ${basepackage}.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ${className}DTO implements Serializable{
	
	<#list table.columns as column>
    // ${column.columnAlias!} 	
	private ${column.javaType} ${column.columnNameLower};
	</#list>

	<@generateJavaColumns/>
}

<#macro generateJavaColumns>
	<#list table.columns as column>	
	public void set${column.columnName}(${column.javaType} value) {
		this.${column.columnNameLower} = value;
	}
	
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	</#list>
</#macro>
