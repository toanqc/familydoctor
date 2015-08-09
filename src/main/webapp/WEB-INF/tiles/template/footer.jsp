<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="header-footer">
	<div class="menu">
		<div class="menu-text separator">
			<a href=""><spring:message code="label.terms" /></a>
		</div>
		<div class="menu-text separator">
			<a href=""><spring:message code="label.privacy" /></a>
		</div>
		<div class="menu-text">
			<a href=""><spring:message code="label.contact.us" /></a>
		</div>
	</div>
	<div class="copyright">
		<spring:message code="label.copyright" />
	</div>

	<div class="menu pull-right">
		<div class="menu-text">
			<spring:message code="label.follow.us" />
		</div>
		<div class="menu-text">
			<a href="http://www.pinterest.com" target="_blank"><img alt=""
				src="<spring:url value="/resources/images/pinterest.png" />"
				height="16px"></a>
		</div>
		<div class="menu-text">
			<a href="http://www.facebook.com" target="_blank"><img alt=""
				src="<spring:url value="/resources/images/facebook.png" />"
				height="16px"></a>
		</div>
		<div class="menu-text">
			<a href="http://www.twitter.com" target="_blank"><img alt=""
				src="<spring:url value="/resources/images/twitter.png" />"
				height="16px"></a>
		</div>
	</div>
</div>
