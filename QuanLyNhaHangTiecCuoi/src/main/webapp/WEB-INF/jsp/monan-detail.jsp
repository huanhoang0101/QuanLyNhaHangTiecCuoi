<%-- 
    Document   : monan-detail
    Created on : Aug 13, 2022, 6:09:02 PM
    Author     : huan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">CHI TIẾT MÓN ĂN</h1>
<div class="row" style="padding: 10px">
    <div class="col-md-6">
        <img class="card-img-top" class="img-fluid" src="${menu.image}" alt="${menu.tenMon}">
    </div>
    <div class="col-md-6">
        <h1>${menu.tenMon}</h1>
        <h3 class="text-danger">${menu.gia} VND</h3>
        <p>${menu.loaiMon}</p>
        <div>
            <input type="button" value="Đặt món" class="btn btn-danger"/>
        </div>
    </div>
</div>

<c:url value="/api/menu/${menu.maMenu}/comments" var="endpoint" />
<form>
    <div class="form-group" style="padding: 10px">
        <textarea class="form-control" placeholder="Nhập đánh giá của bạn..." id="contentId"></textarea>
    </div> 
    <button class="btn btn-danger" onclick="addCommentMonan('${endpoint}', ${menu.maMenu})">Thêm bình luận</button>
</form>

<ul id="comments" class="list-group">
    
</ul> 

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>
<script src="<c:url value="/js/comment_monan.js" />"></script>
<script>
    window.onload = function () {
        loadCommentsMonan('${endpoint}');
    }
</script>