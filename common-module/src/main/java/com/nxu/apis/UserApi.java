package com.nxu.apis;

import com.nxu.entity.Address;
import com.nxu.entity.Area;
import com.nxu.entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

@FeignClient(name = "user-service")
public interface UserApi {

    // ---User的API---------------------------------------------------------------------------------------

    @GetMapping("/user/index")
    String index();

    // 用户登录页面
    @GetMapping("/user/user-login")
    String userLogin();

    // 用户注册页面
    @GetMapping("/user/user-enroll")
    String userEnroll();

    // 用户信息列表
    @GetMapping("/user/user-list")
    String userList();

    // 验证手机号是否注册
    @GetMapping("/user/isEnrolled")
    @ResponseBody
    boolean isEnrolled(String phone);

    // 用户注册
    @PostMapping("/user/doUserEnroll")
    @ResponseBody
    boolean doUserEnroll(@RequestBody User user);

    // 用户登录
    @GetMapping("/doUserLogin")
    @ResponseBody
    HashMap<String, Object> doUserLogin(@RequestParam String phone, @RequestParam String password);

    // 获取用户列表数据
    @GetMapping("/user/getUserListData")
    @ResponseBody
    HashMap<String, Object> getUsers();


    // 获取用户个人信息
    @GetMapping("/user/getUserInfo/{id}")
    String getUserInfo(@PathVariable Long id, Model model);

    // 图片上传后转为二进制和base64格式存入数据库
    @PostMapping("/user/uploadImage")
    @ResponseBody
    Integer uploadImage(@RequestParam("file") MultipartFile file, HttpSession session);

    // ---Address的API-------------------------------------------------------------------------------------

    // 选择地区(级联选择框)
    @GetMapping("/address/getArea/{level}/{code}")
    @ResponseBody
    List<Area> getArea(@PathVariable("level") Integer level, @PathVariable("code") String code);

    // 获取用户的收货地址页面
    @GetMapping("/address/getUserAddressHtml/{id}")
    String getUserAddress(Model model, @PathVariable Long id);

    // 获取添加地址页面
    @GetMapping("/address/getUserAddressAddHtml")
    String getUserAddressAdd(Model model);

    // 添加收货地址
    @PostMapping("/address/addUserAddress")
    @ResponseBody
    HashMap<String, Object> addUserAddress(@RequestBody Address address);

    // 删除收货地址
    @GetMapping("/address/delUserAddress/{id}")
    @ResponseBody
    boolean delUserAddress(@PathVariable Long id);

    // 编辑收货地址
    @PostMapping("/address/userAddress")
    @ResponseBody
    boolean updateUserAddress(@RequestBody Address address);
}