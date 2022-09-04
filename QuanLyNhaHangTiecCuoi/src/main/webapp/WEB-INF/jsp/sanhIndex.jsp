<%-- 
    Document   : sanhIndex
    Created on : Aug 15, 2022, 10:11:56 PM
    Author     : HoanTran
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">SẢNH TIỆC</h1>

<h3 class="text-info">SẢNH CƯỚI &#10024;</h3>
<a>Được bày trí theo phong cách Châu Âu sang trọng sẽ thật sự phù hợp cho một hôn lễ ấm cúng.
    Diện tích có thể linh hoạt với sức chứa lên tới 2000 khách (200 bàn) 
    nhằm đáp ứng nhiều hình thức và nhu cầu tiệc khác nhau.</a>
<br/><br/>

<ul class="pagination">
    <c:forEach begin="1" end="${Math.ceil(SanhCounter/8)}" var="ms">
        <c:url value="/sanhIndex" var="sv">
            <c:param value="${ms}" name="page"  />
        </c:url>
        <li class="page-item"><a class="page-link" href="${sv}">${ms}</a></li>
   </c:forEach>
</ul>

<div class="row">
    <c:forEach items="${sanhs}" var="s">
        <div class="col-md-3 col-xs-12">
            <div class="card">  
                <img class="card-img-top" class="img-fluid" src="${s.image}" alt="Card image">
                <div class="card-body">
                    <h4 class="card-title">${s.ten}</h4>
                    <p class="card-text">Số bàn: ${s.soBan}</p>
                    <p class="card-text">
                        <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "10000000" /> VND
                    </p>
                    <a href="<c:url value="/admin/sanh/${s.maSanh}"/>" class="btn btn-primary">Xem chi tiết</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>


