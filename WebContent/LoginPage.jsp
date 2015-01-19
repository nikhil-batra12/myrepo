<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<tiles:insert page="/baseLayout.jsp" flush="true">
    <tiles:put name="header" value="/header.jsp" />
    <tiles:put name="body" value="/LoginTile.jsp" />
</tiles:insert>