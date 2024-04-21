package com.tkp.light.control;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tkp.light.bean.ProductInfo;
import com.tkp.light.server.ProductInfoService;
import com.tkp.light.util.StateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductInfoControl {
    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("/{id}")
    public ProductInfo getProduct(@PathVariable Integer id) {
        return productInfoService.getById(id);
    }

    @GetMapping("/data")
    @ResponseBody
    public Page<ProductInfo> listProducts(@RequestParam(required = false) Integer proType,
                                          @RequestParam(defaultValue = "1") Integer pageNum,
                                          @RequestParam(defaultValue = "10") Integer pageSize) {
        Page<ProductInfo> page = new Page<>(pageNum, pageSize);
        if (proType != null) {
            return productInfoService.page(page, Wrappers.lambdaQuery(ProductInfo.class).eq(ProductInfo::getProType, proType));
        } else {
            Page<ProductInfo> productInfoPage = productInfoService.page(page);
            return productInfoPage;
        }
    }

    @GetMapping({"/products"})
    public  String products(@RequestParam(name = "proType", defaultValue = "0") Integer proType, Model model){
        Page<ProductInfo> page = new Page<>(1, 30);
        Page<ProductInfo> productInfoPage = productInfoService.page(page, Wrappers.lambdaQuery(ProductInfo.class).eq(ProductInfo::getProType, proType));
        List<ProductInfo> list = productInfoPage.getRecords();
        model.addAttribute("product",list);
        String pagePath = "products";
        switch (proType){
            case 1:
                //产品介绍
                break;
            case 3:
                pagePath = "solution";//解决方案
                break;
            case 4:
                pagePath = "successful";//成功案例
                break;
            default:
                break;
        }
        return pagePath;
    }

    @PostMapping("/delete_id")
    @ResponseBody
    public StateUtil delProduct(@RequestParam("id") int id){
        boolean tf= productInfoService.removeById(id);
        System.out.println(tf);
        if(tf){
            return new StateUtil("成功",200);
        }
        return new StateUtil("失败",400);
    }

    @GetMapping("/update_id")
    public String updateProduct(@RequestParam("id") int id, Model model){
        ProductInfo productBean = productInfoService.getById(id);
        if(productBean == null){
            productBean = new ProductInfo();

        }
        model.addAttribute("productBean",productBean);
        return "page/upload";
    }

    @PostMapping("/updateimage")
    @ResponseBody
    public  StateUtil updateimage(String productImg,Integer id){
        ProductInfo productBean = productInfoService.getById(id);
        if(productBean != null){
            productBean.setProductImg(productImg);
            productInfoService.updateById(productBean);
            return new StateUtil("成功",200);
        }
        return  new StateUtil("失败",400);
    }

    @GetMapping("/product_table")
    public String product_table(){

        return "page/product/main";
}

    @GetMapping("/productDetail/{id}")
    public String productDetail(@PathVariable int id, Model model){
        ProductInfo productInfo= productInfoService.getById(id);
        if(productInfo == null){
            productInfo = new ProductInfo();
        }
        model.addAttribute("productInfo", productInfo);
        return "productDetail";
    }

}
