<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="header-footer">
	<div class="logo">
		<img alt=""
			src="<spring:url value="/resources/images/family_doctor_logo.png"/>"
			height="45px">
	</div>
	<div class="menu">
		<div class="menu-text separator">
			<a href=""><spring:message code="label.what.we.serve" /></a>
		</div>
		<div class="menu-text separator">
			<a href=""><spring:message code="label.what.you.get" /></a>
		</div>
		<div class="menu-text">
			<a href=""><spring:message code="label.who.we.are" /></a>
		</div>
	</div>
	<div class="menu pull-right">
		<div class="menu-text separator">
			<a href="<spring:url value="patients/register" />"><spring:message
					code="label.join.us" /> ></a>
		</div>
		<div class="menu-text">
			<a href=""><img alt=""
				src="<spring:url value="/resources/images/phone.png" />"
				height="16px"> 641-FDOCTOR</a>
		</div>
	</div>
</div>
