<%-- 
    Document   : sanhIndex
    Created on : Aug 15, 2022, 10:11:56 PM
    Author     : HoanTran
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


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
                    <h5 class="card-title">${s.soBan}</h5>
                    <a href="<c:url value="/admin/sanh/${s.maSanh}"/>" class="btn btn-primary">Xem chi tiết</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>


