
<html>
<head>
<title>NLA Application - List of Books</title>
<#include "common/header.ftl">
</head>

<body>

<#include "common/navigation.ftl">

<div class="container">

 <h3>List of Books</h3>
 
	<table class="table table-striped">
		
		<thead>
			<tr>
				<th>ISBN</th>
				<th>Title</th>
				<th>Author</th>
			</tr>
		</thead>
		<tbody>
			<#list list as book>
				<tr>
					<td>${book.isbn}</td>
					<td>${book.title}</td>
					<td>${book.author}</td>
					
				</tr>
			</#list>
		</tbody>
	</table>
	
</div>

<#include "common/footer.ftl">

</body>
</html>
