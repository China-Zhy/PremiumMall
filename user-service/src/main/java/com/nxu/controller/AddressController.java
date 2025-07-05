package com.nxu.controller;

import com.nxu.entity.Address;
import com.nxu.entity.Area;
import com.nxu.service.AddressService;
import com.nxu.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AreaService areaService;

    @Autowired
    private AddressService addressService;

    // 选择地区(级联选择框)
    @GetMapping("/getArea/{level}/{code}")
    @ResponseBody
    public List<Area> getArea(@PathVariable("level") Integer level, @PathVariable("code") String code) {
        return areaService.selectArea(level, code);
    }

    // 获取用户的收货地址页面
    @GetMapping("/getUserAddressHtml/{id}")
    public String getUserAddress(Model model, @PathVariable Long id) {
        model.addAttribute("addressList", addressService.getAddressByUserId(id));
        return "address-list";
    }

    // 获取添加地址页面
    @GetMapping("/getUserAddressAddHtml")
    public String getUserAddressAdd(Model model) {
        model.addAttribute("areaList", areaService.selectArea(1, null)); // 默认显示省
        return "address-add";
    }

    // 添加收货地址
    @PostMapping("/addUserAddress")
    @ResponseBody
    public HashMap<String, Object> addUserAddress(@RequestBody Address address) {
        HashMap<String, Object> map = new HashMap<>();
        if (addressService.save(address)) {
            map.put("result", true);
            map.put("code", address.getId());
        } else {
            map.put("result", false);
        }
        return map;
    }

    // 删除收货地址
    @GetMapping("/delUserAddress/{id}")
    @ResponseBody
    public boolean delUserAddress(@PathVariable Long id) {
        return addressService.removeById(id);
    }

    // 编辑收货地址
    @PostMapping("/userAddress")
    @ResponseBody
    public boolean updateUserAddress(@RequestBody Address address) {
        System.out.println("编辑地址信息：" + address);
        return addressService.updateById(address);
    }

}