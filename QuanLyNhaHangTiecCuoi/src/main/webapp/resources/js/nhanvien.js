/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function delNhanVien(endpoint, id) {
    let d = document.getElementById("load" + id);
    d.style.display = "block"
    fetch(endpoint, {
        method: "delete"
    }).then(function(res) {
        if (res.status === 204)
            location.reload();
    }).catch(function(err) {
        console.error(err)
    })
}

function loadAdminNhanVien(endpoint) {
    fetch(endpoint).then(function(res) {
        return res.json();
    }).then(function(data) {
        let msg = "";
        for (let i = 0; i < data.length; i++) {
            msg += `
            <tr>
                <td>${data[i].tenNV}</td>
                <td>${data[i].sđt}</td>
                <td>${data[i].ngaySinh}</td>
                <td>${data[i].gioiTInh}</td>
                <td>${data[i].loaiNV}</td>
                <td>${data[i].taiKhoan}</td>
                <td>${data[i].matKhau}</td>
                <td>
                    <div class="spinner-border text-secondary" style="display:none" id="load${data[i].maNV}"></div>
                    <button class='btn btn-danger' onclick="delNhanVien('${endpoint+ "/" + data[i].maNV}', ${data[i].maNV})">Xóa</button>
                </td>
            </tr>
            `
        }

        let d = document.getElementById("adminNhanVien");
        d.innerHTML = msg;

        let d2 = document.getElementById("myLoading");
        d2.style.display = "none";
    })
}

