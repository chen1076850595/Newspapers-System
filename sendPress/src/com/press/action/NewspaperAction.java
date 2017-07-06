package com.press.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionContext;
import com.press.pojo.Newspaper;
import com.press.service.NewspaperServiceImpl;
import com.press.util.PressUtil;

public class NewspaperAction {
	
    private Newspaper newspaper;   
    private List<Newspaper> newsList = new ArrayList<Newspaper>();
    private JSONObject newsJSON = new JSONObject();
    private String news;
	
	public Newspaper getNewspaper() {
		return newspaper;
	}
	public void setNewspaper(Newspaper newspaper) {
		this.newspaper = newspaper;
	}
	public List<Newspaper> getNewsList() {
		return newsList;
	}
	public void setNewsList(List<Newspaper> newsList) {
		this.newsList = newsList;
	}
	public JSONObject getNewsJSON() {
		return newsJSON;
	}
	public void setNewsJSON(JSONObject newsJSON) {
		this.newsJSON = newsJSON;
	}
	public String getNews() {
		return news;
	}
	public void setNews(String news) {
		this.news = news;
	}
	
	@Resource(name = "NewspaperServiceImpl")
	private NewspaperServiceImpl newspaperServiceImpl;
	
	
	@Action(value="addNewspaper")
	public void add(){
		newspaperServiceImpl.addNewspaper(newspaper);
	}
	//,results={@Result(name="ok",location="/index.jsp")}
	@Action(value="deleteNewspaper")
	public void delete(){
		newspaperServiceImpl.delNewspaper(newspaper);
		//return "ok";
	}
	@Action(value = "deleteNewspapers")
	public void deletes(){
		System.out.println("删除很多id");
		newspaperServiceImpl.delNewspapers(PressUtil.getId());
	}
	@Action(value="updateNewspaper")
	public void update(){
		newspaperServiceImpl.updateNewspaper(newspaper);
	}
	@Action(value="selectNewspaper",results={@Result(name="ok",location="/selectNews.jsp")})
	public String select(){
		
		 newsList = newspaperServiceImpl.getAllNewspaper();
		 news = PressUtil.getJSONPString(JSONObject.toJSONString(newsList));
		 return "ok";
	}
	@Action(value = "selectByCondition",results = {@Result(name="ok",location="/selectNews.jsp")})
	public void getByCondition() throws IOException{
		if(newspaper.getId()!=null && newspaper.getId()!= 0){
			Newspaper n = newspaperServiceImpl.getById(newspaper.getId());
			news = PressUtil.getJSONPString(JSONObject.toJSONString(n));

		}else{
		newsList = newspaperServiceImpl.getByCondition(newspaper);
		news = PressUtil.getJSONPString(JSONObject.toJSONString(newsList));
		}
		System.out.println(news);
		PressUtil.send(news);
	
		
	}

}
