<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign classNameLowerCase = table.classNameLowerCase> 
package ${basepackage}.service.share.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import ${basepackage}.service.share.${className}ShareService;
import ${basepackage}.Response;
import ${basepackage}.dto.${className}DTO;
import ${basepackage}.po.${className}PO;
import ${basepackage}.service.${className}Service;

/**
 * created by	: ${author}
 * created time	: ${ .now?string("yyyy-MM-dd HH:mm:ss")}
 */
public class ${className}ShareServiceImpl implements ${className}ShareService{

	private static Logger logger = Logger.getLogger(${className}ShareServiceImpl.class);
	
	@Resource
	private ${className}Service ${classNameLower}Service;
	
	@Override
	public Response<Integer> add(${className}DTO ${classNameLower}Dto){
		
		Response<Integer> response = new Response<Integer>();
		
		if(${classNameLower}Dto == null){
			response.setMessage("传入参数不可为空");
			return response;
		}
		
		${className}PO ${classNameLower}po = new ${className}PO(); 
		BeanUtils.copyProperties(${classNameLower}Dto, ${classNameLower}po);
		
		Integer uuid = ${classNameLower}Service.add(${classNameLower}po);
		logger.info("新增${classNameLower}DTO成功");
		response.setCode(0L);
		response.setResObject(uuid);
		return response;
	}
	
	@Override
	public Response<Integer> addBatch(List<${className}DTO> listDto){
		
		Response<Integer> response = new Response<Integer>();
		
		if(listDto == null && listDto.size()>0){
			response.setMessage("传入参数不可为空");
			return response;
		}
		
		List<${className}PO> listPo = new ArrayList<>();
		for(${className}DTO ${classNameLower}Dto : listDto){
			${className}PO ${classNameLower}Po = new ${className}PO();
			BeanUtils.copyProperties(${classNameLower}Dto,${classNameLower}Po);
			listPo.add(${classNameLower}Po);
		}
		Integer count = ${classNameLower}Service.addBatch(listPo);
		logger.info("新增list${classNameLower}DTO成功");
		response.setCode(0L);
		response.setResObject(count);
		return response;
	}
	
	@Override
	public Response<Integer> modifyByUuid(${className}DTO ${classNameLower}Dto){
		
		Response<Integer> response = new Response<>();
		if(${classNameLower}Dto == null){
			response.setMessage("${classNameLower}Dto参数不可为空");
			return response;
		}
		${className}PO ${classNameLower}po = new ${className}PO(); 
		BeanUtils.copyProperties(${classNameLower}Dto, ${classNameLower}po);
		
		Integer count = ${classNameLower}Service.modifyByUuid(${classNameLower}po);
		logger.info("modify${classNameLower}DTO修改成功");
			
		response.setCode(0L);
		response.setResObject(count);
		response.setMessage("成功");
			
		return response;
	}
	
	@Override
	public Response<${className}DTO> queryListByCondition(${className}DTO ${classNameLower}Dto){
		
		Response<${className}DTO> response = new Response<>();
		if(${classNameLower}Dto == null){
			response.setMessage("${classNameLower}Dto参数不可为空");
			return response;
		}
		${className}PO ${classNameLower}Po = new ${className}PO();
		List<${className}PO> listPo = new ArrayList<>();
		List<${className}DTO> listDto = new ArrayList<>();
		BeanUtils.copyProperties(${classNameLower}Dto, ${classNameLower}Po);
		
		listPo = ${classNameLower}Service.queryListByCondition(${classNameLower}Po);
		logger.info("查询queryList成功");
		for (${className}PO ${classNameLower}Po2 : listPo) {
			${className}DTO ${classNameLower}Dto2 = new ${className}DTO();
			BeanUtils.copyProperties(${classNameLower}Po2, ${classNameLower}Dto2);
			listDto.add(${classNameLower}Dto2);
		}
		response.setCode(0L);
		response.setData(listDto);
		response.setMessage("成功");
		
		return response;
	}
	
	@Override
	public Response<${className}DTO> queryPageListByCondition(${className}DTO ${classNameLower}Dto, int pageNum, int limit){
		
		Response<${className}DTO> response = new Response<>();
		if(${classNameLower}Dto == null){
			response.setMessage("${classNameLower}Dto参数不可为空");
			return response;
		}
		${className}PO ${classNameLower}Po = new ${className}PO();
		List<${className}PO> listPo = new ArrayList<>();
		List<${className}DTO> listDto = new ArrayList<>();
		BeanUtils.copyProperties(${classNameLower}Dto, ${classNameLower}Po);
		
		listPo = ${classNameLower}Service.queryPageListByCondition(${classNameLower}Po,pageNum,limit);
		for (${className}PO ${classNameLower}Po2 : listPo) {
			${className}DTO ${classNameLower}Dto2 = new ${className}DTO();
			BeanUtils.copyProperties(${classNameLower}Po2, ${classNameLower}Dto2);
			listDto.add(${classNameLower}Dto2);
		}
		response.setCode(0L);
		response.setData(listDto);
		response.setMessage("成功");
		
		return response;
	}
	
	@Override
	public Response<Integer> getCountByCondition(${className}DTO ${classNameLower}Dto){
		
		Response<Integer> response = new Response<>();
		if(${classNameLower}Dto == null){
			response.setMessage("${classNameLower}Dto参数不可为空");
			return response;
		}
		${className}PO ${classNameLower}po = new ${className}PO(); 
		BeanUtils.copyProperties(${classNameLower}Dto, ${classNameLower}po);
		
		Integer count = ${classNameLower}Service.getCountByCondition(${classNameLower}po);
		logger.info("count查询成功");
		
		response.setCode(0L);
		response.setResObject(count);
		response.setMessage("成功");
			
		return response;
	}
	

}