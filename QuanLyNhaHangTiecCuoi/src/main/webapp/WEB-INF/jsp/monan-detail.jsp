<%-- 
    Document   : monan-detail
    Created on : Aug 13, 2022, 6:09:02 PM
    Author     : huan
--%>

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

<form>
    <div class="form-group" style="padding: 10px">
        <textarea class="form-control" placeholder="Nhập đánh giá của bạn..."></textarea>
        <br>
        <input type="submit" value="Gửi bình luận" class="btn btn-danger"/>
    </div>
</form>

<div class="row">
    <div class="col-md-1" style="padding: 10px">
        <img class="rounded-circle img-fluid" src="${menu.image}" />
    </div>
    <div class="col-md-10">
        <p>Tuyệt vời!!!</p>
        <i>31/12/2022 10:48</i>
    </div>
</div>
<div class="row">
    <div class="col-md-1" style="padding: 10px">
        <img class="rounded-circle img-fluid" src="${menu.image}" />
    </div>
    <div class="col-md-11">
        <p>Tuyệt vời!!!</p>
        <i>31/12/2022 10:48</i>
    </div>
</div>