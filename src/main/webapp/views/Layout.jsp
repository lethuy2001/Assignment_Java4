<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab5</title>
<link rel="stylesheet" href="/PH13751_LeMinhThuy_Lab5.1/css/bootstrap.min.css" />
</head>
<body>
    <div class="container">
        <div class="row mt-5"> 
            <div class="col-10">
                 <h1>THÔNG TIN NGƯỜI DÙNG</h1>
            </div>
            <div class="col-2">
                 <a class="btn btn-primary" href="/PH13751_LeMinhThuy_Lab5.1/users/create">Đăng ký</a>
            </div>
        </div>
        
        <div class="row mt-5">
            <jsp:include page="${view}"></jsp:include>
        </div>
    </div>


    <script src="/PH13751_LeMinhThuy_Lab5.1/js/jquery.min.js"></script>
	<script src="/PH13751_LeMinhThuy_Lab5.1/js/popper.min.js"></script>
	<script src="/PH13751_LeMinhThuy_Lab5.1/js/bootstrap.min.js"></script>
</body>
</html>