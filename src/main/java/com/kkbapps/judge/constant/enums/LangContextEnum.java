package com.kkbapps.judge.constant.enums;

import com.kkbapps.judge.pojo.lang.*;

public enum LangContextEnum {

    Java("java",new JavaContext()),
    Cpp("c++",new CppContext()),
    Python("python",new PythonContext()),
    Js("javascript",new JsContext()),
    Go("golang",new GoContext()),
    C("c",new CContext());

    private String lang;
    private LangContext langContext;

    LangContextEnum(String lang, LangContext langContext) {
        this.lang = lang;
        this.langContext = langContext;
    }

    public static LangContextEnum getByLang(String lang) {
        for (LangContextEnum item : LangContextEnum.values()) {
            if (item.lang.equals(lang)) {
                return item;
            }
        }
        return null;
    }

    public LangContext getLangContext() {
        return langContext;
    }
}
