package com.lwl.booking.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lwl.booking.entity.CategoryPO;
import com.lwl.booking.mapper.CategoryMapper;
import com.lwl.booking.pojo.vo.CategoryVO;
import com.lwl.booking.service.CategoryService;
import com.lwl.common.util.BeanConvertUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuweilong
 * @since 2021-03-30
 */
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryVO> listAll() {
        List<CategoryPO> categories = categoryMapper.selectList(new LambdaQueryWrapper<CategoryPO>());
        if (CollectionUtils.isEmpty(categories)) {
            return Collections.emptyList();
        }
        return BeanConvertUtils.convertList(categories, CategoryVO.class);
    }
}
