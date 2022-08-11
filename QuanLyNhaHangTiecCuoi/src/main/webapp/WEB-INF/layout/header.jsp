<%-- 
    Document   : header
    Created on : Aug 11, 2022, 4:29:08 PM
    Author     : HoanTran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg bg-light">
        <div class="container-fluid">
<<<<<<< HEAD
            <a class="navbar-brand" href="javascript:void(0)">Nhà Hàng</a>
=======
            <a class="navbar-brand" href="#">Nhà Hàng</a>
>>>>>>> main
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
<<<<<<< HEAD
                        <a class="nav-link active" aria-current="page" href="<c:url value="/" />">&#128293; Trang chu</a>
=======
                        <a class="nav-link active" aria-current="page" href="#">Trang Chủ</a>
>>>>>>> main
                    </li>

                    <c:forEach items="${category}" var="c">
                        <li class="nav-item">
                            <a class="nav-link" href="#">${c}</a>
                        </li>
                    </c:forEach>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Dropdown
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#">Action</a></li>
                            <li><a class="dropdown-item" href="#">Another action</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="#">Something else here</a></li>
                        </ul>
                    </li>
                </ul>
                
                <c:url value="/" var="action"/>
                <form action="${action}" class="d-flex" role="search">
                    <input class="form-control me-2" type="text" name="kw" placeholder="Nhập từ khóa tìm kiếm..." aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Tìm</button>
                </form>
                
            </div>
        </div>
    </nav>