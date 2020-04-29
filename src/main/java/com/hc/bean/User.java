package com.hc.bean;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.security.auth.Subject;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

/**
 * @Author: 梁云亮
 * @Date 2020/4/29 23:29
 * @Description:
 */
@Data
@ToString
public class User {
    private Integer id;

    @NotBlank(message = "用户名不能为空")
    @Length(min = 6, max = 32, message = "用户名的长度需要在6~32之间")
    private String name;

    @Past(message = "出生日期必须早于当前日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;

    @Email(regexp = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$", message =  "邮件格式错误")
    private String email;

    @Size(min = 11, max = 11)
    private String mobile;

    @NotNull(message = "用户等级不能为空")
    @Min(value = 0, message = "用户等级最小值为0")
    @Max(value = 6, message = "用户等级最大值为6")
    @Digits(integer = 1, fraction = 0, message = "用户等级必须为整数")
    private Integer level;
}
