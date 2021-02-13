package com.shopping.demo.entity;

import com.shopping.demo.dto.GoodsDto;
import com.shopping.demo.entity.base.BaseModel;
import lombok.Data;

import java.util.List;

/**
 * @Author ldc
 * @Date 2020/12/3 17:20
 * @Version 1.0
 */

@Data
public class Goods extends BaseModel<GoodsDto> {

    private Long id;

    private String goodsName;

    private String goodsPrice;

    private String goodsInventoryCount;

    private String goodsSalesCount;

    private String goodsDetailText;

    private String goodsAddTime;

    private Long goodsUserId;

    private List<FilesRes> goodsDetailImage;

    public Goods(){}

    public Goods(GoodsDto goodsDto){
        this.id = goodsDto.getId();
        this.goodsName = goodsDto.getGoodsName();
        this.goodsPrice = goodsDto.getGoodsPrice();
        this.goodsInventoryCount = goodsDto.getGoodsInventoryCount();
        this.goodsSalesCount = goodsDto.getGoodsSalesCount();
        this.goodsDetailText = goodsDto.getGoodsDetailText();
        this.goodsDetailImage = goodsDto.getGoodsDetailImage();
        this.goodsAddTime = goodsDto.getGoodsAddTime();
    }

    @Override
    public GoodsDto toDto() {
        GoodsDto goodsDto = new GoodsDto();
        goodsDto.setId(id);
        goodsDto.setGoodsName(goodsName);
        goodsDto.setGoodsPrice(goodsPrice);
        goodsDto.setGoodsInventoryCount(goodsInventoryCount);
        goodsDto.setGoodsSalesCount(goodsSalesCount);
        goodsDto.setGoodsDetailText(goodsDetailText);
        goodsDto.setGoodsDetailImage(goodsDetailImage);
        goodsDto.setGoodsAddTime(goodsAddTime);
        return goodsDto;
    }


}
