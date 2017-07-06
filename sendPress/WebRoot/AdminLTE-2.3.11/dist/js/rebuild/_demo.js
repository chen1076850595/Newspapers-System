/**
 * Created by zewei on 2017/6/22.
 */
function SetSearchItem() {
	var check = document.getElementById("check1");
	var value = check.getElementsByTagName("input");
	var countall = 0;
	for (var i = 0; i < 8; i++) {
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
function Add() { //添加新信息
	var da = {
		"newspaper.name" : $("#add-in-0").val(),
		"newspaper.type" : $("#add-in-1").val(),
		"newspaper.pageNum" : $("#add-in-2").val(),
		"newspaper.pageLength" : $("#add-in-3").val(),
		"newspaper.pageWidth" : $("#add-in-4").val(),
		"newspaper.theme" : $("#add-in-5").val(),
		"newspaper.date" : $("#add-in-6").val()
	};
	$.ajax({
		headers : {
			Accept : "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8"
		},
		type : "GET",
		url : "http://localhost:8080/sendPress/addNewspaper",
		data : da,
		success : function(msg) {
			alert("ok" + msg);
		}
	})
}

var searchRes; //全部结果
var numberRes; //结果数
var pageMax; //最大页数
var nowRes; //当前显示结果
var pageSize = 7; //显示结果数
var nowPage; //当前页数

function ChangeResView() { //改变视图

}
function Search() { //查询
	var da = {
		"newspaper.id" : $("#search-in-0").val(),
		"newspaper.name" : $("#search-in-1").val(),
		"newspaper.type" : $("#search-in-2").val(),
		"newspaper.pageNum" : $("#search-in-3").val(),
		"newspaper.pageLength" : $("#search-in-4").val(),
		"newspaper.pageWidth" : $("#search-in-5").val(),
		"newspaper.theme" : $("#search-in-6").val(),
		"newspaper.date" : $("#search-in-7").val()
	};
	searchRes = []; //初始化查询情况；
	$.ajax({
		type : "GET",
		url : "http://localhost:8080/sendPress/selectByCondition",
        //url:"http://localhost:8080/sendPress/selectNewspaper",
		dataType : 'jsonp',
		data : da,
		jsonp : 'callback',
		success : function(data) {
			if (!data) {
				alert("无相应记录！");
			} else {
				if (data.length) {
					searchRes = data;
					numberRes = data.length;
				} else {
					searchRes.push(data);
					numberRes = 1;

				}
			}
			pageMax = Math.ceil(numberRes / pageSize);
			SelectRes(0);
		},
		error : function() {
			alert("获取数据失败，请重试");
		},
	});

//    $.ajax({
//        type:"GET",
//        url:"http://localhost:8080/sendPress/selectNewspaper",
//        dataType: 'json',
//        success:function(data,status){
//            searchRes = $.parseJSON(data);
//        },
//        error: function(){
//        	alert("获取数据失败，请重试");
//        },
//        
//    });
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

function ChagngViewToUpdate(obj) {
	var pp = obj.parentElement.parentElement; //获取到行
	var tdlist = pp.getElementsByTagName("td");
	var ele = null;
	var valuee = [];
	ele = "<td>" + tdlist[0].innerHTML + "</td>";
	for (var i = 1; i < tdlist.length - 1; i++) {
		valuee.push(tdlist[i].innerHTML);
		var temp = '<td><input id="Update-in-' + i + '" class="ChagngViewToUpdate" type="text" value="' + tdlist[i].innerHTML + '"></td>';
		ele += temp;
	}
	ele += '<td style="width:150px"><a href="javascript:void(0)" onclick="ChagngUpdateToView(this)" class="edit-td btn-success"><i class="fa fa-file"></i> 保存</a>&nbsp;<a href="javascript:void(0)" onclick="SelectRes('+nowPage+')" class="edit-td btn-info"><i class="fa fa-close"></i> 取消</a></td>';
	pp.innerHTML = ele;
}
function Update(da) { //更新数据
	$.ajax({
		type : "GET",
		url : "http://localhost:8080/sendPress/updateNewspaper",
		data : da,
		jsonp : 'callback',
		success : function(data) {
			alert("修改成功！");
		},
		error : function() {
			alert("修改成功！");
		}
	})
}

function ChagngUpdateToView(obj) { //更新数据
	var pp = obj.parentElement.parentElement; //获取到行
	var tdlist = pp.getElementsByTagName("td");
	var ele = null;
	var valuee;
	var da = {
		"newspaper.id" : tdlist[0].innerHTML,
		"newspaper.name" : $("#Update-in-1").val(),
		"newspaper.type" : $("#Update-in-2").val(),
		"newspaper.pageNum" : $("#Update-in-3").val(),
		"newspaper.pageLength" : $("#Update-in-4").val(),
		"newspaper.pageWidth" : $("#Update-in-5").val(),
		"newspaper.theme" : $("#Update-in-6").val(),
		"newspaper.date" : $("#Update-in-7").val()
	};
	Update(da);
	ele = "<td>" + tdlist[0].innerHTML + "</td>";

	for (var i = 1; i < tdlist.length - 1; i++) {
		valuee = tdlist[i].getElementsByTagName("input")[0].value;
		var temp = '<td>' + valuee + '</td>';
		ele += temp;
	}
	ele += '<td style="width:150px"><a href="javascript:void (0)" onclick="ChagngViewToUpdate(this)" class="edit-td btn-primary btn-primary"><i class="fa fa-gear"></i> 编辑</a>&nbsp;<a href="javascript:void (0)" class="edit-td btn-warning"><i class="fa fa-cut"></i> 删除</a></td>';
	pp.innerHTML = ele;
}

function UpdateView() { //更新页面
	var page = nowPage+1;
	document.getElementById("search-page").innerHTML = "- "+page+" -";
	var tbody = document.getElementById("search-res"); //拿到table-body
	var trlist = tbody.getElementsByTagName("tr"); //将tr转换为数组
	var res = nowRes; //当前页数据
	var countres = 0
	for (var i = 0; i < pageSize; i++) { //更新行
		ress = res[i]; //行数据
		var tdlist = trlist[i].getElementsByTagName("td"); //获得列数组
		for (var j = 0; j < tdlist.length; j++) { //更新列
			if (countres < res.length) {
				if (j == 0) {
					tdlist[j].innerHTML = ress.id;
				}
				if (j == 1) {
					if (ress.name) {
						tdlist[j].innerHTML = ress.name;
					} else {
						tdlist[j].innerHTML = "";
					}

				}
				if (j == 2) {
					if (ress.type) {
						tdlist[j].innerHTML = ress.type;
					} else {
						tdlist[j].innerHTML = "";
					}
				}
				if (j == 3) {
					if (ress.pageNum) {
						tdlist[j].innerHTML = ress.pageNum;
					} else {
						tdlist[j].innerHTML = "";
					}
				}
				if (j == 4) {
					if (ress.pageLength) {
						tdlist[j].innerHTML = ress.pageLength;
					} else {
						tdlist[j].innerHTML = "";
					}
				}
				if (j == 5) {
					if (ress.pageWidth) {
						tdlist[j].innerHTML = ress.pageWidth;
					} else {
						tdlist[j].innerHTML = "";
					}
				}
				if (j == 6) {
					if (ress.theme) {
						tdlist[j].innerHTML = ress.theme;
					} else {
						tdlist[j].innerHTML = "";
					}
				}
				if (j == 7) {
					if (ress.date) {
						tdlist[j].innerHTML = formatDateTime(ress.date);
					} else {
						tdlist[j].innerHTML = "";
					}
				}
				if (j == 8) {
					tdlist[j].innerHTML = '<a href="javascript:void (0)" onclick="ChagngViewToUpdate(this)" class="edit-td btn-primary"><i class="fa fa-gear"></i> 编辑</a>&nbsp;<a href="javascript:void (0)" onclick="Delete(this)" class="edit-td btn-warning"><i class="fa fa-cut"></i> 删除</a>';
				}
			} else {
				tdlist[j].innerHTML = "";
			}
		}
		countres += 1;
	}
}
function Delete(obj) {
	if(!delconfirm()){
		alert("取消删除！");
	}
	else{
	var pp = obj.parentElement.parentElement; //获取到行
	var tdlist = pp.getElementsByTagName("td");
	var id = tdlist[0].innerHTML;
	var da = {
		"newspaper.id" : id,
	};
	$.ajax({
		type : "GET",
		url : "http://localhost:8080/sendPress/deleteNewspaper",
		dataType : 'jsonp',
		data : da,
		jsonp : 'callback',
		success : function(data) {
			flag = true;
			alert("删除成功！");
		},
		error : function() {
			Search();
			SelectRes(nowPage);
			alert("删除成功！");
		}
	})
	}
}
function Deletes(){
	var idlist = {};
	if (!nowRes){
		alert("没有数据！");
	}
	else{
		for (var i=0;i<nowRes.length;i++){
			idlist[i] = nowRes[i].id;
		}
		//var idlist = $.toJSON(idlist);
		var da = {
			"id":idlist,
		};
		$.ajax({
			type : "GET",
			url : "http://localhost:8080/sendPress/deleteNewspapers",
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
function delconfirm() { 
	 var msg = "您真的确定要删除吗？\n\n请确认！"; 
	 if (confirm(msg)==true){ 
	  return true; 
	 }else{ 
	  return false; 
	 } 
}

function formatDateTime(inputTime) {    
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
    return y + '-' + m + '-' + d+' '+h+':'+minute+':'+second;  
};  
