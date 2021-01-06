package org.jeecg.modules.risk.rule.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 监控 对象集合 定义表
 * @Author: jeecg-boot
 * @Date:   2021-01-04
 * @Version: V1.0
 */
@Data
@TableName("ru_monitor_objects_def")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ru_monitor_objects_def对象", description="监控 对象集合 定义表")
public class MonitorObjectsDef implements Serializable {
    private static final long serialVersionUID = 1L;

	/**objectsId*/
	@Excel(name = "objectsId", width = 15)
    @ApiModelProperty(value = "objectsId")
    private Integer objectsId;
	/**
            11 : 人联网风控 业务 ( IOP ) 
            13：物联网风控 业务（IOT）   
            19：智能营销业务*/
	@Excel(name = "11 : 人联网风控 业务 ( IOP ) 13：物联网风控 业务（IOT）19：智能营销业务", width = 15)
    @ApiModelProperty(value = "11 : 人联网风控 业务 ( IOP ) 13：物联网风控 业务（IOT） 19：智能营销业务")
    private String svcType;
	/**（可考虑 系统自动按规则生成）*/
	@Excel(name = "（可考虑 系统自动按规则生成）", width = 15)
    @ApiModelProperty(value = "（可考虑 系统自动按规则生成）")
    private String objectsName;
	/**objectsType*/
	@Excel(name = "objectsType", width = 15)
    @ApiModelProperty(value = "objectsType")
    private String objectsType;
	/**objectsDef*/
	@Excel(name = "objectsDef", width = 15)
    @ApiModelProperty(value = "objectsDef")
    private String objectsDef;
	/**1、开机
            2、停机
            3、半停
            4、销户*/
	@Excel(name = "1、开机 2、停机 3、半停 4、销户", width = 15)
    @ApiModelProperty(value = "1、开机 2、停机 3、半停 4、销户")
    private String serviceStatus;
	/**basicOrgId*/
	@Excel(name = "basicOrgId", width = 15)
    @ApiModelProperty(value = "basicOrgId")
    private String basicOrgId;
	/**当前时间  -  JOIN_TIME*/
	@Excel(name = "当前时间  -  JOIN_TIME", width = 15)
    @ApiModelProperty(value = "当前时间  -  JOIN_TIME")
    private Integer joinDayLeft;
	/**joinDayRight*/
	@Excel(name = "joinDayRight", width = 15)
    @ApiModelProperty(value = "joinDayRight")
    private Integer joinDayRight;
	/**对象集 简单描述说明*/
	@Excel(name = "对象集 简单描述说明", width = 15)
    @ApiModelProperty(value = "对象集 简单描述说明")
    private String remark;
	/**createTime*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "createTime")
    private Date createTime;
	/**updateTime*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "updateTime")
    private Date updateTime;
	/**userId*/
	@Excel(name = "userId", width = 15)
    @ApiModelProperty(value = "userId")
    private String userId;
	/**1:  正常   0：删除*/
	@Excel(name = "1:  正常   0：删除", width = 15)
    @ApiModelProperty(value = "1:  正常   0：删除")
    private String status;
}
