/**
 * Created by zewei on 2017/6/22.
 */
//员工职务设置
var itemsSearch =[
	"changejop.sno",
	"changejop.sname",
	"changejop.dname",
	"changejop.djop",
];
var itemsSearchName =[
	"编号",
	"姓名",
	"部门",
	"职位",
];
var itemsResponse = [
	"changejop.sno",
	"changejop.sname",
	"changejop.dname",
	"changejop.djop",
];
var itemsResponseName = [
	"编号",
	"姓名",
	"部门",
	"职位",
];
var itemsUpdate = [
	"changejop.sno",
	"changejop.sname",
	"changejop.dname",
	"changejop.djop",
];
var itemsUpdateName = [
	"编号",
	"姓名",
	"部门",
	"职位",
];
var itemsAdd = [
	"changejop.sno",
	"changejop.sname",
	"changejop.dname",
	"changejop.djop",
];
var itemsAddName = [
	"编号",
	"姓名",
	"部门",
	"职位",
];
urlSendPress = {
	"urlSearch" : "http://localhost:8080/sendPress/staffAction!showJop",
	"urlUpdate" : "http://localhost:8080/sendPress/staffAction!changeJop",
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

