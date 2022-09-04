<%-- 
    Document   : monan
    Created on : Aug 11, 2022, 4:39:46 PM
    Author     : HoanTran
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-info">QUẢN LÝ MÓN ĂN</h1>

<c:url value="/admin/menu" var="action" />

<form:form method="post" action="${action}" 
           modelAttribute="menu" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />

    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" path="tenMon" id="name" placeholder="name" />
        <label for="name">Tên món ăn</label>
        <form:errors path="tenMon" element="div" cssClass="invalid-feedback" />
    </div>

    <div class="form-floating mt-3 mb-3">
        <form:input class="form-control" path="gia" id="price" placeholder="price" />
        <label for="price">Giá</label>
        <form:errors path="gia" element="div" cssClass="invalid-feedback" />
    </div>

    <div class="form-group">
        <label for="sel1" class="form-label">Loại món ăn</label>
        <form:select path="loaiMon" class="form-select">
            <option value= "Khai vị">Món khai vị</option>
            <option value= "Món chính">Món chính</option>
            <option value= "Tráng miệng">Món tráng miệng</option>
        </form:select>
    </div>
    
    <div class="form-group">
        <label for="file">Ảnh món ăn</lable>
        <form:input type="file" id="file" path="file" class="form-control" />
    </div>
        
    <div class="form-floating">
        <br>
        <input type="submit" value="Thêm món ăn" class="btn btn-danger" />
    </div>
</form:form>

<div class="spinner-border text-secondary" id="myLoading"></div>
<table class="table table-hover">
    <tr>
        <th></th>
        <th>Tên món ăn</th>
        <th>Loại món</th>
        <th>Giá</th>
        <th></th>
    </tr>
    <tbody id="adminMonAn">

    </tbody>
</table>

<script src="<c:url value="/js/monan.js" />"></script>
<script>
    <c:url value="/api/menu" var="endpoint" />

    window.onload = function () {
        loadAdminMonAn('${endpoint}');
    }
</script>

