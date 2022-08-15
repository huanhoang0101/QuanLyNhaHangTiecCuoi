<%-- 
    Document   : dichvuIndex
    Created on : Aug 15, 2022, 10:51:00 PM
    Author     : HoanTran
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<ul class="pagination">
    <c:forEach begin="1" end="${Math.ceil(DichVuCounter/8)}" var="m">
        <c:url value="/dichvuIndex" var="dv">
            <c:param value="${m}" name="page"  />
        </c:url>
        <li class="page-item"><a class="page-link" href="${dv}">${m}</a></li>
   </c:forEach>
</ul>

<div class="row">
    <c:forEach items="${dichvus}" var="dv">
        <div class="col-md-3 col-xs-12">
            <div class="card">  
                <img class="card-img-top" class="img-fluid" src="${dv.image}" alt="Card image">
                <div class="card-body">
                    <h4 class="card-title">${dv.tenDV}</h4>
                    <p class="card-text">
                        <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${dv.gia}" /> VND
                    </p>
                    <a href="<c:url value="/admin/dichvu/${dv.maDV}"/>" class="btn btn-primary">Xem chi tiết</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

