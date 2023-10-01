
let formWrapper = document.querySelector(".form-wrapper");
let signupBtn = document.querySelector(".signup-Btn");
let loginBtn = document.querySelector(".login-Btn");
let signupForm = document.getElementById("signup-form");
let loginForm = document.getElementById("login-form");

loginBtn.addEventListener("click", ()=>{
    signupForm.style.transform = "translateX(-300px)";
    loginForm.style.transform = "translateY(0)";
    formWrapper.style.background = "rgba(0,0,0,0.1)";
    formWrapper.style.borderColor = "green";
});

signupBtn.addEventListener("click", ()=>{
    signupForm.style.transform = "translateX(0px)";
    loginForm.style.transform = "translateY(-400px)";
    formWrapper.style.background = "transparent";
    formWrapper.style.borderColor = "white";
});