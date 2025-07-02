package com.nxu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nxu.entity.Category;
import com.nxu.mapper.CategoryMapper;
import com.nxu.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    /**
     * 获取商品一级分类
     *
     * @return 商品一级分类集合
     */
    @Override
    public List<Category> getFirstCategory() {
        return this.list(new QueryWrapper<Category>().eq("level", 1));
    }

    /**
     * 获取商品二级分类
     *
     * @param parentId 一级分类ID
     * @return 商品二级分类集合
     */
    @Override
    public List<Category> getSecondCategory(int parentId) {
        return this.list(new QueryWrapper<Category>().eq("level", 2).eq("parent_id", parentId));
    }
}