<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
  <body>
    <form action="selectSendPointByCondition" method=post>
        id  <input type="text" name="sendPoint.id"> <br>
   		name<input type="text" name="sendPoint.printName"><br>
    	address<input type="text" name="sendPoint.printAddress"><br>
    	type<input type="text" name="sendPoint.type"><br>
    	needNum<input type="text" name="sendPoint.needNum"><br>
    	username<input type="text" name="staff.username"><br>
    	tel<input type="text" name="staff.tel"><br>
    	
    
    	
    	
    	<input type="submit" name="查询">
    	
    </form>  
   <form action="addSendPoint" method=post>
   		name<input type="text" name="printPoint.printName"><br>
    	address<input type="text" name="printPoint.printAddress"><br>
    	username<input type="text" name="staff.username"><br>
    
    	
    	
    	<input type="submit" name="增加">
    	
    </form> 
      <form action="addSendPoint" method=post>
   		name<input type="text" name="printPoint.printName"><br>
    	address<input type="text" name="printPoint.printAddress"><br>
    	username<input type="text" name="staff.username"><br>
    
    	
    	
    	<input type="submit" name="增加">
    	
    </form> 
    
    
      <form action="testAction" method=post>
   		id<input type="text" name="pointRelationObject.id"><br>
   		id<input type="text" name="pointRelationObject.printPointName"><br>
   		id<input type="text" name="pointRelationObject.sendPointName"><br>
    	
   
    	
    	<input type="submit" name="增加relation" value="增加test">
    	
    </form> 
  <form action="selectRoadByCondition" method=post>
   		id<input type="text" name="road.id"><br>
   		id<input type="text" name="road.startAddr"><br>
   		id<input type="text" name="bus.busName"><br>
    	
   
    	
    	<input type="submit" name="增加relation" value="chanxunroad">
    	
    </form> 
    <form action="selectGroupRoadByCondition" method=post>
   		id<input type="text" name="groupRoad.id"><br>
   		出发地<input type="text" name="groupRoad.startPoint"><br>
 
    	
   
    	
    	<input type="submit" name="增加relation" value="组合路线">
    	
    </form> 
  </body>
</html>
