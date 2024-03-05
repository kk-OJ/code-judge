package com.kkbapps.judge.constant.enums;

public enum ExecuteTypeEnum {

    EXECUTE_SUCCESS(0,"执行成功"),
    COMPILE_ERROR(1,"编译出错");

    private final Integer state;
    private String desc;

    ExecuteTypeEnum(Integer state, String desc) {
        this.state = state;
        this.desc = desc;
    }

    public static ExecuteTypeEnum getByState(Integer state) {
        for (ExecuteTypeEnum item : ExecuteTypeEnum.values()) {
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
