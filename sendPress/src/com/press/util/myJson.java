package com.press.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

public class myJson {
	
	private static HttpServletRequest request = ServletActionContext.getRequest();

	//json格式转换为jsonp
	public static String getJSONPString(JSONObject jsonObject){
		String callback = request.getParameter("callback"); 
		return callback + "(" + jsonObject.toString() + ")";
	}
	//先前端发送数据
    public void send() {
        try {
    		HttpServletResponse response = (HttpServletResponse) ServletActionContext.getResponse(); 
    		response.setCharacterEncoding("UTF-8"); 
    		PrintWriter out = response.getWriter();
            out.print("");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}