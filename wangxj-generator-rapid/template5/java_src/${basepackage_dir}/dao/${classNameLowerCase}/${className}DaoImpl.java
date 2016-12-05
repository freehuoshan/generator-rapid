<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
<#assign classNameLowerCase = table.classNameLowerCase> 
package ${basepackage}.dao.${classNameLowerCase};

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.kalian.account.provide.model.accountbase.AccountBase;

import ${basepackage}.dao.BaseSessionDaoSupport;
import ${basepackage}.model.${classNameLowerCase}.${className};

@Repository("${classNameLower}Dao")
public class ${className}DaoImpl extends BaseSessionDaoSupport implements ${className}Dao{

	@Override
	public int insert(${className} ${classNameLower}) {
		// TODO Auto-generated method stub
		
		return super.getSqlSession().update("${basepackage}.model.${classNameLowerCase}.${className}.insert", ${classNameLower});
	}
	@Override
	public int insertBatch(List<${className}> list) {
		// TODO Auto-generated method stub
		int count = 0;
		for (${className} ${classNameLower} : list) {
			count += super.getSqlSession().update("${basepackage}.model.${classNameLowerCase}.${className}.insert", ${classNameLower});
		}
		return count;
	}
	
	@Override
	public int update(${className} ${classNameLower}) {
		// TODO Auto-generated method stub
		return super.getSqlSession().update("${basepackage}.model.${classNameLowerCase}.${className}.update", ${classNameLower});
	}
	
	@Override
	public List<${className}> selectList(${className} ${classNameLower}) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("${basepackage}.model.${classNameLowerCase}.${className}.queryByCondition", ${classNameLower});
	}
	
	@Override
	public List<${className}> selectPageList(${className} ${classNameLower}, int offset, int limit) {
		// TODO Auto-generated method stub
		List<${className}> resLs = super.getSqlSession().selectList("${basepackage}.model.${classNameLowerCase}.${className}.queryByCondition", ${classNameLower}, new RowBounds(offset, limit));
		return resLs;
	}

	@Override
	public Integer count(${className} ${classNameLower}) {
		// TODO Auto-generated method stub
		return (Integer)super.getSqlSession().selectOne("${basepackage}.model.${classNameLowerCase}.${className}.getCountByCondition", ${classNameLower});
	}

	@Override
	public ${className} queryInfo(${className} ${classNameLower}) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectOne("${basepackage}.model.${classNameLowerCase}.${className}.queryByCondition", ${classNameLower});
	}

	@Override
	public List<${className}> selectMap(Map<String, String> map) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("${basepackage}.model.${classNameLowerCase}.${className}.queryByCondition", map);
	}
	
}
