package com.lwl.booking.pojo.req;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author liuweilong
 * @date 2021/3/31
 * @description
 */
@Data
public class AddSingleFlowReq {
    @NotNull(message = "amount is null")
    private BigDecimal amount;
    @NotNull(message = "categoryId is null")
    private Integer categoryId;
    @NotNull(message = "categoryId is null")
    private String categoryName;
}
