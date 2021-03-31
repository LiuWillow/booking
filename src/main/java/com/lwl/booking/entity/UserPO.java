package com.lwl.booking.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author liuweilong
 * @since 2021-03-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
public class UserPO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
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

    /**
     * 加密后的密码
     */
    private String passwordSecret;


}
