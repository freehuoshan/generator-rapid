<#include "/java_copyright.include">
<#assign classNameService = "RPay"+table.className>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign classNameLowerCase = table.classNameLowerCase> 

package com.kalian.replacepay.provide.service.share;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.kalian.replacepay.provide.service.ReplacePayResponse;
import com.kalian.replacepay.provide.service.dto.${className}DTO;
import com.kalian.replacepay.provide.service.share.${classNameService}Service;

public interface ${classNameService}Service{
	
	/**
	 * 增加
	 * @return
	 */
	public ReplacePayResponse<Integer> add(${className}DTO ${classNameLower}Dto);
	
	/**
	 * 根据主键ID修改
	 * @return
	 */
	public ReplacePayResponse<Integer> modifyByKey(${className}DTO ${classNameLower}Dto);
	
	/**
	 * 根据条件查询
	 */
	public ReplacePayResponse<${className}DTO> queryListByCondition(${className}DTO ${classNameLower}Dto);
	/**
	 * 分页条件查询
	 */
	public ReplacePayResponse<${className}DTO> queryPageListByCondition(${className}DTO ${classNameLower}Dto, int offset, int limit); 
	
	/**
	 * 条件数量查询
	 * @return
	 */
	public ReplacePayResponse<Integer> getCountByCondition(${className}DTO ${classNameLower}Dto);
	
}
