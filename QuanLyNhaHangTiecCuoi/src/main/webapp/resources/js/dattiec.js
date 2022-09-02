/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global fetch */

function addToDatMonan(maMenu, tenMon, gia) {
    event.preventDefault();

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
        return res.json();
    });
}

function addToDatDichvu(maDV, tenDV, gia) {
    event.preventDefault();

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
        return res.json();
    });
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
        return res.json();
    });
}

function updateDatMonan(obj, maMenu) {
    fetch("/QuanLyNhaHangTiecCuoi/api/dattiecmonan", {
        method: 'put',
        body: JSON.stringify({
            "maMenu": maMenu,
            "tenMon": "",
            "gia": 0,
            "soLuong": obj.value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    });
}

function deleteDatMonan(maMenu) {
    if (confirm("Bạn có muốn xóa món ăn này không ?") === true) {
        fetch(`/QuanLyNhaHangTiecCuoi/api/dattiecmonan/${maMenu}`, {
            method: 'delete'
        }).then(function (res) {
            return res.json();
        });
        let row = document.getElementById(`Monan${maMenu}`);
        row.style.display = "none";
    }
}

function deleteDatSanh(maSanh) {
    if (confirm("Bạn có muốn xóa sảnh này không ?") === true) {
        fetch(`/QuanLyNhaHangTiecCuoi/api/dattiecsanh/${maSanh}`, {
            method: 'delete'
        }).then(function (res) {
            return res.json();
        });
        let row = document.getElementById(`Sanh${maSanh}`);
        row.style.display = "none";
    }
}

function deleteDatDichvu(maDV) {
    if (confirm("Bạn có muốn xóa dịch vụ này không ?") === true) {
        fetch(`/QuanLyNhaHangTiecCuoi/api/dattiecdichvu/${maDV}`, {
            method: 'delete'
        }).then(function (res) {
            return res.json();
        });
        let row = document.getElementById(`Dichvu${maDV}`);
        row.style.display = "none";
    }
}

