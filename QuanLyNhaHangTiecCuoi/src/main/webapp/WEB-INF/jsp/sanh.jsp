<%-- 
    Document   : sanh
    Created on : Aug 15, 2022, 10:49:58 PM
    Author     : HoanTran
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-info">QUẢN LÝ SẢNH</h1>

<c:url value="/admin/sanh" var="action" />

<form:form method="post" action="${action}" 
           modelAttribute="sanh" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />

    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" path="ten" id="name" placeholder="name" />
        <label for="name">Tên sảnh</label>
        <form:errors path="ten" element="div" cssClass="invalid-feedback" />
    </div>

    <div class="form-floating mt-3 mb-3">
        <form:input class="form-control" path="soBan" id="price" placeholder="price" />
        <label for="price">Số bàn</label>
        <form:errors path="soBan" element="div" cssClass="invalid-feedback" />
    </div>

    
    <div class="form-group">
        <label for="file">Ảnh sảnh</lable>
        <form:input type="file" id="file" path="file" class="form-control" />
    </div>
        
    <div class="form-floating">
        <br>
        <input type="submit" value="Thêm sảnh" class="btn btn-danger" />
    </div>
</form:form>

<div class="spinner-border text-secondary" id="myLoading"></div>
<table class="table table-hover">
    <tr>
        <th></th>
        <th>Tên sảnh</th>
        <th>Số bàn</th>
        <th></th>
    </tr>
    <tbody id="adminSanh">

    </tbody>
</table>

<script src="<c:url value="/js/sanh.js" />"></script>
<script>
    <c:url value="/api/sanh" var="endpoint" />

    window.onload = function () {
        loadAdminSanh('${endpoint}');
    }
</script>