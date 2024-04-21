package com.tkp.light.protal_mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tkp.light.bean.solution_bean;
import org.apache.ibatis.annotations.Select;

public interface solutions_mapper {

    @Select("select * from solution_table")
    public IPage<solution_bean> select_solution(Page page);
}
