<%@ include file="common/header.jsp"%>

<div class="container">
	<div class="row">
		<table data-toggle="table" data-url="data1.json" data-cache="false"
			data-height="299" style="width: 100%">
			<thead>
				<tr>
					<th data-field="title">Title</th>
					<th data-field="date">Date</th>
					<th data-field="delete">Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${articles}" var="article">
					<tr>
						<td><a href="${pageContext.request.contextPath}/edit/${article.id}">${article.title}</a></td>
						<td>${article.postedDate}</td>
						<td><a href="${pageContext.request.contextPath}/delete/${article.id}" class="btn btn-link">Delete</a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<%@ include file="common/footer.jsp"%>