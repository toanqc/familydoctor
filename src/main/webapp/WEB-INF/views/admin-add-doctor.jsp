<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="content">
	<div class="inner-content margin-left dashboard-content">
		<h3>New Doctor Account</h3>
		
		<form:form commandName="account" action="/admin/save-doctor" method="post">
			<table>
				<tr>
					<td><label>Firstname:</label></td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td><label>Lastname:</label></td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td><label>Phone:</label></td>
					<td><form:input path="phone" /></td>
				</tr>
				<tr>
					<td><label>Street:</label></td>
					<td><form:input path="address.street" /></td>
				</tr>
				<tr>
					<td><label>City:</label></td>
					<td><form:input path="address.city" /></td>
				</tr>
				<tr>
					<td><label>State:</label></td>
					<td><form:input path="address.state" /></td>
				</tr>
				<tr>
					<td><label>Zip:</label></td>
					<td><form:input path="address.zipcode" /></td>
				</tr>		
			</table>
		</form:form>
	</div>
</div>