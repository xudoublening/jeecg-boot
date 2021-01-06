package org.jeecg.modules.risk.rule.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeecg.modules.risk.rule.entity.Rule;
import org.jeecg.modules.risk.rule.mapper.RuleMapper;
import org.jeecg.modules.risk.rule.service.IRuleService;
import org.springframework.stereotype.Service;

/**
 * @Description: 规则表（已实例化）
 * @Author: jeecg-boot
 * @Date:   2021-01-04
 * @Version: V1.0
 */
@Service
public class RuleServiceImpl extends ServiceImpl<RuleMapper, Rule> implements IRuleService {

}
