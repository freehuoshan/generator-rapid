<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign classNameLowerCase = table.classNameLowerCase> 
package ${basepackage}.po;

import java.math.BigDecimal;

public class ${className}PO{
	
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
