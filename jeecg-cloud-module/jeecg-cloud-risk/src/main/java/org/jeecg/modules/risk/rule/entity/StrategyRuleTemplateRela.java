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
 * @Description: 策略 规则模板 关系表
 * @Author: jeecg-boot
 * @Date:   2021-01-04
 * @Version: V1.0
 */
@Data
@TableName("ru_strategy_rule_template_rela")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ru_strategy_rule_template_rela对象", description="策略 规则模板 关系表")
public class StrategyRuleTemplateRela implements Serializable {
    private static final long serialVersionUID = 1L;

	/**relaId*/
	@Excel(name = "relaId", width = 15)
    @ApiModelProperty(value = "relaId")
    private Integer relaId;
	/**strategyId*/
	@Excel(name = "strategyId", width = 15)
    @ApiModelProperty(value = "strategyId")
    private Integer strategyId;
	/**ruleTemplateId*/
	@Excel(name = "ruleTemplateId", width = 15)
    @ApiModelProperty(value = "ruleTemplateId")
    private Integer ruleTemplateId;
}
