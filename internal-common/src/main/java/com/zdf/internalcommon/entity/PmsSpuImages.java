package com.zdf.internalcommon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * spuͼƬ
 * @author mrzhang
 * @TableName pms_spu_images
 */
@TableName(value ="pms_spu_images")
@Data
public class PmsSpuImages implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * spu_id
     */
    private Long spuId;

    private String imgName;

    private String imgUrl;

    private Integer imgSort;

    private Integer defaultImg;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}