/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function delSanh(endpoint, id) {
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

function loadAdminSanh(endpoint) {
    fetch(endpoint).then(function(res) {
        return res.json();
    }).then(function(data) {
        let msg = "";
        for (let i = 0; i < data.length; i++) {
            msg += `
            <tr>
                <td><img src="${data[i].image}" width='120' /></td>
                <td>${data[i].ten}</td>
                <td>${data[i].soBan}</td>
                <td>
                    <div class="spinner-border text-secondary" style="display:none" id="load${data[i].maSanh}"></div>
                    <button class='btn btn-danger' onclick="delSanh('${endpoint+ "/" + data[i].maSanh}', ${data[i].maSanh})">Xóa</button>
                </td>
            </tr>
            `
        }
        
        let d = document.getElementById("adminSanh");
        d.innerHTML = msg;
        
        let d2 = document.getElementById("myLoading");
        d2.style.display = "none";
    })
}