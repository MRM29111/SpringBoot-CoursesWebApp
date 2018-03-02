<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="panel panel-default">
	<div class="panel-heading text-center">PROFILE</div>
	<div class="panel-body">
		<div class="row">
			<div class="col-md-3 text-center">
				<ul class="list-group">
					<li class="list-group-item">
						<img class="circle" alt="Logo image" src="data:image/png;base64, ${profileImage}" width="230px">
					</li>
				</ul>
			</div>

			<div class="col-md-4">
				<ul class="list-group">
				  <li class="list-group-item">Full Name: ${userModel.fullName }</li>
				  <li class="list-group-item">Age: ${userModel.age }</li>
				  <li class="list-group-item">Email: ${userModel.email}</li>
				  <li class="list-group-item">Country: ${userModel.country.name}, ${userModel.country.shortName}</li>
				  <li class="list-group-item">Role: ${userModel.role.role }</li>
				  <li class="list-group-item">Created at: ${userModel.createdAt }</li>
				  <li class="list-group-item">Edit profile: 
					<a class="btn btn-success btn-xs" href="/user/${userModel.id}/edit">Edit info</a>
<%-- 				  	<c:choose>
				  		<c:when test="${userModel.isEdited == false}">
				  			<a class="btn btn-success btn-xs" href="/user/${userModel.id}/edit">Edit info</a>
				  		</c:when>
				  		<c:otherwise>
				  			<a class="btn btn-warning btn-xs disabled" href="/user/${userModel.id}/edit">Edit info</a>
				  		</c:otherwise>
				  	</c:choose>  --%>
				  </li>
				  <%-- <li class="list-group-item">Change password: <a class="btn btn-danger btn-xs" href="/user/${userId}/profile/change-password">Change password(NO)</a> </li> --%>
				
				</ul>	
			</div>
			<sec:authorize access="hasRole('ROLE_TEACHER')">
				<div class="col-md-4 text-center">
					<ul class="list-group">
						<li class="list-group-item">
							<h3>Courses control panel:</h3>
							<a class="btn btn-success" href="/course/${userId}/create">Create course</a>
							<%-- <a class="btn btn-info" href="/course/${userId}/courses">List of my courses</a> --%>
						</li>
					</ul>
				</div>
			</sec:authorize>
		</div>	
		<%-- <sec:authorize access="hasRole('ROLE_TEACHER')"> --%>
		<c:choose>
			<c:when test="${userCourses ne null}">
				<div class="row">
					<h3 class="text-center">Teacher courses</h3>
					<table class="table table-striped table-hover table-bordered">
						<thead>
							<tr class="info">
								<th>ID</th>
								<th style="width: 300px">IMAGE</th>
								<th>TITLE</th>
								<th>PRICE</th>
								<th style="width: 350px">DESCRIPTION</th>
								<th>CATEGORY</th>
								<th>CONTROL</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${userCourses}" var="userCourse">
								<tr>
									<td>${userCourse.id}</td>
									<td><img src="data:image/png;base64, ${userCourse.courseImage}" width="200px"/></td>
									<td>${userCourse.title}</td>
									<td>${userCourse.price}</td>
									<td>${userCourse.description}</td>
									<td>${userCourse.category.name}</td>
									<td>
										<a class="btn btn-primary" href="#">Edit</a> | <a class="btn btn-danger" href="#">Delete</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>		
			</c:when>
			
			<c:otherwise>
				<div class="row">
					<hr>
					<h3 class="text-center">You do not have any courses yet</h3>
				</div>
			</c:otherwise>
		</c:choose>
		<%-- </sec:authorize> --%>
	</div>
</div>