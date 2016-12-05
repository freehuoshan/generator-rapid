<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.model;

import java.util.*;
import java.math.BigDecimal;

public class ${className} implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//columns START111
	<#list table.columns as column>
	//${column.remarks}	
	private ${column.simpleJavaType} ${column.underscoreName};
	</#list>
	//columns END

<@generateJavaColumns/>

}

<#macro generateJavaColumns>
	<#list table.columns as column>
		<#if column.isDateTimeColumn>
	public String get${column.columnName}String() {
		return DateConvertUtils.format(get${column.columnName}(), FORMAT_${column.constantName});
	}
	public void set${column.columnName}String(String ${column.underscoreName}) {
		set${column.columnName}(DateConvertUtils.parse(value, FORMAT_${column.constantName},${column.javaType}.class));
	}
	
		</#if>	
	public void set${column.underscoreName?cap_first}(${column.simpleJavaType} ${column.underscoreName}) {
		this.${column.underscoreName} = ${column.underscoreName};
	}
	
	public ${column.simpleJavaType} get${column.underscoreName?cap_first}() {
		return this.${column.underscoreName};
	}
	</#list>
</#macro>
