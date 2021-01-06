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
import org.jeecg.modules.risk.rule.entity.MonitorLog;
import org.jeecg.modules.risk.rule.service.IMonitorLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

 /**
 * @Description: 监控日志
 * @Author: jeecg-boot
 * @Date:   2021-01-04
 * @Version: V1.0
 */
@Api(tags="监控日志")
@RestController
@RequestMapping("/rule/monitorLog")
@Slf4j
public class MonitorLogController extends JeecgController<MonitorLog, IMonitorLogService> {
	@Autowired
	private IMonitorLogService monitorLogService;
	
	/**
	 * 分页列表查询
	 *
	 * @param monitorLog
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "监控日志-分页列表查询")
	@ApiOperation(value="监控日志-分页列表查询", notes="监控日志-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(MonitorLog monitorLog,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<MonitorLog> queryWrapper = QueryGenerator.initQueryWrapper(monitorLog, req.getParameterMap());
		Page<MonitorLog> page = new Page<MonitorLog>(pageNo, pageSize);
		IPage<MonitorLog> pageList = monitorLogService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param monitorLog
	 * @return
	 */
	@AutoLog(value = "监控日志-添加")
	@ApiOperation(value="监控日志-添加", notes="监控日志-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody MonitorLog monitorLog) {
		monitorLogService.save(monitorLog);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param monitorLog
	 * @return
	 */
	@AutoLog(value = "监控日志-编辑")
	@ApiOperation(value="监控日志-编辑", notes="监控日志-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody MonitorLog monitorLog) {
		monitorLogService.updateById(monitorLog);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "监控日志-通过id删除")
	@ApiOperation(value="监控日志-通过id删除", notes="监控日志-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		monitorLogService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "监控日志-批量删除")
	@ApiOperation(value="监控日志-批量删除", notes="监控日志-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.monitorLogService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "监控日志-通过id查询")
	@ApiOperation(value="监控日志-通过id查询", notes="监控日志-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		MonitorLog monitorLog = monitorLogService.getById(id);
		if(monitorLog==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(monitorLog);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param monitorLog
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, MonitorLog monitorLog) {
        return super.exportXls(request, monitorLog, MonitorLog.class, "监控日志");
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
        return super.importExcel(request, response, MonitorLog.class);
    }

}
