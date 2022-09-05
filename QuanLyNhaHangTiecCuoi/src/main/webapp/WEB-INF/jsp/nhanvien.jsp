<%-- 
    Document   : nhanvien
    Created on : Aug 19, 2022, 4:47:40 PM
    Author     : HoanTran
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-info">QUẢN LÝ NHÂN VIÊN</h1>

<c:url value="/admin/nhanvien" var="action" />

<form:form method="post" action="${action}" 
           modelAttribute="nhanvien" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />

    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" path="tenNV" id="name" placeholder="name" />
        <label for="name">Tên nhân viên</label>
        <form:errors path="tenNV" element="div" cssClass="invalid-feedback" />
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" path="sđt" id="sodt" placeholder="sodt" />
        <label for="sodt">Số điện thoại</label>
        <form:errors path="sđt" element="div" cssClass="invalid-feedback" />
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" path="ngaySinh" id="sinh" placeholder="sinh" />
        <label for="sinh">Ngày Sinh</label>
        <form:errors path="ngaySinh" element="div" cssClass="invalid-feedback" />
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" path="gioiTInh" id="gt" placeholder="gt" />
        <label for="gt">Giới Tính</label>
        <form:errors path="gioiTInh" element="div" cssClass="invalid-feedback" />
    </div>

    <div class="form-group">
        <label for="form-control" class="form-label">Loại nhân viên</label>
        <form:select path="loaiNV" class="form-select">
            <option value= "Admin">Admin</option>
            <option value= "Nhân viên">Nhân viên</option>
        </form:select>
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" path="taiKhoan" id="tk" placeholder="tk" />
        <label for="tk">Tài Khoản</label>
        <form:errors path="taiKhoan" element="div" cssClass="invalid-feedback" />
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" path="matKhau" id="mk" placeholder="mk" />
        <label for="mk">Mật Khẩu</label>
        <form:errors path="matKhau" element="div" cssClass="invalid-feedback" />
    </div>

    <div class="form-floating">
        <br>
        <input type="submit" value="Thêm nhân viên" class="btn btn-danger" />
    </div>
</form:form>

<div class="spinner-border text-secondary" id="myLoading"></div>
<table class="table table-hover">
    <tr>
        <th>Tên nhân viên</th>
        <th>Số điện thoại</th>
        <th>Ngày Sinh</th>
        <th>Giới Tính</th>
        <th>Loại Nhân viên</th>
        <th>Tài Khoản</th>
    </tr>
    <tbody id="adminNhanVien">

    </tbody>
</table>

<script src="<c:url value="/js/nhanvien.js" />"></script>
<script>
    <c:url value="/api/nhanvien" var="endpoint" />
    window.onload = function () {
        loadAdminNhanVien('${endpoint}');
    }
</script>
