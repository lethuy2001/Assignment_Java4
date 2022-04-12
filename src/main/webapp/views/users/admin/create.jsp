<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>    

<c:if test="${ !empty  sessionScope.message}">
    <div class="alert alert-warning">
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
<div class="col">
    <form action="/PH13751_LeMinhThuy_Lab5.1/users/store" class="container" method="post"> 
         <div class="row mt-3">
              <div class="col">
                  <label id="hoten">Họ và tên:</label>
                  <input class="form-control" name="hoTen" type="text">
              </div>
         </div>
         <div class="row mt-3">
              <div class="col">
                  <label id="gioiTinh" class="me-2">Giới tính:</label>
                  <input name="gioiTinh" type="radio" value="1" checked="checked" > Nam
                  <input name="gioiTinh" type="radio" value="2" > Nữ
              </div>
         </div>
         <div class="row mt-3">
              <div class="col">
                  <label id="diaChi">Địa chỉ:</label>
                  <input class="form-control" name="diaChi" type="text">
              </div>
         </div>
         <div class="row mt-3">
              <div class="col">
                  <label id="email">Email:</label>
                  <input class="form-control" name="email" type="email">
              </div>
         </div>
         <div class="row mt-3">
              <div class="col">
                  <label id="password">Password:</label>
                  <input class="form-control" name="password" type="password">
              </div>
         </div>
         <div class="row mt-3">
              <div class="col">
                  <label id="sdt">Số điện thoại:</label>
                  <input class="form-control" name="sdt" type="sdt">
              </div>
         </div>
         <div class="row mt-3">
              <div class="col">
                   <button class="btn btn-primary" >Đăng ký</button>
                   <button class="btn btn-secondary" type="reset">Reset</button>
              </div>
         </div>
    </form>
</div>