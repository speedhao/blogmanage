package com.speedhao.blogmanage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.speedhao.blogmanage.common.util.Page;
import com.speedhao.blogmanage.model.Blog;
import com.speedhao.blogmanage.model.ParamValue;
import com.speedhao.blogmanage.service.BlogService;
import com.speedhao.blogmanage.service.ParamValueService;

//博客管理类
@Controller
@RequestMapping("/blog")
public class BlogController {
	
	private final String BLOG_TYPE_NAME	=	"blog_type";			//博客类型参数名
	private final int PAGE_SIZE 		= 	5;						//每页显示条数
	private final String JS_LIST_METHOD	=	"Blog.getBlogList";		//js中查询数据方法全名
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private ParamValueService paramValueService;
	
	/**
	 * 文章列表页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("listPage")
	public String listPage(Model model,HttpServletRequest request){
		List<ParamValue> typeList = paramValueService.getCVbyName(this.BLOG_TYPE_NAME);
		model.addAttribute("typeList",typeList);
		return "blog/listPage";
	}
	
	/**
	 * 文章列表数据页
	 * @param model
	 * @return
	 */
	@RequestMapping("list")
	public String list(Model model,HttpServletRequest request){
		//当前页
		int nowPage = request.getParameter("showPage") == null ? 1:Integer.parseInt(request.getParameter("showPage"));
		//查询参数
		String title = request.getParameter("title") == null ? "":request.getParameter("title");
		int type = request.getParameter("type") == null ? 0:Integer.parseInt(request.getParameter("type"));
		
		//记录条数
		int count = blogService.countBlog(title, type);
		List<Blog> list = blogService.listBlog(title,type,nowPage,this.PAGE_SIZE);
		
		//设置分页html显示
		Page page = new Page(this.JS_LIST_METHOD, count, this.PAGE_SIZE);
		model.addAttribute("list",list);
		model.addAttribute("paging",page.showPage(nowPage));
		return "blog/list";
	}
	
	/**
	 * 添加文章controller
	 * @param model
	 * @return
	 */
	@RequestMapping("addPage")
	public String add(Model model){
		List<ParamValue> typeList = paramValueService.getCVbyName(this.BLOG_TYPE_NAME);
		model.addAttribute("typeList",typeList);
		return "blog/addPage";
	}
	
	/**
	 * 编辑博客
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("editPage")
	public String editPage(Model model,HttpServletRequest request){
		if(request.getParameter("bid")!=null){
			//获取博客
			Blog blog = blogService.getBlogById(Integer.parseInt(request.getParameter("bid")));
			if(blog == null){
				model.addAttribute("msg","博客不存在！");
				return "error";
			}
			//博客类型列表
			List<ParamValue> typeList = paramValueService.getCVbyName(this.BLOG_TYPE_NAME);
			model.addAttribute("blog",blog);
			model.addAttribute("typeList",typeList);
			return "blog/editPage";
		}
		else{
			model.addAttribute("msg","博客id不存在！");
			return "error";
		}
	}
	
	/**
	 * 保存博客动作
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="doSave",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String doSave(Model model,HttpServletRequest request){
		Blog blog = this.getBlogInfo(request);
		int state = blogService.addBlog(blog);//保存成功则返回1
		String result = "{\"state\":\""+state+"\"}";
		return result;
	}
	
	/**
	 * 更新博客动作
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="doUpdate",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String doUpdate(Model model,HttpServletRequest request){
		Blog blog = this.getBlogInfo(request);
		int state = blogService.updateBlog(blog);//更新成功返回1
		String result = "{\"state\":\""+state+"\"}";
		return result;
	}
	
	/**
	 * 删除博客动作
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="doDel",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String doDel(Model model,HttpServletRequest request){
		Map<String,String> jsonMap = new HashMap<String, String>();
		if(request.getParameter("bid") != null){
			int bid = Integer.parseInt(request.getParameter("bid"));
			if(blogService.delBlog(bid) == 1){
				jsonMap.put("state","1");
				jsonMap.put("msg","删除成功！");
			}
			else{
				jsonMap.put("state","0");
				jsonMap.put("msg","删除失败！");
			}
		}
		else{
			jsonMap.put("state","0");
			jsonMap.put("msg","参数错误！");
		}
		String result = "";
		ObjectMapper objMap = new ObjectMapper();
		try {
			result = objMap.writeValueAsString(jsonMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 发布动作
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="doOpen",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String doOpen(Model model,HttpServletRequest request){
		Map<String,String> jsonMap = new HashMap<String, String>();
		if(request.getParameter("bid") != null){
			int bid = Integer.parseInt(request.getParameter("bid"));
			if(blogService.openBlog(bid) == 1){
				jsonMap.put("state","1");
				jsonMap.put("msg","发布成功！");
			}
			else{
				jsonMap.put("state","0");
				jsonMap.put("msg","发布失败！");
			}
		}
		else{
			jsonMap.put("state","0");
			jsonMap.put("msg","参数错误！");
		}
		String result = "";
		ObjectMapper objMap = new ObjectMapper();
		try {
			result = objMap.writeValueAsString(jsonMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 参数封装
	 * @param request
	 * @return
	 */
	private Blog getBlogInfo(HttpServletRequest request){
		Blog blog = new Blog();
		//如果有id则是update
		if(request.getParameter("blog_id") != null){
			blog.setId(Integer.parseInt(request.getParameter("blog_id")));
		}
		blog.setTitle(request.getParameter("blog_title"));
		blog.setType(Integer.parseInt(request.getParameter("blog_type")));
		blog.setKeywords(request.getParameter("blog_key"));
		blog.setDescription(request.getParameter("blog_des"));
		//只有新增的时候才有此字段
		if(request.getParameter("del_flag") != null){
			blog.setDel_flag(Integer.parseInt(request.getParameter("del_flag")));
		}
		blog.setContent(request.getParameter("blog_content"));
		
		return blog;
	}
}
