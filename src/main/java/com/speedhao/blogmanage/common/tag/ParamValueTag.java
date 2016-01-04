package com.speedhao.blogmanage.common.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import org.springframework.web.context.WebApplicationContext;
import com.speedhao.blogmanage.service.ParamValueService;

public class ParamValueTag implements Tag
{

    // 页面对象
    private PageContext pageContext;
    // 参数
    private String name;
    private String code;

    // 参数服务，需要手动获取
    private ParamValueService paramValueService;

    @Override
    public int doEndTag() throws JspException
    {
        return 0;
    }

    @Override
    public int doStartTag() throws JspException
    {
        String value = paramValueService.getValue(name, code);
        JspWriter out = this.pageContext.getOut();
        try
        {
            out.write(value);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Tag getParent()
    {
        return null;
    }

    @Override
    public void release()
    {
    }

    @Override
    public void setPageContext(PageContext pageContext)
    {
        this.pageContext = pageContext;
        // 由于tag不受spring容器控制，需要手动获取service
        WebApplicationContext webContext = (WebApplicationContext) pageContext.getServletContext().getAttribute(
                WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        paramValueService = (ParamValueService) webContext.getBean("paramValueServiceImpl");
    }

    @Override
    public void setParent(Tag arg0)
    {
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

}
