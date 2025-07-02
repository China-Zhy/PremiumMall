package com.nxu.model;

import lombok.Data;

import java.util.List;

/**
 * 商品筛选条件信息(后端查询)
 */
@Data
public class ProductSelect {
    private String name;                    // 商品名称
    private Integer category;               // 二级分类
    private List<Integer> brand;            // 商品品牌
    private Integer pageNum;                // 请求第几页
    private Integer pageSize;               // 每页数据量
}