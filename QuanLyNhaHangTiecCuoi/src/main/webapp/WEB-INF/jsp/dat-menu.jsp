<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">ĐẶT MENU MÓN ĂN</h1>

<ul class="pagination">
    <c:forEach begin="1" end="${Math.ceil(MonAnCounter/8)}" var="i">
        <c:url value="/" var="c">
            <c:param value="${i}" name="page"  />
        </c:url>
        <li class="page-item"><a class="page-link" href="${c}">${i}</a></li>
   </c:forEach>
</ul>

<div class="row">
    <c:forEach items="${menus}" var="m">
        <div class="col-md-3 col-xs-12">
            <div class="card">  
                <img class="card-img-top" class="img-fluid" src="${m.image}" alt="Card image">
                <div class="card-body">
                    <h4 class="card-title">${m.tenMon}</h4>
                    <p class="card-text">${m.loaiMon}</p>
                    <p class="card-text">
                        <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${m.gia}" /> VND
                    </p>
                    <a href="<c:url value="/admin/monan/${m.maMenu}"/>" class="btn btn-primary">Xem chi tiết</a>
                    <a href="#" class="btn btn-primary" onclick="addToDatMonan(${m.maMenu}, '${m.tenMon}', ${m.gia})">Đặt món</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
<a href="<c:url value="/dat-dichvu"/>" class="btn btn-primary">Đặt dịch vụ</a>
<a href="<c:url value="/dattiec"/>" class="btn btn-primary">Thanh toán</a>


