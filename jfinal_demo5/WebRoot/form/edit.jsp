<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.demo.person.Person"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/js/jquery-1.12.0.min.js"></script>
<title>index</title>
</head>
<body>
 <form action="/form/update" method="post" id="form_person">
 <% Person person = (Person)request.getAttribute("person");%>
 <input type="hidden" name="person.ID" value="${person.ID}"/>
            姓：
         <input type="text" name="person.LastName"  value="${person.LastName}"/>${LastNameMsg}
            <br />
            
            名：       <input type="text" name="person.FirstName"  value="${person.FirstName}"/>${FirstNameMsg}
            <br />
            地址：
            <input type="text" name="person.Address" value="${person.Address}"/>${AddressMsg}
            <br />
            城市：
            <input type="text" name="person.City" value="${person.City}"/>${CityMsg}
            <br />
          年龄：    <input type="text" name="person.Age" value="${person.Age}"/>
            <br />
            <input id="sub" type="submit" value="保存" />
           
        </form>
</body>

</html>