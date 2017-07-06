/**
 * Created by zewei on 2017/6/22.
 */
//组合路线设置
var itemsSearch =[
"groupRoad.id",
"groupRoad.startPoint",
"groupRoad.endPoint",
"groupRoad.arriveTime",
"groupRoad.state",



];
var itemsSearchName =[
"编号",
"起始点",
"终点",
"到达时间",
"状态",
];
var itemsResponse = [
"groupRoad.id",
"groupRoad.startPoint",
"groupRoad.endPoint",
"groupRoad.arriveTime",
"groupRoad.state",


];
var itemsResponseName = [
"编号",
"起始点",
"终点",
"到达时间",
"状态",
];
var itemsAdd = [

"groupRoad.startPoint",
"groupRoad.endPoint",
"groupRoad.arriveTime",
"groupRoad.state",

];
var itemsAddName = [

"起始点",
"终点",
"到达时间",
"状态",

];
var itemsUpdate = [
"groupRoad.id",
"groupRoad.startPoint",
"groupRoad.endPoint",
"groupRoad.arriveTime",
"groupRoad.state",
];
var itemsUpdateName = [
"编号",
"起始点",
"终点",
"到达时间",
"状态",
];
urlSendPress = {
"urlAdd" : "http://localhost:8080/sendPress/addGroupRoad",
"urlSearch" : "http://localhost:8080/sendPress/selectGroupRoadByCondition",
"urlUpdate" : "http://localhost:8080/sendPress/updateGroupRoad",
"urlDelete" : "http://localhost:8080/sendPress/deleteGroupRoad",
"urlDeletes" : "http://localhost:8080/sendPress/deleteGroupRoads",
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
