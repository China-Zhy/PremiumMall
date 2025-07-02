package com.nxu.model;

import com.nxu.entity.Brand;
import com.nxu.entity.Category;
import lombok.Data;

import java.util.List;

/**
 * 商品搜索条件信息(页面展示)
 */
@Data
public class ProductSearch {
    private Category firstCategory;             // 一级分类
    private List<Category> secondCategory;      // 二级分类
    private List<Brand> brands;                 // 品牌信息
}