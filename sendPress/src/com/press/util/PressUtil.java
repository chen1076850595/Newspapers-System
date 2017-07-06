package com.press.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionContext;
import com.press.pojo.Newspaper;

public class PressUtil {
		private static HttpServletRequest request = ServletActionContext.getRequest();
		//发送数据
		public static void send(String jsonString) {
		        try {
		        	HttpServletResponse response = (HttpServletResponse) ActionContext.getContext()
		    				.get(ServletActionContext.HTTP_RESPONSE);
		    		response.setCharacterEncoding("UTF-8"); 
		    		response.getWriter().print(jsonString);
		    		response.getWriter().close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		//json格式转换为jsonp
		public static String getJSONPString(String string){
			String callback = request.getParameter("callback"); 
			System.out.println(callback);
			return callback+"("+string+")";
		}
		public static int[] getId(){
		    System.out.println("获得Id");
		    int flag=0;
		    for( int i=0;i<7;i++){
		    	
				if(request.getParameter("id["+i+"]")!=null){
					flag++;
				}
		    }
		    int id[] = new int[flag];
		    for(int j=0;j<flag;j++){
		    	id[j] = Integer.parseInt(request.getParameter("id["+j+"]"));
		    	System.out.println(id[j]);
		    }
			
			return id;
		}
	

	    public static String getJSONString(int code, String msg) {
	        JSONObject json = new JSONObject();
	        json.put("code", code);
	        json.put("msg", msg);
	        return json.toJSONString();
	    }

	    public static String getJSONString(int code, Map<String, Object> map) {
	        JSONObject json = new JSONObject();
	        json.put("code", code);
	        for (Map.Entry<String, Object> entry : map.entrySet()) {
	            json.put(entry.getKey(), entry.getValue());
	        }
	        return json.toJSONString();
	    }
	    //MD5算法
	    public static String MD5(String key) {
	        char hexDigits[] = {
	                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
	        };
	        try {
	            byte[] btInput = key.getBytes();
	          
	            MessageDigest mdInst = MessageDigest.getInstance("MD5");
	 
	            mdInst.update(btInput);
	      
	            byte[] md = mdInst.digest();
	       
	            int j = md.length;
	            char str[] = new char[j * 2];
	            int k = 0;
	            for (int i = 0; i < j; i++) {
	                byte byte0 = md[i];
	                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
	                str[k++] = hexDigits[byte0 & 0xf];
	            }
	            return new String(str);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	}


