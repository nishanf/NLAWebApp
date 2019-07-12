
<html>
<head>
<title>NLA Application - List of Patrons</title>
<#include "common/header.ftl">
</head>

<body>

<#include "common/navigation.ftl">


<div class="container">

 <h3>List of Patrons</h3>
 
	<table class="table table-striped">
		
		<thead>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<#list list as person>
				<tr>
					<td>${person.name}</td>
					<td>${person.email}</td>
					<td>${person.phone}</td>
					<td><button value='${person.personId}' class="btn-primary burrowingsBtn"> See list of books burrowed</button></td>
				</tr>
			</#list>
		</tbody>
	</table>
	
	<div id="books-burrowed" />
	
	
</div>

   <#include "common/footer.ftl">
   
</body>
</html>
