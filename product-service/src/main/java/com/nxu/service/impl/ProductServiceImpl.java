package com.nxu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nxu.apis.ReviewApi;
import com.nxu.entity.*;
import com.nxu.mapper.*;
import com.nxu.model.ProductDetails;
import com.nxu.model.ProductSelect;
import com.nxu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    private ReviewApi reviewApi;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private SkuMapper skuMapper;

    @Autowired
    private SpecsMapper specsMapper;

    @Autowired
    private ImageMapper imageMapper;

    /**
     * 按条件搜索商品
     *
     * @param data 搜索条件
     * @return 商品数据集合
     */
    @Override
    public Page<Product> selectProduct(ProductSelect data) {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        if (data.getName() != null && !data.getName().isEmpty()) {
            queryWrapper.like("name", data.getName());
        }
        if (data.getCategory() != null && data.getCategory() > 0) {
            queryWrapper.eq("category_id", data.getCategory());
        }
        if (data.getBrand() != null && !data.getBrand().isEmpty() && data.getBrand().getFirst() != 0) {
            queryWrapper.in("brand_id", data.getBrand());
        }

        // 创建分页对象，pageNum为当前页码，pageSize为每页条数
        Page<Product> page = new Page<>(data.getPageNum(), data.getPageSize());
        return page(page, queryWrapper);
    }

    /**
     * 获取商品详情信息(商品信息，评论信息，规格信息)
     *
     * @param id 商品ID
     * @return 商品详情信息
     */
    @Override
    public ProductDetails getProductDetail(Long id) {
        ProductDetails details = new ProductDetails();      // 商品的综合详情信息

        Product product = productMapper.selectById(id);
        details.setProduct(product);    // 商品信息

        Brand brand = brandMapper.selectById(product.getId());
        details.setBrand(brand);    // 品牌信息

        List<Specs> specs = specsMapper.selectList(new QueryWrapper<Specs>().eq("product_id", id));
        details.setSpecs(specs);    // 规格信息

        List<Sku> skus = skuMapper.selectList(new QueryWrapper<Sku>().eq("product_id", id));
        details.setSkus(skus);      // SKU信息

        List<Image> images = imageMapper.selectList(new QueryWrapper<Image>().eq("product_id", id));
        details.setImages(images);  // 图片信息

        details.setReviews(reviewApi.getProductReviews(id, 1, 30).getRecords());    // 评论信息

        return details;
    }
}