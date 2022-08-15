<%-- 
    Document   : dichvu-detail
    Created on : Aug 15, 2022, 10:50:47 PM
    Author     : HoanTran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">CHI TIẾT DỊCH VỤ</h1>
<div class="row" style="padding: 10px">
    <div class="col-md-6">
        <img class="card-img-top" class="img-fluid" src="${dichvu.image}" alt="${dichvu.tenDV}">
    </div>
    <div class="col-md-6">
        <h1>${dichvu.tenDV}</h1>
        <h3 class="text-danger">${dichvu.gia} VND</h3>
        <div>
            <input type="button" value="Đặt dịch vụ" class="btn btn-danger"/>
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
        <img class="rounded-circle img-fluid" src="${dichvu.image}" />
    </div>
    <div class="col-md-10">
        <p>Tuyệt vời!!!</p>
        <i>31/12/2022 10:48</i>
    </div>
</div>
<div class="row">
    <div class="col-md-1" style="padding: 10px">
        <img class="rounded-circle img-fluid" src="${dichvu.image}" />
    </div>
    <div class="col-md-11">
        <p>Tuyệt vời!!!</p>
        <i>31/12/2022 10:48</i>
    </div>
</div>
