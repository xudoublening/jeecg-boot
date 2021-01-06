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
import org.jeecg.modules.risk.rule.entity.IccidImeiBind;
import org.jeecg.modules.risk.rule.service.IIccidImeiBindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

 /**
 * @Description: 物联卡  机卡绑定表
 * @Author: jeecg-boot
 * @Date:   2021-01-04
 * @Version: V1.0
 */
@Api(tags="物联卡  机卡绑定表")
@RestController
@RequestMapping("/rule/iccidImeiBind")
@Slf4j
public class IccidImeiBindController extends JeecgController<IccidImeiBind, IIccidImeiBindService> {
	@Autowired
	private IIccidImeiBindService iccidImeiBindService;
	
	/**
	 * 分页列表查询
	 *
	 * @param iccidImeiBind
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "物联卡  机卡绑定表-分页列表查询")
	@ApiOperation(value="物联卡  机卡绑定表-分页列表查询", notes="物联卡  机卡绑定表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(IccidImeiBind iccidImeiBind,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<IccidImeiBind> queryWrapper = QueryGenerator.initQueryWrapper(iccidImeiBind, req.getParameterMap());
		Page<IccidImeiBind> page = new Page<IccidImeiBind>(pageNo, pageSize);
		IPage<IccidImeiBind> pageList = iccidImeiBindService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param iccidImeiBind
	 * @return
	 */
	@AutoLog(value = "物联卡  机卡绑定表-添加")
	@ApiOperation(value="物联卡  机卡绑定表-添加", notes="物联卡  机卡绑定表-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody IccidImeiBind iccidImeiBind) {
		iccidImeiBindService.save(iccidImeiBind);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param iccidImeiBind
	 * @return
	 */
	@AutoLog(value = "物联卡  机卡绑定表-编辑")
	@ApiOperation(value="物联卡  机卡绑定表-编辑", notes="物联卡  机卡绑定表-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody IccidImeiBind iccidImeiBind) {
		iccidImeiBindService.updateById(iccidImeiBind);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "物联卡  机卡绑定表-通过id删除")
	@ApiOperation(value="物联卡  机卡绑定表-通过id删除", notes="物联卡  机卡绑定表-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		iccidImeiBindService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "物联卡  机卡绑定表-批量删除")
	@ApiOperation(value="物联卡  机卡绑定表-批量删除", notes="物联卡  机卡绑定表-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.iccidImeiBindService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "物联卡  机卡绑定表-通过id查询")
	@ApiOperation(value="物联卡  机卡绑定表-通过id查询", notes="物联卡  机卡绑定表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		IccidImeiBind iccidImeiBind = iccidImeiBindService.getById(id);
		if(iccidImeiBind==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(iccidImeiBind);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param iccidImeiBind
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, IccidImeiBind iccidImeiBind) {
        return super.exportXls(request, iccidImeiBind, IccidImeiBind.class, "物联卡  机卡绑定表");
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
        return super.importExcel(request, response, IccidImeiBind.class);
    }

}
