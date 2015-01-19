

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@page import="org.json.JSONObject"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="resources/css/Login_page_style.css" type="text/css">
		<link rel="stylesheet" href="resources/css/bootstrap.css" type="text/css">
    </head>
    <body>
  
        <h1>Login Success. Welcome ${firstName}</h1>
  
  <c:forEach items="${hotelList}" var="hotel"> 
 
  <div class="col-xs-10 col-sm-5 col-offset-md-1 col-md-4">
    
    <div class="thumbnail" style="postion:relative;">
 
      <img src=<bean:write name="hotel" property="imgURL"/> alt="..."><br>
       <a id=<bean:write name="hotel" property="id"/> class="btn btn-primary fav" ><bean:write name="hotel" property="favValue"/></a><br>
      <div class="caption">
        <h3><bean:write name="hotel" property="name"/></h3>
   		<p><span>Name:</span> <bean:write name="hotel" property="name"/><br>
   		   Capacity: <bean:write name="hotel" property="capacity"/><br>
   		   Rating: <bean:write name="hotel" property="rating"/><br>
   		   Cost per person: <bean:write name="hotel" property="cost"/><br>
   		   Address: <bean:write name="hotel" property="address"/><br>
   		   Contact No.: <bean:write name="hotel" property="contact"/><br>
       
      </div>
    </div>
  </div>

 </c:forEach>
 
    </body>
    <script src="resources/Js/jquery.js"></script>
    <script src="resources/Js/AddFavourite.js"></script>
    
</html>
