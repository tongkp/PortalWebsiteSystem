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
@TableName("solution")
public class SolutionEntity {
    private Long id;

    String solutionName;
    String solutionBrief;
    String solutionImage;
    String solutionContent;
}
