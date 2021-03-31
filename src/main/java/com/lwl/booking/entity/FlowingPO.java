package com.lwl.booking.entity;

import java.math.BigDecimal;
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
@TableName("t_flowing")
public class FlowingPO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
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
     * 更新时间
     */
    private Date updateTime;

    /**
     * 1 正常 0 删除
     */
    private Integer statusFlag;

    /**
     * 该笔支出的描述
     */
    private String description;

}
