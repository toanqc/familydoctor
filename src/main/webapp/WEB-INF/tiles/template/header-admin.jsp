<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	
<div class="header-footer">
	<div class="logo">
		<a href="<spring:url value="/" />"><img alt=""
			src="<spring:url value="/resources/images/family_doctor_logo.png"/>"
			height="45px"> </a>
	</div>
	<div class="menu">
		<div class="menu-text separator">
			<a href=""><spring:message code="menu.admin.dashboard" /></a>
		</div>
		<div class="menu-text separator">
			<a href=""><spring:message code="menu.admin.account" /></a>
		</div>		
	</div>
	<div class="menu pull-right">
		<div class="menu-text separator">
			<a href="<spring:url value="" />">
				<spring:message code="button.logout" />
			</a>
		</div>
		<div class="menu-text">
			<a href=""><img alt=""
				src="<spring:url value="/resources/images/phone.png" />"
				height="16px"> 641-FDOCTOR</a>
		</div>
	</div>
</div>
