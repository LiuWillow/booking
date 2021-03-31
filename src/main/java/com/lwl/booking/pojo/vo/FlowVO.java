package com.lwl.booking.pojo.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author liuweilong
 * @date 2021/3/31
 * @description
 */
@Data
public class FlowVO {
    /**
     * 自增id
     */
    private Long id;

    /**
     * 属于哪个用户id
     */
    private Long userId;

    /**
     * 数额
     */
    private BigDecimal amount;

    /**
     * 分类
     */
    private Integer categoryId;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 分类图片url
     */
    private String categoryIconUrl;

    /**
     * 创建时间
     */
    private Date flowTime;

    /**
     * 该笔支出的描述
     */
    private String description;
}
