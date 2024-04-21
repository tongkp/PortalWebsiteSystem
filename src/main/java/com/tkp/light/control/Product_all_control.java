package com.tkp.light.control;

//@Controller
//@RequestMapping("/content")
public class Product_all_control {
//    @Autowired
//    ProductServiceImpl productService;
//
//    @Autowired
//    patents_service patentsService;
//
//    @Autowired
//    case_service caseService;
//
//    @Autowired
//    solution_service solutionServices;

/*    @Autowired
    image_service imageService;
    @PostMapping("/product")
    @ResponseBody
    public StateUtil insert_product(ProductInfo productBean){
        if(!ObjectUtils.isEmpty(productBean)) {
            int code = -1;
            boolean isUpdate = false;
            if (productBean.getId() != 0){
                code = productService.updateProductById(productBean);
                isUpdate = true;
            }else {
                code = productService.insert_product(productBean);
            }
            if(!StringUtils.isEmpty(productBean.getProduct_image())){
                int index=productBean.getProduct_image().lastIndexOf("/");
                Image_bean image_bean =new Image_bean();
                image_bean.setImage_name(productBean.getProduct_image().substring(index+1));
                image_bean.setImage_type("1");
                image_bean.setImage_to("1");
                image_bean.setImage_to_id(productBean.getId());
                if(isUpdate){
                    imageService.insert_image(image_bean);
                }else {
//                imageService.update_image()
                }
            }

            if(code==1){
               return new StateUtil("添加成功！",200);
            }
        }else{
            return new StateUtil("添加失败！",400);
        }
        return new StateUtil("添加失败！",400);
    }

    @PostMapping("/patents")
    @ResponseBody
    public StateUtil insert_patents(patents_bean patentsBean){
        if(!ObjectUtils.isEmpty(patentsBean)) {
            int code = patentsService.insert_patents(patentsBean);
            int index=patentsBean.getPatents_image().lastIndexOf("/");
            Image_bean image_bean =new Image_bean();
            image_bean.setImage_name(patentsBean.getPatents_image().substring(index+1));
            image_bean.setImage_type("1");
            image_bean.setImage_to("2");
            image_bean.setImage_to_id(patentsBean.getId());
            imageService.insert_image(image_bean);
            if(code==1){

                return   new StateUtil("添加成功！",200);
            }

        }else{

            return new StateUtil("添加失败！",400);
        }
        return new StateUtil("添加失败！",400);
    }

    @PostMapping("/case")
    @ResponseBody
    public StateUtil insert_case(case_bean caseBean){
        if(!ObjectUtils.isEmpty(caseBean)) {
            int code = caseService.insert_case(caseBean);
            int index=caseBean.getCase_image().lastIndexOf("/");
            Image_bean image_bean =new Image_bean();
            image_bean.setImage_name(caseBean.getCase_image().substring(index+1));
            image_bean.setImage_type("1");
            image_bean.setImage_to("3");
            image_bean.setImage_to_id(caseBean.getId());
            imageService.insert_image(image_bean);
            if(code==1){

                return  new StateUtil("添加成功！",200);
            }

        }else{

            return new StateUtil("添加失败！",400);
        }
        return new StateUtil("添加失败！",400);
    }


    @PostMapping("/solution")
    @ResponseBody
    public StateUtil insert_solution(solution_bean solutionBean){
        if(!ObjectUtils.isEmpty(solutionBean)) {
            int code =solutionServices.insert_solution(solutionBean);
            int index=solutionBean.getSolution_image().lastIndexOf("/");
            Image_bean image_bean =new Image_bean();
            image_bean.setImage_name(solutionBean.getSolution_image().substring(index+1));
            image_bean.setImage_type("1");
            image_bean.setImage_to("4");
            image_bean.setImage_to_id(solutionBean.getId());
            imageService.insert_image(image_bean);
            if(code==1){

                return  new StateUtil("添加成功！",200);
            }

        }else{

            return new StateUtil("添加失败！",400);
        }
        return new StateUtil("添加失败！",400);
    }*/
}
