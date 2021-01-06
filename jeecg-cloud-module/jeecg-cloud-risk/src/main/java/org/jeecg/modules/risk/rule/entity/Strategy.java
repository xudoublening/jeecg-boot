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
 * @Description: ru_strategy
 * @Author: jeecg-boot
 * @Date:   2021-01-04
 * @Version: V1.0
 */
@Data
@TableName("ru_strategy")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ru_strategy对象", description="ru_strategy")
public class Strategy implements Serializable {
    private static final long serialVersionUID = 1L;

	/**strategyId*/
	@Excel(name = "strategyId", width = 15)
    @ApiModelProperty(value = "strategyId")
    private Integer strategyId;
	/**
            11 : 人联网风控 业务 ( IOP ) 
            13：物联网风控 业务（IOT） 
            19：智能营销业务*/
	@Excel(name = "11 : 人联网风控 业务 ( IOP ) 13：物联网风控 业务（IOT）19：智能营销业务", width = 15)
    @ApiModelProperty(value = "11 : 人联网风控 业务 ( IOP ) 13：物联网风控 业务（IOT）19：智能营销业务")
    private String svcType;
	/**strategyType*/
	@Excel(name = "strategyType", width = 15)
    @ApiModelProperty(value = "strategyType")
    private String strategyType;
	/**strategyName*/
	@Excel(name = "strategyName", width = 15)
    @ApiModelProperty(value = "strategyName")
    private String strategyName;
	/**对象集 简单描述说明*/
	@Excel(name = "对象集 简单描述说明", width = 15)
    @ApiModelProperty(value = "对象集 简单描述说明")
    private String remark;
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
	/**
            0：已失效（删除）
            1:   正常*/
	@Excel(name = "0：已失效（删除）；1:   正常", width = 15)
    @ApiModelProperty(value = "0：已失效（删除）；1:   正常")
    private String status;
}
