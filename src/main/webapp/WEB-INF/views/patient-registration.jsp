<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="content">
	<div class="margin-left margin-top-middle title">
		<spring:message code="label.patient.registration" />
		<div class="hr-separator"></div>
	</div>

	<div class="margin-left-large margin-top-middle">
		<spring:url value="/patients" var="patientUrl" />
		<form:form modelAttribute="patient" action="${patientUrl}"
			method="post">
			<table class="data-table">
				<tr>
					<td class="text-align-right"><label for="firstName"><spring:message
								code="label.first.name" /> *</label></td>
					<td><form:input path="firstName" id="firstName" maxlength="10"
							size="14" /></td>
					<td class="text-align-right"><label for="lastName"><spring:message
								code="label.last.name" /> *</label></td>
					<td class="text-align-right">&nbsp;<form:input path="lastName" id="lastName"
							maxlength="10" size="14" /></td>
					<td class="red"><spring:bind path="*">
							<c:if test="${status.error}">
								<h2><spring:message code="label.validation.result" /></h2>
							</c:if>
						</spring:bind></td>
				</tr>
				<tr>
					<td class="text-align-right"><label for="dateOfBirth"><spring:message
								code="label.date.of.birth" /> *</label></td>
					<td colspan="3"><form:input path="dateOfBirth"
							id="dateOfBirth" maxlength="10" size="47" /></td>
					<td rowspan="8" class="text-align-top"><form:errors path="*"
							cssClass="red" /></td>
				</tr>
				<tr>
					<td class="text-align-right"><label for="ssn"><spring:message
								code="label.ssn" /> *</label></td>
					<td><form:input path="ssn" id="ssn" maxlength="4" size="10" /></td>
					<td class="text-align-right"><label for="gender"><spring:message
								code="label.gender" /> *</label></td>
					<td class="text-align-left"><form:radiobutton path="gender"
							id="gender" value="MALE" />&nbsp;<spring:message
							code="label.gender.male" /> <form:radiobutton
							path="gender" id="gender" value="FEMALE" />&nbsp;<spring:message
							code="label.gender.female" /></td>
				</tr>
				<tr>
					<td class="text-align-right"><label for="street"><spring:message
								code="label.address.street" /></label></td>
					<td colspan="3"><form:input path="address.street" id="street"
							maxlength="50" size="47" /></td>
				</tr>
				<tr>
					<td class="text-align-right"><label for="city"><spring:message
								code="label.address.city" /></label></td>
					<td colspan="3"><form:input path="address.city" id="city"
							maxlength="50" size="47" /></td>
				</tr>
				<tr>
					<td class="text-align-right"><label for="state"><spring:message
								code="label.address.state" /></label></td>
					<td><form:input path="address.state" id="state" maxlength="2"
							size="14" /></td>
					<td class="text-align-right"><label for="zipcode"><spring:message
								code="label.address.zipcode" /> *</label></td>
					<td class="text-align-right">&nbsp;<form:input path="address.zipcode" id="zipcode"
							maxlength="5" size="14" /></td>
				</tr>
				<tr>
					<td class="text-align-right"><label for="phone"><spring:message
								code="label.phone" /> *</label></td>
					<td colspan="3"><form:input path="phone" id="phone"
							maxlength="50" size="47" /></td>
				</tr>
				<tr>
					<td class="text-align-right"><label for="email"><spring:message
								code="label.user.email" /> *</label></td>
					<td colspan="3"><form:input path="user.email" id="email"
							maxlength="50" size="47" /></td>
				</tr>
				<tr>
					<td class="text-align-right"><label for="password"><spring:message
								code="label.user.password" /> *</label></td>
					<td colspan="3"><form:password path="user.password"
							id="password" maxlength="50" size="47" /></td>
				</tr>
				<tr>
					<td class="text-align-right"><label for="confirm"><spring:message
								code="label.user.confirm.password" /> *</label></td>
					<td colspan="3"><form:password path="user.confirmPassword"
							id="confirm" maxlength="50" size="47" /></td>
				</tr>
				<tr>
					<td></td>
					<spring:message code="button.submit" var="submit" />
					<spring:message code="button.clear" var="clear" />
					<td colspan="3" class="text-align-center"><input type="submit"
						value="${submit}" /> <input type="reset" value="${clear}" /></td>
				</tr>
			</table>
		</form:form>
	</div>

</div>