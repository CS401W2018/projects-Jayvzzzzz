document.getElementById('myForm').addEventListener('submit',function(event){
    event.preventDefault();

    const firstname = document.getElementById('firstname').value;
    const lastname = document.getElementById('lastname').value;
    const email = document.getElementById('email').value;
    const message = document.getElementById('message').value;

    const formData = {
        firstname: firstname,
        lastname: lastname,
        email: email,
        message: message
    };
    console.log(formData)
    const xhr = new XMLHttpRequest();
    xhr.open("GET", "submit.json", true);
    xhr.setRequestHeader("Content-Type","application/json;charset=UTF-8");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const response = JSON.parse(xhr.responseText);
            document.getElementById("messages").innerHTML = response.message ;
            document.getElementById("myForm").innerHTML = "";
        } else if (xhr.readystate === 4) {
            alert('Error submitting form.');
        }
    };
    console.log("Sending")
    xhr.send(JSON.stringify(formData));
});