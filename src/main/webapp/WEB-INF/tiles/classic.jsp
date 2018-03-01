<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1">
<title><tiles:getAsString name="title"></tiles:getAsString></title>
<jsp:include page="/WEB-INF/include/style-include.jsp" />
</head>

<body>
	<tiles:insertAttribute name="header" />

	<div class="container">
		<tiles:insertAttribute name="body" />
	</div>
	<tiles:insertAttribute name="footer" />
	<jsp:include page="/WEB-INF/include/js-include.jsp" />
</body>
</html>