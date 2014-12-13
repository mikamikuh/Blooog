<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="common/header.jsp"%>
<!-- Main Content -->
<div class="container">
	<div class="row">
		<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
			<c:forEach items="${articles}" var="article">
				<div class="post-preview">
					<a href="${pageContext.request.contextPath}/article/${article.id}">
						<h2 class="post-title">${article.title}</h2>
						<h3 class="post-subtitle">Posted by ${article.author.userName} on ${article.postedDate}</h3>
					</a>
					<p class="post-meta">
						${article.body}
					</p>
				</div>
			</c:forEach>
			<!-- Pager -->
			<ul class="pager">
				<li class="next"><a href="#">Older Posts &rarr;</a></li>
			</ul>
		</div>
	</div>
</div>
<hr>
<%@ include file="common/footer.jsp"%>