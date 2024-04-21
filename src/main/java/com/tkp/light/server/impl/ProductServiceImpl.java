package com.tkp.light.server.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tkp.light.bean.ProductInfo;
import com.tkp.light.mapper.ProductInfoMapper;
import com.tkp.light.server.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements ProductInfoService {
    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Override
    public List<ProductInfo> findByProType(Integer proType) {
        // 使用MyBatis-Plus的LambdaQueryWrapper进行条件查询
        LambdaQueryWrapper<ProductInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProductInfo::getProType, proType);
        return productInfoMapper.selectList(queryWrapper);
    }
}
