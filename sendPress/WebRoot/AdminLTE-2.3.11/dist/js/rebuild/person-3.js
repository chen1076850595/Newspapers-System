/**
 * Created by zewei on 2017/6/22.
 */
//操作员权限设置
var itemsSearch =[
	"changeLevel.sno",
	"changeLevel.sname",
	"changeLevel.ldescription",
];
var itemsSearchName =[
	"编号",
	"姓名",
	"权限",
];
var itemsResponse = [
	"changeLevel.sno",
	"changeLevel.sname",
	"changeLevel.ldescription",
];
var itemsResponseName = [
	"编号",
	"姓名",
	"权限",
];
var itemsAdd = [
	"staff.account",
	"staff.password",
	"staff.username",
	"staff.birthday",
	"staff.tel",
	"staff.regdate",
	"staff.level",
	"staff.state",
];
var itemsAddName = [
	"账号",
	"密码",
	"姓名",
	"生日",
	"电话",
	"部门号",
	"级别",
	"职位",
];
var itemsUpdate = [
	"changeLevel.sno",
	"changeLevel.sname",
	"changeLevel.ldescription",
];
var itemsUpdateName = [
	"编号",
	"姓名",
	"权限",
];

urlSendPress = {
		"urlSearch" : "http://localhost:8080/sendPress/staffAction!showLevel",
		"urlUpdate" : "http://localhost:8080/sendPress/staffAction!changeLevel",
}

var itemSearchNumber = itemsSearch.length;
var itemResponseNumber = itemsResponse.length;
var itemAddNumber = itemsAdd.length;
var itemUpdateNumber = itemsUpdate.length;

var searchRes; //全部结果
var numberRes; //结果数
var pageMax; //最大页数
var nowRes; //当前显示结果
var pageSize = 7; //显示结果数
var nowPage; //当前页数
var isBegin = true;

