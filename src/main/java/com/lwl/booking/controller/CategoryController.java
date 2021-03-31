package com.lwl.booking.controller;


import com.lwl.booking.pojo.vo.CategoryVO;
import com.lwl.booking.service.CategoryService;
import com.lwl.common.context.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liuweilong
 * @since 2021-03-30
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @GetMapping("list-all")
    public BaseResponse<List<CategoryVO>> listAll() {
        List<CategoryVO> list = categoryService.listAll();
        return BaseResponse.success(list);
    }
}
