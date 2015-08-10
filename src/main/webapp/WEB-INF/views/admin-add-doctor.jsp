<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h3>New Doctor Account</h3>

<form:form commandName="account" action="/admin/save-doctor" method="post">
	<label>Firstname:</label>
	<form:input path="firstName" />
	
	<label>Lastname:</label>
	<form:input path="lastName" />
	
	<label>Phone:</label>
	<form:input path="phone" />

	<label>Street:</label>
	<form:input path="address.street" />	
	
	<label>City:</label>
	<form:input path="address.city" />
	
	<label>State:</label>
	<form:input path="address.state" />
	
	<label>Zip:</label>
	<form:input path="address.zipcode" />

</form:form>