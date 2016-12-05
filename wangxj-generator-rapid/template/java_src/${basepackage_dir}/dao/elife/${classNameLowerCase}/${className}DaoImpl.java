<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
<#assign classNameLowerCase = table.classNameLowerCase> 
package ${basepackage}.dao.elife.${classNameLowerCase};

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import ${basepackage}.dao.BaseSessionDaoSupport;
import ${basepackage}.model.elife.${classNameLowerCase}.${className};

@Repository("${classNameLower}Dao")
public class ${className}DaoImpl extends BaseSessionDaoSupport implements ${className}Dao{

	@Override
	public void insert(${className} ${classNameLower}) {
		// TODO Auto-generated method stub
		
		super.getSqlSession().insert("${className}.insert", ${classNameLower});
	}
	
	@Override
	public void update(${className} ${classNameLower}) {
		// TODO Auto-generated method stub
		
		super.getSqlSession().update("${className}.update", ${classNameLower});
	}
	
	@Override
	public List<${className}> selectList(${className} ${classNameLower}) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("${className}.queryByCondition", ${classNameLower});
	}
	
	@Override
	public List<${className}> selectPageList(${className} ${classNameLower}, int offset, int limit) {
		// TODO Auto-generated method stub
		List<${className}> resLs = super.getSqlSession().selectList("${className}.queryByCondition", ${classNameLower}, new RowBounds(offset, limit));
		return resLs;
	}

	@Override
	public Integer count(${className} ${classNameLower}) {
		// TODO Auto-generated method stub
		return (Integer)super.getSqlSession().selectOne("${className}.getCountByCondition", ${classNameLower});
	}

	@Override
	public ${className} queryInfo(${className} ${classNameLower}) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectOne("${className}.queryByCondition", ${classNameLower});
	}

	@Override
	public Map<String, ${className}> selectMap(String strParam) {
		// TODO Auto-generated method stub
		Map<String, ${className}> ${classNameLower}Map = super.getSqlSession().selectMap("${className}.queryByCondition", strParam);
		return ${classNameLower}Map;
	}

	@Override
	public Map<String, ${className}> selectMap(${className} ${classNameLower}, String keyStr) {
		// TODO Auto-generated method stub
		Map<String, ${className}> ${classNameLower}Map = super.getSqlSession().selectMap("${className}.queryByCondition", ${classNameLower}, keyStr);
		return ${classNameLower}Map;
	}
}
