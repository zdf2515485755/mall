package com.zdf.mallproduct.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zdf.internalcommon.constant.PageConstant;
import com.zdf.internalcommon.entity.PmsBrand;
import com.zdf.internalcommon.request.GetBrandListRequestDto;
import com.zdf.internalcommon.result.ResponseResult;
import com.zdf.mallproduct.mapper.PmsBrandMapper;
import com.zdf.mallproduct.service.PmsBrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author mrzhang
* @description 针对表【pms_brand(Ʒ?)】的数据库操作Service实现
* @createDate 2024-06-24 11:38:40
*/
@Service
public class PmsBrandServiceImpl extends ServiceImpl<PmsBrandMapper, PmsBrand>
    implements PmsBrandService {

    @Resource
    private PmsBrandMapper pmsBrandMapper;

    @Override
    public ResponseResult<IPage<PmsBrand>> getBrandList(GetBrandListRequestDto getBrandListRequestDto) {
        QueryWrapper<PmsBrand> pmsBrandQueryWrapper = new QueryWrapper<>();
        pmsBrandQueryWrapper
                .like(!getBrandListRequestDto.getBrandName().isEmpty(),
                        "name", getBrandListRequestDto.getBrandName());
        IPage<PmsBrand> pmsBrandPage = new Page<>(PageConstant.CURRTENT_PAGE, PageConstant.PAGE_SIZE);
        List<PmsBrand> pmsBrands = pmsBrandMapper.selectList(pmsBrandPage, pmsBrandQueryWrapper);
        return ResponseResult.success(pmsBrands);
    }
}