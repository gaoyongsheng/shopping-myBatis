package com.shopping.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shopping.demo.constants.ShopExceptionCode;
import com.shopping.demo.cro.GoodsCro;
import com.shopping.demo.cro.PageRequest;
import com.shopping.demo.cro.PageResult;
import com.shopping.demo.entity.FilesRes;
import com.shopping.demo.entity.Goods;
import com.shopping.demo.entity.User;
import com.shopping.demo.exception.MyShopException;
import com.shopping.demo.mapper.FilesResMapper;
import com.shopping.demo.mapper.GoodsMapper;
import com.shopping.demo.service.GoodsService;
import com.shopping.demo.utils.DateTimeUtils;
import com.shopping.demo.utils.ThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ldc
 * @Date 2020/12/7 16:29
 * @Version 1.0
 */

@Service
@Transactional
public class GoodsServiceImpl extends AbstractBaseImpl implements GoodsService{

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    FilesResMapper filesResMapper;

    @Override
    public void addOneGoods(GoodsCro goodsCro) {

        Goods goods = new Goods(goodsCro.toDto());
        User curUser = (User) ThreadLocalUtils.get();
        goods.setGoodsUserId(curUser.getId());
        goods.setGoodsAddTime(DateTimeUtils.getSysCurDate());

        goodsMapper.insertGoods(goods);

        Long goodsId = goods.getId();

        List<FilesRes> curFileList = goods.getGoodsDetailImage();
        for (FilesRes filesRes : curFileList){
            filesRes.setFileGoodsId(goodsId);
        }
        filesResMapper.insertFilesByList(curFileList);
    }

    @Override
    public void addListGoods(List<GoodsCro> goodsCroList) {
        for(GoodsCro goodsCro : goodsCroList){
            addOneGoods(goodsCro);
        }
    }

    @Override
    public void deleteGoodsById(Long id) {
        Goods curGoods = findGoodsById(id);
        List<FilesRes> detailImgList = curGoods.getGoodsDetailImage();

        filesResMapper.deleteFilesByList(id);

        goodsMapper.deleteGoodsById(id);
    }

    @Override
    public void deleteListGoods(List<Long> goodsIdList) {

        for(Long id : goodsIdList){
            filesResMapper.deleteFilesByList(id);
        }
        goodsMapper.deleteGoodsList(goodsIdList);

    }


    @Override
    public Goods findGoodsById(Long id) {
        Goods curGoods = goodsMapper.getGoodsById(id);
        if(null == curGoods){
            throw new MyShopException(ShopExceptionCode.ENTITY_NO_EXISTS,"实体对象不存在");
        }
        return curGoods;
    }

    @Override
    public PageResult findAllGoods(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        List<Goods> goodsList = goodsMapper.getGoods();
        return getPageResult(pageRequest,new PageInfo<Goods>(goodsList));
    }

    @Override
    public PageResult getGoodsByUserId(PageRequest pageRequest, Long userId) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        List<Goods> goodsList = goodsMapper.getGoodsByUserId(userId);
        return getPageResult(pageRequest,new PageInfo<Goods>(goodsList));
    }


    @Override
    public void editGoods(GoodsCro goodsCro) {

        Long curGoodsId = goodsCro.getId();
        Goods curGoods = findGoodsById(curGoodsId);

        curGoods.setGoodsName(goodsCro.getGoodsName());
        curGoods.setGoodsPrice(goodsCro.getGoodsPrice());
        curGoods.setGoodsInventoryCount(goodsCro.getGoodsInventoryCount());
        curGoods.setGoodsSalesCount(goodsCro.getGoodsSalesCount());
        curGoods.setGoodsDetailText(goodsCro.getGoodsDetailText());

        goodsMapper.updateGoods(curGoods);
    }
}
