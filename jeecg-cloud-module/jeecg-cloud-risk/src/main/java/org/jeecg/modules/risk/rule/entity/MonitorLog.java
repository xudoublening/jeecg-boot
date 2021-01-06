package org.jeecg.modules.risk.rule.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: ru_monitor_log
 * @Author: jeecg-boot
 * @Date:   2021-01-04
 * @Version: V1.0
 */
@Data
@TableName("ru_monitor_log")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ru_monitor_log对象", description="ru_monitor_log")
public class MonitorLog implements Serializable {
    private static final long serialVersionUID = 1L;

	/**logId*/
	@Excel(name = "logId", width = 15)
    @ApiModelProperty(value = "logId")
    private Integer logId;
	/**ruleId*/
	@Excel(name = "ruleId", width = 15)
    @ApiModelProperty(value = "ruleId")
    private Integer ruleId;
	/**triggerTime*/
	@Excel(name = "triggerTime", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "triggerTime")
    private Date triggerTime;
	/**svcNumber*/
	@Excel(name = "svcNumber", width = 15)
    @ApiModelProperty(value = "svcNumber")
    private String svcNumber;
	/**sujbsId*/
	@Excel(name = "sujbsId", width = 15)
    @ApiModelProperty(value = "sujbsId")
    private Integer sujbsId;
	/**custId*/
	@Excel(name = "custId", width = 15)
    @ApiModelProperty(value = "custId")
    private Integer custId;
	/**custName*/
	@Excel(name = "custName", width = 15)
    @ApiModelProperty(value = "custName")
    private String custName;
	/**chlId*/
	@Excel(name = "chlId", width = 15)
    @ApiModelProperty(value = "chlId")
    private String chlId;
	/**triggerDesc*/
	@Excel(name = "triggerDesc", width = 15)
    @ApiModelProperty(value = "triggerDesc")
    private String triggerDesc;
	/**actionDesc*/
	@Excel(name = "actionDesc", width = 15)
    @ApiModelProperty(value = "actionDesc")
    private String actionDesc;
	/**actionTime*/
	@Excel(name = "actionTime", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "actionTime")
    private Date actionTime;
}
