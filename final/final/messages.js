document.getElementById('myForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const firstname = document.getElementById('firstname').value;
    const lastname = document.getElementById('lastname').value;
    const email = document.getElementById('email').value;
    const mess = document.getElementById('mess').value;

    const formData = {
        firstname: firstname,
        lastname: lastname,
        email: email,
        mess: mess
    };

    console.log("Form Data:", formData);

    const xhr = new XMLHttpRequest();
    xhr.open("GET", "submit.json", true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                const response = JSON.parse(xhr.responseText);
                document.getElementById("message").innerHTML = response.message;
                document.getElementById("myForm").reset(); 
            } else {
                alert('Error submitting form.');
            }
        }
    };
    xhr.send(JSON.stringify(formData));
});
