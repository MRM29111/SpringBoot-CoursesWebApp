<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="panel panel-default">
	<div class="panel-heading">Profile</div>
	<div class="panel-body">
		<div class="row">
			<div class="col-md-3">
				<img class="circle" alt="Logo image" src="data:image/png;base64, ${profileImage}" width="200px">
			</div>

			<div class="col-md-4">
				<h3>Profile Info:</h3>
				<ul class="list-group">
				  <li class="list-group-item">Full Name: ${userModel.fullName }</li>
				  <li class="list-group-item">Age: ${userModel.age }</li>
				  <li class="list-group-item">Email: ${userModel.email}</li>
				  <li class="list-group-item">Country: ${userModel.country.name}, ${userModel.country.shortName}</li>
				  <li class="list-group-item">Created at: ${userModel.createdAt }</li>
				  <li class="list-group-item">Edit profile data: <a class="btn btn-warning btn-xs" href="/user/${userId}/profile/edit">Edit user info</a> </li>
				  <%-- <li class="list-group-item">Change password: <a class="btn btn-danger btn-xs" href="/user/${userId}/profile/change-password">Change password(NO)</a> </li> --%>
				
				</ul>	
			</div>
			
			<div class="col-md-4">
				<h3>Courses control panel:</h3>
				<a class="btn btn-success" href="/user/${userId}/course/create">Create course</a>
				<a class="btn btn-info" href="/user/${userId}/courses">List of my courses</a>
			</div>
			
		</div>	
	</div>
</div>