<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
  <body>
    <form action="addNewspaper">
   		name<input type="text" name="newspaper.name"><br>
    	type<input type="text" name="newspaper.type"><br>
    	page_num<input type="text" name="newspaper.pageNum"><br>
    	newspaper.pageLength<input type="text" name="newspaper.pageLength"><br>
    	newspaper.pageWidth<input type="text" name="newspaper.pageWidth"><br>
    	newspaper.theme<input type="text" name="newspaper.theme"><br>
    	newspaper.date<input type="text" name="newspaper.date"><br>
    	
    	<input type="submit" name="新增">
    	
    </form>  
    
    
<a href="add?printPoint.printName=1">add</a>

<br>
 ${staff }
    <form action="staffAction!add" method="post" >
    	账号:<input type="text" name = "staff.account">
    	密码:<input type="password" name = "staff.password">
    	用户名:<input type = "text" name = "staff.username">
    	<input type = "submit" value = "提交">
    </form>
    <form action="staffAction!select" method="post" >
    	ID:<input type="text" name = "staff.id">
    	<input type = "submit" value = "提交">
    </form>
    
    <form action="staffAction!update" method="post" >
    	id:<input type="text" name = "staff.id">
    	用户名:<input type = "text" name = "staff.username">
    	<input type = "submit" value = "提交">
    </form>   
    
    <a href = "staffAction!selectAll">查询所有员工信息</a>
    <form action="staffAction!multipleSelect" method = "post">
    	id:<input type = "text" name = "staff.id">
    	account:<input type = "text" name = "staff.account">
    	name:<input type = "text" name = "staff.username">
    	<input type = "submit" value = "提交">
    </form>   
	<a href = "staffAction!batchDel">删除多个员工</a>
  </body>
</html>
