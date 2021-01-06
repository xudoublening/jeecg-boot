package org.jeecg.modules.risk.rule.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.modules.risk.rule.entity.Rule;
import org.jeecg.modules.risk.rule.service.IRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

 /**
 * @Description: 规则表（已实例化）
 * @Author: jeecg-boot
 * @Date:   2021-01-04
 * @Version: V1.0
 */
@Api(tags="规则表（已实例化）")
@RestController
@RequestMapping("/rule/rule")
@Slf4j
public class RuleController extends JeecgController<Rule, IRuleService> {
	@Autowired
	private IRuleService ruleService;
	
	/**
	 * 分页列表查询
	 *
	 * @param rule
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "规则表（已实例化）-分页列表查询")
	@ApiOperation(value="规则表（已实例化）-分页列表查询", notes="规则表（已实例化）-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(Rule rule,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<Rule> queryWrapper = QueryGenerator.initQueryWrapper(rule, req.getParameterMap());
		Page<Rule> page = new Page<Rule>(pageNo, pageSize);
		IPage<Rule> pageList = ruleService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param rule
	 * @return
	 */
	@AutoLog(value = "规则表（已实例化）-添加")
	@ApiOperation(value="规则表（已实例化）-添加", notes="规则表（已实例化）-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody Rule rule) {
		ruleService.save(rule);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param rule
	 * @return
	 */
	@AutoLog(value = "规则表（已实例化）-编辑")
	@ApiOperation(value="规则表（已实例化）-编辑", notes="规则表（已实例化）-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody Rule rule) {
		ruleService.updateById(rule);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "规则表（已实例化）-通过id删除")
	@ApiOperation(value="规则表（已实例化）-通过id删除", notes="规则表（已实例化）-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		ruleService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "规则表（已实例化）-批量删除")
	@ApiOperation(value="规则表（已实例化）-批量删除", notes="规则表（已实例化）-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.ruleService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "规则表（已实例化）-通过id查询")
	@ApiOperation(value="规则表（已实例化）-通过id查询", notes="规则表（已实例化）-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		Rule rule = ruleService.getById(id);
		if(rule==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(rule);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param rule
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Rule rule) {
        return super.exportXls(request, rule, Rule.class, "规则表（已实例化）");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, Rule.class);
    }

}
