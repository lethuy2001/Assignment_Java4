<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet"
	href="/PH13751_LeMinhThuy_Assignment/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="/PH13751_LeMinhThuy_Assignment/fontawesome/fontawesome/css/all.min.css">
</head>
<body>
	<div class="container-fluid">
		<c:if test="${ !empty sessionScope.success }">
			<div class="alert alert-success">${ sessionScope.success }</div>
			<c:remove var="success" scope="session" />
		</c:if>
		
		<c:if test="${ !empty sessionScope.error }">
			<div class="alert alert-success">${ sessionScope.error }</div>
			<c:remove var="error" scope="session" />
		</c:if>
		<form action="/PH13751_LeMinhThuy_Lab5.1/loginSL" method="post"
			class="row">
			<div class="col-4">
				<div>
					<label>Tài khoản</label> <input class="form-control" type="text"
						name="email">
				</div>
				<div>
					<label>Mật khẩu</label> <input type="password" name="password"
						class="form-control">
				</div>

				<button>Đăng nhập</button>
			</div>
		</form>
	</div>

	<script src="/PH13751_LeMinhThuy_Assignment/js/jquery.min.js"></script>
	<script src="/PH13751_LeMinhThuy_Assignment/js/popper.min.js"></script>
	<script src="/PH13751_LeMinhThuy_Assignment/js/bootstrap.min.js"></script>
</body>
</html>