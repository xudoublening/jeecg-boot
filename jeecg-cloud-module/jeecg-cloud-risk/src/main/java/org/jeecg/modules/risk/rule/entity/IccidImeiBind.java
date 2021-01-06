package org.jeecg.modules.risk.rule.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jeecgframework.poi.excel.annotation.Excel;

import java.io.Serializable;

/**
 * @Description: 物联卡  机卡绑定表
 * @Author: jeecg-boot
 * @Date:   2021-01-04
 * @Version: V1.0
 */
@Data
@TableName("ru_iccid_imei_bind")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ru_iccid_imei_bind对象", description="物联卡  机卡绑定表")
public class IccidImeiBind implements Serializable {
    private static final long serialVersionUID = 1L;

	/**iccid*/
	@Excel(name = "iccid", width = 15)
    @ApiModelProperty(value = "iccid")
    private String iccid;
	/**1  :   首话绑定  （数据由大数据生成插入）
            2  ：手动绑定 imei方式
            3  ：手动绑定 tac 方式*/
	@Excel(name = "1:首话绑定（数据由大数据生成插入）;2 ：手动绑定 imei方式;3  ：手动绑定 tac 方式", width = 15)
    @ApiModelProperty(value = "1  :   首话绑定  （数据由大数据生成插入） 2  ：手动绑定 imei方式 3  ：手动绑定 tac 方式")
    private String bindType;
	/**imeiTac*/
	@Excel(name = "imeiTac", width = 15)
    @ApiModelProperty(value = "imeiTac")
    private String imeiTac;
}
