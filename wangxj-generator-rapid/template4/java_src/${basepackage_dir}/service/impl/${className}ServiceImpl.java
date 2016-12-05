<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>  
<#assign classNameFirstLower = className?uncap_first> 
package ${basepackage}.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
<#include "/java_imports.include">





import java.math.BigInteger;
import java.util.Map;

import org.kl.jdbc.framework.exception.BusinessException;
import org.kl.jdbc.framework.generator.SequenceGenerator;

import com.kl.auth.system.model.SysOrg;

@Service("${classNameLower}Service")
public class ${className}ServiceImpl implements I${className}Service {
	private static final Logger log = Logger.getLogger(${className}ServiceImpl.class);
	@Autowired
	private I${className}Dao ${classNameFirstLower}Dao;

	
	/**查询列表信息
	 * @param query
	 * @return list
	 */
	public List<${className}> select(Map queryParams) {
		return ${classNameFirstLower}Dao.select(queryParams);
	}
	
	
	/**分页查询
	 * @param query
	 * @return
	 */
	public DataGrid dataGrid(Query query) {
		// TODO Auto-generated method stub
		DataGrid<${className}> dg = new DataGrid<${className}>();
		dg.setTotal(${classNameFirstLower}Dao.getRecordCount(query.getQueryParams()));
		dg.setRows(${classNameFirstLower}Dao.queryByCondition(query));
		return dg;
	}
	
	/**
	 * 插入单条记录，用id作主键，把null全替换为""
	 * @param vo 用于添加的VO对象
	 * @return 若添加成功，返回新生成的id
	 */
	public String insert(${className} vo) {
		// TODO Auto-generated method stub
		SequenceGenerator oid = new SequenceGenerator();
		String [] ids = oid.generate(1);
		vo.set${table.idColumn.underscoreName?cap_first}(ids[0]);
		//todo
		//增加版本号和新增时间
		return ${classNameFirstLower}Dao.insert(vo)+"";
	}

	/**
	 * 批更新插入多条记录，用id作主键，把null全替换为""
	 * @param vos 添加的VO对象数组
	 * @return 若添加成功，返回新生成的id数组
	 */
	public String[] insertBatch(${className}[] vos) {
		SequenceGenerator oid = new SequenceGenerator();
		String[] ids =oid.generate(vos.length);
		for(int i = 0; i < vos.length ; i++){
			vos[i].set${table.idColumn.underscoreName?cap_first}(ids[i]);
			//todo
			//增加版本号和新增时间
		}
		return ${classNameFirstLower}Dao.insertBatch(vos);
	}

	/**
	 * 删除单条记录
	 * @param id 用于删除的记录的id
	 * @return 成功删除的记录数
	 */
	public int delete(String id) {
		// TODO Auto-generated method stub
		return ${classNameFirstLower}Dao.delete(id);
	}

	/**
	 * 删除多条记录
	 * @param id 用于删除的记录的id
	 * @return 成功删除的记录数
	 */
	public int deleteBatch(String[] ids) {
		// TODO Auto-generated method stub
		return ${classNameFirstLower}Dao.deleteBatch(ids);
	}
	
	/**
	 * 根据Id进行查询
	 * @param id 用于查找的id
	 * @return 查询到的VO对象
	 */
	public ${className} find(String id){
		return ${classNameFirstLower}Dao.find(id);
	}

	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int update(${className} vo) {
		${className} temp = find(vo.get${table.idColumn.underscoreName?cap_first}());
		if(temp == null) {
			throw new  BusinessException("数据异常");
		}
		BeanUtils.copyProperties(vo, temp,new String[]{""});
		//todo增加版本号 
		return ${classNameFirstLower}Dao.update(temp);
	}
	
	
	/**
	 * 更新单条记录
	 * @param vo 用于更新的VO对象
	 * @return 成功更新的记录数
	 */
	public int updateSelect(${className} vo) {
		${className} temp = find(vo.get${table.idColumn.underscoreName?cap_first}());
		if(temp == null) {
			throw new  BusinessException("数据异常");
		}
		//todo增加版本号 
		return ${classNameFirstLower}Dao.updateSelect(vo);
	}

	/**
	 * 批量更新修改多条记录
	 * @param vos 添加的VO对象数组
	 * @return 成功更新的记录数组
	 */
	public int updateBatch(${className}[] vos) {
		return ${classNameFirstLower}Dao.updateBatch(vos);
	}
	
}
