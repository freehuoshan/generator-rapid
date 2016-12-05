<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.service;

<#include "/java_imports.include">

import java.util.Map;

import org.springframework.stereotype.Repository;


public interface I${className}Service {
	
	
	/**查询列表信息
	 * @param queryParams
	 * @return list
	 */
	public List<${className}> select(Map queryParams);
	
	
	/**分页查询
	 * @param query
	 * @return
	 */
	public DataGrid dataGrid(Query query);

	/**
	 * 插入单条记录，用id作主键，把null全替换为""
	 * @param vo 用于添加的VO对象
	 * @return 若添加成功，返回新生成的id
	 */
	public String insert(${className} vo);

	/**
	 * 批更新插入多条记录，用id作主键，把null全替换为""
	 * @param vos 添加的VO对象数组
	 * @return 若添加成功，返回新生成的id数组
	 */
	public String[] insertBatch(${className}[] vos);

	/**
	 * 删除单条记录
	 * @param id 用于删除的记录的id
	 * @return 成功删除的记录数
	 */
	public int delete(String id);

	/**
	 * 删除多条记录
	 * @param id 用于删除的记录的id
	 * @return 成功删除的记录数
	 */
	public int deleteBatch(String[] ids);

	/**
	 * 根据Id进行查询
	 * @param id 用于查找的id
	 * @return 查询到的VO对象
	 */
	public ${className} find(String id);

	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int update(${className} vo);
	
	
	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int updateSelect(${className} vo);
	
	
	

	/**
	 * 批量更新修改多条记录
	 * @param vos 添加的VO对象数组
	 * @return 成功更新的记录数组
	 */
	public int updateBatch(${className}[] vos);

}
