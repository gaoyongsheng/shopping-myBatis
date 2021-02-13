package com.shopping.demo.entity;

import com.shopping.demo.entity.base.BaseModel;
import lombok.Data;

/**
 * @Author ldc
 * @Date 2020/12/16 11:54
 * @Version 1.0
 */

@Data
public class FilesRes extends BaseModel<FilesRes> {

    private Long id;

    private String fileId;

    private String fileResPath;

    private String fileResFormat;

    private Long fileGoodsId;

    @Override
    public Object toDto() {
        return null;
    }
}
