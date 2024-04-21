package com.tkp.light.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tkp.light.bean.PatentsEntity;
import com.tkp.light.bean.patents_bean;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PatentsMapper extends BaseMapper<PatentsEntity> {

}
