package com.zdf.mallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zdf.internalcommon.entity.PmsCategoryBrandRelation;
import com.zdf.internalcommon.response.BrandAndCategroyRelationVo;
import com.zdf.internalcommon.result.ResponseResult;

/**
* @author mrzhang
* @description 针对表【pms_category_brand_relation】的数据库操作Service
* @createDate 2024-06-24 11:38:40
*/
public interface PmsCategoryBrandRelationService extends IService<PmsCategoryBrandRelation> {
    ResponseResult<BrandAndCategroyRelationVo> getRelation(Long brandId);
}
