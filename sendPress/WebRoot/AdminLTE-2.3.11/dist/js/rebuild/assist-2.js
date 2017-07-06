/**
 * Created by zewei on 2017/6/22.
 */
//员工信息设置
var itemsResponse = [
	"staff.readstate",
	"staff.fromMan",
	"staff.content",
	"staff.ntime",
];
var itemsResponseName = [
	"状态",
	"发件人",
	"内容",
	"时间",
];

urlSendPress = {
		"urlSearch" : "http://localhost:8080/sendPress/staffAction!oldNotice",
}

var itemResponseNumber = itemsResponse.length;

var searchRes; //全部结果
var numberRes; //结果数
var pageMax; //最大页数
var nowRes; //当前显示结果
var pageSize = 7; //显示结果数
var nowPage; //当前页数
var isBegin = true;


/**
 * Created by zewei on 2017/6/22.
 * 工具
 */
function SetSearchItem() {//控制搜索框选项
	var check = document.getElementById("check1");
	var value = check.getElementsByTagName("input");
	var countall = 0;
	for (var i = 0; i < itemSearchNumber; i++) {
		if (value[i].checked) { //选中操作
			countall += 1
			if ($("#search-sp-" + i).hasClass("hidden")) { //被隐藏
				$("#search-sp-" + i).removeClass("hidden");
			}
			if ($("#search-in-" + i).hasClass("hidden")) {
				$("#search-in-" + i).removeClass("hidden");
			}
		} else { //未选中
			if (!($("#search-sp-" + i).hasClass("hidden"))) { //出现
				$("#search-sp-" + i).addClass("hidden");
			}
			if (!($("#search-in-" + i).hasClass("hidden"))) {
				$("#search-in-" + i).addClass("hidden");
			}
		}
	}
	if (countall == 0) {
		if( ($("#search-sp-" + 1).hasClass("hidden")) ) { //隐藏
			$("#search-sp-" + 1).removeClass("hidden");
		}
		if ($("#search-in-" + 1).hasClass("hidden")) {
			$("#search-in-" + 1).removeClass("hidden");
		}
	}
}

function delconfirm() { //弹出确认框
	 var msg = "您真的确定要删除吗？\n\n请确认！"; 
	 if (confirm(msg)==true){ 
	  return true; 
	 }else{ 
	  return false; 
	 } 
}

function formatDateTime(inputTime) { //时间戳格式化    
    var date = new Date(inputTime);  
    var y = date.getFullYear();    
    var m = date.getMonth() + 1;    
    m = m < 10 ? ('0' + m) : m;    
    var d = date.getDate();    
    d = d < 10 ? ('0' + d) : d;    
    var h = date.getHours();  
    h = h < 10 ? ('0' + h) : h;  
    var minute = date.getMinutes();  
    var second = date.getSeconds();  
    minute = minute < 10 ? ('0' + minute) : minute;    
    second = second < 10 ? ('0' + second) : second;   
    return y + '-' + m + '-' + d;  
};  

function Search() { //查询
	searchRes = []; //初始化查询情况；
	$.ajax({
		type : "GET",
		url : urlSendPress.urlSearch,
		dataType : 'jsonp',
		jsonp : 'callback',
		async:false,
		success : function(data) {
			if (!data||data==="没有查询到数据! "||data==""){
				alert("无相应记录！");
			} else {
				if (data.length) {
					searchRes = data;
					numberRes = data.length;
				} else {
					searchRes.push(data);
				}
			}
			pageMax = Math.ceil(numberRes / pageSize);
			if(isBegin){
				SelectRes(0);
				isBegin = false;
			}
			else{
				SelectRes(nowPage);
			}
		},
		error : function() {
			alert("获取数据失败，请重试");
		},
	});
}

function SelectRes(page) { //设置当前页面，当面页数。
	var startres = page * pageSize;
	var endres = (page + 1) * pageSize;
	if (endres >= numberRes) {
		endres = numberRes;
	}
	if (numberRes <= 1) {
		nowRes = searchRes;
	} else {
		nowRes = searchRes.slice(startres, endres);
	}
	nowPage = page;
	UpdateView();
}

function SelectResLast() {
	if (!(nowPage - 1 < 0)) {
		SelectRes(nowPage - 1);
	} else {
		alert("已经到第一页！")
	}
}

