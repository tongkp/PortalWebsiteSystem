package com.tkp.light.server;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tkp.light.bean.patents_bean;

import java.util.List;

public interface patents_ser {
//专利
    public int insert_patents(patents_bean patentsBean);
    public IPage<patents_bean> select_patents(Page page);
    public IPage<patents_bean> select_jub_patents(Page page,String patentsName);
    public boolean delete_id (int id);
    public boolean updateimage(String product_image,int id);
    public patents_bean select_detailpage(String patents_name);
    public List<patents_bean> select_patents();
}
