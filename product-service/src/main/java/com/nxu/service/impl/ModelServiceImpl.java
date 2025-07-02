package com.nxu.service.impl;

import com.nxu.entity.Brand;
import com.nxu.entity.Category;
import com.nxu.mapper.BrandMapper;
import com.nxu.model.ProductSearch;
import com.nxu.service.CategoryService;
import com.nxu.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private CategoryService categoryService;

    /**
     * 获取商品搜索条件
     *
     * @return 商品搜索条件模型
     */
    @Override
    public List<ProductSearch> getProductSearch() {
        ArrayList<ProductSearch> list = new ArrayList<>();
        for (Category category : categoryService.getFirstCategory()) {
            List<Category> secondCategory = categoryService.getSecondCategory(category.getId());
            List<Brand> brandList = brandMapper.getBrandList(category.getId());
            ProductSearch productSearch = new ProductSearch();
            productSearch.setFirstCategory(category);
            productSearch.setSecondCategory(secondCategory);
            productSearch.setBrands(brandList);
            list.add(productSearch);
        }
        return list;
    }
}