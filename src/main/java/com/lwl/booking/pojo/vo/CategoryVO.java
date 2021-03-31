package com.lwl.booking.pojo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author liuweilong
 * @date 2021/3/31
 * @description
 */
@Data
public class CategoryVO {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 分类名
     */
    private String categoryName;

    /**
     * url
     */
    private String categoryIconUrl;
}
