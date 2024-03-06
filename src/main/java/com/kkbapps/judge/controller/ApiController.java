package com.kkbapps.judge.controller;

import com.kkbapps.judge.pojo.Result;
import com.kkbapps.judge.utils.AuthorizationUtil;
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
    public Result getApiKey() {
        Map<String, Object> map = new HashMap<>();
        String AccessKey = AuthorizationUtil.createAccessKey();
        String SecretKey = AuthorizationUtil.createSecretKey(AccessKey);
        map.put("AccessKey", AccessKey);
        map.put("SecretKey", SecretKey);
        return Result.success(200,"获取API签名密钥成功", map);
    }


}
