package com.zca.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
/**
 * Demo class
 *
 * @author zca
 * @date 2020/7/20
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Data
@TableName("student")
public class Student {
    @TableId
    private Integer sid;
    @TableField("stud_name")
    private String studName;
    private Integer sex;
    private Integer grade;


}
