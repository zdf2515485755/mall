package com.zdf.mallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zdf.internalcommon.entity.PmsCategory;
import com.zdf.internalcommon.response.CategoryWithTreeVo;
import com.zdf.internalcommon.result.ResponseResult;

import java.util.List;

/**
* @author mrzhang
* @description 针对表【pms_category】的数据库操作Service
* @createDate 2024-06-24 11:38:40
*/
public interface PmsCategoryService extends IService<PmsCategory> {
    ResponseResult<List<CategoryWithTreeVo>> categoryWithTree();
}
