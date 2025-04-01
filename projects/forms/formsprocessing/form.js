document.getElementById("myForm").addEventListener("submit", function(event) {
    event.preventDefault();
    const fullname = document.getElementById('fullname').value;
    const ign = document.getElementById('ign').value;
    const pass = document.getElementById('pass').value;
    const age = document.getElementById('age').value;
    const role = document.getElementById('role').value;
    const comments = document.getElementById('comments').value;

    let rank = "Not selected"; 
    const ranks = ["warrior", "elite", "master", "epic", "legend", "mythic"];
    for (let i = 0; i < ranks.length; i++) {
        if (document.getElementById(ranks[i]).checked) {
            rank = document.getElementById(ranks[i]).value;
            break;
        }
    }

    const formData = {
    fullname: fullname,
    ign: ign,
    password: pass,
    age: age,
    role: role,
    rank: rank,
    comments: comments
};

console.log(formData)

const xhr = new XMLHttpRequest();
xhr.open("GET", "submit.json", true);
xhr.setRequestHeader("Content-Type","application/json;charset=UTF-8");
xhr.onreadystatechange = function () {
if (xhr.readyState === 4 && xhr.status === 200) {
    const response = JSON.parse(xhr.responseText);
    document.getElementById("message").innerHTML = response.message ;
    document.getElementById("myForm").innerHTML = "";
} else if (xhr.readystate === 4) {
    alert('Please Resubmit Form');
}
};
xhr.send(JSON.stringify(formData));
})