package com.shopping.demo.mapper;

import com.shopping.demo.entity.FilesRes;
import com.shopping.demo.entity.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Gao
 * @Date 2021/2/7 23:33
 * @Version 1.0
 */

@Repository
public interface FilesResMapper {

    // 批量添加图片
    void insertFilesByList(List<FilesRes> goodsDetailImage);

    // 单个图片修改
    void updateFiles(FilesRes filesRes);

    // 根据图片ID删除出片
    void deleteFilesByFilesId(Long fileResId);

    // 批量删除某个商品的图片
    void deleteFilesByList(Long goodsId);

    // 根据商品ID查询图片
    List<FilesRes> getFilesResByGoodsId(Long goodsId);


}
