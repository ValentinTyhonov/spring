<!DOCTYPE html>
<html>
<%@ page language="java" session="true" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <title>Spring MVC</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div style="margin: 15px; font-size: 14px; color: green;" class="navbar-header">Spring MVC - Logos</div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/frontend/shops">All countries</a></li>
            <li><a href="/frontend/shops/new">new shop</a></li>
        </ul>
    </div>
</nav>

<div class="container">

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Population</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="country" items="${countries}">
            <tr>
                <td>${country.id}</td>
                <td>${country.name}</td>
                <td>${country.population}</td>
                <td><a href="update?id=">Edit</a></td>
                <td><a href="delete?id=">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>