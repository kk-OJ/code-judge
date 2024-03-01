package com.kkbapps.judge.utils.code;

import com.kkbapps.judge.constant.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * CodeTemplate工厂类
 */
public class CodeTemplateFactory {

    private static Map<Integer,CodeTemplate> codeTemplateMap = new HashMap<>();

    static {
        for(int i=0;i< Constants.LANGUAGE.length;i++) {
            String className = Constants.LANG_CODETEMPLATE_CLASSNAME[i];
            // 获取字节码对象
            try {
                Class clazz = Class.forName(className);
                CodeTemplate codeTemplate = (CodeTemplate) clazz.newInstance();
                codeTemplateMap.put(i,codeTemplate);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static CodeTemplate get(Integer index) {
        return codeTemplateMap.get(index);
    }
}
