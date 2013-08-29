<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
    <title>Struts 2 in Action: Menu</title>
	</head>

	<body>
	
	  <!-- The property struts tag reads the value off the value stack.  In our case
	       the Struts 2 framework has automatically made the Java bean properties of
	       our action available to the result.  We just need to match the nomenclature
	       of our value paramater below with the Java Beans attribute name of our 
	       HelloWorld action.  
	  -->      
  <hr>   
  <ul>
     <li><a href="<s:url action='chapterTwo/Name'/>">HelloWorld</a></li>	
 	</ul>
  <hr>   	
	</body>
	
</html>
