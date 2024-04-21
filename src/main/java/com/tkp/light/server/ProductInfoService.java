package com.tkp.light.server;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tkp.light.bean.ProductInfo;

import java.util.List;

/**
 * @author tongkp
 * @title ProductInfoService
 * @description 产品信息接口
 * @create 2024/4/18 13:13
 * @wechat 81958419
 * @email tongkp@126.com
 */
public interface ProductInfoService extends IService<ProductInfo> {
    List<ProductInfo> findByProType(Integer proType);

}