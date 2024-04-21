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
@TableName("port_slideshow")
public class SlideshowInfo {
    private Long id;
    String imagePathUrl;
    String imageInformation;
}
