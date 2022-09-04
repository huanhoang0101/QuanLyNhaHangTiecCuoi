<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">NHÀ HÀNG TIỆC CƯỚI</h1>

<h3 class="text-info">SET MENU &#10024;</h3>
<h5 class="text-info">DÀNH CHO TIỆC CƯỚI &#10083;</h5>
<a>Được các chuyên gia ẩm thực giàu kinh nghiệm chế biến, 
    thực đơn của chúng tôi luôn được đầu tư và đổi mới liên tục 
    sẽ mang đến cho thực khách những món ăn đa dạng và có sự dung hòa giữa văn hóa ẩm thực Á-Âu,
    đáp ứng tất cả cá như cầu của quý khách.</a>
<br/><br/>

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
                </div>
            </div>
        </div>
    </c:forEach>
</div>

