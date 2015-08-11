<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="content text-align-center">
	<div class="margin-top-middle">
		<img
			src="<spring:url value="/resources/images/404.png"  htmlEscape="true" />"
			alt="Page not found JSP!!!" />
	</div>

	<div class="margin-top-middle gray-text font-size-middle">
		<a href="<spring:url value="/home" />">&lt; <spring:message
				code="label.go.back" /></a>
	</div>

	<div class="margin-top-middle"></div>
</div>