package com.zdf.mallproduct.controller;

import com.zdf.internalcommon.annotation.PassTokenCheck;
import com.zdf.internalcommon.response.CategoryWithTreeVo;
import com.zdf.internalcommon.result.ResponseResult;
import com.zdf.mallproduct.service.impl.PmsCategoryServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 *@Description 类功能简要描述
 *@Author mrzhang
 *@Date 2024/6/24 13:43
 */
@RestController
@RequestMapping("/category")
@PassTokenCheck
public class CategoryController {

    @Resource
    private PmsCategoryServiceImpl pmsCategoryService;

    @GetMapping("/tree")
    public ResponseResult<List<CategoryWithTreeVo>> categoryWithTree(){
        return pmsCategoryService.categoryWithTree();
    }
}
