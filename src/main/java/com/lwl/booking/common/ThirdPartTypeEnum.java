package com.lwl.booking.common;

/**
 * @author liuweilong
 * @date 2021/3/31
 * @description
 */
public enum ThirdPartTypeEnum {
    WE_CHAT(1, "微信"),
    ;
    private Integer value;
    private String desc;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    ThirdPartTypeEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
