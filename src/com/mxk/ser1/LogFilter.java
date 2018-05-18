package com.mxk.ser1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.sun.xml.internal.bind.v2.runtime.Name;

/**
 * Servlet Filter implementation class LogFilter
 */
public class LogFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LogFilter() {
        // TODO Auto-generated constructor stub
    }
    /**
	 * @see Filter#init(FilterConfig)
	 */
    public void init(FilterConfig fConfig) throws ServletException {
    	//获取初始化参数
    	String site=fConfig.getInitParameter("site");
    	String filtername=fConfig.getFilterName();
    	
    	//输出初始化参数
    	System.out.println("网站名称："+site+" "+"过滤器的name:"+filtername);
    	
    	
	}
	
	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
        //利用过滤器设验证用户名密码
        String name=request.getParameter("name");
        
        System.out.println("过滤器获取到了参数："+name);
        // 输出站点名称
        System.out.println("站点网址：http://www.runoob.com");
        
        if ("123".equals(name)) {
        	  //把请求传回过滤链
            chain.doFilter(request, response);
		}else {
			 //设置返回内容类型
	        response.setContentType("text/html;charset=GBK");

	        //在页面输出响应信息
	        PrintWriter out = response.getWriter();
	        out.print("<b>name不正确，请求被拦截，不能访问web资源</b>");
	        System.out.println("name不正确，请求被拦截，不能访问web资源");
		}
        
        
        
        
        
      
		
	}
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy被调用");
	}
	
	

}
