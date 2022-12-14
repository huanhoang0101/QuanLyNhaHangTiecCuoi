<%-- 
    Document   : dichvu-detail
    Created on : Aug 15, 2022, 10:50:47 PM
    Author     : HoanTran
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">CHI TIẾT DỊCH VỤ</h1>
<div class="row" style="padding: 10px">
    <div class="col-md-6">
        <img class="card-img-top" class="img-fluid" src="${dichvu.image}" alt="${dichvu.tenDV}">
    </div>
    <div class="col-md-6">
        <h1>${dichvu.tenDV}</h1>
        <h3 class="text-danger">${dichvu.gia} VND</h3>
        <a href="<c:url value="#"/>" class="btn btn-primary" onclick="addToDatDichvu(${dichvu.maDV}, '${dichvu.tenDV}', ${dichvu.gia})">Đặt dịch vụ</a>
    </div>
</div>

<c:url value="/api/dichvu/${dichvu.maDV}/comments" var="endpoint" />
<form>
    <div class="form-group" style="padding: 10px">
        <textarea class="form-control" placeholder="Nhập đánh giá của bạn..." id="contentId"></textarea>
    </div> 
    <button class="btn btn-danger" onclick="addCommentDichvu('${endpoint}', ${dichvu.maDV})">Thêm bình luận</button>
</form>

<br/>
<ul id="comments" class="list-group">

</ul> 

<br/>
<a href="<c:url value="/dat-menu"/>" class="btn btn-primary">Đặt món ăn</a>
<a href="<c:url value="/dattiec"/>" class="btn btn-primary">Thanh toán</a>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>
<script src="<c:url value="/js/comment_dichvu.js" />"></script>
<script>
        window.onload = function () {
            loadCommentsDichvu('${endpoint}');
        }
</script>


