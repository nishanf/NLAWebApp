
<h4> List of books burrowed for ${name}  </h4>

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

