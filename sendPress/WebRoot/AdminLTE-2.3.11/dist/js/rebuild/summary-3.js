/**
 * Created by zewei on 2017/6/22.
 */
//印数总计

var itemsResponse = [
" printNumObject.printName",
" printNumObject.totalPrintNum",
];
var itemsResponseName = [
"印点名",
"需要打印总数",
];

urlSendPress = {
"urlSearch" : " http://localhost:8080/sendPress/totalPrintNumAction",
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
	var da ={};
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
					tdlist[j].innerHTML = '';
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
	initResult();
}


function initResult(){
	var select = $("#search-res-head");
	for(var i=0;i<itemResponseNumber;i++){
		var th = '<th>'+itemsResponseName[i]+'</th>';
		select.append(th);
	}
	
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
