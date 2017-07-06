package com.press.action;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.alibaba.fastjson.JSONObject;
import com.itextpdf.text.DocumentException;
import com.opensymphony.xwork2.ActionSupport;
import com.press.pojo.ChangeLevel;
import com.press.pojo.Department;
import com.press.pojo.Newspaper;
import com.press.pojo.Notice;
import com.press.pojo.Staff;
import com.press.pojo.changeJop;
import com.press.service.NewspaperServiceImpl;
import com.press.service.StaffServiceImpl;
import com.press.util.MD5Utils;
import com.press.util.PressUtil;
import com.press.util.TranslatePDF;

@Action(value = "staffAction", results = {
        @Result(name = "add", location = "/addsuccess.jsp"), 
        @Result(name = "selectById", location = "/success.jsp"), 
        @Result(name = "update", location = "/success.jsp"), 
        @Result(name = "selectAll", location = "/success.jsp"), 
        @Result(name = "multipleSelect", location = "/success.jsp"), 
        @Result(name = "batchDel", location = "/delSuccess.jsp"), 
        @Result(name = "login", location = "/loginSuccess.jsp"),
        @Result(name = "loginfail", location = "/loginFail.jsp"),
        @Result(name = "logout", location = "/loginSuccess.jsp"),
        @Result(name = "delete", location = "/delSuccess.jsp"),
        @Result(name = "showJop", location = "/success.jsp"), 
        @Result(name = "sendnotice", location = "/success.jsp"), 
        @Result(name = "receive", location = "/success.jsp"), 
        @Result(name = "oldNotice", location = "/success.jsp"), 
        @Result(name = "modify", location = "/success.jsp"), 
})
public class StaffAction extends ActionSupport {

	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse resp = ServletActionContext.getResponse();
		
	@Resource(name="staffService")
	private StaffServiceImpl staffService;
	@Resource(name="NewspaperServiceImpl")
	private NewspaperServiceImpl newImpl;
	
	private Staff staff;
	private Department department;
	private List<Staff> allStaffs;
	private String jsonString;
	private changeJop changejop;
	private ChangeLevel changeLevel;
	
	public changeJop getChangejop() {
		return changejop;
	}
	public void setChangejop(changeJop changejop) {
		this.changejop = changejop;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	

	public List<Staff> getAllStaffs() {
		return allStaffs;
	}
	public void setAllStaffs(List<Staff> allStaffs) {
		this.allStaffs = allStaffs;
	}
	public String getJsonString() {
		return jsonString;
	}
	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}	
	
	public ChangeLevel getChangeLevel() {
		return changeLevel;
	}
	public void setChangeLevel(ChangeLevel changeLevel) {
		this.changeLevel = changeLevel;
	}
	//添加员工
	public String add() {
		System.out.println( staff );
		staff.setPassword( MD5Utils.md5( staff.getPassword() ) );
		String reback = staffService.add(staff);
		return reback;
	}
	//按ID查找员工
	public String select() {
		staff = staffService.select( staff.getId() );
		return "selectById";
	}
	//更新员工数据
	public void update() {
		String reback = staffService.update( staff );
		PressUtil.send(PressUtil.getJSONPString(new String("success")));
//		return reback;
	}
	//查找所有员工
	public String selectAll() {
		allStaffs = staffService.selectAll();
		return "selectAll";
	}
	//多条件查询
	public String multipleSelect() {
		allStaffs = (List<Staff>)staffService.multipleSelect( staff );
		jsonString = PressUtil.getJSONPString(JSONObject.toJSONString(allStaffs));
		System.out.println("查询员工" + jsonString);

		return "multipleSelect";
	}
	//员工职务设置,显示员工信息
	public void showJop() {
		ArrayList<changeJop> alljops = new ArrayList<changeJop>();
		alljops = (ArrayList<changeJop>) staffService.multipleSelect2( changejop );
		jsonString = PressUtil.getJSONPString(JSONObject.toJSONString(alljops));
		PressUtil.send(jsonString);
		System.out.println(jsonString);
//		return "showJop";
	}
	//修改职务
	public void changeJop() {
		staffService.updatejop( changejop );
		PressUtil.send(JSONObject.toJSONString(new String("success")));		
	}
	//查找员工权限
	public String showLevel() {
		ArrayList<ChangeLevel> levels = new ArrayList<ChangeLevel>();
		levels = (ArrayList<ChangeLevel>) staffService.multipleSelect3(changeLevel);
		jsonString = PressUtil.getJSONPString(JSONObject.toJSONString(levels));
		System.out.println(jsonString);
		return "showJop";
	}
	//修改员工权限
	public void changeLevel() {
		staffService.updatelevel( changeLevel );	
		PressUtil.send(PressUtil.getJSONPString(new String("success")));
	}
	public void show() {}
	//批量删除
	public String batchDel() {
		Integer[] Ids = {2,3,7};
		req.setAttribute("ids", Ids);
		Integer[] getid = (Integer[]) req.getAttribute("ids");
		staffService.batchDel( getid );
		return "batchDel";
	}
	//根据ID号删除员工
	public void delete() {
		staffService.del(staff.getId());
		PressUtil.send(PressUtil.getJSONPString(new String("success")));
	}
	
