/**
 * Created by zewei on 2017/6/22.
 */
//印点
var itemsSearch =[
"printPoint.id",
"printPoint.printName",
"printPoint.printAddress",
"staff.username",
"staff.tel",
];
var itemsSearchName =[
"编号",
"印点名",
"地址",
"负责人姓名",
"联系电话",
];
var itemsResponse = [
"printPoint.id",
"printPoint.name",
"printPoint.addr",
"staff.sName",
"staff.tel",
];
var itemsResponseName = [
"编号",
"印点名",
"地址",
"负责人姓名",
"联系电话",
];
var itemsAdd = [
"printPoint.printName",
"printPoint.printAddress",
"staff.username",
"printPoint.longitude",
"printPoint.latitude",

];
var itemsAddName = [
"印点名",
"地址",
"负责人姓名",
"经度",
"纬度",

];
var itemsUpdate = [
"printPoint.id",
"printPoint.printName",
"printPoint.printAddress",
"staff.username",
];
var itemsUpdateName = [
"编号",
"印点名",
"地址",
"负责人姓名",

];
urlSendPress = {
"urlAdd" : " http://localhost:8080/sendPress/addPrintPoint",
"urlSearch" : " http://localhost:8080/sendPress/selectPrintPointByCondition",
"urlUpdate" : " http://localhost:8080/sendPress/updatePrintPoint",
"urlDelete" : " http://localhost:8080/sendPress/deletePrintPoint",
"urlDeletes" : " http://localhost:8080/sendPress/deletePrintPoints",
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

