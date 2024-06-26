package com.zdf.mallproduct.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zdf.internalcommon.entity.PmsCategoryBrandRelation;
import com.zdf.internalcommon.response.BrandAndCategroyRelationVo;
import org.apache.ibatis.annotations.Param;

/**
* @author mrzhang
* @description 针对表【pms_category_brand_relation(Ʒ?Ʒ???????)】的数据库操作Mapper
* @createDate 2024-06-24 11:38:40
* @Entity generator.domain.PmsCategoryBrandRelation
*/
public interface PmsCategoryBrandRelationMapper extends BaseMapper<PmsCategoryBrandRelation> {
    BrandAndCategroyRelationVo getRelation(@Param("id") Long brandId);
}




