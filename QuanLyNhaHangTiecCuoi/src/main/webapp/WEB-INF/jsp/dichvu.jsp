<%-- 
    Document   : dichvu
    Created on : Aug 15, 2022, 10:50:36 PM
    Author     : HoanTran
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-info">QUẢN LÝ DỊCH VỤ</h1>

<c:url value="/admin/dichvu" var="action" />

<form:form method="post" action="${action}" 
           modelAttribute="dichvu" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />

    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" path="tenDV" id="name" placeholder="name" />
        <label for="name">Tên dịch vụ</label>
        <form:errors path="tenDV" element="div" cssClass="invalid-feedback" />
    </div>

    <div class="form-floating mt-3 mb-3">
        <form:input class="form-control" path="gia" id="price" placeholder="price" />
        <label for="price">Giá</label>
        <form:errors path="gia" element="div" cssClass="invalid-feedback" />
    </div>
    
    <div class="form-group">
        <label for="file">Ảnh dịch vụ</lable>
        <form:input type="file" id="file" path="file" class="form-control" />
    </div>
        
    <div class="form-floating">
        <br>
        <input type="submit" value="Thêm dịch vụ" class="btn btn-danger" />
    </div>
</form:form>

<div class="spinner-border text-secondary" id="myLoading"></div>
<table class="table table-hover">
    <tr>
        <th></th>
        <th>Tên dịch vụ</th>
        <th>Giá</th>
        <th></th>
    </tr>
    <tbody id="adminDichVu">

    </tbody>
</table>

<script src="<c:url value="/js/dichvu.js" />"></script>
<script>
    <c:url value="/api/dichvu" var="endpoint" />

    window.onload = function () {
        loadAdminDichVu('${endpoint}');
    }
</script>
