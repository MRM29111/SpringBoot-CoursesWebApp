<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
        <li><a href="/">Home<span class="sr-only">(current)</span></a></li>
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
			<sec:authorize access="!isAuthenticated()">
				<li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Action <span class="caret"></span></a>
		          <ul class="dropdown-menu" role="menu">
		            <li><a href="/login">Login</a></li>
		            <li class="divider"></li>
		            <li><a href="/register">Register</a></li>
		          </ul>
		        </li>		
		     </sec:authorize>
		     <sec:authorize access="isAuthenticated()">
				<li><a href="/user/profile">User profile</a></li>
				
				<c:url var="logoutUrl" value="/logout" />
				<form:form action="${logoutUrl}" method="post">
					<li><input class="btn btn-danger" type="submit" value="Logout" /></li>
				</form:form>
			</sec:authorize>
      </ul>
    </div>
  </div>
</nav>
