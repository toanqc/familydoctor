<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="content">
	<div class="inner-content">

		<div class="title margin-left margin-top-middle">
			<spring:message code="label.doctor.list" />
		</div>

		<div class="margin-left dashboard-content">
			<table class="data-table full-width">
				<thead>
					<tr>
						<th><spring:message code="label.full.name" /></th>
						<th><spring:message code="label.specialization" /></th>
						<th><spring:message code="label.phone" /></th>
						<th><spring:message code="label.user.email" /></th>
					</tr>
				</thead>

				<c:forEach items="${doctors}" var="doctor">
					<tr class="text-align-center">
						<td>${doctor.firstName}&nbsp;${doctor.lastName}</td>
						<td class="text-first-capital">${fn:toLowerCase(doctor.specialization)}</td>
						<td>${doctor.phone}</td>
						<td>${doctor.user.email}</td>
					</tr>
				</c:forEach>
			</table>

			<div class="margin-top-middle">
				<spring:url value="/admin/add-doctor" var="url" htmlEscape="true" />
				<a href="${url}" class="font-size-middle gray-text"><spring:message
						code="link.add.doctor" /></a>
			</div>
		</div>

	</div>
</div>