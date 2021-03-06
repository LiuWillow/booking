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
public class AddSingleFlowReq {
    /**
     * 后端自动注入
     */
    private Long userId;

    @NotNull(message = "amount is null")
    private BigDecimal amount;
    @NotNull(message = "categoryId is null")
    private Integer categoryId;
    @NotBlank(message = "categoryName is null")
    private String categoryName;
    /**
     * 分类图片url
     */
    @NotBlank(message = "categoryIconUrl is null")
    private String categoryIconUrl;

    /**
     * 支出时间
     */
    @NotNull(message = "flowTime is null")
    private Date flowTime;
    /**
     * 该笔支出的描述
     */
    private String description;
}
