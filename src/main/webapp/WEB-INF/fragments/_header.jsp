<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-inverse">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${pageContext.request.contextPath}/">Online Courses</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
      <ul class="nav navbar-nav">
        <li class="active"><a href="/">Home<span class="sr-only">(current)</span></a></li>
        <li><a href="/course/courses">Courses</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>

      <ul class="nav navbar-nav navbar-right">
		<c:choose>
			<c:when test="${cookie['user_id'].value == null}">
				<li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Action <span class="caret"></span></a>
		          <ul class="dropdown-menu" role="menu">
		            <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
		            <li class="divider"></li>
		            <li><a href="${pageContext.request.contextPath}/register">Register</a></li>
		          </ul>
		        </li>		
			</c:when>
			<c:otherwise>
				<li><a href="${pageContext.request.contextPath}/user/${cookie['user_id'].value}/profile">User profile</a></li>
				<li><a href="${pageContext.request.contextPath}/user/logout">Logout</a></li>
			</c:otherwise>
		</c:choose>
      </ul>
    </div>
  </div>
</nav>
