<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>   
<#assign classNameLowerCase = table.classNameLowerCase> 

package ${basepackage}.service.impl;


import java.util.List;


import javax.annotation.Resource;
import org.apache.log4j.Logger;
import ${basepackage}.dao.${className}Dao;
import ${basepackage}.po.${className}PO;
import ${basepackage}..service.${className}Service;
import org.springframework.stereotype.Service;

/**
 * created by	: ${author}
 * created time	: ${ .now?string("yyyy-MM-dd HH:mm:ss")}
 */

@Service("${classNameLower}Service")
public class ${className}ServiceImpl implements ${className}Service{
	
	private static Logger logger = Logger.getLogger(${className}ServiceImpl.class);
	
	@Resource
	private ${className}Dao ${classNameLower}Dao;
	
	@Override
	public Integer add(${className}PO ${classNameLower}Po) {
		
		return ${classNameLower}Dao.insert(${classNameLower}Po);
	}
	
	@Override
	public Integer addBatch(List<${className}PO> listPo){
		return ${classNameLower}Dao.insertBatch(listPo);
	}
	
	@Override
	public List<${className}PO> queryPageListByCondition(${className}PO ${classNameLower}Po, int pageNum, int limit) {
		
		return ${classNameLower}Dao.selectPageListByCondition(${classNameLower}Po, pageNum, limit);
	}


	@Override
	public Integer modifyByUuid(${className}PO ${classNameLower}Po) {
		
		return ${classNameLower}Dao.updateByUuid(${classNameLower}Po);
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
