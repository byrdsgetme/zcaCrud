package com.zca.controller.utils;

import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class R {
    private Boolean flag;
    private Object data;

    public R(){}

    public R(boolean flag)
    {
        this.flag=flag;
    }

    public R(boolean flag,Object data)
    {
        this.data=data;
        this.flag=flag;
    }
}
