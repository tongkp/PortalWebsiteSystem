package com.tkp.light.server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tkp.light.bean.SlideshowInfo;
import com.tkp.light.mapper.SlideshowMapper;
import com.tkp.light.server.SlideshowService;
import org.springframework.stereotype.Service;

@Service
public class SlideshowServiceImpl extends ServiceImpl<SlideshowMapper, SlideshowInfo> implements SlideshowService {


}
