
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>전체 조회</title>
</head>
<body>
    <table id="selectAll" border="1">
    
    <thead>
      <tr>
        <th>회원 번호</th>
        <th>아이디</th>
        <th>비밀번호</th>
        <th>이름</th>
        <th>등록 날짜</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${userList}" var="user">
      <tr>
        <td>${user.userNo}</td>
        <td>${user.id}</td>
        <td>${user.pw}</td>
        <td>${user.userName}</td>
        <td>${user.enrollDate}</td>
      </tr>
    </c:forEach>
 
    </tbody>
  </table>
</body>
</html>