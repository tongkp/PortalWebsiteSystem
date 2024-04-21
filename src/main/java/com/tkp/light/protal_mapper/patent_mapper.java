package com.tkp.light.protal_mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tkp.light.bean.patents_bean;
import org.apache.ibatis.annotations.Select;

public interface patent_mapper {

    @Select("select * from patents_table")
    public IPage<patents_bean> select_patent(Page page);
}
