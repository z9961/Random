<%-- 
    Document   : index
    Created on : 2018-5-11, 22:05:48
    Author     : 孟文杰
--%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<c:if test="${sessionScope.list==null}">
    <!-- 获取list -->
    <jsp:forward page="/Index"></jsp:forward>
</c:if>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <script type="text/javascript">
        function showvalue() {

            var values = document.getElementsByName('value')

            for (var k = 0; k < values.length; k++) {
                if (values[k].style.display == "none") {
                    values[k].style.display = 'block';
                } else {
                    values[k].style.display = 'none';
                }

            }
        }

        function savetoword() {
            window.location.href = "SaveToWord";
        }
    </script>
</head>
<body>

<div>
    <p>*********************</p>
</div>


<form action="Index" method="post">
    <input type="radio" name="op" value="1">加法
    <input type="radio" name="op" value="2">减法
    <input type="radio" name="op" value="3">加减法
    <input type="radio" name="op" value="4">加减乘除

    <input type="text" name="num" id="num">数量

    <input type="submit" value="生成算式">
</form>

<input type="button" value="保存到Word" onclick="savetoword();">

<form action="Check" method="post">


    <table border="0" style="width: 10%;margin: 0 auto">
        <tr>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th>
                <input type="submit" value="提交">
            </th>


        </tr>
        <c:forEach items="${sessionScope.list}" var="info" varStatus="vs">
            <tr>
                <th style="text-align: left;width: 2%;">
                        ${info.inta}
                </th>
                <th style="text-align: center;width: 2%;">
                        ${info.operator}
                </th>
                <th style="text-align: right;width: 2%;">
                        ${info.intb}
                </th>
                <th style="text-align: right;width: 2%;">
                    =
                </th>
                <th>
                    <input type="text" id="no${vs.index}" name="no${vs.index}">
                </th>
            </tr>
        </c:forEach>

    </table>
</form>
</body>
</html>
