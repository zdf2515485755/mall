package com.zdf.mallproduct.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zdf.internalcommon.entity.PmsBrand;
import com.zdf.internalcommon.request.GetBrandListRequestDto;
import com.zdf.internalcommon.response.BrandAndCategroyRelationVo;
import com.zdf.internalcommon.result.ResponseResult;
import com.zdf.mallproduct.service.impl.PmsBrandServiceImpl;
import com.zdf.mallproduct.service.impl.PmsCategoryBrandRelationServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 *@Description 类功能简要描述
 *@Author mrzhang
 *@Date 2024/6/25 17:56
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Resource
    private PmsBrandServiceImpl pmsBrandService;
    @Resource
    private PmsCategoryBrandRelationServiceImpl pmsCategoryBrandRelationService;

    @GetMapping("/list")
    public ResponseResult<IPage<PmsBrand>> getBrandList(@RequestBody GetBrandListRequestDto getBrandListRequestDto){
        return pmsBrandService.getBrandList(getBrandListRequestDto);
    }

    @GetMapping("/getRelation/{brandId}")
    public ResponseResult<BrandAndCategroyRelationVo> getRelation(@NotNull @PathVariable("brandId") Long brandId){
        return pmsCategoryBrandRelationService.getRelation(brandId);
    }
}
