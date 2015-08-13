<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="content">

	<div class="margin-top-middle text-align-center title">
		<spring:message code="label.welcome" />
		<spring:message code="label.doctor.short" />
		${doctor.firstName} ${doctor.lastName}
	</div>

	<div class="margin-top-middle margin-left title">
		<spring:message code="label.upcoming.appointments" />
	</div>

	<c:forEach items="${upcomingAppointment}" var="appointments">
		<div
			class="margin-top-middle margin-left title font-size-middle appointments">
			<fmt:formatDate pattern="E, MMM dd" value="${appointments.key}" />
			<table class="data-table full-width">
				<c:forEach items="${appointments.value}" var="appointment">
					<tr class="gray-text font-size-small">
						<td width="12%">${appointment.patient.firstName}&nbsp;${appointment.patient.lastName}</td>
						<td width="25%"> ${appointment.description}</td>
						<td width="10%" class="text-align-center">${appointment.time}</td>
						<td width="10%" class="text-align-center">Room
							${appointment.room}</td>
						<td width="10%" class="text-align-center text-first-capital">${fn:toLowerCase(appointment.status)}</td>
						<td width="10%"><a
							href="<spring:url value="/appointments/${appointment.appointmentId}/accept" />"><spring:message
									code="link.accept" /></a></td>
						<td width="10%" class="text-align-center"><a
							href="<spring:url value="/appointments/${appointment.appointmentId}/detail" />"
							id="cancel"><spring:message code="link.detail" /></a></td>
						<td width="10%"><spring:message
								code="label.are.you.sure.reject" var="reject" /> <a
							onclick="return confirm('${reject}')"
							href="<spring:url value="/appointments/${appointment.appointmentId}/reject" />"
							id="cancel"><spring:message code="link.reject" /></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:forEach>

	<c:if test="${not empty overdueAppointment}">
		<div class="margin-top-middle margin-left title-orange">
			<spring:message code="label.overdue.appointments" />
		</div>
	</c:if>

	<c:forEach items="${overdueAppointment}" var="appointments">
		<div
			class="margin-top-middle margin-left green font-size-middle appointments">
			<fmt:formatDate pattern="E, MMM dd" value="${appointments.key}" />
			<table class="data-table full-width">
				<c:forEach items="${appointments.value}" var="appointment">
					<tr class="gray-text font-size-small">
						<td width="12%">${appointment.patient.firstName}&nbsp;${appointment.patient.lastName}</td>
						<td width="25%">${appointment.description}</td>
						<td width="10%" class="text-align-center">${appointment.time}</td>
						<td width="10%" class="text-align-center">Room
							${appointment.room}</td>
						<td width="10%" class="text-align-center red">Overdue</td>
						<td width="10%"><a
							href="<spring:url value="/appointments/${appointment.appointmentId}/cancel" />"><spring:message
									code="link.cancel" /></a></td>
						<td width="15%"></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:forEach>

	<div class="margin-top-large"></div>
</div>