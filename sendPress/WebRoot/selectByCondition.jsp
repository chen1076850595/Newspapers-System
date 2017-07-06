<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
  <body>
    <form action="selectByCondition" method=post>
        id  <input type="text" name="newspaper.id"> <br>
   		name<input type="text" name="newspaper.name"><br>
    	type<input type="text" name="newspaper.type"><br>
    	page_num<input type="text" name="newspaper.pageNum"><br>
    	newspaper.pageLength<input type="text" name="newspaper.pageLength"><br>
    	newspaper.pageWidth<input type="text" name="newspaper.pageWidth"><br>
    	newspaper.theme<input type="text" name="newspaper.theme"><br>
    	newspaper.date<input type="text" name="newspaper.date"><br>
    	
    	
    	<input type="submit" name="查询">
    	
    </form>  
    根据姓名查询：
      <form action="selectByName">
   		name<input type="text" name="newspaper.name"><br>
    	
    	
    	<input type="submit" name="查询">
    	
    </form>  

  </body>
</html>
