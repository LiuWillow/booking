package com.lwl.booking.pojo.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author liuweilong
 * @date 2021/3/30
 * @description
 */
@Data
public class UserInfoVO {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 用户名（微信名）
     */
    private String username;

    /**
     * 手机号
     */
    private String mobilePhone;

    /**
     * 第三方唯一id，如微信id，默认0
     */
    private String thirdPartId;

    /**
     * 第三方类型，0 为没有对接第三方，1 微信
     */
    private Integer thirdPartType;

    /**
     * 头像
     */
    private String profilePhoto;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 状态 1 正常 0 删除
     */
    private Integer statusFlag;
}
