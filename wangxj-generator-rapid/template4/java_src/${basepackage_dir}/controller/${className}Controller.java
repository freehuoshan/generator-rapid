<#include "/custom.include">
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>   
<#assign classNameLowerCase = className?lower_case>   
<#assign pkJavaType = table.idColumn.javaType>   

package ${basepackage}.controller;

import org.apache.log4j.Logger;

import com.kl.auth.system.controller.SysOrgController;


<#include "/java_imports.include">
@Controller
@RequestMapping("/${namespace}/${classNameFirstLower}Control")
public class ${className}Controller extends BaseController{
	private static final Logger log = Logger.getLogger(${className}Controller.class);
	@Autowired
	private I${className}Service ${classNameFirstLower}Service;

	public ${className}Controller() {
		super.folder = "/jsp/${namespace}/${classNameLowerCase}/";
	}

	/**
	 * 获取数据表格
	 * @param request
	 * @param pager
	 * @return
	 */
	@RequestMapping("/dataGrid")
	@ResponseBody
	public DataGrid dataGrid(HttpServletRequest request, Pager pager) {
		Query query = new Query();
		query.setPager(pager);
		query.setQueryParams((Map<String, Object>) getQueryCondition(request));
		return ${classNameFirstLower}Service.dataGrid(query);
	}

	/**
	 * 跳转到添加页面
	 * @param 
	 * @return
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return redirectJsp("${classNameLowerCase}_"+FORWARD_EDIT_PAGE);
	}
	
	@RequestMapping("/listPage")
	public String listPage() {
		return redirectJsp("${classNameLowerCase}_"+FORWARD_LIST_PAGE);
	}
	/**
	 * 跳转到修改页面
	 * @param request
	 * @param ${table.idColumn.underscoreName}
	 * @return
	 */
	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, String ${table.idColumn.underscoreName}) {
		${className} bean = ${classNameFirstLower}Service.find(${table.idColumn.underscoreName});
		request.setAttribute(REQUEST_BEAN, bean);
		return redirectJsp("${classNameLowerCase}_"+FORWARD_EDIT_PAGE);
	}

	/**
	 * 跳转到查看页面
	 * @param request
	 * @param ${table.idColumn.underscoreName}
	 * @return
	 */
	@RequestMapping("/detailPage")
	public String detailPage(HttpServletRequest request, String ${table.idColumn.underscoreName}) {
		${className} bean = ${classNameFirstLower}Service.find(${table.idColumn.underscoreName});
		request.setAttribute(REQUEST_BEAN, bean);
		return redirectJsp("${classNameLowerCase}_"+FORWARD_DETAIL_PAGE);
	}

	/**
	 * 增加一条记录
	 * @param ${className} vo
	 * @return JSON
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public Json insert(${className} vo) {
		Json j = new Json();
		try {
			${classNameFirstLower}Service.insert(vo);
			j.setSuccess(true);
			j.setMsg("增加成功！");
		} catch (Exception e) {
			e.printStackTrace();
			j.setMsg("操作失败！"+e.getMessage());
			log.error(e.getMessage(), e);
		}
		return j;
	}

	/**
	 * 修改一条记录
	 * @param vo
	 * @return JSON
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Json update(${className} vo) {
		Json j = new Json();
		try {
			${classNameFirstLower}Service.update(vo);
			j.setSuccess(true);
			j.setMsg("编辑成功！");
		} catch (Exception e) {
			e.printStackTrace();
			j.setMsg("操作失败！"+e.getMessage());
			log.error(e.getMessage(), e);
		}
		return j;
	}

	/**
	 * 从页面的表单获取一条记录id，并删除多条记录
	 * @param ${table.idColumn.underscoreName}
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(String ${table.idColumn.underscoreName}) {
		Json j = new Json();
		try {
			${classNameFirstLower}Service.delete(${table.idColumn.underscoreName});
			j.setMsg("删除成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			j.setMsg("操作失败！"+e.getMessage());
			log.error(e.getMessage(), e);
		}
		return j;
	}

	/**
	 * 从页面的表单获取多条记录id，并删除多条记录
	 * @param ${table.idColumn.underscoreName}s
	 * @return Json
	 * @throws Exception
	 */
	@RequestMapping("/deleteMulti")
	@ResponseBody
	public Json deleteMulti(String ${table.idColumn.underscoreName}s) {
		String[] ids = ${table.idColumn.underscoreName}s.split(${table.idColumn.underscoreName}s);
		Json j = new Json();
		try {
			${classNameFirstLower}Service.deleteBatch(ids);
			j.setMsg("删除成功！");
			j.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			j.setMsg("操作失败！"+e.getMessage());
			log.error(e.getMessage(), e);
		}
		return j;
	}

	@Override
	public Map<?, ?> getQueryCondition(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Map<String, Object> queryParams = new HashMap<String, Object>();

		return queryParams;
	}
}