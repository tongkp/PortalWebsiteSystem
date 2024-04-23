package com.tkp.light.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("port_product_info")
public class ProductInfo {
    private Long id;

    /**
     * 产品名称
     */
    String productName;
    /**
     * 产品简介
     */
    String productBrief;
    /**
     * 产品图片
     */
    String productImg;
    /**
     * 产品说明
     */
    String productContent;
    /**
     * 类型 1产品，2专利，3解决方案，4成功案例，5banner
     */
    Integer proType;

    /**
     * 排序
     */
    Integer proSort;

    /**
     * 0禁用，1启用，默认启用
     */
    Integer proState;

}

