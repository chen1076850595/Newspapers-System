/**
 * Created by zewei on 2017/6/22.
 */

var account;
var password;
var name;
var id;
function setIframeHeight(iframeId){
    var cwin = document.getElementById(iframeId);
    if (document.getElementById){
        if (cwin && !window.opera){
            if (cwin.contentDocument && cwin.contentDocument.body.offsetHeight){
                cwin.height = cwin.contentDocument.body.offsetHeight + 20; //FF NS
            }
            else if(cwin.Document && cwin.Document.body.scrollHeight){
                cwin.height = cwin.Document.body.scrollHeight + 10;//IE
            }
        }else{
            if(cwin.contentWindow.document && cwin.contentWindow.document.body.scrollHeight)
                cwin.height = cwin.contentWindow.document.body.scrollHeight;//Opera
        }
    }
};

function navigate(element,fathername){
    var name = element.innerText;
    var herf = element.getAttribute('href');
    var section = document.getElementById("content-wrapper");
    section.getElementsByTagName("h1")[0].innerHTML = fathername+'<small><i class="fa fa-chevron-right"></i>'+name+'</small>';
}

function initstaff() {
	sHref = window.location.href;
	if(!sHref.split("?")[1]){
		window.location.href="http://localhost:8080/sendPress/AdminLTE-2.3.11/pages/rebuild/login.html";
	}
	function GetArgsFromHref(sHref)
	{
		var data = [];
		one = sHref.split("?")[1];
		two = one.split("&");
		for(x in two){
			data[x] = two[x].split("=")[1];
		}
		return data;
	}
	data = GetArgsFromHref(sHref);
	account = data[0];
	password = data[2];
	name = data[1];
	id = data[3];
	function staff(){
		document.getElementById("staffname").innerHTML = name;
		document.getElementById("staffaccount").innerHTML = account;
	}
	staff();
}

function logout(){
	$.ajax({
		type : "GET",
		url : "http://localhost:8080/sendPress/staffAction!logout",
		success : function() {
			window.location.href="http://localhost:8080/sendPress/AdminLTE-2.3.11/pages/rebuild/login.html";
		},
		error : function() {
			window.location.href="http://localhost:8080/sendPress/AdminLTE-2.3.11/pages/rebuild/login.html";
		}
	})
}