/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function delMonAn(endpoint, id) {
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

function loadAdminMonAn(endpoint) {
    fetch(endpoint).then(function(res) {
        return res.json();
    }).then(function(data) {
        let msg = "";
        for (let i = 0; i < data.length; i++) {
            msg += `
            <tr>
                <td><img src="${data[i].image}" width='120' /></td>
                <td>${data[i].tenMon}</td>
                <td>${data[i].gia} VND</td>
                <td>
                    <div class="spinner-border text-secondary" style="display:none" id="load${data[i].maMenu}"></div>
                    <button class='btn btn-danger' onclick="delMonAn('${endpoint+ "/" + data[i].maMenu}', ${data[i].maMenu})">Xóa</button>
                </td>
            </tr>
            `
        }
        
        let d = document.getElementById("adminMonAn");
        d.innerHTML = msg;
        
        let d2 = document.getElementById("myLoading");
        d2.style.display = "none";
    })
}
