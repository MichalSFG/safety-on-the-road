<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Comments</title>
    <link href="<c:url value="/resources/dist/css/styles.css"/> " rel="stylesheet"/>
</head>
<body style="background-position: bottom;background-image: url(<c:url value="/resources/dist/assets/img/mountain_road.jpg"/>);background-size: cover">
<div class="row">
    <div class="col-xl-3"></div>
    <div class="col-xl-6">
        <div class="card mb-4">
            <div class="card-header" style="text-align: center; font-weight: bold; font-style: italic">
                Komentarze
            </div>
            <div class="card-header" style="text-align: center; font-weight: bold; font-style: italic; color: red">
                <c:if test="${not empty message}">
                    ${message}
                </c:if>
            </div>
            <div class="card-body" style="background-color: grey">
                <table style="width: 100%; color: white">
                    <thead>
                    <th>Id</th>
                    <th>Nickname</th>
                    <th>Opinion</th>
                    <th>Added</th>
                    </thead>
                    <tbody>
                    <c:forEach items="${comments}" var="item">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.nickname}</td>
                            <td>${item.opinion}</td>
                            <td>${item.created}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="card-footer" align="center">
                <a href="/roadAdvice/all" class="btn btn-primary">Back to Homepage</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
