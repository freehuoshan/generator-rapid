<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign classNameLowerCase = table.classNameLowerCase> 
package ${basepackage}.service.share;

import ${basepackage}.Response;
import java.util.List;
import ${basepackage}.dto.${className}DTO;

/**
 * created by	: ${author}
 * created time	: ${ .now?string("yyyy-MM-dd HH:mm:ss")}
 */

public interface ${className}ShareService{

	/**
	 * 添加${className}DTO
	 * @return	新增主键
	 */
	public Response<Integer> add(${className}DTO ${classNameLower}Dto);
	
	/**
	 * 批量添加
	 * @return 成功添加的条数
	 */
	public Response<Integer> addBatch(List<${className}DTO> listDto);
	
	/**
	 * 根据主键ID修改
	 * @return 新增条数: 默认1
	 */
	public Response<Integer> modifyByUuid(${className}DTO ${classNameLower}Dto);
	
	/**
	 * 条件查询
	 */
	public Response<${className}DTO> queryListByCondition(${className}DTO ${classNameLower}Dto);
	
	/**
	 * 条件分页查询
	 * @param pageNum: 页码
	 * @param limit:   每页条数
	 */
	public Response<${className}DTO> queryPageListByCondition(${className}DTO ${classNameLower}Dto, int pageNum, int limit);
	
	/**
	 * 条件数量查询
	 * @return
	 */
	public Response<Integer> getCountByCondition(${className}DTO ${classNameLower}Dto);
	

}