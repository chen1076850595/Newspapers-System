/**
 * Created by zewei on 2017/6/22.
 */
//员工信息设置
var itemsSearch =[
	"staff.id",
	"staff.account",
	"staff.username",
	"staff.birthday",
	"staff.tel",
	"staff.regdate",
	"staff.state",
];
var itemsSearchName =[
	"编号",
	"账号",
	"姓名",
	"生日",
	"电话",
	"注册日期",
	"状态",
];
var itemsResponse = [
	"staff.id",
	"staff.account",
	"staff.username",
	"staff.birthday",
	"staff.tel",
	"staff.regdate",
	"staff.state",
];
var itemsResponseName = [
	"编号",
	"账号",
	"姓名",
	"生日",
	"电话",
	"注册日期",
	"状态",
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
	"staff.id",
	"staff.account",
	"staff.username",
	"staff.birthday",
	"staff.tel",
	"staff.regdate",
	"staff.state",
];
var itemsUpdateName = [
	"编号",
	"账号",
	"姓名",
	"生日",
	"电话",
	"注册日期",
	"状态",
];

urlSendPress = {
		"urlAdd" : "http://localhost:8080/sendPress/staffAction!add",
		"urlSearch" : "http://localhost:8080/sendPress/staffAction!multipleSelect",
		"urlUpdate" : "http://localhost:8080/sendPress/staffAction!update",
		"urlDelete" : "http://localhost:8080/sendPress/staffAction!delete",
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

