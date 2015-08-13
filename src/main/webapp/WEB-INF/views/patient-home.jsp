<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="content">
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
						<td width="20%" class="text-first-capital">${appointment.doctor.firstName} ${appointment.doctor.lastName} &#149; ${fn:toLowerCase(appointment.doctor.specialization)}</td>
						<td width="25%">${appointment.description}</td>
						<td width="10%" class="text-align-center">${appointment.time}</td>
						<td width="10%" class="text-align-center">Room
							${appointment.room}</td>
						<td width="10%" class="text-align-center text-first-capital">${fn:toLowerCase(appointment.status)}</td>
						<td width="10%" class="text-align-center"><a
							href="<spring:url value="/appointments/${appointment.appointmentId}/reschedule" />"><spring:message
									code="link.reschedule" /></a></td>
						<td width="10%" class="text-align-center"><a
							href="<spring:url value="/appointments/${appointment.appointmentId}/detail" />"
							id="cancel"><spring:message code="link.detail" /></a></td>
						<td width="10%" class="text-align-center"><spring:message
								code="label.are.you.sure" var="confirm" /> <a
							onclick="return confirm('${confirm}')"
							href="<spring:url value="/appointments/${appointment.appointmentId}/cancel" />"
							id="cancel"><spring:message code="link.cancel" /></a></td>
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
						<td width="20%" class="text-first-capital">${appointment.doctor.firstName} ${appointment.doctor.lastName} &#149; ${fn:toLowerCase(appointment.doctor.specialization)}</td>
						<td width="25%">${appointment.description}</td>
						<td width="10%" class="text-align-center">${appointment.time}</td>
						<td width="10%" class="text-align-center">Room
							${appointment.room}</td>
						<td width="10%" class="text-align-center red">Overdue</td>
						<td width="10%" class="text-align-center"><spring:message
								code="label.are.you.sure" var="confirm" /> <a
							onclick="return confirm('${confirm}')"
							href="<spring:url value="/appointments/${appointment.appointmentId}/cancel" />"
							id="cancel"><spring:message code="link.cancel" /></a></td>

					</tr>
				</c:forEach>
			</table>
		</div>
	</c:forEach>
	<div class="margin-top-large"></div>
</div>