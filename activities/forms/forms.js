document.getElementById('myForm').addEventListener('submit',function(event){
    event.preventDefault();

    const fullname = document.getElementById('fullname').value;
    const password = document.getElementById('pass').value;
    const email = document.getElementById('email').value;
    const age = document.getElementById('age').value;
    const state = document.getElementById('state').value;

    const formData = {
        fullname: fullname,
        email: email,
        password: pass,
        age: age
    };
    console.log(formData)
    const xhr = new XMLHttpRequest();
    xhr.open("GET", "submit.json", true);
    xhr.setRequestHeader("Content-Type","application/json;charset=UTF-8");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            alert ('Form submitted succesfully.');
        } else if (xhr.readystate === 4) {
            alert('Error submitting form.');
        }
    };
    console.log("Sending")
    xhr.send(JSON.stringify(formData));
});