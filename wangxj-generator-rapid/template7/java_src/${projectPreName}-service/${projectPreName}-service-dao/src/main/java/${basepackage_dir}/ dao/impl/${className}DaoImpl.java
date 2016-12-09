<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>   
<#assign classNameLowerCase = table.classNameLowerCase> 

package ${basepackage}.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.github.pagehelper.PageHelper;

import ${basepackage}.dao.base.BaseSessionDaoSupport;
import ${basepackage}.po.${className}PO;
import ${basepackage}.dao.${className}Dao;
import org.apache.log4j.Logger;

/**
 * created by	: ${author}
 * created time	: ${ .now?string("yyyy-MM-dd HH:mm:ss")}
 */
 */

@Repository("${classNameLower}Dao")
public class ${className}DaoImpl extends BaseSessionDaoSupport implements ${className}Dao{

	private static Logger logger = Logger.getLogger(${className}DaoImpl.class);
	
	@Override
	public Integer insert(${className}PO ${classNameLower}Po) {
		return super.getSqlSession().update("${className}POMapper.insert", ${classNameLower}Po);
	}
	
	@Override
	public Integer insertBatch(List<${className}PO> listPo){
		Integer count=0;
		for(${className}PO ${classNameLower}Po : listPo){
			this.insert(${classNameLower}Po);
			count++;
		}
		return count;
	}
	
	@Override
	public Integer updateByUuid(${className}PO ${classNameLower}Po) {
	
		return super.getSqlSession().update("${className}POMapper.updateByUuid", ${classNameLower}Po);
	}
	
	@Override
	public List<AuthorityResourcesPO> selectListByCondition(${className}PO ${classNameLower}Po) {
		
		return super.getSqlSession().selectList("${className}POMapper.selectByCondition", ${classNameLower}Po);
	}
	
	@Override
	public List<AuthorityResourcesPO> selectPageListByCondition(${className}PO ${classNameLower}Po, int pageNum, int limit) {
		PageHelper.startPage(pageNum, limit);
		return super.getSqlSession().selectList("${className}POMapper.selectByCondition", ${classNameLower}Po);
	}

	@Override
	public Integer getCountByCondition(${className}PO ${classNameLower}Po) {
		
		return (Integer)super.getSqlSession().selectOne("${className}POMapper.selectCountByCondition", ${classNameLower}Po);
	}
	
}
