<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link href="resources/css/login.css" rel="stylesheet" type="text/css">

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page"
						href="${pageContext.servletContext.contextPath}/">Home</a></li>
					<%
					String id = (String) session.getAttribute("email");

					if (id == null) {
					%>
					<li class="nav-item"><a class="nav-link" href="login">Login</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="register">Register</a>
					</li>
					<%
					}
					if (id != null) {
					%>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.servletContext.contextPath}/logout">Logout</a>
					</li>
					<form class="form-inline my-2 my-lg-0">

						<h3 class="my-2 my-sm-0">
							<%
							String name = (String) session.getAttribute("username");
							out.print(name);
							%>
						</h3>
					</form>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.servletContext.contextPath}/readlater/page">Read
							Later List</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.servletContext.contextPath}/likedbook/page">Liked
							Books</a></li>

					<%
					}
					%>
				</ul>
			</div>
		</div>
	</nav>
	<!--  http://localhost:8080/SpringMVCDemo/greet  -->
	<%
		String id2 = (String) session.getAttribute("email");

		if (id2 != null) {
		%>
	<h1>Welcome ${sessionScope.email }</h1>
	<div class="row">
		<c:forEach items="${books}" var="book">

			<div class="col-md-4">
				<div class="card p-3">
					<div class="d-flex flex-row mb-3">
						<img src="https://i.imgur.com/ccMhxvC.png" width="70">
						<div class="d-flex flex-column ml-2">
							<span>Name: ${book.bookname}</span> <span>Author Name :
								${book.authorname}</span> <span>Publication: ${book.publication}</span>
							<span>Price: ${book.price}</span>
							<div>
								<br> <a
									href="${pageContext.servletContext.contextPath}/readlater?bookid=${book.bookid}">
									<button type="button" class="btn btn-primary">Read
										Later</button>
								</a>
							</div>
							<div>
								<br> <a
									href="${pageContext.servletContext.contextPath}/likedbook?bookid=${book.bookid}">
									<button type="button" class="btn btn-primary">Like Me</button>
								</a>
							</div>
						</div>

					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<%} else { %>
	
		<div>
			<h2>Please login first</h2>
			<a href="${pageContext.servletContext.contextPath}/login">
			<button >Login</button>
			</a>
		</div>
	<%} %>

</body>
</html>