	//发送通知给其它部门
	public String sendNotice() {
		
		String dname = req.getParameter("dname");
		String content = req.getParameter("content");
		Staff staff = (Staff) req.getSession().getAttribute("staff");
		if( staff != null ){
			int id = staff.getId();
			staffService.sendNotice(id, dname, content);		
		}
		return "sendnotice";
	}
	//收取通知
	public String receiveNotice() {
		
		Staff staff = (Staff) req.getSession().getAttribute("staff");		
		if( staff != null ){
			int id = staff.getId();
			List<Notice> notices = staffService.receiveNotice(id,0);	
			jsonString = PressUtil.getJSONPString(JSONObject.toJSONString(notices));
			System.out.println(jsonString);
		}		
		return "receive";
	}
	//查找已阅通知
	public String oldNotice() {
		
		Staff staff = (Staff) req.getSession().getAttribute("staff");		
		if( staff != null ){
			int id = staff.getId();	
			List<Notice> notices = staffService.receiveNotice(id,1);	
			jsonString = PressUtil.getJSONPString(JSONObject.toJSONString(notices));
			System.out.println(jsonString);
		}		
		return "oldNotice";
	}
	//修改密码
	public void modifyPasswd() {
		
		Staff staff = (Staff) req.getSession().getAttribute("staff");	
		if( staff != null) {
			int id = staff.getId();
			String oldpassword = req.getParameter("oldpassword");
			String newpassword = req.getParameter("newpassword");		
			List<Staff> staffs = staffService.findByIdAndPassword(id, MD5Utils.md5(oldpassword));
			if( staffs != null ) {
				Staff staff2 = staffs.get(0);
				staff2.setPassword(MD5Utils.md5(newpassword));
				staffService.update(staff2);
			}	
		}
		PressUtil.send(PressUtil.getJSONPString(new String("success")));
//		return "modify";
	}
		
	//登录账号
	public void login() throws IOException {
		//判断账号密码是否正确
		Object object = staffService.loginCheck( staff );
		String auto = req.getParameter("autologin");
		System.out.println("核验登录");
		//账号密码正确，返回一个正确的对象
		if( object instanceof Staff )
			staff = (Staff) object;
		//账号或者密码错误，返回错误信息，然后跳转到失败页面
		else {
			jsonString = PressUtil.getJSONPString(JSONObject.toJSONString((String)object));
			PressUtil.send(jsonString);
		}
		//将staff对象存入session中,再跳转页面
		req.getSession(true).setAttribute("staff", staff);
		jsonString = PressUtil.getJSONPString(JSONObject.toJSONString(staff));
		PressUtil.send(jsonString);		
		//如果勾选了自动登录
		if( "auto".equals( auto ) ) {
			//默认保存7天
		  int seconds = 60*60*24*7;	 
	      //声明cookie
	      Cookie c = new Cookie("autoLoginId", String.valueOf( staff.getId() ) );	 
	      Cookie c2 = new Cookie("autoLoginPassword", staff.getPassword() );
	      Cookie c3 = new Cookie("autoLoginName", staff.getUsername() );
	      c.setMaxAge(seconds); 
	      c.setPath(req.getContextPath()); 
	      c2.setMaxAge(seconds); 
	      c2.setPath(req.getContextPath());  
	      c3.setMaxAge(seconds); 
	      c3.setPath(req.getContextPath()); 
	      //保存cookie 
	      resp.addCookie(c);
	      resp.addCookie(c2);
	      resp.addCookie(c3);
		}
//		resp.sendRedirect("http://localhost:8080/sendPress/AdminLTE-2.3.11/index.html");
	}
	//刷新
	public String reflash() {
		System.out.println( staff  );
		return "login";
	}
	//退出登录
	public String logout() {
		//清空session
		req.getSession().invalidate();
	    Cookie c = new Cookie("autoLoginId", "ddd");
	    c.setMaxAge(0);
	    c.setPath(req.getContextPath());
	    resp.addCookie(c);
	    c = new Cookie("autoLoginPassword", "ddd");
	    c.setMaxAge(0);
	    c.setPath(req.getContextPath());
	    resp.addCookie(c);
	    c = new Cookie("autoLoginName", "ddd");
	    c.setMaxAge(0);
	    c.setPath(req.getContextPath());
	    resp.addCookie(c);
		return "logout";
	}
	//打印汇总一
	public void printOne() {
		//调用汇总函数，得到一个List对象
		String path = "D:/summary1.pdf";
		List<Staff> staffs = staffService.selectAll();
		try {
			TranslatePDF.changePDF(staffs, path); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	//打印汇总二
	public void printTwo() {
		String path = "D:/summary2.pdf";
		List<Newspaper> newspapers = newImpl.getAllNewspaper();
		try {
			TranslatePDF.changePDF(newspapers, path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//打印汇总三
	public void printThree() {
		String path = "D:/summary3.pdf";		
	}
}
