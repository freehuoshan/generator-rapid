<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
<#assign classNameLowerCase = table.classNameLowerCase> 
package ${basepackage}.service.impl;

import java.util.List;

import javax.annotation.Resource;

import ${basepackage}.dao.${className}Dao;
import ${basepackage}.po.${className}PO;
import ${basepackage}.service.${className}Service;
import org.springframework.stereotype.Service;

@Service("${classNameLower}Service")
public class ${className}ServiceImpl implements ${className}Service{
	
	@Resource
	private ${className}Dao ${classNameLower}Dao;
	
	@Override
	public List<${className}PO> queryPageListByCondition(${className}PO ${classNameLower}Po, int pageNum, int limit) {
		
		return ${classNameLower}Dao.selectPageList(${classNameLower}Po, pageNum, limit);
	}

	@Override
	public Integer add(${className}PO ${classNameLower}Po) {
		
		return ${classNameLower}Dao.insert(${classNameLower}Po);
	}

	@Override
	public Integer modifyByKey(${className}PO ${classNameLower}Po) {
		
		return ${classNameLower}Dao.updateByKey(${classNameLower}Po);
	}

	@Override
	public List<${className}PO> queryListByCondition(${className}PO ${classNameLower}Po) {
		
		return ${classNameLower}Dao.selectListByCondition(${classNameLower}Po);
	}

	@Override
	public Integer getCountByCondition(${className}PO ${classNameLower}Po) {
		
		return ${classNameLower}Dao.getCountByCondition(${classNameLower}Po);
	}

}
