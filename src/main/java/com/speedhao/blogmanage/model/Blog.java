package com.speedhao.blogmanage.model;

import java.util.Date;

public class Blog
{
    private int id;
    private String title;
    private String content;
    private String keywords;
    private String description;
    private Date create_time;
    private int view_count;
    private int up_count;
    private int type;
    private int del_flag;

    @Override
    public String toString()
    {
        return "id:" + id + ",title" + title;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getKeywords()
    {
        return keywords;
    }

    public void setKeywords(String keywords)
    {
        this.keywords = keywords;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getCreate_time()
    {
        return create_time;
    }

    public void setCreate_time(Date create_time)
    {
        this.create_time = create_time;
    }

    public int getView_count()
    {
        return view_count;
    }

    public void setView_count(int view_count)
    {
        this.view_count = view_count;
    }

    public int getUp_count()
    {
        return up_count;
    }

    public void setUp_count(int up_count)
    {
        this.up_count = up_count;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public int getDel_flag()
    {
        return del_flag;
    }

    public void setDel_flag(int del_flag)
    {
        this.del_flag = del_flag;
    }

}
