var nameError = document.getElementById('name-error');
var phoneError = document.getElementById('phone-error');
var emailError = document.getElementById('email-error');
var messageError = document.getElementById('message-error');
var submitError = document.getElementById('submit-error');

function validateName(){
    var name = document.getElementById('contact-name').value;
    if(name.length == 0){
        nameError.innerHTML = 'Name is Required';
        return false;
    }
    if(!name.match(/^[A-Za-z]*\s{1}[A-Za-z]*$/)){
        nameError.innerHTML = 'Enter Full Name';
        return false;
    }

    nameError.innerHTML = '<i class="fa-sharp fa-solid fa-check"></i>';
    return true;

}

function validatePhone(){
    var phone = document.getElementById('contact-phone').value;
    
    if(phone.length == 0){
        phoneError.innerHTML = 'Phone Number is Required';
        return false;
    }

    if(phone.length !== 10){
        phoneError.innerHTML = 'Number Should be 10 Digits';
        return false;
    }

    if(!phone.match(/^[0-9]{10}$/)){
        phoneError.innerHTML = 'Only Numbers Please';
        return false;
    }

    phoneError.innerHTML = '<i class="fa-sharp fa-solid fa-check"></i>';
    return true;
}

function validateEmail(){
    var email = document.getElementById('contact-email').value;

    if(email.length == 0){
        emailError.innerHTML = 'Email is Required';
        return false;
    }
    

    if(!email.match(/^[A-Za-z\._\-0-9]*[@][A-Za-z]*[\.][a-z]{2,4}$/)){
        emailError.innerHTML = 'Valid email ID Please';
        return false;
    }

    emailError.innerHTML = '<i class="fa-sharp fa-solid fa-check"></i>';
    return true;
}

function validateMessage(){
    var message = document.getElementById('contact-message').value;

    if(message.length == 0){
        messageError.innerHTML = 'Message is Required';
        return false;
    }

    if(message.length < 20){
        messageError.innerHTML = 'Message is very Short';
        return false;
    }

    messageError.innerHTML = '<i class="fa-sharp fa-solid fa-check"></i>';
        return true;
}

function validateForm(){
    if(!validateName() ||
    !validateEmail() ||
    !validateMessage() ||
    !validatePhone()){
        submitError.innerHTML = 'Please Fix the Error to Submit';
                return false;
    }
    submitError.innerHTML = '';
    return true;
    
}