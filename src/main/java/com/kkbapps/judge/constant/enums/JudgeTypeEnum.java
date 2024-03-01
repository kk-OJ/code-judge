package com.kkbapps.judge.constant.enums;

public enum JudgeTypeEnum {

    EXECUTE_CODE_ONLY(1,"仅执行代码"),
    NORMAL_JUDGE(2,"普通判题");

    private final Integer state;
    private String desc;

    JudgeTypeEnum(Integer state, String desc) {
        this.state = state;
        this.desc = desc;
    }

    public static JudgeTypeEnum getByState(Integer state) {
        for (JudgeTypeEnum item : JudgeTypeEnum.values()) {
            if (item.getState().equals(state)) {
                return item;
            }
        }
        return null;
    }

    public Integer getState() {
        return state;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
