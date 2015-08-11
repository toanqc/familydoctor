<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="content">
	<div class="inner-content">

		<div class="margin-left inner-left-content dashboard-content">
			<span class="title">Doctor List</span>
			<table class="data-table full-width">
				<thead>
					<tr>
						<th>Name</th>
						<th>Specialization</th>
						<th>Phone</th>
						<th>Email</th>
					</tr>
				</thead>			

				<c:forEach items="${doctors}" var="doctor">
					<tr>
						<td>${doctor.firstName} ${doctor.lastName}</td>
						<td>${doctor.specialization}</td>
						<td>${doctor.phone}</td>
						<td>${doctor.user.email}</td>
					</tr>
				</c:forEach>
			</table>
			
			<spring:url value="/admin/add-doctor" var="url" htmlEscape="true"/>
			<button type="button" onclick="window.location='${url}'">Add Doctor</button>	
		</div>
		
	</div>
</div>