package com.lwl.booking.pojo.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author liuweilong
 * @date 2021/3/31
 * @description
 */
@Data
public class RegisterReq {
    /**
     * 手机号
     */
    @NotBlank(message = "mobilePhone is blank")
    private String mobilePhone;
    private String passwordSecret;
}
