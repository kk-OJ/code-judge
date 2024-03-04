package com.kkbapps.judge.constant.enums;

import com.kkbapps.judge.pojo.lang.CppContext;
import com.kkbapps.judge.pojo.lang.JavaContext;
import com.kkbapps.judge.pojo.lang.LangContext;
import com.kkbapps.judge.pojo.lang.PythonContext;

public enum LangContextEnum {

    Java("java",new JavaContext()),
    Cpp("c++",new CppContext()),
    Python("python",new PythonContext());

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
