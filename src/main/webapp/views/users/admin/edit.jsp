<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="col">
    <form action="/PH13751_LeMinhThuy_Lab5.1/users/update?id=${user.id}" class="container" method="post"> 
         <div class="row mt-3">
              <div class="col">
                  <label id="hoten">Họ và tên:</label>
                  <input class="form-control" name="hoTen" type="text" value="${user.hoTen}">
              </div>
         </div>
         <div class="row mt-3">
              <div class="col">
                  <label id="gioiTinh" class="me-2">Giới tính:</label>
                  <input name="gioiTinh" type="radio" value="1" ${user.gioiTinh == 1 ? 'checked' : '' } > Nam
                  <input name="gioiTinh" type="radio" value="2" ${user.gioiTinh == 2 ? 'checked' : '' } > Nữ
              </div>
         </div>
         <div class="row mt-3">
              <div class="col">
                  <label id="diaChi">Địa chỉ:</label>
                  <input class="form-control" name="diaChi" type="text" value="${user.diaChi}">
              </div>
         </div>
         <div class="row mt-3">
              <div class="col">
                  <label id="email">Email:</label>
                  <input class="form-control" name="email" type="email" value="${user.email}">
              </div>
         </div>
         <div class="row mt-3">
              <div class="col">
                  <label id="password">Password:</label>
                  <input class="form-control" name="password" type="password" value="${user.password}">
              </div>
         </div>
         <div class="row mt-3">
              <div class="col">
                  <label id="sdt">Số điện thoại:</label>
                  <input class="form-control" name="sdt" type="sdt" value="${user.sdt}">
              </div>
         </div>
         <div class="row mt-3">
              <div class="col">
                   <button class="btn btn-primary" >Sửa</button>
                   <button class="btn btn-secondary" type="reset">Reset</button>
              </div>
         </div>
    </form>
</div>