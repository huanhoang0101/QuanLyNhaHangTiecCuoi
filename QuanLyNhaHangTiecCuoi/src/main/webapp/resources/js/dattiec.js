/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global fetch */

function addToDatMonan(maMenu, tenMon, gia) {
//    event.preventDefault()

    fetch("/QuanLyNhaHangTiecCuoi/api/dattiecmonan", {
        method: 'post',
        body: JSON.stringify({
            "maMenu": maMenu,
            "tenMon": tenMon,
            "gia": gia,
            "soLuong": 1
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json()
    })
//            .then (function(data){
//        let c = document.getElementById("cart")
//        c.innerText = data
//    })
}

function addToDatDichvu(maDV, tenDV, gia) {
    fetch("/QuanLyNhaHangTiecCuoi/api/dattiecdichvu", {
        method: 'post',
        body: JSON.stringify({
            "maDV": maDV,
            "tenDV": tenDV,
            "gia": gia
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json()
    })
}

function addToDatSanh(maSanh, tenSanh, gia, soBan) {
    fetch("/QuanLyNhaHangTiecCuoi/api/dattiecsanh", {
        method: 'post',
        body: JSON.stringify({
            "maSanh": maSanh,
            "tenSanh": tenSanh,
            "gia": gia,
            "soBan": soBan
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json()
    })
}

