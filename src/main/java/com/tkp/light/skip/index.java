package com.tkp.light.skip;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tkp.light.bean.CompanyInfo;
import com.tkp.light.bean.PatentsEntity;
import com.tkp.light.bean.ProductInfo;
import com.tkp.light.bean.SlideshowInfo;
import com.tkp.light.server.CompanyService;
import com.tkp.light.server.PatentsService;
import com.tkp.light.server.ProductInfoService;
import com.tkp.light.server.SlideshowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class index {
    @Autowired
    private CompanyService companyService;

    @Autowired
    private SlideshowService slideshowService;

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    PatentsService patentsService;

    @GetMapping({"/home","/"})
    public String log(HttpSession session){
        QueryWrapper<CompanyInfo> queryWrapper=new QueryWrapper<CompanyInfo>();
        queryWrapper.getSqlFirst();
        CompanyInfo s= companyService.getOne(queryWrapper);
        session.setAttribute("company_phone",s.getCompanyPhone());
        session.setAttribute("company_place",s.getCompanyPlace());
        session.setAttribute("company_intro",s.getCompanyIntro());
        session.setAttribute("company_content",s.getCompanyContent());
        session.setAttribute("company_image",s.getCompanyImage());

        List<SlideshowInfo> slideshowInfoList = slideshowService.list();
        session.setAttribute("slideshowInfoList",slideshowInfoList);


        QueryWrapper<ProductInfo> productInfoQueryWrapper=new QueryWrapper<ProductInfo>();
        productInfoQueryWrapper.eq("pro_state", 1);
        productInfoQueryWrapper.orderByDesc("pro_sort");
        productInfoQueryWrapper.last("limit 3");

        //查询排序值前3的产品列表
        productInfoQueryWrapper.eq("pro_type", 1);
        List<ProductInfo> productInfoList = productInfoService.list(productInfoQueryWrapper);
        if(!productInfoList.isEmpty()){
            session.setAttribute("cp",productInfoList);
        }else {
            ProductInfo wran =new ProductInfo();
            wran.setProductImg("/layuimini/images/400.jpg");
            productInfoList =new ArrayList<>();
            productInfoList.add(wran);
            session.setAttribute("cp",productInfoList);
        }

        //查询banner列表
        QueryWrapper<ProductInfo> bannerQueryWrapper=new QueryWrapper<ProductInfo>();
        bannerQueryWrapper.eq("pro_state", 1);
        bannerQueryWrapper.orderByDesc("pro_sort");
        bannerQueryWrapper.last("limit 3");
        bannerQueryWrapper.eq("pro_type", 5);
        List<ProductInfo> bannerList = productInfoService.list(bannerQueryWrapper);
        if(!bannerList.isEmpty()){
            session.setAttribute("bannerList",bannerList);
        }else {
            bannerList =new ArrayList<>();
            session.setAttribute("bannerList",bannerList);
        }
        return "index";
    }

    @GetMapping({"/about"})
    public  String about(){

        return "about";
    }

    @GetMapping({"/detailpages_services"})
    public  String detailpages_services(){

        return "productDetail";
    }
}
