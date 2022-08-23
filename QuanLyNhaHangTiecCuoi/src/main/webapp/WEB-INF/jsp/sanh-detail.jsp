<%-- 
    Document   : sanh-detail
    Created on : Aug 15, 2022, 10:50:12 PM
    Author     : HoanTran
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">CHI TIẾT SẢNH</h1>
<div class="row" style="padding: 10px">
    <div class="col-md-6">
        <img class="card-img-top" class="img-fluid" src="${sanh.image}" alt="${sanh.ten}">
    </div>
    <div class="col-md-6">
        <h1>${sanh.ten}</h1>
        <h3 class="text-danger">1 VND</h3>
        <p>${sanh.soBan} bàn</p>
        <div>
            <input type="button" value="Đặt bàn" class="btn btn-danger"/>
        </div>
    </div>
</div>

<c:url value="/api/sanh/${sanh.maSanh}/comments" var="endpoint" />
<form>
    <div class="form-group" style="padding: 10px">
        <textarea class="form-control" placeholder="Nhập đánh giá của bạn..." id="contentId"></textarea>
    </div> 
    <button class="btn btn-danger" onclick="addCommentSanh('${endpoint}', ${sanh.maSanh})">Thêm bình luận</button>
</form>

<ul id="comments" class="list-group">

</ul> 

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>
<script src="<c:url value="/js/comment_sanh.js" />"></script>
<script>
        window.onload = function () {
            loadCommentsSanh('${endpoint}');
        }
</script>

