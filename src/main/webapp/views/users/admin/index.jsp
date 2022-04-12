<%@ page language="java"  contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  session="true" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:if test="${ !empty  sessionScope.message}">
    <div class="alert alert-success">
         ${ sessionScope.message }
    </div>
    <c:remove var="message" scope="session"/>
</c:if>

<c:if test="${ !empty  sessionScope.error}">
    <div class="alert alert-danger">
         ${ sessionScope.error }
    </div>
    <c:remove var="message" scope="session"/>
</c:if>


<table class="table table-hover">
	<tr>
		<th>Họ tên</th>
		<th>Giới tính</th>
		<th>Địa chỉ</th>
		<th>Email</th>
		<th>Số điện thoại</th>
		<th colspan="2">Thao tác</th>
	</tr>

	<c:forEach var="user" items="${list}">
		<tr>
			<td>${user.hoTen}</td>
			<td><c:choose>
					<c:when test="${user.gioiTinh == 1}">Nam</c:when>
					<c:when test="${user.gioiTinh == 2}">Nữ</c:when>
				</c:choose></td>
			<td>${user.diaChi}</td>
			<td>${user.email}</td>
			<td>${user.sdt}</td>
			<td><a class="btn btn-warning"
				href="/PH13751_LeMinhThuy_Lab5.1/users/edit?id=${user.id}"> Sửa</a>
			</td>
			<td><button class="btn btn-danger" data-bs-toggle="modal"
				data-bs-target="#exampleModal${user.id}"> Xóa</button></td>
		</tr>
		<!-- Modal -->
		<div class="modal fade" id="exampleModal${user.id}" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Bạn có muốn
							xóa người dùng không?</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-footer">
						<a class="btn btn-primary"
							href="/PH13751_LeMinhThuy_Lab5.1/users/delete?id=${user.id}">
							Có</a>
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Không</button>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</table>
