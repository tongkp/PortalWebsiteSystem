package com.tkp.light.server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tkp.light.bean.SolutionEntity;
import com.tkp.light.mapper.SolutionMapper;
import com.tkp.light.server.SolutionService;
import org.springframework.stereotype.Service;

@Service
public class SolutionServiceImpl extends ServiceImpl<SolutionMapper, SolutionEntity> implements SolutionService {

}
