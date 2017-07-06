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


function Add() { //添加新信息
	var da ={};
	for (var i=0;i<itemAddNumber;i++){
		da[itemsAdd[i]] = $("#add-in-"+i).val();
	}
	$.ajax({
		type : "GET",
		url : urlSendPress.urlAdd,
		data : da,
		dataType : 'jsonp',
		jsonp : 'callback',
		success : function(msg) {
			alert(msg);
		},
		error:function(msg){
			alert("失败！");
		}
	})
}

function Search() { //查询
	var da ={};
	for (var i=0;i<itemSearchNumber;i++){
		da[itemsSearch[i]] = $("#search-in-"+i).val();
	}
	searchRes = []; //初始化查询情况；
	$.ajax({
		type : "GET",
		url : urlSendPress.urlSearch,
		dataType : 'jsonp',
		data : da,
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
function ChagngViewToUpdate(obj) {
	var pp = obj.parentElement.parentElement; //获取到行
	var tdlist = pp.getElementsByTagName("td");
	var ele = null;
	var valuee = [];
	ele = "<td>" + tdlist[0].innerHTML + "</td>";
	for (var i = 1; i < tdlist.length - 1; i++) {
		valuee.push(tdlist[i].innerHTML);
		var temp = '<td><input id="update-in-' + i + '" class="ChagngViewToUpdate" type="text" value="' + tdlist[i].innerHTML + '"></td>';
		ele += temp;
	}
	ele += '<td style="width:150px"><a href="javascript:void(0)" onclick="ChagngUpdateToView(this)" class="edit-td btn-success"><i class="fa fa-file"></i> 保存</a>&nbsp;<a href="javascript:void(0)" onclick="SelectRes('+nowPage+')" class="edit-td btn-info"><i class="fa fa-close"></i> 取消</a></td>';
	pp.innerHTML = ele;
}

function Update(da) { //更新数据
	$.ajax({
		type : "GET",
		url : urlSendPress.urlUpdate,
		dataType : 'jsonp',
		data : da,
		jsonp : 'callback',
		success : function(data) {
			alert(data);
			SelectRes(nowPage);
		},
		error : function() {
			alert("成功！");
		}
	})
}

function ChagngUpdateToView(obj) { //更新视图到查看状态
	var pp = obj.parentElement.parentElement; //获取到行
	var tdlist = pp.getElementsByTagName("td");
	var ele = null;
	var valuee;
	var da ={};
	for (var i=0;i<itemUpdateNumber;i++){
		da[itemsUpdate[i]] = $("#update-in-"+i).val();
	}
	da[itemsUpdate[0]] = tdlist[0].innerHTML;
	Update(da); //更新数据
	ele = "<td>" + tdlist[0].innerHTML + "</td>";

	for (var i = 1; i < tdlist.length - 1; i++) {
		valuee = tdlist[i].getElementsByTagName("input")[0].value;
		var temp = '<td>' + valuee + '</td>';
		ele += temp;
	}
	ele += '<td style="width:150px"><a href="javascript:void (0)" onclick="ChagngViewToUpdate(this)" class="edit-td btn-primary btn-primary"><i class="fa fa-gear"></i> 编辑</a>&nbsp;<a href="javascript:void (0)" onclick="Delete(this)" class="edit-td btn-warning"><i class="fa fa-cut"></i> 删除</a></td>';
	pp.innerHTML = ele;
}
//---------------------------------------------------------------

function Delete(obj) { //删除行数据
	if(!delconfirm()){
		alert("取消删除！");
	}
	else{
	var pp = obj.parentElement.parentElement; //获取到行
	var tdlist = pp.getElementsByTagName("td");
	var id = tdlist[0].innerHTML;
	var da = {};
	da[itemsUpdate[0]] = id,
	$.ajax({
		type : "GET",
		url : urlSendPress.urlDelete,
		dataType : 'jsonp',
		data : da,
		jsonp : 'callback',
		async:false,
		success : function(data) {
			flag = true;
			alert(data);
			var temp = nowPage;
			Search();
			console.log(searchRes);
			nowPage = temp;
		},
		error : function() {
			var temp = nowPage;
			Search();
			console.log(searchRes);
			nowPage = temp;
			alert("删除成功！");
		}
	})
	}
}
function Deletes(){
	if(!delconfirm()){
		alert("取消删除！");
	}
	else{
		var idlist = {};
		if (!nowRes){
			alert("没有数据！");
		}
		else{
			for (var i=0;i<nowRes.length;i++){
				idlist[i] = nowRes[i].id;
			}
			//var idlist = $.toJSON(idlist);
			var da = {};
			da[itemsUpdate[0]] = idlist;
			$.ajax({
				type : "GET",
				url : urlSendPress.urlDeletes,
				dataType : 'jsonp',
				data : da,
				jsonp : 'callback',
				success : function(data) {
					alert("删除成功！");
				},
				error : function() {
					Search();
					alert("删除成功！");
				}
			})
		}	
	}
}
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