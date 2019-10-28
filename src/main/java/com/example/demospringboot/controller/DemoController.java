package com.example.demospringboot.controller;

import com.example.demospringboot.dto.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 本示例描述了，请求和响应参数，时间类型的字段格式化（包含时区的设置）
 */
@RestController
public class DemoController {
    @PostMapping("get/user")
    public UserDto getUser(@RequestBody UserDto userDto)throws Exception{

        return userDto;
    }
}
