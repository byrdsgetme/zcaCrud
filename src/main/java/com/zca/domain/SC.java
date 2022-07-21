package com.zca.domain;

import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("sc")
public class SC {

    @TableField("sid")
    private Integer sid;
    private String studName;
    private Integer sex;
    private Integer grade;
    @TableField("cid")
    private Integer cid;
    private String courseName;
    private Integer credit;

}
