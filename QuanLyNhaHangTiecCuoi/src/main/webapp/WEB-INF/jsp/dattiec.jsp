<%-- 
    Document   : dattiec
    Created on : Aug 29, 2022, 11:18:48 PM
    Author     : huan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">CHI TIẾT ĐẶT TIỆC</h1>

<table class="table">
    <tr>
        <th>Mã sảnh</th>
        <th>Tên sảnh</th>
        <th>Số bàn</th>
        <th>Giá</th>
        <th></th>
    </tr>
    <c:forEach items="${datsanhcuoi}" var="s">
        <tr>
            <td>${s.maSanh}</td>
            <td>${s.tenSanh}</td>
            <td>${s.soBan}</td>
            <td>${s.gia} VND</td>
            <td>
                <input type="button" value="Xóa" class="btn btn-danger" />
            </td>
        </tr>
    </c:forEach> 
</table>

<c:if test="${datmonan != null}">
    <table class="table">
        <tr>
            <th>Mã món ăn</th>
            <th>Tên món</th>
            <th>Đơn giá</th>
            <th>Số lượng</th>
            <th></th>
        </tr>
        <c:forEach items="${datmonan}" var="c">
            <tr>
                <td>${c.maMenu}</td>
                <td>${c.tenMon}</td>
                <td>${c.gia} VND</td>
                <td>
                    <div class="form-group">
                        <input type="number" value="${c.soLuong}" class="form-control" />
                    </div>
                </td>
                <td>
                    <input type="button" value="Xóa" class="btn btn-danger" />
                </td>
            </tr>
        </c:forEach> 
    </table>
</c:if>

<c:if test="${datDV != null}">
    <table class="table">
        <tr>
            <th>Mã món ăn</th>
            <th>Tên món</th>
            <th>Đơn giá</th>
            <th></th>
        </tr>
        <c:forEach items="${datDV}" var="dv">
            <tr>
                <td>${dv.maDV}</td>
                <td>${dv.tenDV}</td>
                <td>${dv.gia} VND</td>
                <td>
                    <input type="button" value="Xóa" class="btn btn-danger" />
                </td>
            </tr>
        </c:forEach> 
    </table>
</c:if>

<h3>Tổng cộng: </h3>


<input type="button" value="Thanh toán" class="btn btn-danger" />