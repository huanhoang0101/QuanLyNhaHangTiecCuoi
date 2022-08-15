/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function delDichVu(endpoint, id) {
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

function loadAdminDichVu(endpoint) {
    fetch(endpoint).then(function(res) {
        return res.json();
    }).then(function(data) {
        let msg = "";
        for (let i = 0; i < data.length; i++) {
            msg += `
            <tr>
                <td><img src="${data[i].image}" width='120' /></td>
                <td>${data[i].tenDV}</td>
                <td>${data[i].gia} VND</td>
                <td>
                    <div class="spinner-border text-secondary" style="display:none" id="load${data[i].maDV}"></div>
                    <button class='btn btn-danger' onclick="delDichVu('${endpoint+ "/" + data[i].maDV}', ${data[i].maDV})">Xóa</button>
                </td>
            </tr>
            `
        }
        
        let d = document.getElementById("adminDichVu");
        d.innerHTML = msg;
        
        let d2 = document.getElementById("myLoading");
        d2.style.display = "none";
    })
}
