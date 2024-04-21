package com.tkp.light.protal_mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tkp.light.bean.ProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProductInfoMapper extends BaseMapper<ProductInfo> {

    @Select("select * from product_table")
    public IPage<ProductInfo> select_product(Page page);


}
