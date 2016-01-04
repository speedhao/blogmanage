package com.speedhao.blogmanage.common.util;

/**
 * 生成分页的html代码
 * @author speedhao
 *
 */
public class Page {
	
	private String method;	//js方法名称
	private int total;		//总记录数
	private int limit;		//每页记录数
	private int allPage;	//总页数
	
	/**
	 * 构造方法
	 * @param url 基础url
	 * @param total 总记录数
	 * @param limit 每页记录数
	 */
	public Page(String method,int total,int limit){
		this.method = method;
		this.total = total;
		this.limit = limit;
		this.allPage = (this.total/this.limit);
		if((this.total%this.limit) != 0)
		{
			this.allPage++;
		}
	}
	
	/**
	 * 显示分页html
	 * @param nowPage 当前显示的页
	 * @return
	 */
	public String showPage(int nowPage){
		StringBuffer str = new StringBuffer();
		
		if(nowPage != 1)
		{
			str.append("<a href=\"javascript:"+this.method+"("+(nowPage-1)+");\">上一页</a>\n");
		}
		
		if(this.allPage <= 4)
		{
			for (int i = 1; i <= this.allPage; i++) {
				if(i == nowPage)
				{
					str.append("<a class=\"current\">"+i+"</a>\n");
				}
				else
				{
					str.append("<a href=\"javascript:"+this.method+"("+i+");\">"+i+"</a>\n");
				}
			}
		}
		else
		{
			if(nowPage == 1)
			{
				str.append("<a class=\"current\">1</a>\n");
				str.append("<a href=\"javascript:"+this.method+"(2);\">2</a>\n");
				str.append("<a class=\"more\">...</a>\n");
				str.append("<a href=\"javascript:"+this.method+"("+(this.allPage-1)+");\">"+(this.allPage-1)+"</a>\n");
				str.append("<a href=\"javascript:"+this.method+"("+this.allPage+");\">"+this.allPage+"</a>\n");
			}
			else
			{
				if(nowPage == this.allPage)
				{
					str.append("<a href=\"javascript:"+this.method+"(1);\">1</a>\n");
					str.append("<a href=\"javascript:"+this.method+"(2);\">2</a>\n");
					str.append("<a class=\"more\">...</a>\n");
					str.append("<a href=\"javascript:"+this.method+"("+(this.allPage-1)+");\">"+(this.allPage-1)+"</a>\n");
					str.append("<a class=\"current\">"+this.allPage+"</a>\n");
				}
				else
				{
					str.append("<a href=\"javascript:"+this.method+"(1);\">1</a>\n");
					str.append("<a class=\"more\">...</a>\n");
					str.append("<a class=\"current\">"+nowPage+"</a>\n");
					str.append("<a class=\"more\">...</a>\n");
					str.append("<a href=\"javascript:"+this.method+"("+this.allPage+");\">"+this.allPage+"</a>\n");
				}
			}
		}
		
		if(nowPage < this.allPage)
		{
			str.append("<a href=\"javascript:"+this.method+"("+(nowPage+1)+");\">下一页</a>\n");
		}
		
		return str.toString();
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getAllPage() {
		return allPage;
	}

	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}
}
