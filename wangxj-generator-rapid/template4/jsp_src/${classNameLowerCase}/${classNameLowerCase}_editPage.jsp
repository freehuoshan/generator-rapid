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
	var submitForm = function($dialog, $grid, $pjq) {
		if ($('form').form('validate')) {
			var url;
			if ($(':input[name="${table.idColumn.underscoreName}"]').val().length > 0) {
				url = sy.contextPath + '/${namespace}/${classNameFirstLower}Control/update.htm';
			} else {
				url = sy.contextPath + '/${namespace}/${classNameFirstLower}Control/insert.htm';
			}
			$.post(url, sy.serializeObject($('form')), function(result) {
				if (result.success) {
					$grid.datagrid('load');
					$dialog.dialog('destroy');
				} else {
					$pjq.messager.alert('提示', result.msg, 'error');
				}
			}, 'json');
		}
	};
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
						<input name="${column.underscoreName}" value="${r"${bean."}${column.underscoreName}}" class="easyui-validatebox" data-options="required:false"  />
					</td>
				</tr>	
				</#list>	
			</table>
		</fieldset>
	</form>
</body>
</html>