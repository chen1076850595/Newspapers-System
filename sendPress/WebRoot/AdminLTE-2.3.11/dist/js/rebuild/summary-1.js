/**
 * Created by zewei on 2017/6/22.
 */
//当日版面信息
var itemsSearch =[
		"newspaper.id",
		"newspaper.name",
		"newspaper.type",
		"newspaper.pageNum",
		"newspaper.pageLength",
		"newspaper.pageWidth",
		"newspaper.theme",
		"newspaper.date",
		];
var itemsSearchName =[
	"编号",
	"报名",
	"类型",
	"页数",
	"版高",
	"版宽",
	"主题",
	"日期",
	];
var itemsResponse = [
		"newspaper.id",
		"newspaper.name",
		"newspaper.type",
		"newspaper.pageNum",
		"newspaper.pageLength",
		"newspaper.pageWidth",
		"newspaper.theme",
		"newspaper.date",
];
var itemsResponseName = [
		"编号",
		"报名",
		"类型",
		"页数",
		"版高",
		"版宽",
		"主题",
		"日期",
];
var itemsAdd = [
		"newspaper.name",
		"newspaper.type",
		"newspaper.pageNum",
		"newspaper.pageLength",
		"newspaper.pageWidth",
		"newspaper.theme",
		"newspaper.date",
];
var itemsAddName = [
		"报名",
		"类型",
		"页数",
		"版高",
		"版宽",
		"主题",
		"日期",
];
var itemsUpdate = [
		"newspaper.id",
		"newspaper.name",
		"newspaper.type",
		"newspaper.pageNum",
		"newspaper.pageLength",
		"newspaper.pageWidth",
		"newspaper.theme",
		"newspaper.date",
];
var itemsUpdateName = [
		"编号",
		"报名",
		"类型",
		"页数",
		"版高",
		"版宽",
		"主题",
		"日期",
];
urlSendPress = {
		"urlAdd" : "http://localhost:8080/sendPress/addNewspaper",
		"urlSearch" : "http://localhost:8080/sendPress/selectByCondition",
		//"urlSearch" : "http://localhost:8080/sendPress/selectByCondition",
		
		"urlUpdate" : "http://localhost:8080/sendPress/updateNewspaper",
		"urlDelete" : "http://localhost:8080/sendPress/deleteNewspaper",
		"urlDeletes" : "http://localhost:8080/sendPress/deleteNewspaper",
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

var myDate = new Date();
//获取当前年
var year=myDate.getFullYear();
//获取当前月
var month=myDate.getMonth()+1;
//获取当前日
var date=myDate.getDate();
//获取当前日

var nowdate = year+"-"+month+"-"+date;
