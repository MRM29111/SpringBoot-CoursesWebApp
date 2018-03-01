<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1">

<c:choose>
	<c:when test="${title == null}">
		<tiles:putAttribute name="title" value="App title" />
	</c:when>
	<c:otherwise>
		<tiles:putAttribute name="title" value="${title}" />
	</c:otherwise>
</c:choose>

<title><tiles:getAsString name="title"></tiles:getAsString></title>
<jsp:include page="/WEB-INF/include/style-include.jsp" />
</head>

<body>
	<tiles:insertAttribute name="header" />

	<div class="container">
		<tiles:insertAttribute name="body" />
	</div>
	<%-- <tiles:insertAttribute name="footer" /> --%>
	<jsp:include page="/WEB-INF/include/js-include.jsp" />
</body>
</html>