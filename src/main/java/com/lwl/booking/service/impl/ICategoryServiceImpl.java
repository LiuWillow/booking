package com.lwl.booking.service.impl;

import com.lwl.booking.entity.CategoryPO;
import com.lwl.booking.mapper.CategoryMapper;
import com.lwl.booking.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuweilong
 * @since 2021-03-30
 */
@Service
public class ICategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryPO> implements ICategoryService {

}
