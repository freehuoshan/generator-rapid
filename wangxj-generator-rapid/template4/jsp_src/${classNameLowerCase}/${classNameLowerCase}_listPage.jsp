<%@page import="${basepackage}.model.*" %>
<#include "/macro.include"/> 
<#include "/custom.include"/> 
<#assign className = table.className>   
<#assign classNameLowerCase = className?lower_case>
<#assign classNameFirstLower = table.classNameFirstLower>   
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.kl.util.SecurityUtil"%>
<%
	String contextPath = request.getContextPath();
	SecurityUtil securityUtil = new SecurityUtil(session);
%>
<!DOCTYPE html>
<html>
<head>
<title>管理列表</title>
<jsp:include page="../../../../inc.jsp"></jsp:include>
<script type="text/javascript">
	var grid;
	var addFun = function() {
		var dialog = parent.sy.modalDialog({
			//width :  680,
			//height : 300,
			title : '添加信息',
			url : sy.contextPath + '/${namespace}/${classNameFirstLower}Control/addPage.htm',
			buttons : [ {
				text : '添加',
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
				}
			}, {
				text : '关闭',
				handler : function() {
					dialog.dialog('destroy');
				}
			}  ]
		});
	};
	
	var showFun = function(${table.idColumn.underscoreName}) {
		var dialog = parent.sy.modalDialog({
			title : '查看信息',
			url : sy.contextPath + '/${namespace}/${classNameFirstLower}Control/detailPage.htm?${table.idColumn.underscoreName}='+${table.idColumn.underscoreName},
			buttons : [{
				text : '关闭',
				handler : function() {
					dialog.dialog('destroy');
				}
			}  ]
		});
	};
	var editFun = function(${table.idColumn.underscoreName}) {
		var dialog = parent.sy.modalDialog({
			//width :  680,
			//height : 300,
			title : '编辑信息',
			url : sy.contextPath + '/${namespace}/${classNameFirstLower}Control/editPage.htm?${table.idColumn.underscoreName}=' + ${table.idColumn.underscoreName},
			buttons : [ {
				text : '编辑',
				handler : function() {
					dialog.find('iframe').get(0).contentWindow.submitForm(dialog, grid, parent.$);
				}
			}, {
				text : '关闭',
				handler : function() {
					dialog.dialog('destroy');
				}
			}  ]
		});
	};
	var removeFun = function( ${table.idColumn.underscoreName}) {
		parent.$.messager.confirm('询问', '您确定要删除此记录？', function(r) {
			if (r) {
				$.post(sy.contextPath + '/${namespace}/${classNameFirstLower}Control/delete.htm', {
					 ${table.idColumn.underscoreName} : ${table.idColumn.underscoreName}
				}, function() {
					grid.datagrid('reload');
				}, 'json');
			}
		});
	};
	$(function() {
		grid = $('#grid').datagrid({
			title : '',
			url : sy.contextPath + '/${namespace}/${classNameFirstLower}Control/dataGrid',
			striped : true,
			rownumbers : true,
			pagination : true,
			singleSelect : true,
			idField : ' ${table.idColumn.underscoreName}',
			sortName : ' ${table.idColumn.underscoreName}',
			sortOrder : 'asc',
			//frozenColumns : 
			columns : [ [ 
			             
				<#list table.columns as column>
					{width : '100', title : '${column.remarks}', field :'${column.underscoreName}', sortable : true,hidden:false}, 
				</#list>
				{ 
					width : '80', 
					title : '操作', 
					field : 'action', 
					formatter : function(value, row) {
					var str = '';
					<%//if (securityUtil.havePermission("/${namespace}/${classNameFirstLower}Control/detailPage")) {%>
						str += sy.formatString('<img class="iconImg ext-icon-note" title="查看" onclick="showFun(\'{0}\');"/>', row.${table.idColumn.underscoreName});
					<%//}%>
					<%//if (securityUtil.havePermission("/${namespace}/${classNameFirstLower}Control/editPage")) {%>
						str += sy.formatString('<img class="iconImg ext-icon-note_edit" title="编辑" onclick="editFun(\'{0}\');"/>', row.${table.idColumn.underscoreName});
					<%//}%>
					<%//if (securityUtil.havePermission("/${namespace}/${classNameFirstLower}Control/delete")) {%>
						str += sy.formatString('<img class="iconImg ext-icon-note_delete" title="删除" onclick="removeFun(\'{0}\');"/>', row.${table.idColumn.underscoreName});
					<%//}%>
					return str;
				}
			} ] ],
			toolbar : '#toolbar',
			onBeforeLoad : function(param) {
				parent.$.messager.progress({
					text : '数据加载中....'
				});
			},
			onDblClickRow: function (rowIndex, rowData) {
				showFun(rowData. ${table.idColumn.underscoreName});
			},
			onLoadSuccess : function(data) {
				$('.iconImg').attr('src', sy.pixel_0);
				parent.$.messager.progress('close');
			}
		});
	});
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div id="toolbar" style="display: none;">
		<table>
			<tr>
				<%//if (securityUtil.havePermission("/${namespace}/${classNameFirstLower}Control/addPage")) {%>
				<td><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'ext-icon-note_add',plain:true" onclick="addFun();">添加</a></td>
				<%//}%>
				<td><div class="datagrid-btn-separator"></div></td>
				<td><input id="searchBox" class="easyui-searchbox" style="width: 150px" data-options="searcher:function(value,name){grid.datagrid('load',{'QUERY_t#name_S_LK':value});},prompt:'搜索名称'"></input></td>
				<td><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'ext-icon-zoom_out',plain:true" onclick="$('#searchBox').searchbox('setValue','');grid.datagrid('load',{});">清空查询</a></td>
			</tr>
		</table>
	</div>
	<div data-options="region:'center',fit:true,border:false">
		<table id="grid" data-options="fit:true,border:false"></table>
	</div>
</body>
</html>