package com.press.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.press.pojo.Staff;
import com.press.util.PressUtil;

public class AutoLoginFilter implements Filter{
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {		
	    //在这儿读取cookie
	    HttpServletRequest req = (HttpServletRequest) request;
	    System.out.println( req.getContextPath() );
	    Staff staff = new Staff();
	    //获取所的有cookie
	    Cookie[] cs = req.getCookies(); 
	    int i = 0;
	    if( cs != null && req.getSession().getAttribute("staff") == null){
	      for( Cookie c : cs ){
	    	//先拿到ID
	       if( "autoLoginId".equals( c.getName() ) ) {
	    	   System.out.println("id");
	    	   staff.setId( Integer.valueOf( c.getValue() ) );
	         i++;
	       } 
	       //再拿到密码
	       if( "autoLoginPassword".equals( c.getName() ) ) {
	    	   System.out.println("ps");
	    	   staff.setPassword( c.getValue() );	    	   
	         i++;	    	   
	       }
	       //再拿到用户名
	       if( "autoLoginName".equals( c.getName() ) ) {
	    	   System.out.println("name");
	    	   staff.setUsername( c.getValue() );	    	   
	         i++;	    	   
	       }
	       //存入session中
	       if( i == 3 ) {
	    	   req.getSession( true ).setAttribute("staff", staff );
	   		   String jsonString = PressUtil.getJSONPString(JSONObject.toJSONString(staff));
	   		   PressUtil.send(jsonString);	
	       }
	      } 
	    }	 
	    //放行
	    chain.doFilter(request, response); 
	  }

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
}
