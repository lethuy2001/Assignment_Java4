<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>    

<div>
<form action="/PH13751_LeMinhThuy_Lab5.1/Catagories" method="post">
    Name: <input type="text" name="ten">
    <select name="user_id">
         <c:forEach var="user"  items="${dsUser}">
               <option value="${user.id}">${user.hoTen}</option>
         </c:forEach>
        
    </select>
    <button>Đăng ký</button>
</form>

    
</div>