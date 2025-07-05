package com.nxu.controller;

import com.nxu.entity.User;
import com.nxu.service.AreaService;
import com.nxu.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AreaService areaService;

    @GetMapping("/index/{id}")
    public String index(@PathVariable Long id, Model model) {
        model.addAttribute("userId", id);
        return "index";
    }

    // 用户登录页面
    @GetMapping("/user-login")
    public String userLogin() {
        return "user-login";
    }

    // 用户注册页面
    @GetMapping("/user-enroll")
    public String userEnroll() {
        return "user-enroll";
    }

    // 用户信息列表
    @GetMapping("/user-list")
    public String userList() {
        return "user-list";
    }

    // 验证手机号是否注册
    @GetMapping("/isEnrolled")
    @ResponseBody
    public boolean isEnrolled(String phone) {
        return userService.isPhoneExist(phone);
    }

    // 用户注册
    @PostMapping("/doUserEnroll")
    @ResponseBody
    public boolean doUserEnroll(@RequestBody User user) {
        user.setName("用户" + user.getPhone().substring(user.getPhone().length() - 4));   // 默认用户名
        user.setAvatar("/image/smail.jpg");     // 默认头像
        return userService.save(user);
    }

    // 用户登录
    @GetMapping("/doUserLogin")
    @ResponseBody
    public HashMap<String, Object> doUserLogin(@RequestParam String phone, @RequestParam String password) {
        HashMap<String, Object> map = new HashMap<>();
        if (userService.isPhoneExist(phone)) {
            User user = userService.getUserByPhone(phone);
            if (user.getPassword().equals(password)) {
                map.put("userId", user.getId());
                map.put("code", 1); // 登录成功
            } else {
                map.put("code", 2); // 密码错误
            }
        } else {
            map.put("code", 0); // 该手机号未注册
        }
        return map;
    }

    // 获取用户列表数据
    @GetMapping("/getUserListData")
    @ResponseBody
    public HashMap<String, Object> getUsers() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("count", userService.list().size());
        map.put("data", userService.list());
        return map;
    }

    // 获取用户个人信息
    @GetMapping("/getUserInfo/{id}")
    public String getUserInfo(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "user-info";
    }

    // 图片上传后转为二进制和base64格式存入数据库
    @PostMapping("/uploadImage")
    @ResponseBody
    public Integer uploadImage(@RequestParam("file") MultipartFile file, HttpSession session) throws IOException {
        if (!file.isEmpty()) {
            byte[] binaryData = file.getBytes();
            session.setAttribute("base64Image", "data:image/jpeg;base64," + Base64.encodeBase64String(binaryData));
            return 1;
        } else {
            System.out.println("警告：上传的图片为空！");
            return 0;
        }
    }
}