<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign classNameLowerCase = table.classNameLowerCase> 
package ${basepackage}.dto;

import java.io.Serializable;

/**
 * created by	: ${author}
 * created time	: ${ .now?string("yyyy-MM-dd HH:mm:ss")}
 */

public class ${className}DTO implements Serializable{ 
	
	<#list table.columns as column>
    // ${column.columnAlias!} 	
	private ${column.javaType} ${column.columnNameLower};
	</#list>
	
	public ${className}DTO(){
		super();
	}
	
	public ${className}DTO(<#list table.columns as column>${column.javaType} ${column.columnNameLower}<#if column_has_next>,</#if></#list>){
		<#list table.columns as column>	
			this.${column.columnNameLower} = ${column.columnNameLower};
		</#list>
	}

	<@generateJavaColumns/>
	
	<@generateTostring clazzName="${className}"/>
	
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


	

