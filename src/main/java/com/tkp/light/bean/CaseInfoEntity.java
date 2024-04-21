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
@TableName("case_info")
public class CaseInfoEntity {
    private Long id;

    String case_name;
    String case_brief;
    String case_image;
    String case_content;
}
