package com.zdf.mallproduct.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zdf.internalcommon.constant.CategoryConstant;
import com.zdf.internalcommon.entity.PmsCategory;
import com.zdf.internalcommon.response.CategoryWithTreeVo;
import com.zdf.internalcommon.result.ResponseResult;
import com.zdf.mallproduct.mapper.PmsCategoryMapper;
import com.zdf.mallproduct.service.PmsCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author mrzhang
* @description 针对表【pms_category】的数据库操作Service实现
* @createDate 2024-06-24 11:38:40
*/
@Service
public class PmsCategoryServiceImpl extends ServiceImpl<PmsCategoryMapper, PmsCategory>
    implements PmsCategoryService {
    @Resource
    private PmsCategoryMapper pmsCategoryMapper;

    @Override
    public ResponseResult<List<CategoryWithTreeVo>> categoryWithTree() {
        List<PmsCategory> pmsCategories = pmsCategoryMapper.selectList(new QueryWrapper<PmsCategory>().eq("show_status", CategoryConstant.IS_VIEW));
        List<CategoryWithTreeVo> categoryWithTreeVos = pmsCategories.stream().filter(pmsCategory -> pmsCategory.getParentCid() == CategoryConstant.ROOT_CATEGORY_ID)
                .map(pmsCategory -> {
                    CategoryWithTreeVo categoryWithTreeVo = new CategoryWithTreeVo();
                    BeanUtils.copyProperties(pmsCategory, categoryWithTreeVo);
                    categoryWithTreeVo.setChildNode(getChildList(pmsCategory, pmsCategories));
                    return categoryWithTreeVo;
                }).collect(Collectors.toList());
        return ResponseResult.success(categoryWithTreeVos);
    }

    private List<CategoryWithTreeVo> getChildList(PmsCategory pmsCategory, List<PmsCategory> pmsCategories) {
        List<PmsCategory> categories = pmsCategories.stream().filter(category -> category.getParentCid().equals(pmsCategory.getCatId()))
                .collect(Collectors.toList());
        if (categories.isEmpty()){
            return Collections.emptyList();
        }
        return categories.stream().map(child -> {
            CategoryWithTreeVo categoryWithTreeVo = new CategoryWithTreeVo();
            BeanUtils.copyProperties(child, categoryWithTreeVo);
            categoryWithTreeVo.setChildNode(getChildList(child, pmsCategories));
            return categoryWithTreeVo;
        }).collect(Collectors.toList());
    }
}
