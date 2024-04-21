package com.tkp.light.control;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tkp.light.bean.SolutionEntity;
import com.tkp.light.server.SolutionService;
import com.tkp.light.util.StateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/solution")
public class solution_show_control {
    @Autowired
    SolutionService solutionService;

    @GetMapping("/solution_show_table")
    @ResponseBody
    public Map<String, Object> solution_show_table(@RequestParam("page") int num, @RequestParam("limit") int size){
        QueryWrapper<SolutionEntity> queryWrapper=new QueryWrapper<>();
        Page<SolutionEntity> page=new Page<>(num, size);
        IPage<SolutionEntity> solutionEntityPage = solutionService.page(page, queryWrapper);
        long tatol = solutionEntityPage.getTotal();
        List<SolutionEntity> list =  solutionEntityPage.getRecords();
        Map<String,Object> map =new HashMap<>();

        map.put("code",0);
        map.put("msg","");
        map.put("count",tatol);
        map.put("data",list);

        return map;
    }

    @GetMapping("/solution_showjubu_table")
    @ResponseBody
    public Map<String,Object>  solution_showjubu_table(@RequestParam("page") int num,@RequestParam("limit") int size,@RequestParam("solution_name") String name){
        Page<SolutionEntity> page =new Page<>(num,size);
        QueryWrapper<SolutionEntity> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("solution_name",name);
        IPage<SolutionEntity> solutionEntityPage = solutionService.page(page, queryWrapper);

        List<SolutionEntity> list =  solutionEntityPage.getRecords();
        Map<String,Object> map =new HashMap<>();

        map.put("code",0);
        map.put("msg","");
        map.put("count",solutionEntityPage.getTotal());
        map.put("data",list);
        return map;
    }




    @PostMapping("/delete_id")
    @ResponseBody
    public StateUtil solution_tables(@RequestParam("id") int id){
        boolean tf=solutionService.removeById(id);
        System.out.println(tf);
        if(tf){
            return new StateUtil("成功",200);
        }
        return new StateUtil("失败",400);
    }

    @GetMapping("/solution_table")
    public String solution_table(){
        return "page/table_solution";
    }


    @PostMapping("/updateimage")
    @ResponseBody
    public  StateUtil updateimage(String product_image,int id){
        SolutionEntity solutionEntity = solutionService.getById(id);
        solutionEntity.setSolutionImage(product_image);
        boolean a= solutionService.updateById(solutionEntity);
        if(a){
            return  new StateUtil("成功",200);
        }
        return  new StateUtil("失败",400);

    }


    @PostMapping("/show_detailpage")
    @ResponseBody
    public StateUtil show_detailpage(String name, HttpSession httpSession){
        QueryWrapper<SolutionEntity> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("solution_name",name);
        List<SolutionEntity> solutionEntityList = solutionService.list(queryWrapper);


        SolutionEntity productBean= solutionEntityList.get(0);
        httpSession.setAttribute("detailpage_name",productBean.getSolutionName());
        httpSession.setAttribute("detailpage_content",productBean.getSolutionContent());
        return new StateUtil("成功",200);
    }
}
