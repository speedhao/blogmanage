package com.speedhao.blogmanage.model;

import org.springframework.beans.factory.annotation.Autowired;

public class ParamValue
{
    private int id;
    private String param_name;
    private String param_code;
    private String param_value;
    private int del_falg;

    @Autowired
    public String toString()
    {
        return "name:" + param_name + ",code:" + param_code + ",value:" + param_value;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getParam_name()
    {
        return param_name;
    }

    public void setParam_name(String param_name)
    {
        this.param_name = param_name;
    }

    public String getParam_code()
    {
        return param_code;
    }

    public void setParam_code(String param_code)
    {
        this.param_code = param_code;
    }

    public String getParam_value()
    {
        return param_value;
    }

    public void setParam_value(String param_value)
    {
        this.param_value = param_value;
    }

    public int getDel_falg()
    {
        return del_falg;
    }

    public void setDel_falg(int del_falg)
    {
        this.del_falg = del_falg;
    }
}
