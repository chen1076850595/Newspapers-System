<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
  <body>
    <form action="selectPrintPointByCondition" method=get>
        id  <input type="text" name="printPoint.id"> <br>
   		name<input type="text" name="printPoint.printName"><br>
    	address<input type="text" name="printPoint.printAddress"><br>
    	username<input type="text" name="staff.username"><br>
    	tel<input type="text" name="staff.tel"><br>
    
    	
    	
    	<input type="submit" name="查询">
    	
    </form>  
   <form action="addPrintPoint" method=post>
   		name<input type="text" name="printPoint.printName"><br>
    	address<input type="text" name="printPoint.printAddress"><br>
    	username<input type="text" name="staff.username"><br>
    
    	
    	
    	<input type="submit" name="增加">
    	
    </form> 
    <br>
    更新数据
    <form action="updatePrintPoint" method=post>
    id<input type="text" name="printPoint.id"><br>
   		name<input type="text" name="printPoint.printName"><br>
    	address<input type="text" name="printPoint.printAddress"><br>
    	username<input type="text" name="staff.username"><br>
    
    	
    	
    	<input type="submit" name="增加">
    	
    </form> 

  </body>
</html>
