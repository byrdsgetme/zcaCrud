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
@TableName("course")
public class Course {
    @TableId
    private Integer cid;
    @TableField("course_name")
    private String courseName;
    private Integer credit;


}
