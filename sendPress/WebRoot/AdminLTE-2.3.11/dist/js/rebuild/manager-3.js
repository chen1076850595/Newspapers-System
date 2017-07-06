/**
 * Created by zewei on 2017/6/22.
 */
//报点关系设置
var itemsSearch =[
"pointRelationObject.id",
"pointRelationObject.printPointName",
"pointRelationObject.sendPointName",

];
var itemsSearchName =[
"编号",
"印点名",
"送点名",
];
var itemsResponse = [
"pointRelationObject.id",
"pointRelationObject.printPointName",
"pointRelationObject.sendPointName",

];
var itemsResponseName = [
"编号",
"印点名",
"送点名",
];
var itemsAdd = [
"pointRelationObject.id",
"pointRelationObject.printPointName",
"pointRelationObject.sendPointName",


];
var itemsAddName = [
"编号",
"印点名",
"送点名",

];
var itemsUpdate = [
"pointRelationObject.id",
"pointRelationObject.printPointName",
"pointRelationObject.sendPointName",

];
var itemsUpdateName = [
"编号",
"印点名",
"送点名",
];
urlSendPress = {
"urlAdd" : "http://localhost:8080/sendPress/addPointRelation",
"urlSearch" : "http://localhost:8080/sendPress/selectPointRelationByCondition",
"urlUpdate" : "http://localhost:8080/sendPress/updatePointRelation",
"urlDelete" : "http://localhost:8080/sendPress/deletePointRelation",
"urlDeletes" : "http://localhost:8080/sendPress/deletePointRelations",
} 
var isBegin = true;
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



