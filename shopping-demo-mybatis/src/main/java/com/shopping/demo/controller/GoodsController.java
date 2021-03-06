package com.shopping.demo.controller;

import com.shopping.demo.cro.GoodsCro;
import com.shopping.demo.cro.PageRequest;
import com.shopping.demo.entity.Goods;
import com.shopping.demo.exception.MyShopException;
import com.shopping.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author ldc
 * @Date 2020/12/7 16:35
 * @Version 1.0
 */

@RestController
@RequestMapping("/service/v1")
public class GoodsController extends AbstractBaseCtrl {

    @Autowired
    GoodsService goodsService;

    @PostMapping("/goods.addone")
    public Object addOne(@RequestBody GoodsCro goodsCro){
        goodsService.addOneGoods(goodsCro);
        return success("");
    }

    @PostMapping("/goods.addList")
    public Object addList(@RequestBody List<GoodsCro> goodsCroList){
        goodsService.addListGoods(goodsCroList);
        return success("");
    }

    @GetMapping("/goods.findById/{id}")
    public Object findGoodsById(@PathVariable("id") Long id){
        try{
            return success(goodsService.findGoodsById(id));
        } catch (MyShopException ex){
            return failure(ex.getErrorCode(),ex.getMessage());
        }
    }

    @PostMapping("/goods.findAll")
    public Object findGoodsAll(@RequestBody PageRequest pageQuery){
        return success(goodsService.findAllGoods(pageQuery));
    }

    @GetMapping("/goods.findAllByUserId")
    public Object findGoodsAllByUserId(@RequestBody PageRequest pageQuery,@RequestParam("userId") Long userId){
        return success(goodsService.getGoodsByUserId(pageQuery,userId));
    }

    @DeleteMapping("/goods.deleteById/{id}")
    public Object deleteGoodsById(@PathVariable("id") Long id){
        try{
            goodsService.deleteGoodsById(id);
            return success("");
        } catch (MyShopException ex){
            return failure(ex.getErrorCode(),ex.getMessage());
        }

    }

    @DeleteMapping("/goods.deleteListGoods")
    public Object deleteListGoods(@RequestBody List<Long> goodsIdList){
        goodsService.deleteListGoods(goodsIdList);
        return success("");
    }

    @PutMapping("/goods.edit")
    public Object editGoods(@RequestBody GoodsCro goodsCro){
        try{
            goodsService.editGoods(goodsCro);
            return success("");
        } catch (MyShopException ex){
            return failure(ex.getErrorCode(),ex.getMessage());
        }
    }

}
