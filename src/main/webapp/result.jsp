<%-- 
    Document   : index
    Created on : 2018-5-12, 13:44:23
    Author     : 孟文杰
--%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<c:if test="${sessionScope.resultlist==null}">
    <!-- 获取list -->
    <jsp:forward page="/Index"></jsp:forward>
</c:if>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style type="text/css">
        .th {
            width: 10%;
        }
    </style>
    <script src="js/Chart.bundle.js"></script>
</head>
<body>

<div>
    <p>2015级JAVA7班 201540704729 孟文杰</p>
</div>

<div id="canvas-holder" style="width:40%">
    <canvas id="chart-area"></canvas>
</div>


<table border="0" style="border-bottom-color: red;border-bottom: red;width: 50%;margin-left: 20%">

    <tr>
        <th>
            No.
        </th>
        <th>
            a
        </th>
        <th>
            op
        </th>
        <th>
            b
        </th>
        <th>
            =
        </th>
        <th>
            result
        </th>
        <th>
            your result
        </th>
        <th>
            istrue
        </th>
    </tr>

    <c:forEach items="${sessionScope.resultlist}" var="info" varStatus="vs">
        <tr>
            <th>
                    ${vs.count}
            </th>

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
                    ${info.value}
            </th>
            <th>
                    ${info.result}
            </th>

            <c:if test="${info.istrue==true}">
                <th style="color: green">
                        ${info.istrue}
                </th>
            </c:if>
            <c:if test="${info.istrue==false}">
                <th style="color: red">
                        ${info.istrue}
                </th>
            </c:if>
        </tr>
    </c:forEach>

</table>
</form>

<script type="text/javascript">

    var truenum = ${sessionScope.truenum};
    var falsenum = ${sessionScope.falsenum};

    var config = {
        type: 'pie',
        data: {
            datasets: [{
                data: [
                    falsenum,
                    truenum,
                ],
                backgroundColor: [
                    'rgb(255, 20, 20)',
                    'rgb(20, 255, 20)',
                ],
                label: 'Dataset 1'
            }],
            labels: [
                '错误',
                '正确',
            ]
        },
        options: {
            responsive: true
        }
    };

    window.onload = function () {
        var ctx = document.getElementById('chart-area').getContext('2d');
        window.myPie = new Chart(ctx, config);
    };

</script>
</body>
</html>
