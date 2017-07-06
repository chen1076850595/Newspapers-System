/**
 * Created by zewei on 2017/6/22.
 */
//打包份数设置
//打包份数设置
var itemsSearch =[
"bundle.id",
"bundle.bundleNum",
"printPoint.printName",



];
var itemsSearchName =[
"编号",
"打包份数",
"印点名",
];
var itemsResponse = [
"objects.id",
"objects.bundleNum",
"objects.printName",

];
var itemsResponseName = [
"编号",
"打包份数",
"印点名",
];
var itemsAdd = [

"objects.bundleNum",
"objects.printName",
];
var itemsAddName = [

"打包份数",
"印点名",

];
var itemsUpdate = [
"objects.id",
"objects.bundleNum",
"objects.printName",
];
var itemsUpdateName = [
"编号",
"打包份数",
"印点名",
];
urlSendPress = {
"urlAdd" : "http://localhost:8080/sendPress/addBundle",
"urlSearch" : "http://localhost:8080/sendPress/selectBundleByCondition",
"urlUpdate" : "http://localhost:8080/sendPress/updateBundle",
"urlDelete" : "http://localhost:8080/sendPress/deleteBundle",
"urlDeletes" : "http://localhost:8080/sendPress/deleteBundles",
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

