<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
    <title>Name Collector</title>
	</head>
	<body>
	    <hr>
		<h4>Enter your name so that we can customize a greeting just for you!</h4> 	
	   	<s:form action="HelloWorld">
    	<s:textfield name="username"  label="Username"/>
        <s:textfield name="password"  label="Password"/>
    	<s:submit/>
		</s:form>
		<s:form action="upload" method="post" enctype="multipart/form-data">
    
		<s:file name="pic"  label="Picture"/>
    	<s:submit/>
		</s:form>
	    <hr>	  
	</body>
</html>
  