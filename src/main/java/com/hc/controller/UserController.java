package com.hc.controller;

import com.hc.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author: 梁云亮
 * @Date 2020/4/29 23:34
 * @Description:
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @RequestMapping("/add1")
    public void add1(@Valid User user) {
        System.out.println(user);
    }

    @RequestMapping("/add2")
    public void add2(@Valid User user, BindingResult result) {
        StringBuffer sb = new StringBuffer();
        if (result.hasErrors()) {
            for (FieldError fieldError : result.getFieldErrors()) {
                String message = fieldError.getDefaultMessage();
                sb.append(message+"\t");
            }
            log.error(sb.toString());
        } else {
            System.out.println(user);
        }
    }

}
