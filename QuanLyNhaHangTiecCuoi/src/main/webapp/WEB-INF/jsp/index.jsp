<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
    <nav class="navbar navbar-expand-lg bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">NhaHang</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Home</a>
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
                    <input class="form-control me-2" type="texe" name="kw" placeholder="Nhập từ khóa tìm kiếm..." aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Tìm</button>
                </form>
                
            </div>
        </div>
    </nav>

    <div class="container">
        <div class="row">

            <c:forEach items="${menus}" var="m">
                <div class="col-md-4 col-xs-12">
                    <div class="card">
                        <img class="card-img-top" class="img-fluid" src="https://res.cloudinary.com/dnrpggpn0/image/upload/v1659920425/Foods/com_tam_w9raak.png?fbclid=IwAR0jHz_RCpjREAENUUR6NKoNb3L14Pevuv4iq3casOjzcgZqxYaolVpx5uM" alt="Card image">
                        <div class="card-body">
                            <h4 class="card-title">${m.tenMon}</h4>
                            <p class="card-text">${m.loaiMon}</p>
                            <p class="card-text">${m.gia}</p>
                            <a href="#" class="btn btn-primary">See Profile</a>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>

    <div class="mt-3 p-4 bg-info text-white rounded">
        <h1>Nha Hang Tiec Cuoi</h1>
        <p>&#127801; Lorem ipsum...</p>
    </div>
</body>
</html>
