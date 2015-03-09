/**
 * Created by sevasan on 3/7/2015.
 */
function validateForm() {
    var email = document.forms["login-form"]["email"].value;
    var password = document.forms["login-form"]["password"].value;

    if (email == null || email == "" || !validateEmail(email)) {
        document.getElementById("email").style.border = "2px solid #d8000c";
    } else {
        document.getElementById("email").style.border = '';
    }
    if (password == null || password == "") {
        document.getElementById("password").style.border = "2px solid #d8000c";
    } else {
        document.getElementById("password").style.border = '';
    }
    if ((email == null || email == "") || (password == null || password == "") ||  !validateEmail(email)) {
        document.getElementById("error-empty-input").style.display = "block";
    } else {
        document.getElementById("error-empty-input").style.display = "none";
    }
    return !(email == null || email == "") && !(password == null || password == "") && validateEmail(email);
}
function validateEmail(email) {
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}
