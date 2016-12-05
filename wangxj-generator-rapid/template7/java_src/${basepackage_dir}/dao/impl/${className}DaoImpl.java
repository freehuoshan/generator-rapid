<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
<#assign classNameLowerCase = table.classNameLowerCase> 
package ${basepackage}.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.kalian.replacepay.provide.po.BusinessBasePO;

import ${basepackage}.dao.base.BaseSessionDaoSupport;
import ${basepackage}.po.${className}PO;
import ${basepackage}.dao.${className}Dao;

@Repository("${classNameLower}Dao")
public class ${className}DaoImpl extends BaseSessionDaoSupport implements ${className}Dao{

	@Override
	public Integer insert(${className}PO ${classNameLower}Po) {
		return super.getSqlSession().update("${className}POMapper.insertSelective", ${classNameLower}Po);
	}
	
	@Override
	public Integer updateByKey(${className}PO ${classNameLower}Po) {
	
		return super.getSqlSession().update("${className}POMapper.updateByKey", ${classNameLower}Po);
	}
	
	@Override
	public List<${className}PO> selectListByCondition(${className}PO ${classNameLower}Po) {
		
		return super.getSqlSession().selectList("${className}POMapper.selectByCondition", ${classNameLower}Po);
	}
	
	@Override
	public List<${className}PO> selectPageListByCondition(${className}PO ${classNameLower}Po, int pageNum, int limit) {
		PageHelper.startPage(pageNum, limit);
		return super.getSqlSession().selectList("${className}POMapper.selectByCondition", ${classNameLower}Po);
	}

	@Override
	public Integer getCountByCondition(${className}PO ${classNameLower}Po) {
		
		return (Integer)super.getSqlSession().selectOne("${className}POMapper.selectCountByCondition", ${classNameLower}Po);
	}
	
}
