<%-- 
    Document   : dattiec
    Created on : Aug 29, 2022, 11:18:48 PM
    Author     : huan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
        <tr id="Sanh${s.maSanh}">
            <td>${s.maSanh}</td>
            <td>${s.tenSanh}</td>
            <td>${s.soBan}</td>
            <td>
                <p class="card-text">
                    <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${s.gia}" /> VND
                </p>
            </td>
            <td>
                <input type="button" 
                       value="Xóa" 
                       onclick="deleteDatSanh(${s.maSanh})"
                       class="btn btn-danger" />
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
        <c:forEach items="${datmonan}" var="m">
            <tr id="Monan${m.maMenu}">
                <td>${m.maMenu}</td>
                <td>${m.tenMon}</td>
                <td>
                    <p class="card-text">
                        <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${m.gia}" /> VND
                    </p>
                </td>
                <td>
                    <div class="form-group">
                        <input type="number"  
                               onblur="updateDatMonan(this, ${m.maMenu})"
                               value="${m.soLuong}" 
                               class="form-control" />
                    </div>
                </td>
                <td>
                    <input type="button" 
                           value="Xóa" 
                           onclick="deleteDatMonan(${m.maMenu})"
                           class="btn btn-danger" />
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
            <tr id="Dichvu${dv.maDV}">
                <td>${dv.maDV}</td>
                <td>${dv.tenDV}</td>
                <td>
                    <p class="card-text">
                        <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${dv.gia}" /> VND
                    </p>
                </td>
                <td>
                    <input type="button" 
                           value="Xóa" 
                           onclick="deleteDatDichvu(${dv.maDV})"
                           class="btn btn-danger" />
                </td>
            </tr>
        </c:forEach> 
    </table>
</c:if>

<h3>Tổng cộng: </h3>


<input type="button" value="Thanh toán" class="btn btn-danger" />