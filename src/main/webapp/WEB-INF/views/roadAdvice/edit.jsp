<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit road advice</title>
    <link href="<c:url value="/resources/dist/css/styles.css"/> " rel="stylesheet"/>
</head>
<body>
<div align="center" style="background-color: lightgrey">
    <h3 style="font-style: italic; font-weight: bold">Change data:</h3>
    <form:form modelAttribute="roadAdvice">
        <form:hidden path="id"/>
        <form:hidden path="uploader"/>
        <form:hidden path="url"/>
        <form:hidden path="uploadDate"/>
        <form:hidden path="created"/>
        <table style="width: auto">
            <tr>
                <th>Title:</th>
                <td><form:input path="title"/></td>
            </tr>
            <tr>
                <th>Description:</th>
                <td><form:textarea path="description"/></td>
            </tr>
        </table>
        <button type="submit" class="btn btn-success">Edit</button>
        <a href="/roadAdvice/all" class="btn btn-danger">Back to Homepage</a>
    </form:form>
</div>
<div class="row">
    <div class="col-xl-3"></div>
    <div class="col-xl-6">
        <div class="card mb-4">
            <div class="card-header" style="text-align: center; font-weight: bold; font-style: italic">
                Watch again!
            </div>
            <div class="card-body" style="height: 400px; background-color: dimgrey">
                <iframe src="${roadAdvice.url}" height="360" width="590" frameborder="0" allowfullscreen></iframe>
            </div>
        </div>
    </div>
</div>
</body>
</html>