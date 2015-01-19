<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" href="resources/css/bootstrap.css" type="text/css">
      
    </head>
    <body>
        <div class="page_header">
              <tiles:insert attribute="header" ignore="true" />
        </div>
     	<div class="nav-bar">
        	<tiles:insert attribute="navbar"  ignore="true"/>
        </div>
        <div class="main_content">
             <tiles:insert attribute="body" />
        </div> 
     </body>
</html>
