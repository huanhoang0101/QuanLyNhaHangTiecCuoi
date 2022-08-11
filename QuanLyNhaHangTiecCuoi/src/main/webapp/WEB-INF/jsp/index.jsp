<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>




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
                        <a href="#" class="btn btn-primary">Xem chi tiết</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>


