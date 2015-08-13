<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="content">
	<div class="default-height">

		<div class="title margin-left margin-top-middle">
			<spring:message code="label.doctor.list" />
		</div>

		<div class="margin-left admin-dashboard-content">
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
					<tr class="text-align-center" id="row-${doctor.doctorId}">
						<td>${doctor.firstName}&nbsp;${doctor.lastName}</td>
						<td class="text-first-capital">${fn:toLowerCase(doctor.specialization)}</td>
						<td>${doctor.phone}</td>
						<td>${doctor.user.email}</td>
						<td class="gray-text font-size-middle"><spring:url value="/admin/doctor/${doctor.doctorId}"
								var="url" htmlEscape="true" /> <a href="${url}"><spring:message
									code="button.label.edit" /></a></td>
					</tr>
				</c:forEach>
			</table>

			<div class="margin-top-middle">
				<spring:url value="/admin/add-doctor" var="url" htmlEscape="true" />
				<a href="${url}" class="font-size-middle gray-text"><spring:message
						code="link.add.doctor" /></a>
			</div>
		</div>
		<div class="margin-top-middle"></div>
	</div>
</div>