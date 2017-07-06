/**
 * Created by zewei on 2017/6/22.
 */
//路线
var itemsSearch =[
"road.id",
"road.startAddr",
"road.endAddr",
"road.arriveTime",
"road.state",
"bus.busName",
];
var itemsSearchName =[
"编号",
"起始地址",
"终点",
"到达时间",
"状态",
"车队",
];
var itemsResponse = [
"objects.id",
"objects.startAddr",
"objects.endAddr",
"objects.arriveTime",
"objects.state",
"objects.busName",

];
var itemsResponseName = [
"编号",
"起始地址",
"终点",
"到达时间",
"状态",
"车队",
];
var itemsAdd = [

"road.startAddr",
"road.endAddr",
"road.arriveTime",
"road.state",
"bus.busName",

];
var itemsAddName = [

"起始地址",
"终点",
"到达时间",
"状态",
"车队",

];
var itemsUpdate = [
"road.id",
"road.startAddr",
"road.endAddr",
"road.arriveTime",
"road.state",
"bus.busName",
];
var itemsUpdateName = [
"编号",
"起始地址",
"终点",
"到达时间",
"状态",
"车队",

];
urlSendPress = {
"urlAdd" : "http://localhost:8080/sendPress/addRoad",
"urlSearch" : "http://localhost:8080/sendPress/selectRoadByCondition",
"urlUpdate" : "http://localhost:8080/sendPress/updateRoad",
"urlDelete" : "http://localhost:8080/sendPress/deleteRoad",
"urlDeletes" : "http://localhost:8080/sendPress/deleteRoads",
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


