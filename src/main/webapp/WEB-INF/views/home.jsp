<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="content">
	<div class="background-content">
		<div class="margin-left slogan title">
			<spring:message code="label.slogan" var="slogans" />
			<c:forEach items="${slogan}" var="slogan">
				${slogan}<br />
			</c:forEach>
		</div>
		<div
			class="margin-left slogan-additional gray-text font-size-middle oblique">
			<spring:message code="label.slogan.additional"
				var="additionalSlogans" />
			<c:forEach items="${additionalSlogans}" var="additionalSlogan">
				${additionalSlogan}<br />
			</c:forEach>
		</div>
	</div>

	<div class="inner-content">
		<div class="margin-left inner-left-content">
			<div class="title margin-top-middle">
				<spring:message code="label.for.patients" />
			</div>
			<div class="margin-top-small gray-text font-size-large">
				<spring:message code="label.connection" var="connections" />
				<c:forEach items="${connections}" var="connection">
					${connection}<br />
				</c:forEach>
			</div>
			<div class="margin-top-small gray-text font-size-middle">
				<spring:message code="label.already.member" />
			</div>
			<div class="margin-top-small">
				<spring:message code="button.login" var="login" />
				<input type="button" id="login" value="${login}" />
			</div>
			<div
				class="margin-left-huge margin-top-small gray-text font-size-middle">
				<a href=""><spring:message code="label.new.member" /></a>
			</div>
		</div>

		<div class="inner-middle-content sepator-content"></div>

		<div class="margin-left inner-right-content">
			<div class="title margin-top-middle">
				<spring:message code="label.news.events" />
			</div>
			<div class="margin-top-small gray-text font-size-middle">
				<a href=""><spring:message code="label.news.first" /></a>
			</div>
			<div class="margin-top-small gray-text font-size-middle">
				<a href=""><spring:message code="label.news.second" /></a>
			</div>
			<div class="margin-top-small gray-text font-size-middle">
				<a href=""><spring:message code="label.news.third" /></a>
			</div>
			<div class="margin-top-small gray-text font-size-middle">
				<a href=""><spring:message code="label.news.forth" /></a>
			</div>
		</div>
	</div>
</div>