<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Forum Topic</title>
    <link href="<c:url value="/resources/dist/css/styles.css"/> " rel="stylesheet"/>
</head>
<body style="background-image: url(<c:url
        value="/resources/dist/assets/img/mountain_road.jpg"/>); background-position: bottom; background-size: cover">
<div align="center" style="background-color: lightgrey">
    <h3 style="font-style: italic; font-weight: bold">Add a Forum Topic:</h3>
    <form:form action="/forum/addTopic" method="post" modelAttribute="forumTopic">
        <table style="width: auto">
            <tr>
                <th>Title:</th>
                <td><form:input path="title"/></td>
            </tr>
            <tr>
                <th>Content:</th>
                <td><form:textarea path="content"/></td>
            </tr>
        </table>
        <input type="hidden" name="subjectId" value="${subjectId}">
        <button type="submit" class="btn btn-success">Add</button>
        <a href="/forum/?id=${subjectId}" class="btn btn-danger">Back to Forum</a>
    </form:form>
</div>
</body>
</html>
