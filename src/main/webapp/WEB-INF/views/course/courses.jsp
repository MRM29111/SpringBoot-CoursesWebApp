<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<div class="container">
	<h1>Courses List</h1>
	<display:table id="coursesList" list="${coursesList}" pagesize="15" requestURI="/course/courses">

		<display:column property="id" title="Id" sortable="true" />
		<display:column title="Course image" media="html" style="width:160px;">
			<img alt="" src="http://via.placeholder.com/150x150">
		</display:column>
		<display:column property="title" title="Title" sortable="true" paramId="id" paramProperty="id" url="/course"/>
		<display:column property="price" title="Price" sortable="false" />
		<display:column property="description" title="Description" sortable="false" />
		<display:column property="user.fullName" title="Teacher" sortable="false" />
	
	</display:table>
</div>