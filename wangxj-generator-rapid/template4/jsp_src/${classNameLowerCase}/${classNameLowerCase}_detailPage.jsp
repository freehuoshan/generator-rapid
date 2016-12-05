<#include "/macro.include"/>
<#include "/custom.include"/>  
<#macro jspEl value>${r"${"}${value}}</#macro>
<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first> 
<#assign classNameLowerCase = className?lower_case>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<jsp:include page="../../../../inc.jsp"></jsp:include>
<script type="text/javascript">

</script>
</head>
<body>
	<form method="post" class="form">
		<fieldset>
			<legend>基本信息</legend>
			<table class="table" style="width: 100%;">
				<#list table.columns as column>
				<tr>	
					<th>${column.remarks}</th>
					<td>
						${r"${bean."}${column.underscoreName}}
					</td>
				</tr>	
				</#list>	
			</table>
		</fieldset>
	</form>
</body>
</html>