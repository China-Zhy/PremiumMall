package com.nxu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nxu.entity.Area;
import com.nxu.mapper.AreaMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area> implements AreaService {

    /**
     * 通过自身级别和上级编码查找地区
     *
     * @param level      地区级别
     * @param parentCode 上级编码
     * @return 地区结合
     */
    @Override
    public List<Area> selectArea(Integer level, String parentCode) {
        if (parentCode == null || parentCode.isEmpty()) {
            parentCode = "0";
        }
        return this.list(new QueryWrapper<Area>().eq("level", level).eq("parent_code", parentCode));
    }
}