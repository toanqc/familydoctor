<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="content">
	<div class="margin-top-middle margin-left title">
		<spring:message code="label.upcoming.appointments" />
	</div>

	<c:forEach items="${appointmentMap}" var="appointments">
		<div
			class="margin-top-middle margin-left title font-size-middle appointments">
			<fmt:formatDate pattern="E, MMM dd" value="${appointments.key}" />
			<table class="data-table full-width">
				<c:forEach items="${appointments.value}" var="appointment">
					<tr class="gray-text font-size-small">
						<td width="30%">${appointment.description}</td>
						<td width="20%">${appointment.time}</td>
						<td width="20%">${appointment.room}</td>
						<td width="15%"><a
							href="<spring:url value="/appointments/${appointment.appointmentId}/reschedule" />">Reschedule</a></td>
						<td width="15%"><a href="">Cancel</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:forEach>

	<div
		class="margin-top-middle margin-left gray-text font-size-middle text-underline">
		<a href="<spring:url value="/appointments/register" />"><spring:message
				code="label.schedule.an.appointent" /></a>
	</div>
	<div class="margin-top-large"></div>
</div>