function SelectResNext() {
	if (!(nowPage + 1 >= pageMax)) {
		SelectRes(nowPage + 1);
	} else {
		alert("已经到最后一页！")
	}
}
//----------------------------------------------------------------

//---------------------------------------------------------------

//-------------------------------------------------------------
function UpdateView() { //更新视图
	var page = nowPage+1; //重零开始
	$("#search-page").html("-"+page+"-");
//	var tbody = document.getElementById("search-res"); //拿到table-body
//	var tbody = $("#search-res");
//	var trlist = tbody.getElementsByTagName("tr"); //将tr转换为数组
	var trlist = $("#search-res tr");
	var res = nowRes; //当前页数据
	var countres = 0
	for (var i = 0; i < pageSize; i++) { //更新行
		ress = res[i]; //行数据
		var tdlist = trlist[i].getElementsByTagName("td");//获得列数组
		for (var j = 0; j <itemResponseNumber+1; j++) { //更新列
			if (countres < res.length) {
				if (j >= itemResponseNumber) {
					tdlist[j].innerHTML = '<a href="javascript:void (0)" onclick="ChagngViewToUpdate(this)" class="edit-td btn-primary"><i class="fa fa-gear"></i> 编辑</a>&nbsp;<a href="javascript:void (0)" onclick="Delete(this)" class="edit-td btn-warning"><i class="fa fa-cut"></i> 删除</a>';
				}
				else{
					var temp = itemsResponse[j].split(".");
					if (ress[temp[1]]){
						if(temp[1]=="date"||temp[1]=="regdate"){
							tdlist[j].innerHTML = formatDateTime(ress[temp[1]]);
						}
						else{
							tdlist[j].innerHTML = ress[temp[1]];
						}	
					}
					else{
						tdlist[j].innerHTML = "";
					}
				}
			} else {
				tdlist[j].innerHTML = "";
			}
		}
		countres += 1;
	}
}

//-------------------------------------------------------------
//自动设置table.
//-------------------------------------------------------------
function initwindow(){
	initSearch();
	initResult();
	initAdd();
}
function initSearch(){
    var	select = $("#check1");
    for(var i=0;i<itemSearchNumber;i++){
    	var checkbox = '<li><input type="checkbox" name="value-'+i+'">'+itemsSearchName[i]+'</li>';
    	select.append(checkbox);
    }
    var button = '<li><button type="button" onclick="SetSearchItem()"class="btn btn-sm btn-info btn-flat pull-right">确定</button></li>';
    select.append(button);
	select = $("#search-body-group");
    for(var i=0;i<itemSearchNumber;i++){
    	if (i==0){
    		var input = '<span class="input-group-addon" id="search-sp-'+i+'">'+itemsSearchName[i]+'</span><input type="text" class="form-control" id="search-in-'+i+'"name="'+itemsSearchName[i]+'">';
    	}
    	else{
    		var input = '<span class="input-group-addon hidden" id="search-sp-'+i+'">'+itemsSearchName[i]+'</span><input type="text" class="form-control hidden" id="search-in-'+i+'"name="'+itemsSearchName[i]+'">';
    	}
    	select.append(input);
    }
}

function initResult(){
	var select = $("#search-res-head");
	for(var i=0;i<itemResponseNumber;i++){
		var th = '<th>'+itemsResponseName[i]+'</th>';
		select.append(th);
	}
	select.append('<th>操作</th>');
	
	select = $("#search-res");
	for(var i=0;i<pageSize;i++){
		var tr ='<tr>'
		if(i%2){
			tr = '<tr  style="background-color: #d1e3ef;">';
		}
		for(var j=0;j<itemResponseNumber+1;j++){
			tr += '<td></td>';
		}
		tr += '</tr>';
		select.append(tr);
	}
}

function initAdd(){
	var select = $("#add-form-head");
	for(var i=0;i<itemAddNumber;i++){
		var th = '<th>'+itemsAddName[i]+'</th>';
		select.append(th);
	}
	select = $("#add-form");
	for(var i=0;i<itemAddNumber;i++){
		var td = '<td><input type="text" name="'+itemsAdd[i]+'" id="add-in-'+i+'"></td>';
		select.append(td);
	}
}

function send(){
	$('div#froala-editor').froalaEditor('html.get');
}