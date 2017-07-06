package com.press.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.press.dao.DepartmentDAO;
import com.press.dao.JurisdictionDAO;
import com.press.dao.NoticeDAO;
import com.press.dao.StaffDAO;
import com.press.pojo.ChangeLevel;
import com.press.pojo.Department;
import com.press.pojo.Jurisdiction;
import com.press.pojo.Notice;
import com.press.pojo.Staff;
import com.press.pojo.changeJop;
import com.press.util.MD5Utils;

@Service("staffService")
public class StaffServiceImpl implements StaffService{
	
	
	
	@Resource(name="staffDao")
	private StaffDAO staffDao;
	
	@Resource(name="departmentDao")
	private DepartmentDAO departmentDao;
	
	@Resource(name="jurDao")
	private JurisdictionDAO jDao;
	
	@Resource(name="noticeDao")
	private NoticeDAO noticeDao;
	
	@Override
	public String add( Staff staff ) {
		staffDao.save( staff );
		return "add";
	}

	@Override
	public Staff select(Integer id) {	
		
		return (Staff) staffDao.findById("com.press.pojo.Staff", id );
	}

	@Override
	public String update( Staff staff ) {
		staffDao.update( staff );
		return "update";
	}

	@Override
	public String del(int id) {
		Staff staff = new Staff();
		staff.setId( id );
		staffDao.delete( staff );
		return "delete";
	}
	@Override
	public List<Staff> selectAll() {
		//传入要查询的表对应的实体类名
		return (List<Staff>)staffDao.findAll("Staff");
	}
	@Override
	public List<Staff> multipleSelect(Staff staff) {
		
		return (List<Staff>)staffDao.findByProperty2(staff);
	}
	@Override
	public List<changeJop> multipleSelect2(changeJop jop) {
		
		return (List<changeJop>)staffDao.findByProperty3(jop);
	}
	public List<ChangeLevel> multipleSelect3(ChangeLevel changeLevel) {
		
		return (List<ChangeLevel>)staffDao.findByProperty4(changeLevel);
	}
	@Override
	public void batchDel(Integer[] getid) {
		
		Staff staff = new Staff();
		for( int i = 0; i < getid.length; i++ ) {
			staff.setId( getid[i] );
			staffDao.delete( staff );
		}	
	}
	@Override
	public Object loginCheck(Staff staff) {

		List<Staff> staffs, staffs2;
		//先检测账号
		staffs = staffDao.findByAccount( staff.getAccount() );
		if( staffs.size() == 0 ) {
			System.out.println("账号错误");
			return "Account Wrong";
		}
		else {
			staffs2 = staffDao.findByPassword( MD5Utils.md5( staff.getPassword() ) );
			if( staffs2.size() == 0 )
				return "Password Wrong";				
		}
		//如果账号和密码都正确，则返回staff对象
		return staffs.get(0);
	}
	//修改工作岗位
	public void updatejop(com.press.pojo.changeJop changejop) {
		Staff staff = (Staff) staffDao.findById("com.press.pojo.Staff", changejop.getSno());
		//先得到部门信息
		List<Department> department = (List<Department>) departmentDao.findByDName( changejop.getDname());
		staff.setJop( changejop.getDjop() );
		//得到部门号
		staff.setDno( String.valueOf(department.get(0).getDNo()) );
		staffDao.update( staff );
		
	}

	public void updatelevel(ChangeLevel changeLevel) {
		
		Staff staff = (Staff) staffDao.findById("com.press.pojo.Staff", changeLevel.getSno() );
		System.out.println( changeLevel.getLdescription() );
		//先得到部门信息
		List<Jurisdiction> jurisdictions = (List<Jurisdiction>) jDao.findByDescription( changeLevel.getLdescription() );
		//得到部门号
		staff.setLevel( jurisdictions.get(0).getLevel() );
		staffDao.update( staff );		
		
	}
	//发送通知
	public void sendNotice(Integer id, String dname, String content) {
			
		//根据部门名称找到部门号
		List<Department> departments = (List<Department>)departmentDao.findByDName(dname);
		int dno = departments.get(0).getDNo();		
		//根据部门号，从人员表中找到对应的人,发送信息给对应的人
		List<Staff> staffs = (List<Staff>)staffDao.findByDno(String.valueOf(dno));
		for( Staff s : staffs ) {
			Notice notice = new Notice();
			notice.setContent(content);
			notice.setFromMan(id);
			notice.setToMan(s.getId());
			notice.setReadstate(0);
			notice.setNtime( new Timestamp(System.currentTimeMillis()) );
			noticeDao.save(notice);
		}
	}
	//接收通知
	public List<Notice> receiveNotice(int id, int state) {
		//接收未阅读通知,所以state为0
		List<Notice> notices = noticeDao.findByProperty2(id,state);
		for( Notice notice : notices ) {
			//将标志改为已阅
			notice.setReadstate(1);
			noticeDao.update(notice);
		}
		return notices;
	}
	//根据ID和密码查找用户信息
	public List<Staff> findByIdAndPassword(int id, String password) {
		return staffDao.findByIdAndPassword(id, password);
	}
}
