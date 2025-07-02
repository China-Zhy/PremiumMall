package com.nxu.apis;

import com.nxu.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@FeignClient(name = "user-service")
public interface UserApi {

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
}