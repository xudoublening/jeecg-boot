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
 * @Description: 规则表（已实例化）
 * @Author: jeecg-boot
 * @Date:   2021-01-04
 * @Version: V1.0
 */
@Data
@TableName("ru_rule")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ru_rule对象", description="规则表（已实例化）")
public class Rule implements Serializable {
    private static final long serialVersionUID = 1L;

	/**ruleId*/
	@Excel(name = "ruleId", width = 15)
    @ApiModelProperty(value = "ruleId")
    private Integer ruleId;
	/**objectsId*/
	@Excel(name = "objectsId", width = 15)
    @ApiModelProperty(value = "objectsId")
    private Integer objectsId;
	/**strategyId*/
	@Excel(name = "strategyId", width = 15)
    @ApiModelProperty(value = "strategyId")
    private Integer strategyId;
	/**ruleTemplateId*/
	@Excel(name = "ruleTemplateId", width = 15)
    @ApiModelProperty(value = "ruleTemplateId")
    private Integer ruleTemplateId;
	/**
            11 : 人联网风控 业务 ( IOP ) 
            13：物联网风控 业务（IOT）   
            19：智能营销业务*/
	@Excel(name = "11 : 人联网风控 业务 ( IOP ) 13：物联网风控 业务（IOT） 19：智能营销业务", width = 15)
    @ApiModelProperty(value = "11 : 人联网风控 业务 ( IOP ) 13：物联网风控 业务（IOT） 19：智能营销业务")
    private java.lang.String svcType;
	/**triggerValue*/
	@Excel(name = "triggerValue", width = 15)
    @ApiModelProperty(value = "triggerValue")
    private java.lang.String triggerValue;
	/**（ 所有都会  生成日志）
            1:   什么都不做   
            2：发送短信
            3：邮件通知
            4：api调用  （这就是更灵活的动作了）*/
	@Excel(name = "（ 所有都会  生成日志）1:什么都不做 2：发送短信 3：邮件通知 4：api调用  （这就是更灵活的动作了）", width = 15)
    @ApiModelProperty(value = "（ 所有都会  生成日志）1:什么都不做 2：发送短信 3：邮件通知 4：api调用  （这就是更灵活的动作了）")
    private java.lang.String action;
	/**actionParam*/
	@Excel(name = "actionParam", width = 15)
    @ApiModelProperty(value = "actionParam")
    private java.lang.String actionParam;
	/**如果状态是  禁用     生效中的也不起作用*/
	@Excel(name = "如果状态是  禁用     生效中的也不起作用", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "如果状态是  禁用     生效中的也不起作用")
    private java.util.Date activeTime;
	/**inactiveTime*/
	@Excel(name = "inactiveTime", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "inactiveTime")
    private Date inactiveTime;
	/**userId*/
	@Excel(name = "userId", width = 15)
    @ApiModelProperty(value = "userId")
    private String userId;
	/**createTime*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "createTime")
    private Date createTime;
	/**1:  启用
            2：禁用  （要想修改需先禁用）
            3：删除 
            */
	@Excel(name = "1:启用  2：禁用（要想修改需先禁用） 3：删除 ", width = 15)
    @ApiModelProperty(value = "1:启用  2：禁用（要想修改需先禁用） 3：删除 ")
    private java.lang.String state;
	/**stateChgTime*/
	@Excel(name = "stateChgTime", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "stateChgTime")
    private Date stateChgTime;
}
