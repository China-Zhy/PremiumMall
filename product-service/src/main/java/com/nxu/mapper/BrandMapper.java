package com.nxu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nxu.entity.Brand;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper extends BaseMapper<Brand> {

    @Select("SELECT b.* from `brand` b WHERE b.id in (SELECT DISTINCT p.brand_id from product p WHERE p.`status`=1 AND p.category_id in (SELECT c.id from category c WHERE c.parent_id = #{categoryId}));")
    List<Brand> getBrandList(int categoryId);
}