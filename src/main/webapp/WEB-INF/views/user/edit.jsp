<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="panel panel-default">
	<div class="panel-heading">Edit profile info</div>
	<div class="panel-body">
		<form:form action="/user/${editUserModel.id}/edit?${_csrf.parameterName}=${_csrf.token}" method="POST"
				modelAttribute="editUserModel" enctype="multipart/form-data">
			<div class="form-group">
				<form:errors path="*" cssClass="error" />
			</div>
			
			<div class="form-group">
				<form:hidden path="id"/>
				<form:hidden path="password"/>
				
				<label class="control-label">E-mail address</label>
				<form:input path="email" cssClass="form-control" title="E-mail address" disabled="true"/>

				<label class="control-label">Full Name</label>
				<form:input path="fullName" cssClass="form-control" title="Full Name" />

				<label class="control-label">Age</label>
				<form:input path="age" cssClass="form-control" title="Age" />
				
				<label class="control-label">Country</label>
				<form:select path="country" cssClass="form-control" title="Country"> 
					<c:forEach items="${countries}" var="country">
						<form:option value="${country}">${country.name}, ${country.shortName}</form:option>
					</c:forEach>
				</form:select>
				
				<label class="control-label">Profile Image</label>				
				<form:input path="profileImage" type="file" cssClass="form-control"/>				
			</div>
			<div class="form-group">
				<span class="input-group-btn"> 
				<input type="submit" class="btn btn-primary" value="Save">
				</span>
			</div>
		</form:form>
		<%-- <input type="file" name="profileImage" class="form-control"> --%>
	</div>
</div>