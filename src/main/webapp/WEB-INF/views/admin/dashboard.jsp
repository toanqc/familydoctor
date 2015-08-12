<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="content">
	<div class="inner-content">

		<div class="margin-left admin-dashboard-content">
			<span class="title"><spring:message code="label.doctor.list" /></span>
			<table class="data-table full-width admin-doctor-list">
				<thead>
					<tr>
						<th><spring:message code="table.header.name" /></th>
						<th><spring:message code="label.specialization" /></th>
						<th><spring:message code="label.phone" /></th>
						<th><spring:message code="label.user.email" /></th>
						<th>&nbsp;</th>
					</tr>
				</thead>			

				<c:forEach items="${doctors}" var="doctor">
					<tr id="row-${doctor.doctorId}">
						<td>${doctor.firstName} ${doctor.lastName}</td>
						<td>${doctor.specialization}</td>
						<td>${doctor.phone}</td>
						<td>${doctor.user.email}</td>
						<td>
							<spring:url value="/admin/doctor/${doctor.doctorId}" var="url" htmlEscape="true"/>
							<a href="${url}"><spring:message code="button.label.edit" /></a> | 
							
							<a style="cursor:pointer" onclick="deleteAccount(${doctor.doctorId})"><spring:message code="button.label.delete" /></a>
						</td>
					</tr>
				</c:forEach>
			</table>
			
			<spring:url value="/admin/add-doctor" var="url" htmlEscape="true"/>
			<button type="button" onclick="window.location='${url}'"><spring:message code="button.label.add.doctor" /></button>	
		</div>
		
	</div>
</div>

<script>
$(document).ready(function(){
	deleteAccount = function(id){
		$.ajax({
			url: "/FamilyDoctor/admin/delete-doctor/",
			type: "POST",
			dataType: "json",
			data: {id : id},
			success: function(response){
				$("#row-"+id).fadeOut();
			}, 
			error : function(response){
				alert("Error while request: " + response);
			}
		});
	}
});
</script>