<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="content">
	<div class="margin-top-middle margin-left gray-text font-size-small">
		<a class="text-underline" href="<spring:url value="/patients/home" />"><spring:message
				code="label.home" /></a> >
		<spring:message code="label.reschedule.an.appointent" />
	</div>

	<div class="margin-left margin-top-middle title">
		<spring:message code="label.schedule.an.appointent" />
		<div class="hr-separator"></div>
	</div>

	<div class="margin-left-large margin-top-middle">
		<spring:url
			value="/appointments/${appointment.appointmentId}/reschedule"
			var="appointmentUrl" />
		<form:form modelAttribute="appointment" action="${appointmentUrl}"
			method="post">
			<table class="data-table">
				<tr>
					<td class="text-align-right"><label for="specialization"><spring:message
								code="label.specialty" /> *</label></td>
					<td colspan="3"><form:select path="doctor.specialization"
							cssClass="text-first-capital" disabled="true" id="specialization">
							<form:option value="${appointment.doctor.specialization}">
								${fn:toLowerCase(appointment.doctor.specialization)}
							</form:option>
						</form:select></td>
					<spring:bind path="*">
						<c:if test="${status.error}">
							<td class="red"><h3>Validation Result</h3>
						</c:if>
					</spring:bind>
				</tr>
				<tr>
					<td class="text-align-right"><label for="doctor"><spring:message
								code="label.doctor" /> *</label></td>
					<td colspan="3"><form:select id="doctor"
							path="doctor.doctorId" disabled="true">
							<form:option value="${appointment.doctor.doctorId}"
								label="${appointment.doctor.firstName} ${appointment.doctor.lastName}" />
						</form:select></td>
					<td rowspan="8" class="text-align-top"><form:errors path="*"
							cssClass="red" /></td>
				</tr>
				<tr>
					<td class="text-align-right"><label for="date"><spring:message
								code="label.date" /> *</label></td>
					<td colspan="3"><form:input path="date" id="date"
							maxlength="10" size="47" /></td>
				</tr>
				<tr>
					<td class="text-align-right"><label for="time"><spring:message
								code="label.time" /> *</label></td>
					<td><form:input path="time" id="time" maxlength="8" size="10" /></td>
				</tr>
				<tr>
					<td class="text-align-right"><label for="description"><spring:message
								code="label.description" /> *</label></td>
					<td colspan="3"><form:textarea path="description"
							id="description" maxlength="255" rows="10" cols="45" /></td>
				</tr>
				<tr>
					<td></td>
					<td colspan="3" class="text-align-center"><input type="submit"
						value="Submit" /> <input type="reset" value="Clear" /></td>
				</tr>
			</table>
		</form:form>
	</div>

</div>