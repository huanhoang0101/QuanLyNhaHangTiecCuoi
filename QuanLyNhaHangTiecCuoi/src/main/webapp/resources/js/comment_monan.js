/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global fetch, moment */

function loadCommentsMonan(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let c = document.getElementById("comments");
        let h = '';
        for (let d of data)
            h += `
                <li class="list-group-item"><em>${d.content}</em> được bình luận bởi <strong>${d.user.tenKH}</strong> vào <strong>${moment(d.createdDate).locale("vi").fromNow()}</strong></li>
            `;
        c.innerHTML = h;
    });
}

function addCommentMonan(endpoint, maMenu) {
    fetch(endpoint, {
        method: "post",
        body: JSON.stringify({
            "content": document.getElementById("contentId").value,
            "maMenu": maMenu
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let d = document.querySelector("#comments li:first-child");
        let h = `
                <li class="list-group-item"><em>${data.content}</em> duoc binh luan boi <strong>${data.user.tenKH}</strong> vao luc <strong>${moment(data.createdDate).locale("vi").fromNow()}</strong></li>
            `;
        d.insertAdjacentHTML("beforebegin", h);
    });
}
