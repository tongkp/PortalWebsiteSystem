package com.wuhao.wuhaozn_springboot.bean;

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
@TableName("product_table")
public class product_bean {
    int id;
    String product_name;
    String product_brief;
    String product_image;
    String product_content;
    /**
     * 类型 1产品，2专利，3解决方案，4成功案例
     */
    int pType;

}
