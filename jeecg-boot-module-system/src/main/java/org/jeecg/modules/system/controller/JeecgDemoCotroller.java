package org.jeecg.modules.system.controller;

import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: zhangjingbiao
 * @Date: 2020/12/4 18:31
 */
@RestController
@RequestMapping("/test/jeecgDemo")
@Slf4j
public class JeecgDemoCotroller {

    @GetMapping(value = "/hello")
    public Result<String> hello(){
        Result<String> result = new Result<>();
        result.setResult("Hello World");
        result.setSuccess(true);
        return result;
    }

}
