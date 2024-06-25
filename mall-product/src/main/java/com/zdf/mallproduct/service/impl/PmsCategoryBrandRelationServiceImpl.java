package com.zdf.mallproduct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zdf.internalcommon.entity.PmsCategoryBrandRelation;
import com.zdf.internalcommon.response.BrandAndCategroyRelationVo;
import com.zdf.internalcommon.result.ResponseResult;
import com.zdf.mallproduct.mapper.PmsCategoryBrandRelationMapper;
import com.zdf.mallproduct.service.PmsCategoryBrandRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author mrzhang
* @description 针对表【pms_category_brand_relation(Ʒ?Ʒ???????)】的数据库操作Service实现
* @createDate 2024-06-24 11:38:40
*/
@Service
public class PmsCategoryBrandRelationServiceImpl extends ServiceImpl<PmsCategoryBrandRelationMapper, PmsCategoryBrandRelation>
    implements PmsCategoryBrandRelationService {

    @Resource
    private PmsCategoryBrandRelationMapper pmsCategoryBrandRelationMapper;

    @Override
    public ResponseResult<BrandAndCategroyRelationVo> getRelation(Long brandId) {
       return ResponseResult.success(pmsCategoryBrandRelationMapper.getRelation(brandId));
    }
}




