package com.lwl.booking.pojo.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author liuweilong
 * @date 2021/3/31
 * @description
 */
@Data
public class CountByTimeReq {
    /**
     * 后端自动注入
     */
    private Long userId;
    @NotNull(message = "beginTime is null")
    private Date beginTime;
    @NotNull(message = "endTime is null")
    private Date endTime;
}
