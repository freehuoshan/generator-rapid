<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign classNameLowerCase = table.classNameLowerCase> 
package ${basepackage}.bean.${classNameLowerCase};

import ${basepackage}.bean.BaseObject;

public class ${className} extends BaseObject{
	
	<#list table.columns as column>
    // ${column.columnAlias!} 	
	private ${column.simpleJavaType} ${column.underscoreName};
	</#list>

	<@generateJavaColumns/>
}

<#macro generateJavaColumns>
	<#list table.columns as column>	
	public void set${column.underscoreName?cap_first}(${column.simpleJavaType} ${column.underscoreName}) {
		this.${column.underscoreName} = ${column.underscoreName};
	}
	
	public ${column.simpleJavaType} get${column.underscoreName?cap_first}() {
		return this.${column.underscoreName};
	}
	</#list>
</#macro>
