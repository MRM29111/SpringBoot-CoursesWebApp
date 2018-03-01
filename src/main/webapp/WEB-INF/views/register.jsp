<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">
					<h3>Register</h3>
					<form:form action="${pageContext.request.contextPath}/register" modelAttribute="userModel">
						<div class="form-group">
							<form:errors path="*" cssClass="error"/>
						</div>
						<div class="form-group">
  							<label class="control-label">E-mail address</label>
							<form:input path="email" cssClass="form-control" title="E-mail address" />
							
							<label class="control-label">Password</label>
							<form:password path="password" cssClass="form-control" title="Password" />
							
							<label class="control-label">Password Confirmation</label>
							<form:password path="passwordConfirm" cssClass="form-control" title="Password Confirmation" />
						</div>
						<div class="form-group">
							<span class="input-group-btn">
								<input type="submit" class="btn btn-primary" value="Register">
							</span>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>