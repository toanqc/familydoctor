<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h3>New Doctor Account</h3>

<form:form commandName="doctor" action="/admin/doctor/new" method="post">
	<label>Firstname:</label>
	<form:input path="firstName" />
	
	<label>Lastname:</label>
	<form:input path="lastName" />
	
	<label>Phone:</label>
	<form:input path="phone" />
	
	<label>Email:</label>
	<form:input path="email" />
	
	<label>Specialization:</label>
	<form:input path="specialization" />	
	
	<label>License #:</label>
	<form:input path="licenseNumber" />	
	
	<label>Street:</label>
	<form:input path="address.street" />	
	
	<label>City:</label>
	<form:input path="address.city" />
	
	<label>State:</label>
	<form:input path="address.state" />
	
	<label>Zip:</label>
	<form:input path="address.zip" />
	
	<label>Password:</label>
	<form:input path="password" />
	
	<label>Repeat Password:</label>
	<form:input path="password2" />
</form:form>