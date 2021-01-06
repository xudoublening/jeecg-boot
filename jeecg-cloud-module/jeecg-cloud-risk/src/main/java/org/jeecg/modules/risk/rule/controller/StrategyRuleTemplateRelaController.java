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
import org.jeecg.modules.risk.rule.entity.StrategyRuleTemplateRela;
import org.jeecg.modules.risk.rule.service.IStrategyRuleTemplateRelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

 /**
 * @Description: 策略 规则模板 关系表
 * @Author: jeecg-boot
 * @Date:   2021-01-04
 * @Version: V1.0
 */
@Api(tags="策略 规则模板 关系表")
@RestController
@RequestMapping("/rule/strategyRuleTemplateRela")
@Slf4j
public class StrategyRuleTemplateRelaController extends JeecgController<StrategyRuleTemplateRela, IStrategyRuleTemplateRelaService> {
	@Autowired
	private IStrategyRuleTemplateRelaService strategyRuleTemplateRelaService;
	
	/**
	 * 分页列表查询
	 *
	 * @param strategyRuleTemplateRela
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "策略 规则模板 关系表-分页列表查询")
	@ApiOperation(value="策略 规则模板 关系表-分页列表查询", notes="策略 规则模板 关系表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(StrategyRuleTemplateRela strategyRuleTemplateRela,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<StrategyRuleTemplateRela> queryWrapper = QueryGenerator.initQueryWrapper(strategyRuleTemplateRela, req.getParameterMap());
		Page<StrategyRuleTemplateRela> page = new Page<StrategyRuleTemplateRela>(pageNo, pageSize);
		IPage<StrategyRuleTemplateRela> pageList = strategyRuleTemplateRelaService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param strategyRuleTemplateRela
	 * @return
	 */
	@AutoLog(value = "策略 规则模板 关系表-添加")
	@ApiOperation(value="策略 规则模板 关系表-添加", notes="策略 规则模板 关系表-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody StrategyRuleTemplateRela strategyRuleTemplateRela) {
		strategyRuleTemplateRelaService.save(strategyRuleTemplateRela);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param strategyRuleTemplateRela
	 * @return
	 */
	@AutoLog(value = "策略 规则模板 关系表-编辑")
	@ApiOperation(value="策略 规则模板 关系表-编辑", notes="策略 规则模板 关系表-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody StrategyRuleTemplateRela strategyRuleTemplateRela) {
		strategyRuleTemplateRelaService.updateById(strategyRuleTemplateRela);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "策略 规则模板 关系表-通过id删除")
	@ApiOperation(value="策略 规则模板 关系表-通过id删除", notes="策略 规则模板 关系表-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		strategyRuleTemplateRelaService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "策略 规则模板 关系表-批量删除")
	@ApiOperation(value="策略 规则模板 关系表-批量删除", notes="策略 规则模板 关系表-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.strategyRuleTemplateRelaService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "策略 规则模板 关系表-通过id查询")
	@ApiOperation(value="策略 规则模板 关系表-通过id查询", notes="策略 规则模板 关系表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		StrategyRuleTemplateRela strategyRuleTemplateRela = strategyRuleTemplateRelaService.getById(id);
		if(strategyRuleTemplateRela==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(strategyRuleTemplateRela);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param strategyRuleTemplateRela
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, StrategyRuleTemplateRela strategyRuleTemplateRela) {
        return super.exportXls(request, strategyRuleTemplateRela, StrategyRuleTemplateRela.class, "策略 规则模板 关系表");
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
        return super.importExcel(request, response, StrategyRuleTemplateRela.class);
    }

}
