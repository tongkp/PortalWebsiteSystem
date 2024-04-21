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
@TableName("port_patents")
public class PatentsEntity {
    private Long id;

    String patentsName;
    String patentsBrief;
    String patentsImage;
    String patentsContent;
}
