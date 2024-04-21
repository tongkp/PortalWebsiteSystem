package com.tkp.light.server.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tkp.light.bean.PatentsEntity;
import com.tkp.light.bean.patents_bean;
import com.tkp.light.mapper.PatentsMapper;
import com.tkp.light.mapper.patents_mapper;
import com.tkp.light.server.PatentsService;
import com.tkp.light.server.patents_ser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatentsServiceImpl extends ServiceImpl<PatentsMapper, PatentsEntity> implements PatentsService {

}
