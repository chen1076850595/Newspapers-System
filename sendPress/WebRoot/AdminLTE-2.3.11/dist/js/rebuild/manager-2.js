/**
 * Created by zewei on 2017/6/22.
 */
//送报点
var itemsSearch =[
"sendPoint.id",
"sendPoint.sendName",
"sendPoint.address",
"sendPoint.needNum",
"sendPoint.type",
"staff.username",
"staff.tel",
];
var itemsSearchName =[
"编号",
"送报点名",
"地址",
"需要数量",
"类型",
"负责人姓名",
"联系电话",


];
var itemsResponse = [
"sendPoint.id",
"sendPoint.name",
"sendPoint.addr",
"sendPoint.needNum",
"staff.sName",
"staff.tel",
"staff.type",
];
var itemsResponseName = [
"编号",
"送报点名",
"地址",
"需要数量",
"负责人姓名",
"联系电话",
"类型",
];
var itemsAdd = [
"sendPoint.sendName",
"sendPoint.address",
"sendPoint.needNum",
"sendPoint.type",
"sendPoint.longitude",
"sendPoint.latitude",
"staff.username",
"staff.tel",
];
var itemsAddName = [
"送报点名",
"地址",
"需要数量",
"类型",
"经度",
"纬度",
"负责人姓名",
"联系电话",


];
var itemsUpdate = [
"sendPoint.id",
"sendPoint.sendName",
"sendPoint.address",
"sendPoint.needNum",
"sendPoint.type",
"staff.username",
"staff.tel",
];
var itemsUpdateName = [
"送报点名",
"地址",
"需要数量",
"类型",
"经度",
"纬度",
"负责人姓名",
"联系电话",

];
urlSendPress = {
"urlAdd" : " http://localhost:8080/sendPress/addSendPoint",
"urlSearch" : " http://localhost:8080/sendPress/selectSendPointByCondition",
"urlUpdate" : " http://localhost:8080/sendPress/updateSendPoint",
"urlDelete" : " http://localhost:8080/sendPress/deleteSendPoint",
"urlDeletes" : " http://localhost:8080/sendPress/deleteSendPoints",
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

