package com.lwl.booking.service;

import com.lwl.booking.pojo.vo.CategoryVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liuweilong
 * @since 2021-03-30
 */
public interface CategoryService {

    /**
     * 获取所有分类
     * @return
     */
    List<CategoryVO> listAll();
}
