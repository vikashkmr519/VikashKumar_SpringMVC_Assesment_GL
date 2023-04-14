<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
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
<style>
.error {
	color: red;
}
</style>
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
						aria-current="page" href="${pageContext.servletContext.contextPath}/">Home</a></li>
					<%
					String id = (String) session.getAttribute("email");

					if (id == null) {
					%>
					<li class="nav-item"><a class="nav-link" href="${pageContext.servletContext.contextPath}/login">Login</a>
					</li>
					<%
					}
					if (id != null) {
					%>
					<li class="nav-item"><a class="nav-link" href="${pageContext.servletContext.contextPath}/logout">Logout</a>
					</li>
					<%
					}
					%>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">
		<section class="h-100 h-custom" style="background-color: #8fc4b7;">
			<div class="container py-5 h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-lg-8 col-xl-6">
						<div class="card rounded-3">
							<img
								src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img3.webp"
								class="w-100"
								style="border-top-left-radius: .3rem; border-top-right-radius: .3rem;"
								alt="Sample photo">
							<div class="card-body p-4 p-md-5">
								<h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Registration
									Info</h3>

								<form class="px-md-2" action="register" method="POST">

									<div class="form-outline mb-4">
										<input type="text" id="username" name="username" placeholder="username" class="form-control" />
										<label class="form-label" for="form3Example1q">User Name</label>
									</div>
									<div class="form-outline mb-4">
										<input type="text" id="email" name="email" placeholder="email" class="form-control" />
										<label class="form-label" for="form3Example1q">Email</label>
									</div>
									
									<div class="form-outline mb-4">
										<input type="text" id="password" name="password" placeholder="Password" class="form-control" />
										<label class="form-label" for="form3Example1q">Password</label>
									</div>

									

									<button type="submit" class="btn btn-success btn-lg mb-1">Register</button>

								</form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>

</body>
</html>