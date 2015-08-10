<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="content default-height">
	<div class="margin-top-middle margin-left-large gray-text font-size-middle">
		Your account has been created successfully. The email address is:
		${patientAccount.user.email}.<br /> Please login <a
			href="<spring:url value="/login" />">here</a> to the system and start
		an appoint with your doctor. Thank you!
	</div>
</div>