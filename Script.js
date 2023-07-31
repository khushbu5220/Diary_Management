let captchaText = document.querySelector('#captcha');
var ctx = captchaText.getContext("2d");
ctx.font = "30px Roboto";
ctx.fillStyle = "#08e5ff";


let userText = document.querySelector('#textBox');
let submitButton = document.querySelector('#submitButton');
let output = document.querySelector('#output');
var username = document.getElementById('username').value; 
var password = document.getElementById('pswd').value;

let refreshButton = document.querySelector('#refreshButton');
let outputUsername = document.querySelector('#outputUsername');
let outputPassword = document.querySelector('#outputPassword');

// alphaNums contains the characters with which you want to create the CAPTCHA
let alphaNums = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'];
let emptyArr = [];

// This loop generates a random string of 7 characters using alphaNums
// Further this string is displayed as a CAPTCHA
for (let i = 1; i <= 7; i++) {
    emptyArr.push(alphaNums[Math.floor(Math.random() * alphaNums.length)]);
}
var c = emptyArr.join('');
ctx.fillText(emptyArr.join(''),captchaText.width/4, captchaText.height/2);


// This event listener is stimulated whenever the user press the "Enter" button
// "Correct!" or "Incorrect, please try again" message is
// displayed after validating the input text with CAPTCHA
userText.addEventListener('keyup', function(e) {
    // Key Code Value of "Enter" Button is 13
    if (e.keyCode === 13) {
        if (userText.value === c) {           
            output.classList.add("correctCaptcha");
            output.innerHTML = "Correct!";
            window.location.href = "systemlist.html"; 
        } else {
            output.classList.add("incorrectCaptcha");
            output.innerHTML = "Incorrect Captcha Entered, please try again!";
        }
    }
});

// This event listener is stimulated whenever the user clicks the "Submit" button
// "Correct!" or "Incorrect, please try again" message is
// displayed after validating the input text with CAPTCHA
submitButton.addEventListener('click', function() {
    // if(username == ""){
    //     outputUsername.classList.add("incorrectCaptcha");
    //     outputUsername.innerHTML = "Username Required!";
    // }
    // else{
    //     outputUsername.innerHTML = "";
    // }
    // if(password == ""){       
    //     outputPassword.classList.add("incorrectCaptcha");
    //     outputPassword.innerHTML = "Password Required!";
    // }
    // else{
    //     outputPassword.innerHTML = "";
    // }



    if (userText.value === c) {
        output.classList.add("correctCaptcha");
        output.innerHTML = "Correct!";
        if(username.length !== null && password.length !== null){
            event.preventDefault()
            const username = document.getElementById('username').value
            const password = document.getElementById('pswd').value
            const messageReponse = document.getElementById("messageReponse");

            var xhr = new XMLHttpRequest();
            xhr.open('POST', 'http://localhost:8080/token', true);
            xhr.setRequestHeader('Content-Type', 'application/json');

            xhr.onreadystatechange = function() {
                if(xhr.readyState === XMLHttpRequest.DONE) {
                    if(xhr.status === 200) {
                        console.log(xhr.responseText);
                        // localStorage.setItem('token', xhr.responseText)
                        // window.location = "systemlist.html"
                        sessionStorage.setItem('token', xhr.responseText)
                        window.location = "systemlist.html"
                    }
                    else {
                        messageReponse.textContent = '* Incorrect Username/ Password!';
                        messageReponse.style.color = "red";
                        // window.location = "loginpage.html"
                    }
                }
            };

            var data = {
                username: username,
                password: password
            };

            xhr.send(JSON.stringify(data))


            // window.location.href = "systemlist.html"; 
        }
    } else {
        output.classList.add("incorrectCaptcha");
        output.innerHTML = "Incorrect Captcha Entered, please try again!";
    }
});




// This event listener is stimulated whenever the user press the "Refresh" button
// A new random CAPTCHA is generated and displayed after the user clicks the "Refresh" button
refreshButton.addEventListener('click', function() {
    userText.value = "";
    let refreshArr = [];
    for (let j = 1; j <= 7; j++) {
        refreshArr.push(alphaNums[Math.floor(Math.random() * alphaNums.length)]);
    }
    ctx.clearRect(0, 0, captchaText.width, captchaText.height);
    c = refreshArr.join('');
    ctx.fillText(refreshArr.join(''),captchaText.width/4, captchaText.height/2);
    output.innerHTML = "";
});