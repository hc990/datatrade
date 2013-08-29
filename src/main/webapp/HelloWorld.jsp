<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
    <title>HelloWorld</title>
	</head>

	<body>
	
	  <!-- The property struts tag reads the value off the value stack.  In our case
	       the Struts 2 framework has automatically made the Java bean properties of
	       our action available to the result.  We just need to match the nomenclature
	       of our value paramater below with the Java Beans attribute name of our 
	       HelloWorld action.  
	  -->
	  <hr>
	    <h3>Custom Greeting Page</h3>      
        <h4><s:property value="customGreeting"/></h4>
      <hr>
	</body>
	
</html>
