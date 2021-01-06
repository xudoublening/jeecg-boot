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
 * @Description: 规则模板
 * @Author: jeecg-boot
 * @Date:   2021-01-04
 * @Version: V1.0
 */
@Data
@TableName("ru_rule_template")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ru_rule_template对象", description="规则模板")
public class RuleTemplate implements Serializable {
    private static final long serialVersionUID = 1L;

	/**ruleTemplateId*/
	@Excel(name = "ruleTemplateId", width = 15)
    @ApiModelProperty(value = "ruleTemplateId")
    private Integer ruleTemplateId;
	/**
            11 : 人联网风控 业务 ( IOP ) 
            13：物联网风控 业务（IOT）  
            19：智能营销业务*/
	@Excel(name = "11 : 人联网风控 业务 ( IOP ) 13：物联网风控 业务（IOT）19：智能营销业务", width = 15)
    @ApiModelProperty(value = "11 : 人联网风控 业务 ( IOP ) 13：物联网风控 业务（IOT）19：智能营销业务")
    private String svcType;
	/**ruleType*/
	@Excel(name = "ruleType", width = 15)
    @ApiModelProperty(value = "ruleType")
    private String ruleType;
	/**  如：高风险区域限制   */
	@Excel(name = "  如：高风险区域限制   ", width = 15)
    @ApiModelProperty(value = "  如：高风险区域限制   ")
    private String triggerType;
	/**如： 当超出  ${AREA_CODE｝地市使用时 触发*/
	@Excel(name = "如： 当超出  ${AREA_CODE｝地市使用时 触发", width = 15)
    @ApiModelProperty(value = "如： 当超出  ${AREA_CODE｝地市使用时 触发")
    private String triggerTemplate;
	/**triggerParams*/
	@Excel(name = "triggerParams", width = 15)
    @ApiModelProperty(value = "triggerParams")
    private String triggerParams;
	/**userId*/
	@Excel(name = "userId", width = 15)
    @ApiModelProperty(value = "userId")
    private String userId;
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
	/**1:  正常在用
            0：已删除*/
	@Excel(name = "1:正常在用 0：已删除", width = 15)
    @ApiModelProperty(value = "1:正常在用 0：已删除")
    private String status;
}
