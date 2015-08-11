<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="content">
	<div class="height-300">
		<div class="inner-left-content margin-top-small login-background">&nbsp;</div>
		<div class="margin-left inner-right-content">
			<div class="title margin-top-middle">
				<spring:message code="label.sign.in" />
			</div>
			<div class="hr-separator"></div>
			<div class="margin-top-small gray-text font-size-small">
				<spring:url value="/doLogin" var="loginUrl" />
				<form:form modelAttribute="user" action="${loginUrl}" method="post">
					<table class="data-table">
						<tr>
							<td colspan="2" class="red"><c:if test="${fail == true}">
									<spring:message code="label.login.fail" />
								</c:if> <form:errors path="*" /></td>
						</tr>
						<tr>
							<td class="text-align-right"><label for="email"><spring:message
										code="label.user.email" /></label></td>
							<td><form:input path="email" maxlength="50" name="email"
									size="40" /></td>
						</tr>
						<tr>
							<td class="text-align-right"><label for="password"><spring:message
										code="label.user.password" /></label></td>
							<td><form:password path="password" name="password"
									maxlength="50" size="40" /></td>
						</tr>
						<tr>
							<td colspan="2" class="text-align-right font-size-small"><a
								class="gray-text"
								href="<spring:url value="/patients/register" />"><spring:message
										code="label.new.member" /></a><br /> <a class="gray-text"
								href="<spring:url value="/forgetPass" />"><spring:message
										code="label.forgot.password" /></a></td>
						</tr>
						<tr>
							<td colspan="2" class="text-align-center font-size-small"><input
								type="submit" value="<spring:message code="button.sign.in"/>"></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
	</div>
	<div class="margin-top-middle margin-left-huge height-220">
		<div class="title ">
			<spring:message code="label.access.health" />
		</div>
		<div class="gray-text margin-top-small font-size-middle">
			<spring:message code="label.connection.doctors" var="doctors" />
			<c:forEach items="${doctors}" var="doctor">
				${doctor}<br />
			</c:forEach>
		</div>
		<div class="gray-text margin-top-small font-size-small">
			<spring:message code="label.visits.infos" var="infos" />
			<ul>
				<c:forEach items="${infos}" var="info">
					<li>${info}</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>