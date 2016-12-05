<#include "/java_copyright.include">
<#assign classNameService = "RPay"+table.className>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign classNameLowerCase = table.classNameLowerCase> 

package com.kalian.replacepay.provide.service.share.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import com.kalian.replacepay.provide.service.${className}Service;
import com.kalian.replacepay.provide.service.ReplacePayResponse;
import com.kalian.replacepay.provide.service.dto.${className}DTO;
import com.kalian.replacepay.provide.po.${className}PO;
import com.kalian.replacepay.provide.service.share.${classNameService}Service;

public class ${classNameService}ServiceImpl implements ${classNameService}Service{
	
	private static Logger logger = Logger.getLogger(${classNameService}ServiceImpl.class);
	
	@Resource
	private ${className}Service ${classNameLower}Service;
	
	@Override
	public ReplacePayResponse<Integer> add(${className}DTO ${classNameLower}Dto){
		
		ReplacePayResponse<Integer> response = new ReplacePayResponse<Integer>();
		
		if(${classNameLower}Dto == null){
			response.setMessage("传入参数不可为空");
			return response;
		}
		
		${className}PO ${classNameLower}po = new ${className}PO(); 
		BeanUtils.copyProperties(${classNameLower}Dto, ${classNameLower}po);
		List<Integer> countList = new ArrayList<>();
		Integer count = 0;
		
		try {
			count = ${classNameLower}Service.add(${classNameLower}po);
			logger.info("新增${className}DTO成功");
			
			countList.add(count);
			response.setCode(0L);
			response.setData(countList);
			response.setMessage("成功");
			
		} catch (Exception e) {
			logger.info("新增${className}DTO出错，回滚");
			response.setMessage("新增${className}DTO出错，回滚");
			throw e;
		}
		return response;
	}
	
	@Override
	public ReplacePayResponse<Integer> modifyByKey(${className}DTO ${classNameLower}Dto) {
		
		ReplacePayResponse<Integer> response = new ReplacePayResponse<>();
		if(${classNameLower}Dto == null){
			response.setMessage("${classNameLower}Dto参数不可为空");
			return response;
		}
		${className}PO ${classNameLower}po = new ${className}PO(); 
		List<Integer> countList = new ArrayList<>();
		BeanUtils.copyProperties(${classNameLower}Dto, ${classNameLower}po);
		Integer count = 0;
		
		try {
			count = ${classNameLower}Service.modifyByKey(${classNameLower}po);
			logger.info("modify${className}DTO修改成功");
			
			countList.add(count);
			response.setCode(0L);
			response.setData(countList);
			response.setMessage("成功");
			
		} catch (Exception e) {
			logger.error("modify${className}DTO修改数据库出错，回滚");
			response.setMessage("modify${className}DTO修改数据库出错，回滚");
			throw e;
		}
		return response;
	}
	
	@Override
	public ReplacePayResponse<${className}DTO> queryListByCondition(${className}DTO ${classNameLower}Dto) {
		
		ReplacePayResponse<${className}DTO> response = new ReplacePayResponse<>();
		if(${classNameLower}Dto == null){
			response.setMessage("${classNameLower}Dto参数不可为空");
			return response;
		}
		${className}PO ${classNameLower}Po = new ${className}PO();
		List<${className}PO> listPo = new ArrayList<>();
		List<${className}DTO> listDto = new ArrayList<>();
		BeanUtils.copyProperties(${classNameLower}Dto, ${classNameLower}Po);
		
		try {
			listPo = ${classNameLower}Service.queryListByCondition(${classNameLower}Po);
			logger.info("查询queryList成功");
			if(listPo.size() == 0){
				response.setCode(0L);
				response.setData(null);
				response.setMessage("成功");
				return response;
			}
			for (Iterator<${className}PO> iterator = listPo.iterator(); iterator.hasNext();) {
				
				${className}PO ${classNameLower}Po2 = (${className}PO)iterator.next();
				${className}DTO ${classNameLower}Dto2 = new ${className}DTO();
				BeanUtils.copyProperties(${classNameLower}Po2, ${classNameLower}Dto2);
				listDto.add(${classNameLower}Dto2);
			}
			response.setCode(0L);
			response.setData(listDto);
			response.setMessage("成功");
		} catch (Exception e) {
			logger.error("查询queryList成功出错");
			response.setMessage("数据库查询queryList出错");
			e.printStackTrace();
		}
		
		return response;
		
	}
	
	@Override
	public ReplacePayResponse<${className}DTO> queryPageListByCondition(${className}DTO ${classNameLower}Dto, int pageNum, int limit) {
		
		ReplacePayResponse<${className}DTO> response = new ReplacePayResponse<>();
		if(${classNameLower}Dto == null){
			response.setMessage("${classNameLower}Dto参数不可为空");
			return response;
		}
		${className}PO ${classNameLower}Po = new ${className}PO();
		List<${className}PO> listPo = new ArrayList<>();
		List<${className}DTO> listDto = new ArrayList<>();
		BeanUtils.copyProperties(${classNameLower}Dto, ${classNameLower}Po);
		
		try {
			listPo = ${classNameLower}Service.queryPageListByCondition(${classNameLower}Po,pageNum,limit);
			logger.info("查询queryPageList成功");
			if(listPo.size() == 0){
				response.setCode(0L);
				response.setData(null);
				response.setMessage("成功");
				return response;
			}
			for (Iterator<${className}PO> iterator = listPo.iterator(); iterator.hasNext();) {
				
				${className}PO ${classNameLower}Po2 = (${className}PO)iterator.next();
				${className}DTO ${classNameLower}Dto2 = new ${className}DTO();
				BeanUtils.copyProperties(${classNameLower}Po2, ${classNameLower}Dto2);
				listDto.add(${classNameLower}Dto2);
			}
			response.setCode(0L);
			response.setData(listDto);
			response.setMessage("成功");
		} catch (Exception e) {
			logger.error("查询queryPageList成功出错");
			response.setMessage("数据库查询queryPageList出错");
			e.printStackTrace();
		}
		
		return response;
		
	}
	
	@Override
	public ReplacePayResponse<Integer> getCountByCondition(${className}DTO ${classNameLower}Dto) {
		
		ReplacePayResponse<Integer> response = new ReplacePayResponse<>();
		if(${classNameLower}Dto == null){
			response.setMessage("${classNameLower}Dto参数不可为空");
			return response;
		}
		${className}PO ${classNameLower}po = new ${className}PO(); 
		List<Integer> countList = new ArrayList<>();
		BeanUtils.copyProperties(${classNameLower}Dto, ${classNameLower}po);
		Integer count = 0;
		
		try {
			count = ${classNameLower}Service.getCountByCondition(${classNameLower}po);
			logger.info("count查询成功");
			
			countList.add(count);
			response.setCode(0L);
			response.setData(countList);
			response.setMessage("成功");
			
		} catch (Exception e) {
			logger.error("count查询成功");
			response.setMessage("count查询成功");
			e.printStackTrace();
		}
		return response;
	}
	
	
}
