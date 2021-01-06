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
import org.jeecg.modules.risk.rule.entity.MonitorObjectsDef;
import org.jeecg.modules.risk.rule.service.IMonitorObjectsDefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

 /**
 * @Description: 监控 对象集合 定义表
 * @Author: jeecg-boot
 * @Date:   2021-01-04
 * @Version: V1.0
 */
@Api(tags="监控 对象集合 定义表")
@RestController
@RequestMapping("/rule/monitorObjectsDef")
@Slf4j
public class MonitorObjectsDefController extends JeecgController<MonitorObjectsDef, IMonitorObjectsDefService> {
	@Autowired
	private IMonitorObjectsDefService monitorObjectsDefService;
	
	/**
	 * 分页列表查询
	 *
	 * @param monitorObjectsDef
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "监控 对象集合 定义表-分页列表查询")
	@ApiOperation(value="监控 对象集合 定义表-分页列表查询", notes="监控 对象集合 定义表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(MonitorObjectsDef monitorObjectsDef,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		log.info("开始查询监控对象集合");
		QueryWrapper<MonitorObjectsDef> queryWrapper = QueryGenerator.initQueryWrapper(monitorObjectsDef, req.getParameterMap());
		Page<MonitorObjectsDef> page = new Page<MonitorObjectsDef>(pageNo, pageSize);
		IPage<MonitorObjectsDef> pageList = monitorObjectsDefService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param monitorObjectsDef
	 * @return
	 */
	@AutoLog(value = "监控 对象集合 定义表-添加")
	@ApiOperation(value="监控 对象集合 定义表-添加", notes="监控 对象集合 定义表-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody MonitorObjectsDef monitorObjectsDef) {
		monitorObjectsDefService.save(monitorObjectsDef);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param monitorObjectsDef
	 * @return
	 */
	@AutoLog(value = "监控 对象集合 定义表-编辑")
	@ApiOperation(value="监控 对象集合 定义表-编辑", notes="监控 对象集合 定义表-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody MonitorObjectsDef monitorObjectsDef) {
		monitorObjectsDefService.updateById(monitorObjectsDef);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "监控 对象集合 定义表-通过id删除")
	@ApiOperation(value="监控 对象集合 定义表-通过id删除", notes="监控 对象集合 定义表-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		monitorObjectsDefService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "监控 对象集合 定义表-批量删除")
	@ApiOperation(value="监控 对象集合 定义表-批量删除", notes="监控 对象集合 定义表-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.monitorObjectsDefService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "监控 对象集合 定义表-通过id查询")
	@ApiOperation(value="监控 对象集合 定义表-通过id查询", notes="监控 对象集合 定义表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		MonitorObjectsDef monitorObjectsDef = monitorObjectsDefService.getById(id);
		if(monitorObjectsDef==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(monitorObjectsDef);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param monitorObjectsDef
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, MonitorObjectsDef monitorObjectsDef) {
        return super.exportXls(request, monitorObjectsDef, MonitorObjectsDef.class, "监控 对象集合 定义表");
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
        return super.importExcel(request, response, MonitorObjectsDef.class);
    }

}
