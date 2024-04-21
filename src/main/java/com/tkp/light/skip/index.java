package com.tkp.light.skip;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

        QueryWrapper<SlideshowInfo> slideshowEntityQueryWrapper = new QueryWrapper<>();
        slideshowEntityQueryWrapper.getSqlFirst();
        List<SlideshowInfo> slideshowInfoList = slideshowService.list(slideshowEntityQueryWrapper);
        session.setAttribute("slideshowInfoList",slideshowInfoList);

        Random random = new Random();
        List<ProductInfo> list1=productInfoService.list();
        if(list1.size()!=0) {
            List<ProductInfo> list2 = new ArrayList<>();

            for (int i = 1; i <= 3; i++) {
                String index = "cp" + i;
                list2.add(list1.get(random.nextInt(list1.size())));
            }
            session.setAttribute("cp", list2);
        }else {
            ProductInfo wran =new ProductInfo();
            wran.setProductImg("/layuimini/images/400.jpg");
            list1.add(wran);
            session.setAttribute("cp",list1);
        }
        QueryWrapper<PatentsEntity> patentsEntityQueryWrapper = new QueryWrapper<>();
        List<PatentsEntity> list3=patentsService.list(patentsEntityQueryWrapper);
        if(!list3.isEmpty()) {
            List<PatentsEntity> list4 = new ArrayList<PatentsEntity>();
            for (int i = 1; i <= 2; i++) {
                list4.add(list3.get(random.nextInt(list3.size())));
            }
            session.setAttribute("zl", list4);

        }else {
            PatentsEntity warn= new PatentsEntity();
            warn.setPatentsName("没有添加任何专利");
            warn.setPatentsBrief("没有添加任何专利");
            warn.setPatentsImage("/layuimini/images/400.jpg");
            list3.add(warn);
            session.setAttribute("zl", list3);
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
