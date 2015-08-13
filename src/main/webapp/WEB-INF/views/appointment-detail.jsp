<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="content">
	<div class="margin-top-middle margin-left gray-text font-size-small">
		<a class="text-underline" href="<spring:url value="/patients/home" />"><spring:message
				code="label.home" /></a> >
		<spring:message code="label.appointment.detail" />
	</div>

	<div>
		<div class="margin-left inner-left-content margin-top-middle title">
			<spring:message code="label.appointment.detail" />
			<div class="hr-separator"></div>
		</div>
		<div class="margin-left inner-right-content margin-top-middle title">
			<spring:message code="label.invoice.detail" />
			<div class="hr-separator"></div>
		</div>
	</div>

	<div>
		<div class="margin-left inner-left-content margin-top-middle">
			<table class="data-table">
				<tr>
					<td class="text-align-right text-bold"><label><spring:message
								code="label.specialty" />:</label></td>
					<td class="text-first-capital">${fn:toLowerCase(appointment.doctor.specialization)}</td>
				</tr>
				<tr>
					<td class="text-align-right text-bold"><label for="doctor"><spring:message
								code="label.doctor" />:</label></td>
					<td>${appointment.doctor.firstName}&nbsp;${appointment.doctor.lastName}</td>
				</tr>
				<tr>
					<td class="text-align-right text-bold"><label for="date"><spring:message
								code="label.date" />:</label></td>
					<td><fmt:formatDate dateStyle="long"
							value="${appointment.date}" /></td>
				</tr>
				<tr>
					<td class="text-align-right text-bold"><label><spring:message
								code="label.appointment.status" />:</label></td>
					<td class="text-first-capital">${fn:toLowerCase(appointment.status)}</td>
				</tr>
				<tr>
					<td class="text-align-right text-bold"><label
						for="description"><spring:message code="label.patient" />:</label></td>
					<td>${appointment.patient.firstName} &nbsp; ${appointment.patient.lastName}</td>
				</tr>				
				<tr>
					<td class="text-align-right text-bold"><label
						for="description"><spring:message code="label.description" />:</label></td>
					<td>${appointment.description}</td>
				</tr>
			</table>
		</div>

		<div class="margin-left inner-right-content margin-top-middle">
			<spring:url value="/appointments/${appointment.appointmentId}/pay"
				var="appointmentUrl" />
			<form:form modelAttribute="appointment" action="${appointmentUrl}"
				method="post">
				<table class="data-table">
					<tr>
						<td class="text-align-right text-bold"><label><spring:message
									code="label.invoice.date.created" />:</label></td>
						<td><fmt:formatDate dateStyle="long"
								value="${appointment.invoice.dateCreated}" /></td>
					</tr>
					<tr>
						<td class="text-align-right text-bold"><label><spring:message
									code="label.invoice.amount" />:</label></td>
						<td><fmt:formatNumber value="${appointment.invoice.amount}"
								type="currency" /></td>

					</tr>
					<tr>
						<td class="text-align-right text-bold"><label><spring:message
									code="label.invoice.status" />:</label></td>
						<td class="text-first-capital">${fn:toLowerCase(appointment.invoice.status)}</td>

					</tr>
					<tr>
						<td class="text-align-right text-bold"><label><spring:message
									code="label.invoice.ccard" />:</label></td>
						<td><c:if
								test="${empty appointment.invoice.ccardLast4Digits}">
								<spring:message code="label.invoice.not.available" />
							</c:if> <c:if test="${not empty appointment.invoice.ccardLast4Digits}">
							****-${appointment.invoice.ccardLast4Digits}
						</c:if></td>
					</tr>
					<tr>
						<td class="text-align-right text-bold"><label><spring:message
									code="label.invoice.date.paid" />:</label></td>
						<td><c:if test="${empty appointment.invoice.datePaid}">
								<spring:message code="label.invoice.not.pay.yet" />
							</c:if> ${appointment.invoice.datePaid}</td>
					</tr>
					<tr>
						<td></td>
						<c:set var="disabled" value="disabled" />
						<c:if test="${appointment.invoice.status == 'PENDING'}">
							<c:set var="disabled" value="" />
						</c:if>
						<td class="text-align-center"><button type="button"
								${disabled}>
								<spring:message code="button.pay" />
							</button></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</div>