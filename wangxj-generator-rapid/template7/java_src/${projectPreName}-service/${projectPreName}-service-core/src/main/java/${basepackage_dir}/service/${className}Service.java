<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>   
<#assign classNameLowerCase = table.classNameLowerCase> 

package ${basepackage}.service;

import java.util.List;
import ${basepackage}.po.${className}PO;

/**
 * created by	: ${author}
 * created time	: ${ .now?string("yyyy-MM-dd HH:mm:ss")}
 */

public interface ${className}Service{
	/**
	 * 新增
	 * @return
	 */
	public Integer add(${className}PO ${classNameLower}Po);
	
	/**
	 * 批量添加
	 * @return
	 */
	public Integer addBatch(List<${className}PO> listPo);
	
	/**
	 * 根据主键ID修改
	 * @return
	 */
	public Integer modifyByUuid(${className}PO ${classNameLower}Po);
	
	/**
	 * 条件查询
	 */
	public List<${className}PO> queryListByCondition(${className}PO ${classNameLower}Po);
	
	/**
	 * 条件分页查询
	 */
	public List<${className}PO> queryPageListByCondition(${className}PO ${classNameLower}Po, int pageNum, int limit);
	
	/**
	 * 条件数量查询
	 * @return
	 */
	public Integer getCountByCondition(${className}PO ${classNameLower}Po);
}
