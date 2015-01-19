<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@page import="org.json.JSONObject"%> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="resources/css/Login_page_style.css" type="text/css">
		<link rel="stylesheet" href="resources/css/bootstrap.css" type="text/css">
    </head>
    <body>
  <h1 id="No-fav"></h1>
  <c:if test="${not empty FavHotelList}">
       
  <c:forEach items="${FavHotelList}" var="hotel"> 
 
  <div class="col-xs-10 col-sm-5 col-offset-md-1 col-md-4 content-container">
    
    <div class="thumbnail" style="postion:relative;">
 
      <img src=<bean:write name="hotel" property="imgURL"/> alt="..."><br>
       <a href="#" id=<bean:write name="hotel" property="id"/> class="btn btn-primary fav"  role="button" ><bean:write name="hotel" property="favValue"/></a><br>
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
</c:if>
 <c:if test="${empty FavHotelList}">
 	<p>No Favourites Added</p>
 </c:if>
    </body>
    <script src="resources/Js/jquery.js"></script>
    <script src="resources/Js/ManageFavourite.js"></script>
    <script>
    
    </script>
</html>
