<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="content">
	<div class="inner-content">
		<div class="margin-left inner-left-content dashboard-content">
			<spring:url value="/admin/add-doctor" var="url" htmlEscape="true"/>
			<button type="button" onclick="window.location='${url}'">Add Doctor</button>
			
			<p>Doctor List</p>
		</div>
	</div>
</div>