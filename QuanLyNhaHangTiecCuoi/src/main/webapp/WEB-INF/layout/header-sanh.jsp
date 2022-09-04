<%-- 
    Document   : header
    Created on : Aug 11, 2022, 4:29:08 PM
    Author     : HoanTran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="javascript:void(0)">&#127775; Nhà Hàng Tiệc Cưới &#127775;</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="<c:url value="/" />">&#128143; Trang chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="<c:url value="/sanhIndex" />">&#128141; Sảnh</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="<c:url value="/dichvuIndex" />">&#127881; Dịch Vụ</a>
                </li>


                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        &#127860; Menu
                    </a>
                    <ul class="dropdown-menu">
                        <c:url value="/" var="cUrl">
                            <c:param name="lm" value="" />
                        </c:url>
                        <li><a class="dropdown-item" href="${cUrl}">Tất cả món ăn</a></li>
                        <c:url value="/" var="cUrl">
                            <c:param name="lm" value="Khai vị" />
                        </c:url>
                        <li><a class="dropdown-item" href="${cUrl}">Khai vị</a></li>
                            <c:url value="/" var="cUrl">
                                <c:param name="lm" value="Món chính" />
                            </c:url>
                        <li><a class="dropdown-item" href="${cUrl}">Món chính</a></li>
                            <c:url value="/" var="cUrl">
                                <c:param name="lm" value="Tráng miệng" />
                            </c:url>
                        <li><a class="dropdown-item" href="${cUrl}">Tráng miệng</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="<c:url value="/dat-sanh" />">&#128150; Đặt tiệc</a>
                </li>
            </ul>

            <c:url value="/sanhIndex/" var="action"/>
            <form action="${action}" class="d-flex" role="search">
                <input class="form-control me-2" type="text" name="kw" placeholder="Nhập từ khóa tìm kiếm..." aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Tìm</button>
            </form>

        </div>
    </div>
</nav>