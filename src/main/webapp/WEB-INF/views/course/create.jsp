<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">
					<h3>Add Course</h3>
					<form:form action="/course/${userId}/create" modelAttribute="courseModel" enctype="multipart/form-data" method="POST">
						<div class="form-group">
							<form:errors path="*" cssClass="error"/>
						</div>
						<div class="form-group">
  							<form:hidden path="user"/>
  							<label class="control-label">Title</label>
							<form:input path="title" cssClass="form-control" title="Title" />
							
							<label class="control-label">Description</label>
							<form:input path="description" cssClass="form-control" title="Description" />
							
							<label class="control-label">Price(9.99 - 299.00)</label>
							<form:input path="price" cssClass="form-control" title="Price" />
							
							<label class="control-label">Choose the category:</label>
							<form:select path="category" cssClass="form-control" title="Country"> 
								<c:forEach items="${categories}" var="category">
									<form:option value="${category}">${category.name}</form:option>
								</c:forEach>
							</form:select>
							
							<label class="control-label">Course Image</label>
							<input type="file" name="courseFileImage" class="form-control">
						</div>
						<div class="form-group">
							<span class="input-group-btn">
								<input type="submit" class="btn btn-primary" value="Add">
							</span>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>