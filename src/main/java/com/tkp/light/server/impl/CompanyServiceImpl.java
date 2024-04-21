package com.tkp.light.server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tkp.light.bean.CompanyInfo;
import com.tkp.light.mapper.CompanyMapper;
import com.tkp.light.server.CompanyService;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, CompanyInfo> implements CompanyService{

}
