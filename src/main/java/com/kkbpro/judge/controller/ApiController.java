package com.kkbpro.judge.controller;

import com.kkbapps.iprestrictionsbootstarter.Annotation.EnableIPLimit;
import com.kkbpro.judge.pojo.Result;
import com.kkbpro.judge.utils.AuthorizationUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiController {

    /**
     * 获取签名密钥
     */
    @GetMapping("/getApiKey")
    @EnableIPLimit(count = Long.MAX_VALUE, interval = 10L * 60 * 1000)
    public Result getApiKey() {
        Map<String, Object> map = new HashMap<>();
        String AccessKey = AuthorizationUtil.createAccessKey();
        String SecretKey = AuthorizationUtil.createSecretKey(AccessKey);
        map.put("AccessKey", AccessKey);
        map.put("SecretKey", SecretKey);
        return Result.success(200,"获取API签名密钥成功", map);
    }


}
