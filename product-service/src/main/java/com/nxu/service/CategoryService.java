package com.nxu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nxu.entity.Category;

import java.util.List;

public interface CategoryService extends IService<Category> {

    /**
     * 获取商品一级分类
     *
     * @return 商品一级分类集合
     */
    List<Category> getFirstCategory();

    /**
     * 获取商品二级分类
     *
     * @param parentId 一级分类ID
     * @return 商品二级分类集合
     */
    List<Category> getSecondCategory(int parentId);
}