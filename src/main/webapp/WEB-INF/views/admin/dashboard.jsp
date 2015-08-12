<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="content">
	<div class="inner-content">

		<div class="margin-left admin-dashboard-content">
			<span class="title">Doctor List</span>
			<table class="data-table full-width admin-doctor-list">
				<thead>
					<tr>
						<th>Name</th>
						<th>Specialization</th>
						<th>Phone</th>
						<th>Email</th>
						<th>&nbsp;</th>
					</tr>
				</thead>			

				<c:forEach items="${doctors}" var="doctor">
					<tr>
						<td>${doctor.firstName} ${doctor.lastName}</td>
						<td>${doctor.specialization}</td>
						<td>${doctor.phone}</td>
						<td>${doctor.user.email}</td>
						<td>
							<spring:url value="/admin/doctor/${doctor.doctorId}" var="url" htmlEscape="true"/>
							<a href="${url}">Edit</a> | 
							
							<a href="" onclick="deleteAccount(${doctor.doctorId})">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			
			<spring:url value="/admin/add-doctor" var="url" htmlEscape="true"/>
			<button type="button" onclick="window.location='${url}'">Add Doctor</button>	
		</div>
		
	</div>
</div>