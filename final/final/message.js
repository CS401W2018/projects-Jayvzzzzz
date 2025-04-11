document.getElementById('messages').addEventListener('submit', function(event) {
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

    console.log("Form Data:", formData);

    const xhr = new XMLHttpRequest();
    xhr.open("POST", "submit.json", true); // Use POST instead of GET
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

    console.log("Sending...");
    xhr.send(JSON.stringify(formData));
});
